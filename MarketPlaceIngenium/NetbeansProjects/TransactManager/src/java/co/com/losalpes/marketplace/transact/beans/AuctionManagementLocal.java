package co.com.losalpes.marketplace.transact.beans;

import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.OfertaBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.exceptions.BussinessException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AuctionManagementLocal {

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
    public String crearSubasta(PurchaseOrderBO po) throws BussinessException;

    public Boolean asignarFabricantesSubasta(String numSeguimientoSubasta, List<FabricanteBO> fabricantes) throws BussinessException;

    public boolean registrarOferta(String numSeguimientoSubasta, OfertaBO oferta) throws BussinessException;

    public FabricanteBO darGanadorSubasta(String numSeguimientoSubasta) throws BussinessException;

    public boolean cerrarSubasta(String numSeguimientoSubasta) throws BussinessException;

    public List<SubastaBO> consultarSubastasFabricante(String nit);

    public List<FabricanteBO> consultarFabricantesSubasta(String numSeguimiento) throws BussinessException;

    public SubastaBO consultarSubastaOrdenCompra(String numSeguimientoPO) throws BussinessException;
}
