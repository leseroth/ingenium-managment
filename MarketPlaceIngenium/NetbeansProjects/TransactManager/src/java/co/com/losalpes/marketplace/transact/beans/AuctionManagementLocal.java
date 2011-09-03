/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.losalpes.marketplace.transact.beans;

import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.OfertaBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.exceptions.SubastaCerradaException;
import co.com.losalpes.marketplace.transact.exceptions.SubastaNoExisteException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface AuctionManagementLocal {

    public String crearSubasta(PurchaseOrderBO po);

    public Boolean asignarFabricantesSubasta(String numSeguimientoSubasta, List<FabricanteBO> fabricantes) throws SubastaNoExisteException, SubastaCerradaException;

    public boolean registrarOferta(String numSeguimientoSubasta, OfertaBO oferta) throws SubastaNoExisteException, SubastaCerradaException;

    public FabricanteBO darGanadorSubasta(String numSeguimientoSubasta) throws SubastaNoExisteException;

    public boolean cerrarSubasta(String numSeguimientoSubasta) throws SubastaNoExisteException;

    public List<SubastaBO> consultarSubastasFabricante(String nit);

    public List<FabricanteBO> consultarFabricantesSubasta(String numSeguimiento) throws SubastaNoExisteException;

    public SubastaBO consultarSubastaOrdenCompra(String numSeguimientoPO) throws SubastaNoExisteException;
}
