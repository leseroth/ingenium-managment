package co.com.losalpes.marketplace.transact.ws;

import co.com.losalpes.marketplace.transact.beans.AuctionManagementLocal;
import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.exceptions.BussinessException;
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
public class TransactAuctionManagement {

    @EJB
    private AuctionManagementLocal ejbRef;

    /**
     * Recibe el purchaseOrder, si esta presente el fabricante es una orden de compra directa.
     * <ul>
     * <li>Crea el registro en PurchaseOrder y en Subasta</li>
     * <li>El numero de seguimiento debe estar presente como correlacion con POManager y no estar repetido</li>
     * <li>El numero de seguimiento es igual en POManager y en TransactManager</li>
     * <li>Si el comercio no existe se crea</li>
     * <li>El producto se crea si no existe</li>
     * <li>Si se debe crear el comercio debe tener nit y nombre</li>
     * <li>Si la orden de compra tiene id es ignorado, dado que el id es local a la base de datos</li>
     * <li>El producto debe tener categoria y nombre</li>
     * <li>El item debe tener cantidad</li>
     * </ul>
     * @param po PurchaseOrderBO
     * @return El numero de seguimiento
     * @throws BussinessException Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
     */
    @WebMethod(operationName = "crearSubasta")
    public String crearSubasta(@WebParam(name = "po") PurchaseOrderBO po) throws BussinessException {
        return ejbRef.crearSubasta(po);
    }

    /**
     * Recibe el numero de seguimiento de una subasta y le asigna los fabricantes indicados
     * <ul>
     * <li>El numero de seguimiento debe existir</li>
     * <li>No deben existir en la base de datos mas de una subasta con ese numero de seguimiento</li>
     * <li>Si el fabricante no existe se crea</li>
     * <li>La informacion del fabricante debe estar completa para poder ser adicionado a la lista</li>
     * <li>Un fabricante debe tener nit, nombre y email para poder ser creado</li>
     * <li>La subasta solo asigna a los fabricantes que existian o los que fue posible crear</li>
     * <li>La subasta no debe tener ningun fabricante registrado</li>
     * <li>Si ningun fabricante se puede asignar a la subasta esta finaliza y pasa a estar inactiva</li>
     * </ul>
     * @param numSeguimientoSubasta Numero de segumiento
     * @param fabricantes Lista de fabricantes
     * @return true en caso de que el proceso termine correctamente, false en caso de que no se haya podido asignar ningun fabricante a la subasta
     * @throws BussinessException Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
     */
    @WebMethod(operationName = "asignarFabricantesSubasta")
    public Boolean asignarFabricantesSubasta(@WebParam(name = "numSeguimientoSubasta") String numSeguimientoSubasta, @WebParam(name = "fabricantes") java.util.List<FabricanteBO> fabricantes) throws BussinessException {
        return ejbRef.asignarFabricantesSubasta(numSeguimientoSubasta, fabricantes);
    }

    @WebMethod(operationName = "darGanadorSubasta")
    public FabricanteBO darGanadorSubasta(@WebParam(name = "idSubasta") String idSubasta)
            throws BussinessException {
        return ejbRef.darGanadorSubasta(idSubasta);
    }

    @WebMethod(operationName = "cerrarSubasta")
    public boolean cerrarSubasta(@WebParam(name = "idSubasta") String idSubasta)
            throws BussinessException {
        return ejbRef.cerrarSubasta(idSubasta);
    }

    @WebMethod(operationName = "consultarSubastasFabricante")
    public java.util.List<SubastaBO> consultarSubastasFabricante(@WebParam(name = "nit") String nit) {
        return ejbRef.consultarSubastasFabricante(nit);
    }

    @WebMethod(operationName = "consultarFabricantesSubasta")
    public java.util.List<FabricanteBO> consultarFabricantesSubasta(@WebParam(name = "numSeguimiento") String numSeguimiento) throws BussinessException {
        return ejbRef.consultarFabricantesSubasta(numSeguimiento);
    }

    @WebMethod(operationName = "consultarSubastaOrdenCompra")
    public SubastaBO consultarSubastaOrdenCompra(@WebParam(name = "numSeguimientoPO") String numSeguimientoPO) throws BussinessException {
        return ejbRef.consultarSubastaOrdenCompra(numSeguimientoPO);
    }
}
