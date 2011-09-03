/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.ws;

import co.com.losalpes.marketplace.facturacion.beans.CtaFactManagmentLocal;
import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.exceptions.CuentaFacturacionNoExisteException;
import co.com.losalpes.marketplace.facturacion.exceptions.FacturaException;
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

    @WebMethod(operationName = "crearCuentaFacturacion")
    public String crearCuentaFacturacion(@WebParam(name = "cliente")
    ClienteBO cliente) {
        return ejbRef.crearCuentaFacturacion(cliente);
    }

    @WebMethod(operationName = "consultarCuentaFacturacion")
    public CuentaFacturacionBO consultarCuentaFacturacion(@WebParam(name = "numeroCuenta")
    String numeroCuenta) throws CuentaFacturacionNoExisteException {
        return ejbRef.consultarCuentaFacturacion(numeroCuenta);
    }

    @WebMethod(operationName = "generarFacturaCorte")
    public Boolean generarFacturaCorte(@WebParam(name = "corte")
    int corte, @WebParam(name = "plazo")int plazo) throws FacturaException {
        return ejbRef.generarFacturaCorte(corte, plazo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarCuentaFacturacionCliente")
    public CuentaFacturacionBO consultarCuentaFacturacionCliente(@WebParam(name = "nit")
    String nit) throws CuentaFacturacionNoExisteException {
        return ejbRef.consultarCuentaFacturacionCliente(nit);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarTransaccion")
    public Boolean registrarTransaccion(@WebParam(name = "cargo")
    CargoBO cargo, @WebParam(name = "numeroCuenta")
    String numeroCuenta) throws CuentaFacturacionNoExisteException {
        return ejbRef.registrarTransaccion(cargo, numeroCuenta);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarEstadoCliente")
    public Boolean cambiarEstadoCliente(@WebParam(name = "nit")
    String nit, @WebParam(name = "estado")
    String estado) throws CuentaFacturacionNoExisteException {
        return ejbRef.cambiarEstadoCliente(nit, estado);
    }

    @WebMethod(operationName = "reportarClientesMorosos")
    public Boolean reportarClientesMorosos(@WebParam(name = "corte")
    Integer corte) {
        return ejbRef.reportarClientesMorosos(corte);
    }
}
