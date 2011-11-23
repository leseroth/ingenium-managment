/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.List;
import javax.ejb.Local;

/**
 * Interfaz local de POManagement
 * @author Erik
 */
@Local
public interface PoManagementLocal {

    /**
     * Recibe el purchaseOrder, si esta presente el fabricante es una orden de compra directa.
     * <ul>
     * <li>Si el comercio no existe se crea</li>
     * <li>Si el fabricante no existe se crea</li>
     * <li>El producto siempre se crea</li>
     * <li>Si el fabricante viene, se considera orden directa y se asocia al producto</li>
     * <li> Si se debe crear el comercio debe tener nit y nombre</li>
     * <li>Si se debe crear el fabricante debe tener nit y nombre</li>
     * <li>La orden de compra no debe tener estado, numSeguimiento ni id</li>
     * <li>El producto debe tener categoria, nombre y precio</li>
     * </ul>
     * @param purchaseOrderBO PurchaseOrderBO
     * @return El numero de seguimiento
     * @throws BussinessException Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
     */
    public String registrarPO(PurchaseOrderBO purchaseOrderBO) throws BussinessException;

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
    public List<PurchaseOrderBO> consultarPOFabricantePorEstado(String nit, String estado) throws BussinessException;

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
    public boolean actualizarEstadoPO(String numSeguimiento, String estado) throws BussinessException;

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
    public List<PurchaseOrderBO> consultarPOsComercio(String nit) throws BussinessException;

    public PurchaseOrderBO consultarPO(String numSeguimiento) throws BussinessException;

    public boolean establecerFabricanteAtiende(String numSeguimiento, FabricanteBO fabricante, List<ProductoBO> productosAtiende) throws BussinessException;

    public ComercioBO consultarComercioPorPO(String numSeguimiento) throws BussinessException;

    /**
     * Crea un usuario en el sistema.
     * @param nit
     * @param nombre
     * @param rol Puede ser Comercio o Fabricante
     * @return true en caso de que la creacion sea satisfactoria
     * @throws BussinessException
     */
    public boolean crearCliente(String nit, String nombre, String rol) throws BussinessException;

    /**
     * Actualiza un usuario en el sistema, unicamente el nombre.
     * @param nit
     * @param nombre
     * @param rol Puede ser Comercio o Fabricante
     * @return true en caso de que la actualizacion sea satisfactoria
     * @throws BussinessException En caso de que no exista
     */
    public boolean actualizarCliente(String nit, String nombre, String rol) throws BussinessException;
}
