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
import co.com.losalpes.marketplace.pomanager.exceptions.ClienteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.FabricanteNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import co.com.losalpes.marketplace.pomanager.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static co.com.losalpes.marketplace.pomanager.util.Constants.*;

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
     * - El comercio debe existir y tener un nit unico
     * - El fabricante debe existir y tener un nit unico
     * - El producto se crea en caso de no existir en la base de datos local
     * @param po PurchaseOrderBO
     * @return El numero de seguimiento
     * @throws Una excepcion de negocio en caso de que no se cumplan las condiciones anteriores
     */
    public String registrarPO(PurchaseOrderBO po) throws BussinessException {
        PurchaseOrder purchaseOrder = new PurchaseOrder(po);
        Query query = null;

        // Buscar el comercio
        query = em.createNamedQuery("getComercioByNit");
        query.setParameter("nit", po.getComercioBO().getNit());
        List<Comercio> comList = (List<Comercio>) query.getResultList();
        if (comList.isEmpty()) {
            throw new BussinessException(EXC_COMERCIO_NO_EXISTE, po.getComercioBO().getNit());
        } else {
            purchaseOrder.setComercio(comList.get(0));
        }

        // Asignar numero de seguimiento
        String numSeguimiento = Util.getNumSeguimiento(purchaseOrder.getComercio());
        purchaseOrder.setNumSeguimiento(numSeguimiento);

        // Registrar el fabricante si es orden directa
        if (po.getFabricanteBO() != null) {
            query = em.createNamedQuery("getFabricanteFromNit");
            query.setParameter("nit", po.getFabricanteBO().getNit());
            List<Fabricante> fabList = (List<Fabricante>) query.getResultList();
            if (fabList.isEmpty()) {
                throw new BussinessException(EXC_FABRICANTE_NO_EXISTE, po.getFabricanteBO().getNit());
            } else {
                purchaseOrder.setFabricante(fabList.get(0));
            }
        }

        // Registrar los items
        Collection<ItemPO> itms = purchaseOrder.getItems();
        for (ItemPO itemPO : itms) {
            Producto producto = itemPO.getProducto();
            em.find(Producto.class, producto.getId());
            em.persist(itemPO);
        }
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
