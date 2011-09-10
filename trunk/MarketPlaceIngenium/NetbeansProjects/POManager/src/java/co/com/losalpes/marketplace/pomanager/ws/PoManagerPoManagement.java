/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.ws;

import co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.List;
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
public class PoManagerPoManagement {
    @EJB
    private PoManagementLocal ejbRef;

    @WebMethod(operationName = "registrarPO")
    public String registrarPO(@WebParam(name = "po")
    PurchaseOrderBO po) {
        return ejbRef.registrarPO(po);
    }

    @WebMethod(operationName = "consultarPO")
    public PurchaseOrderBO consultarPO(@WebParam(name = "numSeguimiento")
    String numSeguimiento) throws OrdenCompraNoExisteException{
        return ejbRef.consultarPO(numSeguimiento);
    }

    @WebMethod(operationName = "actualizarEstadoPO")
    public boolean actualizarEstadoPO(@WebParam(name = "numSeguimiento")
    String numSeguimiento, @WebParam(name = "estado") String estado) throws OrdenCompraNoExisteException{
        return ejbRef.actualizarEstadoPO(numSeguimiento, estado);
    }

    @WebMethod(operationName = "establecerFabricanteAtiende")
    public boolean establecerFabricanteAtiende(@WebParam(name = "numSeguimiento")
    String numSeguimiento, @WebParam(name = "fabricante")FabricanteBO fabricante,
    @WebParam(name = "productosAtiende") List<ProductoBO> productosAtiende) throws OrdenCompraNoExisteException{
        return ejbRef.establecerFabricanteAtiende(numSeguimiento, fabricante, productosAtiende);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarComercioPorPO")
    public ComercioBO consultarComercioPorPO(@WebParam(name = "numSeguimiento")
    String numSeguimiento) throws OrdenCompraNoExisteException {
        return ejbRef.consultarComercioPorPO(numSeguimiento);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarPOsComercio")
    public java.util.List<PurchaseOrderBO> consultarPOsComercio(@WebParam(name = "nit")
    String nit) throws ClienteNoExisteException {
        return ejbRef.consultarPOsComercio(nit);
    }

}