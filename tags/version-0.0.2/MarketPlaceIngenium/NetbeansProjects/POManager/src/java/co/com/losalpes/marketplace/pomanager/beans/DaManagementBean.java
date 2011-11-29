/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
import co.com.losalpes.marketplace.pomanager.entities.DispatchAdvice;
import co.com.losalpes.marketplace.pomanager.entities.Fabricante;
import co.com.losalpes.marketplace.pomanager.entities.ItemPO;
import co.com.losalpes.marketplace.pomanager.entities.Producto;
import co.com.losalpes.marketplace.pomanager.entities.PurchaseOrder;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marketplace
 */
@Stateless
public class DaManagementBean implements DaManagementRemote, DaManagementLocal {

    @PersistenceContext
    private EntityManager em;

    public String registrarDA(DispatchAdviceBO da, String numSeguimientoPo) throws BussinessException {
        DispatchAdvice aviso = new DispatchAdvice(da);
        String numSeguimiento = "DA-" + numSeguimientoPo + "-" + System.currentTimeMillis();
        da.setNumSeguimiento(numSeguimiento);

        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimientoPo);
        List<PurchaseOrder> po = (List<PurchaseOrder>) q.getResultList();
        if (po.isEmpty()) {
            throw new BussinessException("La orden de compra especificada no existe");
        }
        da.setPo(po.get(0).toBO());

        q = em.createNamedQuery("getFabricanteFromNit");
        q.setParameter("nit", da.getFabricante().getNit());
        List<Fabricante> fabricantes = (List<Fabricante>) q.getResultList();
        Fabricante fab = null;
        if (fabricantes.isEmpty()) {
            fab = new Fabricante(da.getFabricante());
            em.persist(fab);
        } else {
            fab = fabricantes.get(0);
        }
        da.setFabricante(fab.toBO());

        List<ItemPO> its = new ArrayList<ItemPO>();
        for (int i = 0; i < da.getItems().size(); i++) {
            Producto p = new Producto(da.getItems().get(i).getProductoBO());
            em.persist(p);
            ItemPO it = new ItemPO(da.getItems().get(i));
            it.setProducto(p);
            its.add(it);
            em.persist(it);
        }
        aviso.setItems(its);
        em.persist(aviso);
        em.flush();
        return numSeguimiento;
    }

    public DispatchAdviceBO consultarDA(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getDaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        DispatchAdvice da = (DispatchAdvice) q.getSingleResult();
        if (da == null) {
            throw new BussinessException("El aviso de despacho con el número de seguimiento " +
                    numSeguimiento + " no existe.");
        }
        return da.toBO();
    }

    public List<DispatchAdviceBO> consultarDAsFabricante(String nit) throws BussinessException {
        Query q = em.createNamedQuery("getDaByFabricante");
        q.setParameter("nit", nit);
        List<DispatchAdvice> das = (List<DispatchAdvice>) q.getResultList();
        if (das.isEmpty()) {
            throw new BussinessException("El cliente especificado no tiene DAs asociadas");
        }
        List<DispatchAdviceBO> dasBO = new ArrayList<DispatchAdviceBO>();
        for (int i = 0; i < das.size(); i++) {
            dasBO.add(das.get(0).toBO());
        }
        return dasBO;
    }

    public DispatchAdviceBO consultarDAnumSeguimientoPO(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<PurchaseOrder> pos = (List<PurchaseOrder>) q.getResultList();
        if (pos.isEmpty()) {
            throw new BussinessException("La orden de compra especificada no existe");
        }
        q = em.createNamedQuery("getDaByNumSeguimientoPO");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<DispatchAdvice> das = (List<DispatchAdvice>) q.getResultList();
        if (das.isEmpty()) {
            throw new BussinessException("No existe aviso de despacho asociado a la PO especificada");
        }
        return das.get(0).toBO();
    }
}
