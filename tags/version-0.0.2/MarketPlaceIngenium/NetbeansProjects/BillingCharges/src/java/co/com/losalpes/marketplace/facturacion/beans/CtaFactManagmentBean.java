package co.com.losalpes.marketplace.facturacion.beans;

import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.entities.Cargo;
import co.com.losalpes.marketplace.facturacion.entities.Cliente;
import co.com.losalpes.marketplace.facturacion.entities.CuentaFacturacion;
import co.com.losalpes.marketplace.facturacion.entities.Factura;
import co.com.losalpes.marketplace.facturacion.exceptions.BussinessException;
import co.com.losalpes.marketplace.facturacion.util.BillGeneration;
import co.com.losalpes.marketplace.mailer.ws.MailSendingManagementService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.WebServiceRef;

import static co.com.losalpes.marketplace.facturacion.util.Constants.*;

/**
 *
 * @author marketplace
 */
@Stateless
public class CtaFactManagmentBean implements CtaFactManagmentRemote, CtaFactManagmentLocal {

    private static final String INGENIUM_EMAIL = "ingenium.uniandes@gmail.com";
    private static final String INGENIUM_EMAIL_PASSWORD = "ingenium2011";
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8148/MailSendingManagementService/MailSendingManagement.wsdl")
    private MailSendingManagementService service;
    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public String crearCuentaFacturacion(ClienteBO clienteBO) throws BussinessException {
        CuentaFacturacion cuentaFacturacion = null;

        if (clienteBO.getNit() == null) {
            throw new BussinessException(EXC_INFO_INCOMPLETE, "Nit");
        }

        Query query = em.createNamedQuery("getClienteByNit");
        query.setParameter("nit", clienteBO.getNit());
        List<Cliente> clienteList = (List<Cliente>) query.getResultList();

        if (!clienteList.isEmpty()) {
            query = em.createNamedQuery("getCuentaByNitCliente");
            query.setParameter("nit", clienteBO.getNit());
            List<CuentaFacturacion> cuentaFacturacionList = (List<CuentaFacturacion>) query.getResultList();
            cuentaFacturacion = cuentaFacturacionList.get(0);
        } else {
            if (clienteBO.getId() != null) {
                throw new BussinessException(EXC_ENTITY_DETACHED, "Cliente");
            } else if (clienteBO.getEstado() != null) {
                throw new BussinessException(EXC_ENTITY_TOO_MUCH_INFO, "Estado", "Cliente");
            }

            Cliente cliente = new Cliente(clienteBO);
            cliente.setEstado(ClienteBO.OK);
            if (!cliente.isInfoComplete()) {
                throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Cliente");
            }

            em.persist(cliente);

            cuentaFacturacion = new CuentaFacturacion();
            cuentaFacturacion.initCuentaFacturacion(cliente);
            em.persist(cuentaFacturacion);
        }

        return cuentaFacturacion.getNumeroCuenta();
    }

    @Override
    public CuentaFacturacionBO consultarCuentaFacturacionCliente(String nit) throws BussinessException {
        Query q = em.createNamedQuery("getCuentaByNitCliente");
        q.setParameter("nit", nit);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new BussinessException("El cliente especificado no tiene cuenta de facturacion asociada");
        }
        return cuentas.get(0).toBO();
    }

    @Override
    public CuentaFacturacionBO consultarCuentaFacturacion(String numeroCuenta) throws BussinessException {
        Query q = em.createNamedQuery("getCtaFacturacionByNum");
        q.setParameter("numero", numeroCuenta);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new BussinessException("La cuenta de facturación con el número " + numeroCuenta + " no existe");
        }
        return cuentas.get(0).toBO();
    }

    @Override
    public Boolean generarFacturaCorte(int corte, int plazo) throws BussinessException {
        try {
            Query q = em.createNamedQuery("getCuentaFacturacionByCorte");
            q.setParameter("corte", corte);
            List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
            for (int i = 0; i < cuentas.size(); i++) {
                CuentaFacturacion cuenta = cuentas.get(i);
                Factura factura = BillGeneration.generateBill(cuenta, plazo);
                em.persist(factura);
                cuenta.getFacturaList().add(factura);

                try { // Call Web Service Operation
                    co.com.losalpes.marketplace.mailer.ws.MailSendingManagement port = service.getMailSendingManagementPort();

                    List<String> to = new ArrayList<String>();
                    to.add(cuenta.getCliente().getEmail());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaInicio = sdf.format(factura.getFechaInicio());
                    String fechaFin = sdf.format(factura.getFechaFin());
                    String subject = "Factura del período " + fechaInicio + " - " + fechaFin;
                    String message = "Estimado " + cuenta.getCliente().getNombre() + ":\n\nAdjuntamos la factura para el período " + fechaInicio + " - " + fechaFin + ".\n\nCordialmente,\n\nEl equipo del MarketPlace de los Alpes";
                    List<String> attachments = new ArrayList<String>();
                    attachments.add(factura.getUrl());

                    port.sendMail(to, null, null, subject, message, INGENIUM_EMAIL, INGENIUM_EMAIL_PASSWORD, attachments);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            throw new BussinessException("Error generando facturas");
        }
        return true;
    }

    @Override
    public Boolean registrarTransaccion(CargoBO cargoBO, String numeroCuenta) throws BussinessException {
        Query q = em.createNamedQuery("getCtaFacturacionByNum");
        q.setParameter("numero", numeroCuenta);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new BussinessException("La cuenta especificada no existe");
        }
        Cargo cargo = new Cargo(cargoBO);
        em.persist(cargo);
        cuentas.get(0).getCargoList().add(cargo);
        return true;
    }

    @Override
    public Boolean cambiarEstadoCliente(String nit, String estado) throws BussinessException {
        Query q = em.createNamedQuery("getCuentaByNitCliente");
        q.setParameter("nit", nit);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new BussinessException("El cliente especificado no existe");
        }
        cuentas.get(0).getCliente().setEstado(estado);
        return true;
    }

    @Override
    public Boolean reportarClientesMorosos(int corte) {
        Query q = em.createNamedQuery("getCuentaFacturacionByCorte");
        q.setParameter("corte", corte);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        for (int i = 0; i < cuentas.size(); i++) {
            CuentaFacturacion cta = cuentas.get(i);
            Date fechaInicio = new Date();
            Long valorPagoAnterior = 0L;
            for (int j = 0; j < cta.getFacturaList().size(); j++) {
                Factura f = cta.getFacturaList().get(j);
                if (f.getFechaFin().equals(cta.getFechaUltimoCorte())) {
                    fechaInicio = f.getFechaInicio();
                    valorPagoAnterior = f.getValorPago();
                    break;
                }
            }
            boolean noMoroso = false;
            for (int j = 0; j < cta.getCargoList().size(); j++) {
                Cargo c = cta.getCargoList().get(j);
                if (c.getFecha().after(fechaInicio) && c.getFecha().before(cta.getFechaUltimoCorte()) && c.getValor() < 0) {
                    noMoroso = true;
                    break;
                }
            }
            if (!noMoroso) {
                cta.getCliente().setEstado(ClienteBO.REPORTADO);
                Cargo cargo = new Cargo();
                cargo.setDescripcion("Valor a pagar factura anterior");
                cargo.setFecha(new Date(System.currentTimeMillis()));
                cargo.setReferencia("" + System.currentTimeMillis());
                cargo.setValor(valorPagoAnterior);
                cta.getCargoList().add(cargo);
                em.persist(cargo);
            }
        }
        return true;
    }
}
