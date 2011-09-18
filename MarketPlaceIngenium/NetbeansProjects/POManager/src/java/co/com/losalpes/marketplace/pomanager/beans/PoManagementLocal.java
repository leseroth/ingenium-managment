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
import co.com.losalpes.marketplace.pomanager.exceptions.FabricanteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.List;
import javax.ejb.Local;

/**
 * 
 * @author Erik
 */
@Local
public interface PoManagementLocal {

    public String registrarPO(PurchaseOrderBO purchaseOrderBO);

    public PurchaseOrderBO consultarPO(String numSeguimiento) throws OrdenCompraNoExisteException;

    public boolean actualizarEstadoPO(String numSeguimiento, String estado) throws OrdenCompraNoExisteException;

    public boolean establecerFabricanteAtiende(String numSeguimiento, FabricanteBO fabricante, List<ProductoBO> productosAtiende) throws OrdenCompraNoExisteException;

    public ComercioBO consultarComercioPorPO(String numSeguimiento) throws OrdenCompraNoExisteException;

    public List<PurchaseOrderBO> consultarPOsComercio(String nit) throws ClienteNoExisteException;

    public List<PurchaseOrderBO> consultarPOsFabricante(String nit) throws FabricanteNoExisteException;
}
