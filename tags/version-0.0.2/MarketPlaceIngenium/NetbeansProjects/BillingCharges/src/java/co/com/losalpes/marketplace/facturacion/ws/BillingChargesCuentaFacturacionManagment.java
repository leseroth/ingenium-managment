package co.com.losalpes.marketplace.facturacion.ws;

import co.com.losalpes.marketplace.facturacion.beans.CtaFactManagmentLocal;
import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.exceptions.BussinessException;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author marketplace
 */
@WebService()
@Stateless()
public class BillingChargesCuentaFacturacionManagment {

    @EJB
    private CtaFactManagmentLocal ejbRef;

    /**
     * Crea una cuenta de facturacion para el cliente indicado siguiendo las siguientes reglas.
     * <ul>
     * <li>El nit es obligatorio</li>
     * <li>No debe venir ID ni Estado</li>
     * <li>Si se debe crear el cliente debe venir nit, email, direccion y nombre</li>
     * <li>El numero de cuenta de facturacion tiene el formato idCliente-yyMMddhhmm</li>
     * <li>Si el cliente ya existe se retorna la cuenta de facturacion correspondiente</li>
     * </ul>
     * @param cliente Cliente cuya cuenta se consulta
     * @return Numero de cuenta de facturacion
     * @throws BussinessException En caso de que alguna de las reglas anteriores no se cumpla
     */
    @WebMethod(operationName = "crearCuentaFacturacion")
    public String crearCuentaFacturacion(@WebParam(name = "cliente") ClienteBO cliente) throws BussinessException {
        return ejbRef.crearCuentaFacturacion(cliente);
    }

    @WebMethod(operationName = "consultarCuentaFacturacion")
    public CuentaFacturacionBO consultarCuentaFacturacion(@WebParam(name = "numeroCuenta") String numeroCuenta) throws BussinessException {
        return ejbRef.consultarCuentaFacturacion(numeroCuenta);
    }

    @WebMethod(operationName = "generarFacturaCorte")
    public Boolean generarFacturaCorte(@WebParam(name = "corte") int corte, @WebParam(name = "plazo") int plazo) throws BussinessException {
        return ejbRef.generarFacturaCorte(corte, plazo);
    }

    @WebMethod(operationName = "consultarCuentaFacturacionCliente")
    public CuentaFacturacionBO consultarCuentaFacturacionCliente(@WebParam(name = "nit") String nit) throws BussinessException {
        return ejbRef.consultarCuentaFacturacionCliente(nit);
    }

    @WebMethod(operationName = "registrarTransaccion")
    public Boolean registrarTransaccion(@WebParam(name = "cargo") CargoBO cargo, @WebParam(name = "numeroCuenta") String numeroCuenta) throws BussinessException {
        return ejbRef.registrarTransaccion(cargo, numeroCuenta);
    }

    @WebMethod(operationName = "cambiarEstadoCliente")
    public Boolean cambiarEstadoCliente(@WebParam(name = "nit") String nit, @WebParam(name = "estado") String estado) throws BussinessException {
        return ejbRef.cambiarEstadoCliente(nit, estado);
    }

    @WebMethod(operationName = "reportarClientesMorosos")
    public Boolean reportarClientesMorosos(@WebParam(name = "corte") Integer corte) throws BussinessException {
        return ejbRef.reportarClientesMorosos(corte);
    }
}
