package co.com.losalpes.marketplace.pomanager.beans;

import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.entities.PurchaseOrder;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.entities.Comercio;
import co.com.losalpes.marketplace.pomanager.entities.Fabricante;
import co.com.losalpes.marketplace.pomanager.entities.ItemPO;
import co.com.losalpes.marketplace.pomanager.entities.Producto;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static co.com.losalpes.marketplace.pomanager.util.Constants.*;
import static co.com.losalpes.marketplace.pomanager.util.Util.*;

/**
 * Bean que implementa los metodos del servicio web relacionado a las ordenes de compra
 * @author Erik
 */
@Stateless
public class PoManagementBean implements PoManagementRemote, PoManagementLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public String registrarPO(PurchaseOrderBO purchaseOrderBO) throws BussinessException {

        PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderBO);
        Query query = null;

        // Validar que venga la informacion que es
        if (purchaseOrder.getEstado() != null || purchaseOrder.getNumSeguimiento() != null || purchaseOrder.getId() != null) {
            throw new BussinessException(EXC_ENTITY_TOO_MUCH_INFO, "estado, numSeguimiento, id", "PurchaseOrder");
        }

        // Buscar el comercio
        Comercio com = purchaseOrder.getComercio();
        query = em.createNamedQuery("getComercioByNit");
        query.setParameter("nit", com.getNit());
        List<Comercio> comList = (List<Comercio>) query.getResultList();
        if (comList.isEmpty()) {
            if (com.isInfoComplete()) {
                if (com.getId() == null) {
                    em.persist(com);
                } else {
                    throw new BussinessException(EXC_ENTITY_DETACHED, "Comercio");
                }
            } else {
                throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Comercio");
            }
        } else {
            purchaseOrder.setComercio(comList.get(0));
        }

        // Asignar numero de seguimiento
        String numSeguimiento = getNumSeguimiento(purchaseOrder.getComercio());
        purchaseOrder.setNumSeguimiento(numSeguimiento);

        // Registrar el fabricante si es orden directa
        Fabricante fab = purchaseOrder.getFabricante();
        if (fab != null) {
            query = em.createNamedQuery("getFabricanteByNit");
            query.setParameter("nit", purchaseOrderBO.getFabricanteBO().getNit());
            List<Fabricante> fabList = (List<Fabricante>) query.getResultList();
            if (fabList.isEmpty()) {
                if (fab.isInfoComplete()) {
                    if (fab.getId() == null) {
                        em.persist(fab);
                    } else {
                        throw new BussinessException(EXC_ENTITY_DETACHED, "Fabricante");
                    }
                } else {
                    throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Fabricante");
                }
            } else {
                fab = fabList.get(0);
                purchaseOrder.setFabricante(fab);
            }
        }

        // Registrar los items
        for (ItemPO itemPO : purchaseOrder.getItems()) {
            Producto producto = itemPO.getProducto();
            //Si era compra directa, asociar el fabricante
            if (fab != null) {
                producto.setFabricanteAtiende(fab);
            } else {
                producto.setFabricanteAtiende(null);
            }
            if (producto.isInfoComplete()) {
                em.persist(producto);
            } else {
                throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Producto");
            }
            em.persist(itemPO);
        }

        purchaseOrder.setEstado(PurchaseOrderState.SolicitadoComercio.toString());
        em.persist(purchaseOrder);

        return numSeguimiento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderBO> consultarPOFabricantePorEstado(String nit, String estado) throws BussinessException {
        // Verificar el estado
        if (estado != null) {
            PurchaseOrderState state = PurchaseOrderState.getState(estado);
            if (state == null) {
                throw new BussinessException(EXC_INCORRECT_STATE, estado);
            }
        }

        Query query;
        // Verificar que exista el fabricante
        query = em.createNamedQuery("getFabricanteByNit");
        query.setParameter("nit", nit);
        if (query.getResultList().isEmpty()) {
            throw new BussinessException(EXC_ENTITY_INEXSISTENT, "Fabricante", "nit=" + nit);
        }

        // Cargar las ordenes de compra del fabricante
        query = em.createNamedQuery("getPurchaseOrdersByNitFabricante");
        query.setParameter("nit", nit);
        List<PurchaseOrder> poFabricanteList = (List<PurchaseOrder>) query.getResultList();

        // Crear el objeto de respuesta
        List<PurchaseOrderBO> poBOFabricanteList = new ArrayList<PurchaseOrderBO>();
        for (PurchaseOrder po : poFabricanteList) {
            if (estado == null || estado.equals(po.getEstado())) {
                poBOFabricanteList.add(po.toBO());
            }
        }

        return poBOFabricanteList;
    }

    /**
     * {@inheritDoc}
     */
    public boolean actualizarEstadoPO(String numSeguimiento, String estado) throws BussinessException {
        boolean updated = false;

        if (numSeguimiento == null) {
            throw new BussinessException(EXC_INCORRECT_ARGUMENT, "numSeguimiento=null");
        } else {
            PurchaseOrderState stateAfter = PurchaseOrderState.getState(estado);

            if (stateAfter == null) {
                throw new BussinessException(EXC_INCORRECT_STATE, estado);
            }

            Query q = em.createNamedQuery("getPurchaseOrderByNumSeguimiento");
            q.setParameter("numSeguimiento", numSeguimiento);
            List<PurchaseOrder> poList = q.getResultList();
            PurchaseOrder po = null;
            if (poList.isEmpty()) {
                throw new BussinessException(EXC_PO_STATE_UPDATE, "No existe el numero de seguimiento " + numSeguimiento);
            } else if (poList.size() != 1) {
                throw new BussinessException(EXC_PO_STATE_UPDATE, "Esta repetido el numero de seguimiento " + numSeguimiento);
            } else {
                po = poList.get(0);
            }

            PurchaseOrderState stateBefore = PurchaseOrderState.getState(po.getEstado());
            if (PurchaseOrderState.isValidStateChange(stateBefore, stateAfter)) {
                po.setEstado(stateAfter.toString());
                em.persist(po);
                em.flush();
                updated = true;
            } else {
                throw new BussinessException(EXC_PO_STATE_UPDATE, "No se puede pasar de " + stateBefore + " a " + stateAfter);
            }
        }

        return updated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PurchaseOrderBO> consultarPOsComercio(String nit) throws BussinessException {
        Query query = em.createNamedQuery("getPurchaseOrdersByNitComercio");
        query.setParameter("nit", nit);

        List<PurchaseOrder> poComercioList = (List<PurchaseOrder>) query.getResultList();
        List<PurchaseOrderBO> poBOComercioList = new ArrayList<PurchaseOrderBO>();
        for (PurchaseOrder po : poComercioList) {
            poBOComercioList.add(po.toBO());
        }
        
        return poBOComercioList;
    }

    public PurchaseOrderBO consultarPO(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<PurchaseOrder> po = (List<PurchaseOrder>) q.getResultList();
        if (po.isEmpty()) {
            throw new BussinessException("La orden de compra con el número de seguimiento " +
                    numSeguimiento + " no existe");
        }
        return po.get(0).toBO();
    }

    public boolean establecerFabricanteAtiende(String numSeguimiento, FabricanteBO fabricante, List<ProductoBO> productosAtiende) throws BussinessException {
        try {
            Query q = em.createNamedQuery("getPoFromNumSeguimiento");
            q.setParameter("numSeguimiento", numSeguimiento);
            PurchaseOrder po = (PurchaseOrder) q.getSingleResult();
            Fabricante fab = em.find(Fabricante.class, fabricante.getNit());
            if (fab == null) {
                fab = new Fabricante(fabricante);
                em.persist(fab);
            }
            Collection<ItemPO> items = po.getItems();
            Iterator<ItemPO> it = items.iterator();
            while (it.hasNext()) {
                ItemPO item = it.next();
                if (productosAtiende.contains(item.getProducto().toBO())) {
                    item.getProducto().setFabricanteAtiende(fab);
                }
            }
            em.flush();
        } catch (Exception ex) {
            throw new BussinessException("La orden de compra con el número de seguimiento " +
                    numSeguimiento + " no existe");
        }
        return true;
    }

    public ComercioBO consultarComercioPorPO(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<PurchaseOrder> pos = (List<PurchaseOrder>) q.getResultList();
        if (pos.isEmpty()) {
            throw new BussinessException("La orden de compra con el número de seguimiento " + numSeguimiento + " no existe.");
        }
        return pos.get(0).getComercio().toBO();
    }
}
