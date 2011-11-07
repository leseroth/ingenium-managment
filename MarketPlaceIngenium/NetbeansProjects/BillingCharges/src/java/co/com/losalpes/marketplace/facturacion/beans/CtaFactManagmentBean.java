package co.com.losalpes.marketplace.facturacion.beans;

import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.entities.Cargo;
import co.com.losalpes.marketplace.facturacion.entities.Cliente;
import co.com.losalpes.marketplace.facturacion.entities.CuentaFacturacion;
import co.com.losalpes.marketplace.facturacion.entities.Factura;
import co.com.losalpes.marketplace.facturacion.exceptions.CuentaFacturacionNoExisteException;
import co.com.losalpes.marketplace.facturacion.exceptions.FacturaException;
import co.com.losalpes.marketplace.facturacion.utilities.BillGeneration;
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

    public String crearCuentaFacturacion(ClienteBO cliente) {
        Query q = em.createNamedQuery("getClienteByNit");
        q.setParameter("nit", cliente.getNit());
        List<Cliente> clientes = (List<Cliente>) q.getResultList();
        if (!clientes.isEmpty()) {
            q = em.createNamedQuery("getCuentaByNitCliente");
            q.setParameter("nit", cliente.getNit());
            List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
            return cuentas.get(0).getNumeroCuenta();
        }
        Cliente c = new Cliente(cliente);
        em.persist(c);
        CuentaFacturacion cta = new CuentaFacturacion();
        cta.setCliente(c);
        em.persist(cta);
        return cta.getNumeroCuenta();
    }

    public CuentaFacturacionBO consultarCuentaFacturacionCliente(String nit) throws CuentaFacturacionNoExisteException {
        Query q = em.createNamedQuery("getCuentaByNitCliente");
        q.setParameter("nit", nit);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new CuentaFacturacionNoExisteException("El cliente especificado no tiene cuenta de facturacion asociada");
        }
        return cuentas.get(0).toBO();
    }

    public CuentaFacturacionBO consultarCuentaFacturacion(String numeroCuenta) throws CuentaFacturacionNoExisteException {
        Query q = em.createNamedQuery("getCtaFacturacionByNum");
        q.setParameter("numero", numeroCuenta);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new CuentaFacturacionNoExisteException("La cuenta de facturación con el número " + numeroCuenta + " no existe");
        }
        return cuentas.get(0).toBO();
    }

    public Boolean generarFacturaCorte(int corte, int plazo) throws FacturaException {
        try {
            Query q = em.createNamedQuery("getCuentaFacturacionByCorte");
            q.setParameter("corte", corte);
            List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
            for (int i = 0; i < cuentas.size(); i++) {
                CuentaFacturacion cuenta = cuentas.get(i);
                Factura f = BillGeneration.getInstance().generateBill(cuenta, plazo);
                em.persist(f);
                cuenta.adicionarFactura(f);

                try { // Call Web Service Operation
                    co.com.losalpes.marketplace.mailer.ws.MailSendingManagement port = service.getMailSendingManagementPort();

                    List<String> to = new ArrayList<String>();
                    to.add(cuenta.getCliente().getEmail());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaInicio = sdf.format(f.getFechaInicio());
                    String fechaFin = sdf.format(f.getFechaFin());
                    String subject = "Factura del período " + fechaInicio + " - " + fechaFin;
                    String message = "Estimado " + cuenta.getCliente().getNombre() + ":\n\nAdjuntamos la factura para el período " + fechaInicio + " - " + fechaFin + ".\n\nCordialmente,\n\nEl equipo del MarketPlace de los Alpes";
                    List<String> attachments = new ArrayList<String>();
                    attachments.add(f.getUrl());

                    port.sendMail(to, null, null, subject, message, INGENIUM_EMAIL, INGENIUM_EMAIL_PASSWORD, attachments);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            throw new FacturaException("Error generando facturas");
        }
        return true;
    }

    public Boolean registrarTransaccion(CargoBO cargo, String numeroCuenta) throws CuentaFacturacionNoExisteException {
        Query q = em.createNamedQuery("getCtaFacturacionByNum");
        q.setParameter("numero", numeroCuenta);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new CuentaFacturacionNoExisteException("La cuenta especificada no existe");
        }
        Cargo c = new Cargo(cargo);
        em.persist(c);
        cuentas.get(0).adicionarCargo(c);
        return true;
    }

    public Boolean cambiarEstadoCliente(String nit, String estado) throws CuentaFacturacionNoExisteException {
        Query q = em.createNamedQuery("getCuentaByNitCliente");
        q.setParameter("nit", nit);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        if (cuentas.isEmpty()) {
            throw new CuentaFacturacionNoExisteException("El cliente especificado no existe");
        }
        cuentas.get(0).getCliente().setEstado(estado);
        return true;
    }

    public Boolean reportarClientesMorosos(int corte) {
        Query q = em.createNamedQuery("getCuentaFacturacionByCorte");
        q.setParameter("corte", corte);
        List<CuentaFacturacion> cuentas = (List<CuentaFacturacion>) q.getResultList();
        for (int i = 0; i < cuentas.size(); i++) {
            CuentaFacturacion cta = cuentas.get(i);
            Date fechaInicio = new Date();
            Long valorPagoAnterior = 0L;
            for (int j = 0; j < cta.getFacturas().size(); j++) {
                Factura f = cta.getFacturas().get(j);
                if (f.getFechaFin().equals(cta.getFechaUltimoCorte())) {
                    fechaInicio = f.getFechaInicio();
                    valorPagoAnterior = f.getValorPago();
                    break;
                }
            }
            boolean noMoroso = false;
            for (int j = 0; j < cta.getCargos().size(); j++) {
                Cargo c = cta.getCargos().get(j);
                if (c.getFecha().after(fechaInicio) && c.getFecha().before(cta.getFechaUltimoCorte()) && c.getValor() < 0) {
                    noMoroso = true;
                    break;
                }
            }
            if (!noMoroso) {
                cta.getCliente().setEstado(ClienteBO.REPORTADO);
                Cargo c = new Cargo();
                c.setDescripcion("Valor a pagar factura anterior");
                c.setFecha(new Date(System.currentTimeMillis()));
                c.setReferencia("" + System.currentTimeMillis());
                c.setValor(valorPagoAnterior);
                cta.adicionarCargo(c);
                em.persist(c);
            }
        }
        return true;
    }
}
