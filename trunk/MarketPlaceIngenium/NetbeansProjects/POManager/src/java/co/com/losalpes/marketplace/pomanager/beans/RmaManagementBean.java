/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
import co.com.losalpes.marketplace.pomanager.entities.DispatchAdvice;
import co.com.losalpes.marketplace.pomanager.entities.ItemPO;
import co.com.losalpes.marketplace.pomanager.entities.Producto;
import co.com.losalpes.marketplace.pomanager.entities.PurchaseOrder;
import co.com.losalpes.marketplace.pomanager.entities.ReturnMaterialAdvice;
import co.com.losalpes.marketplace.pomanager.exceptions.AvisoDespachoNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marketplace
 */
@Stateless
public class RmaManagementBean implements RmaManagementRemote, RmaManagementLocal {

    @PersistenceContext
    private EntityManager em;

    public String registrarRMA(ReturnMaterialAdviceBO rma) throws OrdenCompraNoExisteException, AvisoDespachoNoExisteException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", rma.getPo().getNumSeguimiento());
        List<PurchaseOrder> po = (List<PurchaseOrder>)q.getResultList();
        if(po.isEmpty())
            throw new OrdenCompraNoExisteException("La orden de compra con el número de seguimiento "+
                    rma.getPo().getNumSeguimiento() + " no existe.");
        q = em.createNamedQuery("getDaFromNumSeguimiento");
        q.setParameter("numSeguimiento", rma.getDa().getNumSeguimiento());
        List<DispatchAdvice> da = (List<DispatchAdvice>)q.getResultList();
        if(da.isEmpty())
            throw new AvisoDespachoNoExisteException("El aviso de despacho con el número de seguimiento "+
                    rma.getDa().getNumSeguimiento() + " no existe.");
        ReturnMaterialAdvice rm = new ReturnMaterialAdvice(rma);
        List<ItemPO> items = new ArrayList<ItemPO>();
         for(int i = 0; i < rma.getItemsDevueltos().size(); i++){
             ItemPOBO it = rma.getItemsDevueltos().get(i);
             ItemPO item = new ItemPO();
             Producto prod = po.get(0).getItems().get(0).getProducto();
             item.setProducto(prod);
             item.setCantidad(it.getCantidad());
             items.add(item);
         }
        rm.setPo(po.get(0));
        rm.setDa(da.get(0));
        String numSeguimiento = "RMA-"+po.get(0).getNumSeguimiento()+"-"+da.get(0).getNumSeguimiento()+"-"+System.currentTimeMillis();
        rm.setNumSeguimiento(numSeguimiento);
        em.persist(rm);
        //em.flush();
        return numSeguimiento;
    }

    public List<ReturnMaterialAdviceBO> consultarRMAsComercio(String nit) throws ClienteNoExisteException{
        Query q = em.createNamedQuery("getRMAsComercio");
        q.setParameter("nit", nit);
        List<ReturnMaterialAdvice> rmas = (List<ReturnMaterialAdvice>)q.getResultList();
        if(rmas.isEmpty())
            throw new ClienteNoExisteException("El cliente especificado no tiene RMAs asociadas");
        List<ReturnMaterialAdviceBO> rmasBO = new ArrayList<ReturnMaterialAdviceBO>();
        for(int i = 0; i < rmas.size(); i++){
            rmasBO.add(rmas.get(i).toBO());
        }
        return rmasBO;
    }

    public List<ReturnMaterialAdviceBO> consultarRMAsFabricante(String nit) throws ClienteNoExisteException{
        Query q = em.createNamedQuery("getRMAsFabricante");
        q.setParameter("nit", nit);
        List<ReturnMaterialAdvice> rmas = (List<ReturnMaterialAdvice>)q.getResultList();
        if(rmas.isEmpty())
            throw new ClienteNoExisteException("El cliente especificado no tiene RMAs asociadas");
        List<ReturnMaterialAdviceBO> rmasBO = new ArrayList<ReturnMaterialAdviceBO>();
        for(int i = 0; i < rmas.size(); i++){
            rmasBO.add(rmas.get(i).toBO());
        }
        return rmasBO;
    }
}
