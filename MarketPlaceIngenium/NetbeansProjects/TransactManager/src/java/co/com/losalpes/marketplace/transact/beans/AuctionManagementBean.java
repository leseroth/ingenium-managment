package co.com.losalpes.marketplace.transact.beans;

import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import co.com.losalpes.marketplace.transact.bos.OfertaBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.transact.bos.SubastaBO;
import co.com.losalpes.marketplace.transact.entities.Comercio;
import co.com.losalpes.marketplace.transact.entities.Fabricante;
import co.com.losalpes.marketplace.transact.entities.ItemPO;
import co.com.losalpes.marketplace.transact.entities.Oferta;
import co.com.losalpes.marketplace.transact.entities.Producto;
import co.com.losalpes.marketplace.transact.entities.PurchaseOrder;
import co.com.losalpes.marketplace.transact.entities.Subasta;
import co.com.losalpes.marketplace.transact.exceptions.BussinessException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static co.com.losalpes.marketplace.transact.util.Constants.*;

/**
 *
 * @author marketplace
 */
@Stateless
public class AuctionManagementBean implements AuctionManagementRemote, AuctionManagementLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public String crearSubasta(PurchaseOrderBO purchaseOrderBO) throws BussinessException {
        PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderBO);
        Query query = null;

        // Validar que venga la informacion que es
        if (purchaseOrder.getNumSeguimiento() == null || purchaseOrder.getItem() == null || purchaseOrder.getItem().getProducto() == null) {
            throw new BussinessException(EXC_ENTITY_TOO_FEW_INFO, "numSeguimiento, item, producto", "PurchaseOrder");
        }
        purchaseOrder.setId(null);

        // Verificar el numero de seguimiento
        String numSeguimiento = purchaseOrderBO.getNumSeguimiento();
        query = em.createNamedQuery("getSubastaFromNumSeguimiento");
        query.setParameter("numSeguimiento", numSeguimiento);
        if (!query.getResultList().isEmpty()) {
            throw new BussinessException(EXC_DUPLICATED_FIELD, "numSeguimiento", numSeguimiento, "Subasta");
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

        // Validar que venga la informacion que es
        ItemPO itemPO = purchaseOrder.getItem();
        if (itemPO.getId() != null) {
            throw new BussinessException(EXC_ENTITY_TOO_MUCH_INFO, "id", "Item");
        } else if (!itemPO.isInfoComplete()) {
            throw new BussinessException(EXC_ENTITY_TOO_FEW_INFO, "cantidad, producto", "Item");
        }
        itemPO.setId(null);

        // Registrar el item
        Producto producto = itemPO.getProducto();
        query = em.createNamedQuery("findByCategoriaNombre");
        query.setParameter("nombre", producto.getNombre());
        query.setParameter("categoria", producto.getCategoria());
        List<Producto> productList = (List<Producto>) query.getResultList();
        if (productList.isEmpty()) {
            if (producto.isInfoComplete()) {
                em.persist(producto);
            } else {
                throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Producto");
            }
        } else {
            itemPO.setProducto(productList.get(0));
        }
        em.persist(itemPO);

        purchaseOrder.setEstado(PurchaseOrderState.SolicitadoComercio.toString());
        em.persist(purchaseOrder);

        Subasta subasta = new Subasta();
        subasta.setPo(purchaseOrder);
        subasta.setActiva(true);
        subasta.setNumSeguimiento(numSeguimiento);
        em.persist(subasta);

        return numSeguimiento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean asignarFabricantesSubasta(String numSeguimientoSubasta, List<FabricanteBO> fabricanteBOList) throws BussinessException {
        Query query = null;

        query = em.createNamedQuery("getSubastaFromNumSeguimiento");
        query.setParameter("numSeguimiento", numSeguimientoSubasta);
        List<Subasta> subastaList = (List<Subasta>) query.getResultList();

        if (subastaList.isEmpty()) {
            throw new BussinessException(EXC_SUBASTA, numSeguimientoSubasta, "No existe");
        } else if (subastaList.size() > 1) {
            throw new BussinessException(EXC_SUBASTA, numSeguimientoSubasta, "Existe mas de una subasta con ese numero de seguimiento");
        }

        Subasta subasta = subastaList.get(0);
        if (!subasta.isActiva()) {
            throw new BussinessException(EXC_SUBASTA, numSeguimientoSubasta, "Se encuentra cerrada");
        } else if (!subasta.getFabricantes().isEmpty()) {
            throw new BussinessException(EXC_SUBASTA, numSeguimientoSubasta, "Ya se habian asignado los fabricantes de esta subasta");
        }

        for (FabricanteBO fabricanteBO : fabricanteBOList) {
            query = em.createNamedQuery("getFabricanteByNit");
            query.setParameter("nit", fabricanteBO.getNit());

            List<Fabricante> fabricanteList = (List<Fabricante>) query.getResultList();
            Fabricante fabricante = null;

            if (fabricanteList.isEmpty()) {
                fabricante = new Fabricante(fabricanteBO);
                fabricante.setId(null);
                if (fabricante.isInfoComplete()) {
                    em.persist(fabricante);
                } else {
                    System.err.println("***** MARKETPLACE ***** No se pudo crear el fabricante " + fabricante.getNit());
                    fabricante = null;
                }
            } else {
                fabricante = fabricanteList.get(0);
            }

            if (fabricante != null) {
                subasta.getFabricantes().add(fabricante);
            }
        }

        boolean result = !subasta.getFabricantes().isEmpty();
        if (!result) {
            subasta.setActiva(false);
            em.persist(subasta);
        }

        return result;
    }

    public boolean registrarOferta(String numSeguimientoSubasta, OfertaBO oferta) throws BussinessException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimientoSubasta);
        List<Subasta> sub = (List<Subasta>) q.getResultList();
        if (sub.isEmpty()) {
            throw new BussinessException("La subasta identificada con el número de seguimiento " +
                    numSeguimientoSubasta + " no existe");
        }
        if (!sub.get(0).isActiva()) {
            throw new BussinessException("La subasta identificada con el número de seguimiento " +
                    numSeguimientoSubasta + " está cerrada");
        }

        q = em.createNamedQuery("getFabricanteFromNit");
        q.setParameter("nit", oferta.getFabricanteBO().getNit());
        List<Fabricante> fabs = (List<Fabricante>) q.getResultList();
        if (fabs.isEmpty()) {
            Fabricante f = new Fabricante();
            f.setNombre(oferta.getFabricanteBO().getNombre());
            f.setNit(oferta.getFabricanteBO().getNit());
            f.setEmail(oferta.getFabricanteBO().getEmail());
            em.persist(f);
            fabs.add(f);
        }
        Oferta of = new Oferta(oferta);
        of.setFabricante(fabs.get((0)));
        of.setFechaEntrega(oferta.getFechaEntrega());
        of.setProductoOfrecido(new Producto(oferta.getProductoOfrecidoBO()));
        em.persist(of);

        Oferta offer = sub.get(0).getMejor();
        if (offer.getValor() < oferta.getValor()) {
            sub.get(0).setMejor(new Oferta(oferta));
        }

        return true;
    }

    public FabricanteBO darGanadorSubasta(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        Subasta sub = (Subasta) q.getSingleResult();
        if (sub == null) {
            throw new BussinessException("La subasta identificada con el nùmero de seguimiento " + numSeguimiento + " no existe.");
        }
        return sub.getMejor().getFabricante().toBO();
    }

    public boolean cerrarSubasta(String numSeguimiento) throws BussinessException {
        Subasta s = em.find(Subasta.class, numSeguimiento);
        if (s == null) {
            throw new BussinessException("La subasta identificada con el nùmero de seguimiento " + numSeguimiento + " no existe.");
        }
        s.setActiva(false);
        return true;
    }

    public List<SubastaBO> consultarSubastasFabricante(String nit) {
        Query q = em.createNamedQuery("getAllSubastas");
        List<Subasta> subs = (List<Subasta>) q.getResultList();
        List<SubastaBO> subsBO = new ArrayList<SubastaBO>();
        for (int i = 0; i < subs.size(); i++) {
            List<Fabricante> fabs = subs.get(i).getFabricantes();
            for (int j = 0; j < fabs.size(); j++) {
                if (fabs.get(j).getNit().equals(nit)) {
                    subsBO.add(subs.get(i).toBO());
                    break;
                }
            }
        }
        return subsBO;
    }

    public List<FabricanteBO> consultarFabricantesSubasta(String numSeguimiento) throws BussinessException {
        Query q = em.createNamedQuery("getSubastaFromNumSeguimiento");
        q.setParameter("numSeguimiento", numSeguimiento);
        List<Subasta> subs = (List<Subasta>) q.getResultList();
        if (subs.isEmpty()) {
            throw new BussinessException("La subasta especificada no existe");
        }
        List<FabricanteBO> fabs = new ArrayList<FabricanteBO>();
        for (int i = 0; i < subs.get(0).getFabricantes().size(); i++) {
            Fabricante f = subs.get(0).getFabricantes().get(i);
            FabricanteBO fab = new FabricanteBO();
            fab.setNit(f.getNit());
            fab.setNombre(f.getNombre());
            fab.setEmail(f.getEmail());
            fabs.add(fab);
        }
        return fabs;
    }

    public SubastaBO consultarSubastaOrdenCompra(String numSeguimientoPO) throws BussinessException {
        Query q = em.createNamedQuery("getSubastaFromOrdenCompra");
        q.setParameter("numSeguimientoPO", numSeguimientoPO);
        List<Subasta> subs = (List<Subasta>) q.getResultList();
        if (subs.isEmpty()) {
            throw new BussinessException("La subasta asociada a la ordend de compra especificada no existe");
        }
        return subs.get(0).toBO();
    }
}
