package co.com.losalpes.marketplace.facturacion.beans;

import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.exceptions.BussinessException;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface CtaFactManagmentLocal {

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
    public String crearCuentaFacturacion(ClienteBO cliente) throws BussinessException;

    public CuentaFacturacionBO consultarCuentaFacturacion(String numeroCuenta) throws BussinessException;

    public Boolean generarFacturaCorte(int corte, int plazo) throws BussinessException;

    public CuentaFacturacionBO consultarCuentaFacturacionCliente(String nit) throws BussinessException;

    public Boolean registrarTransaccion(CargoBO cargo, String numeroCuenta) throws BussinessException;

    public Boolean cambiarEstadoCliente(String nit, String estado) throws BussinessException;

    public Boolean reportarClientesMorosos(int corte) throws BussinessException;
}
