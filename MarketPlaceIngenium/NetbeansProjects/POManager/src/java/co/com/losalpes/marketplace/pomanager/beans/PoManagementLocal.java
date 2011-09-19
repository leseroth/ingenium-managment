/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
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

    public PurchaseOrderBO consultarPO(String numSeguimiento) throws OrdenCompraNoExisteException;

    public boolean actualizarEstadoPO(String numSeguimiento, String estado) throws OrdenCompraNoExisteException;

    public boolean establecerFabricanteAtiende(String numSeguimiento, FabricanteBO fabricante, List<ProductoBO> productosAtiende) throws OrdenCompraNoExisteException;

    public ComercioBO consultarComercioPorPO(String numSeguimiento) throws OrdenCompraNoExisteException;

    public List<PurchaseOrderBO> consultarPOsComercio(String nit) throws ClienteNoExisteException;
}
