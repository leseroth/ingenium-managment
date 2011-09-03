/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.beans;

import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.exceptions.CuentaFacturacionNoExisteException;
import co.com.losalpes.marketplace.facturacion.exceptions.FacturaException;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface CtaFactManagmentLocal {

    public String crearCuentaFacturacion(ClienteBO cliente);

    public CuentaFacturacionBO consultarCuentaFacturacion(String numeroCuenta)throws CuentaFacturacionNoExisteException;

    public Boolean generarFacturaCorte(int corte, int plazo)throws FacturaException;

    public CuentaFacturacionBO consultarCuentaFacturacionCliente(String nit) throws CuentaFacturacionNoExisteException;

    public Boolean registrarTransaccion(CargoBO cargo, String numeroCuenta) throws CuentaFacturacionNoExisteException;

    public Boolean cambiarEstadoCliente(String nit, String estado) throws CuentaFacturacionNoExisteException;

    public Boolean reportarClientesMorosos(int corte);
}
