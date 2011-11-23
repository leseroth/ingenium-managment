package co.com.losalpes.marketplace.pomanager.ws;

import co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author Erik
 */
@WebService()
@Stateless()
public class PoManagerPoManagement {

    @EJB
    private PoManagementLocal ejbRef;

    /**
     * Recibe el purchaseOrder, si esta presente el fabricante es una orden de compra directa.
     * <ul>
     * <li>Si el comercio no existe se crea</li>
     * <li>Si el fabricante no existe se crea</li>
     * <li>El producto siempre se crea</li>
     * <li>Si el fabricante viene, se considera orden directa y se asocia al producto</li>
     * <li>Si se debe crear el comercio debe tener nit y nombre</li>
     * <li>Si se debe crear el fabricante debe tener nit y nombre</li>
     * <li>La orden de compra no debe tener estado, numSeguimiento ni id</li>
     * <li>El producto debe tener categoria, nombre y precio</li>
     * </ul>
     * @param purchaseOrderBO PurchaseOrderBO
     * @return El numero de seguimiento
     * @throws BussinessException Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
     */
    @WebMethod(operationName = "registrarPO")
    public String registrarPO(
            @WebParam(name = "purchaseOrderBO") PurchaseOrderBO purchaseOrderBO)
            throws BussinessException {
        return ejbRef.registrarPO(purchaseOrderBO);
    }

    /**
     * Busca las ordenes de compra de un fabricante.
     * <ul>
     * <li>El fabricante debe existir</li>
     * <li>El estado debe ser un estado valido</li>
     * <li>Si el estado viene en null, se retornan todas las ordenes de compra del fabricante</li>
     * </ul>
     * @param nit Nit del fabricante
     * @param estado Estado de la orden de compra
     * @return La lista de ordenes de compra asociadas al fabricante
     * @throws BussinessException En caso de que una de las condiciones no se cumpla
     * @see co.com.losalpes.marketplace.pomanager.util.PurchaseOrderState
     */
    @WebMethod(operationName = "consultarPOFabricantePorEstado")
    public java.util.List<PurchaseOrderBO> consultarPOFabricantePorEstado(
            @WebParam(name = "nit") String nit, @WebParam(name = "estado") String estado)
            throws BussinessException {
        return ejbRef.consultarPOFabricantePorEstado(nit, estado);
    }

    /**
     * Actualiza el estado de una PurchaseOrder por el numero de seguimiento.
     * <ul>
     * <li>El numero de seguimiento debe existir</li>
     * <li>El estado debe ser un estado valido</li>
     * <li>La transicion de estados debe ser valida, es decir no se puede pacar de AceptadoFabricante a SolicitadoComercio</li>
     * <li>El numero de seguimiento y el estado son obligatorios</li>
     * </ul>
     * @param numSeguimiento Numero de seguimiento de la orden de compra
     * @param estado Nuevo estado de la orden de compra
     * @return true en caso de que la actualizacion haya sido correcta, false en caso contrario
     * @throws BussinessException En caso de que alguna de las condiciones no se cumpla
     * @see co.com.losalpes.marketplace.pomanager.util.PurchaseOrderState
     */
    @WebMethod(operationName = "actualizarEstadoPO")
    public boolean actualizarEstadoPO(
            @WebParam(name = "numSeguimiento") String numSeguimiento, @WebParam(name = "estado") String estado)
            throws BussinessException {
        return ejbRef.actualizarEstadoPO(numSeguimiento, estado);
    }

    /**
     * Consulta las ordenes de compra asociadas a un comercio teniendo en cuenta su nit.
     * <ul>
     * <li>El nit debe existir</li>
     * <li>Si el comercio no tiene ordenes de compra asociadas se retorna una lista vacia</li>
     * </ul>
     * @param nit Nit del Comercio
     * @return Lista de ordenes de compra del comercio
     * @throws BussinessException En caso de que haya alguna excepcion de negocio
     */
    @WebMethod(operationName = "consultarPOsComercio")
    public java.util.List<PurchaseOrderBO> consultarPOsComercio(@WebParam(name = "nit") String nit) throws BussinessException {
        return ejbRef.consultarPOsComercio(nit);
    }

    @WebMethod(operationName = "consultarPO")
    public PurchaseOrderBO consultarPO(@WebParam(name = "numSeguimiento") String numSeguimiento) throws BussinessException {
        return ejbRef.consultarPO(numSeguimiento);
    }

    @WebMethod(operationName = "establecerFabricanteAtiende")
    public boolean establecerFabricanteAtiende(@WebParam(name = "numSeguimiento") String numSeguimiento, @WebParam(name = "fabricante") FabricanteBO fabricante,
            @WebParam(name = "productosAtiende") List<ProductoBO> productosAtiende) throws BussinessException {
        return ejbRef.establecerFabricanteAtiende(numSeguimiento, fabricante, productosAtiende);
    }

    @WebMethod(operationName = "consultarComercioPorPO")
    public ComercioBO consultarComercioPorPO(@WebParam(name = "numSeguimiento") String numSeguimiento) throws BussinessException {
        return ejbRef.consultarComercioPorPO(numSeguimiento);
    }

    /**
     * Crea un usuario en el sistema.
     * @param nit
     * @param nombre
     * @param rol Puede ser Comercio o Fabricante
     * @return true en caso de que la creacion sea satisfactoria
     * @throws BussinessException
     */
    @WebMethod(operationName = "crearCliente")
    public boolean crearCliente(
            @WebParam(name = "nit") String nit, @WebParam(name = "nombre") String nombre, @WebParam(name = "rol") String rol)
            throws BussinessException {
        return ejbRef.crearCliente(nit, nombre, rol);
    }

    /**
     * Actualiza un usuario en el sistema, unicamente el nombre.
     * @param nit
     * @param nombre
     * @param rol Puede ser Comercio o Fabricante
     * @return true en caso de que la actualizacion sea satisfactoria
     * @throws BussinessException En caso de que no exista
     */
    @WebMethod(operationName = "actualizarCliente")
    public boolean actualizarCliente(
            @WebParam(name = "nit") String nit, @WebParam(name = "nombre") String nombre, @WebParam(name = "rol") String rol)
            throws BussinessException {
        return ejbRef.actualizarCliente(nit, nombre, rol);
    }
}
