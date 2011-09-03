/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.transact.beans;

import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.OfertaBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.entities.Fabricante;
import co.com.losalpes.marketplace.transact.entities.ItemPO;
import co.com.losalpes.marketplace.transact.entities.Oferta;
import co.com.losalpes.marketplace.transact.entities.Producto;
import co.com.losalpes.marketplace.transact.entities.PurchaseOrder;
import co.com.losalpes.marketplace.transact.entities.Subasta;
import co.com.losalpes.marketplace.transact.exceptions.SubastaCerradaException;
import co.com.losalpes.marketplace.transact.exceptions.SubastaNoExisteException;
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
public class AuctionManagementBean implements AuctionManagementRemote, AuctionManagementLocal {

    @PersistenceContext
    private EntityManager em;

    public String crearSubasta(PurchaseOrderBO po) {
        PurchaseOrder p = new PurchaseOrder(po);
        em.persist(p.getComercio());
        em.flush();

        ItemPO item = p.getItem();
        Producto prod = item.getProducto();
        em.persist(prod);
        em.flush();
        em.persist(item);
        em.flush();

        em.persist(p);
        em.flush();

        Subasta s = new Subasta();
        s.setPo(p);
        s.setActiva(true);
        s.setNumSeguimiento("sub" + System.currentTimeMillis());
        em.persist(s);
        em.close();
        return s.getNumSeguimiento();
    }

    public Boolean asignarFabricantesSubasta(String numSeguimientoSubasta, List<FabricanteBO> fabricantes) throws SubastaNoExisteException, SubastaCerradaException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimientoSubasta);
        List<Subasta> sub = (List<Subasta>)q.getResultList();
        if (sub.isEmpty())
            throw new SubastaNoExisteException("La subasta identificada con el número de seguimiento "+
                    numSeguimientoSubasta + " no existe");
        if (!sub.get(0).isActiva())
            throw new SubastaCerradaException("La subasta identificada con el número de seguimiento " +
                    numSeguimientoSubasta + " está cerrada");
        List<Fabricante> fabs = new ArrayList<Fabricante>();
        for(int i = 0; i < fabricantes.size(); i++){
            q = em.createNamedQuery("getFabricanteFromNit");
            q.setParameter("nit", fabricantes.get(i).getNit());
            List<Fabricante> fabrics = (List<Fabricante>)q.getResultList();
            if (fabrics.isEmpty()) {
                Fabricante f = new Fabricante();
                f.setNombre(fabricantes.get(i).getNombre());
                f.setNit(fabricantes.get(i).getNit());
                f.setEmail(fabricantes.get(i).getEmail());
                em.persist(f);
                fabs.add(f);
            }
            else
                fabs.add(fabrics.get(0));
        }
        sub.get(0).setFabricantes(fabs);
        return true;
    }

    public boolean registrarOferta(String numSeguimientoSubasta, OfertaBO oferta) throws SubastaNoExisteException, SubastaCerradaException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimientoSubasta);
        List<Subasta> sub = (List<Subasta>)q.getResultList();
        if (sub.isEmpty())
            throw new SubastaNoExisteException("La subasta identificada con el número de seguimiento "+
                    numSeguimientoSubasta + " no existe");
        if (!sub.get(0).isActiva())
            throw new SubastaCerradaException("La subasta identificada con el número de seguimiento " +
                    numSeguimientoSubasta + " está cerrada");

        q = em.createNamedQuery("getFabricanteFromNit");
        q.setParameter("nit", oferta.getFabricante().getNit());
        List<Fabricante> fabs = (List<Fabricante>)q.getResultList();
        if (fabs.isEmpty()) {
            Fabricante f = new Fabricante();
            f.setNombre(oferta.getFabricante().getNombre());
            f.setNit(oferta.getFabricante().getNit());
            f.setEmail(oferta.getFabricante().getEmail());
            em.persist(f);
            fabs.add(f);
        }
        Oferta of = new Oferta(oferta);
        of.setFabricante(fabs.get((0)));
        of.setFechaEntrega(oferta.getFechaEntrega());
        of.setProductoOfrecido(new Producto(oferta.getProductoOfrecido()));
        em.persist(of);

        Oferta offer = sub.get(0).getMejor();
        if(offer.getValor() < oferta.getValor()){
            sub.get(0).setMejor(new Oferta(oferta));
        }

        return true;
    }

    public FabricanteBO darGanadorSubasta(String numSeguimiento) throws SubastaNoExisteException{
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        Subasta sub = (Subasta)q.getSingleResult();
        if(sub == null)
            throw new SubastaNoExisteException("La subasta identificada con el nùmero de seguimiento "+ numSeguimiento+" no existe.");
        return sub.getMejor().getFabricante().toBO();
    }

    public boolean cerrarSubasta(String numSeguimiento) throws SubastaNoExisteException{
        Subasta s = em.find(Subasta.class, numSeguimiento);
        if(s == null)
            throw new SubastaNoExisteException("La subasta identificada con el nùmero de seguimiento "+ numSeguimiento+" no existe.");
        s.setActiva(false);
        return true;
    }

    public List<SubastaBO> consultarSubastasFabricante(String nit){
        Query q = em.createNamedQuery("getAllSubastas");
        List<Subasta> subs = (List<Subasta>)q.getResultList();
        List<SubastaBO> subsBO = new ArrayList<SubastaBO>();
        for(int i = 0; i < subs.size(); i++){
            List<Fabricante> fabs = subs.get(i).getFabricantes();
            for(int j = 0; j < fabs.size(); j++){
                if(fabs.get(j).getNit().equals(nit)) {
                    subsBO.add(subs.get(i).toBO());
                    break;
                }
            }
        }
        return subsBO;
    }

    public List<FabricanteBO> consultarFabricantesSubasta(String numSeguimiento) throws SubastaNoExisteException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<Subasta> subs = (List<Subasta>)q.getResultList();
        if(subs.isEmpty())
            throw new SubastaNoExisteException("La subasta especificada no existe");
        List<FabricanteBO> fabs = new ArrayList<FabricanteBO>();
        for(int i = 0; i < subs.get(0).getFabricantes().size(); i++){
            Fabricante f = subs.get(0).getFabricantes().get(i);
            FabricanteBO fab = new FabricanteBO();
            fab.setNit(f.getNit());
            fab.setNombre(f.getNombre());
            fab.setEmail(f.getEmail());
            fabs.add(fab);
        }
        return fabs;
    }

    public SubastaBO consultarSubastaOrdenCompra(String numSeguimientoPO) throws SubastaNoExisteException {
        Query q = em.createNamedQuery("getSubastaFromOrdenCompra");
        q.setParameter("numSeguimientoPO", numSeguimientoPO);
        List<Subasta> subs = (List<Subasta>)q.getResultList();
        if(subs.isEmpty())
            throw new SubastaNoExisteException("La subasta asociada a la ordend de compra especificada no existe");
        return subs.get(0).toBO();
    }
}
