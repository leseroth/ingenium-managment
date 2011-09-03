/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.losalpes.marketplace.transact.ws;

import co.com.losalpes.marketplace.transact.beans.AuctionManagementLocal;
import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.OfertaBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.exceptions.SubastaCerradaException;
import co.com.losalpes.marketplace.transact.exceptions.SubastaNoExisteException;
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
public class TransactAuctionManagement {

    @EJB
    private AuctionManagementLocal ejbRef;

    @WebMethod(operationName = "crearSubasta")
    public String crearSubasta(@WebParam(name = "po") PurchaseOrderBO po) {
        return ejbRef.crearSubasta(po);
    }

    @WebMethod(operationName = "registrarOferta")
    public boolean registrarOferta(@WebParam(name="numSeguimientoSubasta") String numSeguimientoSubasta,
        @WebParam(name = "oferta") OfertaBO oferta) throws SubastaNoExisteException, SubastaCerradaException {
        return ejbRef.registrarOferta(numSeguimientoSubasta, oferta);
    }

    @WebMethod(operationName = "darGanadorSubasta")
    public FabricanteBO darGanadorSubasta(@WebParam(name = "idSubasta") String idSubasta)
        throws SubastaNoExisteException {
        return ejbRef.darGanadorSubasta(idSubasta);
    }

    @WebMethod(operationName = "cerrarSubasta")
    public boolean cerrarSubasta(@WebParam(name = "idSubasta") String idSubasta)
        throws SubastaNoExisteException {
        return ejbRef.cerrarSubasta(idSubasta);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarSubastasFabricante")
    public java.util.List<SubastaBO> consultarSubastasFabricante(@WebParam(name = "nit")
    String nit) {
        return ejbRef.consultarSubastasFabricante(nit);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "asignarFabricantesSubasta")
    public Boolean asignarFabricantesSubasta(@WebParam(name = "numSeguimientoSubasta")
    String numSeguimientoSubasta, @WebParam(name = "fabricantes")
    java.util.List<FabricanteBO> fabricantes) throws SubastaCerradaException, SubastaNoExisteException {
        return ejbRef.asignarFabricantesSubasta(numSeguimientoSubasta, fabricantes);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarFabricantesSubasta")
    public java.util.List<FabricanteBO> consultarFabricantesSubasta(@WebParam(name = "numSeguimiento")
    String numSeguimiento) throws SubastaNoExisteException {
        return ejbRef.consultarFabricantesSubasta(numSeguimiento);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarSubastaOrdenCompra")
    public SubastaBO consultarSubastaOrdenCompra(@WebParam(name = "numSeguimientoPO")
    String numSeguimientoPO) throws SubastaNoExisteException {
        return ejbRef.consultarSubastaOrdenCompra(numSeguimientoPO);
    }
}
