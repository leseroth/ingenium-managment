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
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.FabricanteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
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
 * 
 * @author Erik
 */
@Stateless
public class PoManagementBean implements PoManagementRemote, PoManagementLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     * Recibe el purchaseOrder, si esta presente el fabricante es una orden de compra directa.
     * - Si el comercio no existe se crea
     * - Si el fabricante no existe se crea
     * - Si el producto del fabricante no existe se crea
     * @param po PurchaseOrderBO
     * @return El numero de seguimiento
     * @throws Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
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
            query = em.createNamedQuery("getFabricanteFromNit");
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

    public PurchaseOrderBO consultarPO(String numSeguimiento) throws OrdenCompraNoExisteException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<PurchaseOrder> po = (List<PurchaseOrder>) q.getResultList();
        if (po.isEmpty()) {
            throw new OrdenCompraNoExisteException("La orden de compra con el número de seguimiento " +
                    numSeguimiento + " no existe");
        }
        return po.get(0).toBO();
    }

    public boolean actualizarEstadoPO(String numSeguimiento, String estado) throws OrdenCompraNoExisteException {
        try {
            Query q = em.createNamedQuery("getPoFromNumSeguimiento");
            q.setParameter("numSeguimiento", numSeguimiento);
            PurchaseOrder po = (PurchaseOrder) q.getSingleResult();
            po.setEstado(estado);
            em.flush();
        } catch (Exception ex) {
            throw new OrdenCompraNoExisteException("La orden de compra con el número de seguimiento " +
                    numSeguimiento + " no existe");
        }
        return false;
    }

    public boolean establecerFabricanteAtiende(String numSeguimiento, FabricanteBO fabricante, List<ProductoBO> productosAtiende) throws OrdenCompraNoExisteException {
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
            throw new OrdenCompraNoExisteException("La orden de compra con el número de seguimiento " +
                    numSeguimiento + " no existe");
        }
        return true;
    }

    public ComercioBO consultarComercioPorPO(String numSeguimiento) throws OrdenCompraNoExisteException {
        Query q = em.createNamedQuery("getPoFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<PurchaseOrder> pos = (List<PurchaseOrder>) q.getResultList();
        if (pos.isEmpty()) {
            throw new OrdenCompraNoExisteException("La orden de compra con el número de seguimiento " + numSeguimiento + " no existe.");
        }
        return pos.get(0).getComercio().toBO();
    }

    public List<PurchaseOrderBO> consultarPOsComercio(String nit) throws ClienteNoExisteException {
        Query q = em.createNamedQuery("getAllPOs");
        List<PurchaseOrder> pos = (List<PurchaseOrder>) q.getResultList();
        List<PurchaseOrderBO> posBO = new ArrayList<PurchaseOrderBO>();
        for (int i = 0; i < pos.size(); i++) {
            if (pos.get(i).getComercio().getNit().equals(nit)) {
                posBO.add(pos.get(i).toBO());
            }
        }
        if (posBO.isEmpty()) {
            throw new ClienteNoExisteException("El cliente especificado no tiene POs asociadas.");
        }
        return posBO;
    }

    public List<PurchaseOrderBO> consultarPOsFabricante(String nit) throws FabricanteNoExisteException {
        Query q = em.createNamedQuery("getPOsFabricante");
        q.setParameter("nit", nit);

        List<PurchaseOrder> poList = (List<PurchaseOrder>) q.getResultList();
        List<PurchaseOrderBO> poBoList = new ArrayList<PurchaseOrderBO>();

        System.out.println("Total " + poList.size());
        for (PurchaseOrder po : poList) {
            poBoList.add(po.toBO());
        }

        if (poBoList.isEmpty()) {
            throw new FabricanteNoExisteException("El fabricante especificado no tiene POs asociadas.");
        }
        return poBoList;
    }
}
