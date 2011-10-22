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
import co.com.losalpes.marketplace.transact.util.PostageComparator;
import com.ecocoma.service.shipping.fedex.FedExService;
import com.ecocoma.service.shipping.fedex.FedExServiceSoap;
import com.ecocoma.service.shipping.fedex.Postage;
import com.ecocoma.service.shipping.fedex.Shipping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static co.com.losalpes.marketplace.transact.util.Constants.*;
import static co.com.losalpes.marketplace.transact.util.Util.*;

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
    public String crearSubasta(PurchaseOrderBO purchaseOrderBO, Date fechaMax) throws BussinessException {
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
        subasta.setFechaMaxSubasta(fechaMax);
        subasta.setFechaCreacionSubasta(new Date());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SubastaBO> consultarSubastasFabricante(String nitFabricante) throws BussinessException {

        if (isEmptyString(nitFabricante)) {
            throw new BussinessException(EXC_INCORRECT_ARGUMENT, "nitFabricante = " + nitFabricante);
        }

        Query query = null;

        query = em.createNamedQuery("getFabricanteByNit");
        query.setParameter("nit", nitFabricante);
        if (query.getResultList().isEmpty()) {
            throw new BussinessException(EXC_ENTITY_INEXSISTENT, "Fabricante", nitFabricante);
        }

        query = em.createNamedQuery("getSubastasByActiva");
        query.setParameter("activa", true);
        List<Subasta> subastaList = (List<Subasta>) query.getResultList();
        List<SubastaBO> subastaBOResponseList = new ArrayList<SubastaBO>();

        iteraSubasta:
        for (Subasta subasta : subastaList) {
            List<Fabricante> fabricanteList = subasta.getFabricantes();

            iteraFabricanteSubasta:
            for (Fabricante fabricante : fabricanteList) {
                if (nitFabricante.equals(fabricante.getNit())) {
                    subastaBOResponseList.add(subasta.toBO());
                    break iteraFabricanteSubasta;
                }
            }
        }

        return subastaBOResponseList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registrarOferta(String numSeguimientoSubasta, OfertaBO ofertaBO) throws BussinessException {
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
        }

        Fabricante fabricante = null;
        String nitFabricante = ofertaBO.getFabricanteBO().getNit();
        iteraFabricante:
        for (Fabricante fab : subasta.getFabricantes()) {
            if (fab.getNit().equals(nitFabricante)) {
                fabricante = fab;
                break iteraFabricante;
            }
        }
        if (fabricante == null) {
            throw new BussinessException(EXC_FABRICANTE_NO_ASOCIADO_SUBASTA, nitFabricante, numSeguimientoSubasta);
        }

        Oferta oferta = new Oferta(ofertaBO);
        oferta.setFabricante(fabricante);
        oferta.setId(null);
        oferta.setNumSeguimiento(numSeguimientoSubasta);
        oferta.setProductoOfrecido(null);
        if (oferta.isInfoComplete()) {
            calculateBestOffer(subasta, oferta);
            em.persist(oferta);
            subasta.getOfertas().add(oferta);
            em.persist(subasta);
        } else {
            throw new BussinessException(EXC_ENTITY_INCOMPLETE, "Oferta");
        }
        return true;
    }

    /**
     * Permite determinar cual subasta es mejor deacuerdo a las siguientes reglas.
     * <ul>
     * <li>Para ser considerada dentro del proceso la fecha de entrega debe ser menor a la fecha de entrega de la orden de compra</li>
     * <li>Se consulta el servicio de fedex para determinar las opciones de envio disponible</li>
     * <li>Si es la primera oferta y se puede enviar antes de la fecha de la orden de compra se considera la mejor</li>
     * <li>Se selecciona la opcion de envio cuya fecha de entrega sea mas cercana (y por tanto economica) a la fecha de entrega de la orden de compra</li>
     * <li>Se determina el valor total multiplicando la cantidad por el precio unitario y sumando el precio de envio</li>
     * <li>Si ya existe una oferta mejor, se comparan los precios para determinar cual es la mejor</li>
     * <li>La oferta almacena su estado y la forma de envio seleccionada</li>
     * </ul>
     * @param subasta Subasta a evaluar
     * @param oferta Oferta a evaluar
     */
    protected void calculateBestOffer(Subasta subasta, Oferta oferta) {

        if (subasta.getPo().getEntrega().after(oferta.getFechaEntrega())) {
            Comercio comercio = subasta.getPo().getComercio();
            Fabricante fabricante = oferta.getFabricante();
            Producto producto = subasta.getPo().getItem().getProducto();

            int cantidad = subasta.getPo().getItem().getCantidad();
            String weight = Integer.parseInt(producto.getPeso()) * cantidad + "";
            String declaredValue = oferta.getValor() * cantidad + "";

            List<Postage> postageList = getAvailableShippings(comercio, fabricante, oferta, producto, weight, declaredValue);

            if (postageList.isEmpty()) {
                oferta.setEstadoOferta(OFFER_NO_SEND_OPTION);
            } else if (postageList.size() == 1) {
                Postage post = postageList.get(0);
                if (post.getCode().equals("ERR") && post.getMailService().equals("Invalid domain or key")) {
                    updateEcocomaKey();
                    postageList = getAvailableShippings(comercio, fabricante, oferta, producto, weight, declaredValue);
                }
            }

            if (!postageList.isEmpty()) {
                Collections.sort(postageList, new PostageComparator());
                Postage bestPostage = null;

                iteraPost:
                for (Postage postage : postageList) {
                    int days = getFedexTime(postage.getMailService());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(oferta.getFechaEntrega());
                    calendar.add(Calendar.DATE, days);
                    if (subasta.getPo().getEntrega().after(calendar.getTime())) {
                        bestPostage = postage;
                        break iteraPost;
                    }
                }

                if (bestPostage == null) {
                    oferta.setEstadoOferta(OFFER_NO_SEND_OPTION);
                } else {
                    String rate = bestPostage.getRate();
                    Double rateDouble = null;
                    if (rate.indexOf(",") != -1) {
                        rate = rate.replaceAll(",", "");
                        rateDouble = Double.parseDouble(rate) / 2000;
                    } else {
                        rateDouble = Double.parseDouble(rate);
                    }
                    long valorOferta = (long) (Long.parseLong(declaredValue) + rateDouble);
                    Oferta mejorOferta = subasta.getMejor();
                    oferta.setMensaje(bestPostage.getMailService() + " [ Valor Total en Dolares : " + valorOferta + " ]");

                    if (subasta.getOfertas() == null || subasta.getOfertas().isEmpty() || mejorOferta == null) {
                        subasta.setMejor(oferta);
                        oferta.setEstadoOferta(OFFER_FIRST);
                        subasta.setMensaje(createMessage(OFFER_BEST_CURRENT, "" + valorOferta, fabricante.getNombre()));
                    } else {
                        String mensajeMejor = mejorOferta.getMensaje();
                        mensajeMejor = mensajeMejor.substring(mensajeMejor.lastIndexOf(":") + 1, mensajeMejor.lastIndexOf("]")).trim();
                        long valorMejor = Long.parseLong(mensajeMejor);
                        if (valorMejor < valorOferta) {
                            oferta.setEstadoOferta(createMessage(OFFER_NOT_BEST, "" + valorMejor, mejorOferta.getFabricante().getNombre()));
                        } else {
                            mejorOferta.setEstadoOferta(createMessage(OFFER_OVERCOMED, "" + valorOferta, fabricante.getNombre()));
                            em.persist(mejorOferta);

                            subasta.setMejor(oferta);
                            oferta.setEstadoOferta(createMessage(OFFER_BEST, "" + valorMejor, mejorOferta.getFabricante().getNombre()));
                            subasta.setMensaje(createMessage(OFFER_BEST_CURRENT, "" + valorOferta, fabricante.getNombre()));
                        }
                    }
                }
            }

        } else {
            oferta.setEstadoOferta(OFFER_INVALID_TIME);
        }

        if (isEmptyString(subasta.getMensaje())) {
            subasta.setMensaje(OFFER_ALL_INVALID);
        }
    }

    protected List<Postage> getAvailableShippings(Comercio comercio, Fabricante fabricante, Oferta oferta, Producto producto, String weight, String declaredValue) {

        String senderPostalCode = fabricante.getCodPostal();
        String senderCountryCode = fabricante.getCodPais();
        String recipientPostalCode = comercio.getCodPostal();
        String recipientCountryCode = comercio.getCodPais();

        Shipping shipping = null;
        System.out.println("<" + ECOCOMA_KEY + "+" + senderPostalCode + "+" + senderCountryCode + "+" + recipientPostalCode + "+" + recipientCountryCode + "+" + weight + "+" + declaredValue + ">");

        try { // Call Web Service Operation
            FedExService serviceFedEx = new FedExService();
            FedExServiceSoap port = serviceFedEx.getFedExServiceSoap();
            shipping = port.getFedExRate(ECOCOMA_KEY, null, null, senderPostalCode, senderCountryCode, recipientPostalCode, recipientCountryCode, weight, declaredValue);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error al llamar al web service de ecocoma de fedex " + ex);
        }

        return shipping.getPackage().getPostage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FabricanteBO> consultarFabricantesSubasta(String numSeguimientoSubasta) throws BussinessException {
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

        List<FabricanteBO> fabricantes = new ArrayList<FabricanteBO>();
        for (Fabricante fab : subasta.getFabricantes()) {
            FabricanteBO fabBO = fab.toBO();
            fabricantes.add(fabBO);
        }
        return fabricantes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cerrarSubasta(String numSeguimiento) throws BussinessException {
        Query query = null;

        query = em.createNamedQuery("getSubastaFromNumSeguimiento");
        query.setParameter("numSeguimiento", numSeguimiento);
        List<Subasta> subastaList = (List<Subasta>) query.getResultList();

        if (subastaList.isEmpty()) {
            throw new BussinessException(EXC_SUBASTA, numSeguimiento, "No existe");
        } else if (subastaList.size() > 1) {
            throw new BussinessException(EXC_SUBASTA, numSeguimiento, "Existe mas de una subasta con ese numero de seguimiento");
        }

        Subasta subasta = subastaList.get(0);
        subasta.setActiva(false);
        em.persist(subasta);
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
