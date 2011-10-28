package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class SubastaBO implements Serializable, MarketPlaceBO {

    private Long id;
    private boolean activa;
    private String numSeguimiento;
    private OfertaBO mejorOfertaBO;
    private String mensaje;
    private Date fechaCreacionSubasta;
    private Date fechaMaxSubasta;
    private PurchaseOrderBO purchaseOrderBO;
    private List<OfertaBO> ofertaBOList;
    private List<FabricanteBO> fabricanteBOList;

    /**
     * Basic Constructor
     */
    public SubastaBO() {
        ofertaBOList = new ArrayList<OfertaBO>();
        fabricanteBOList = new ArrayList<FabricanteBO>();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * @return the numSeguimiento
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * @param numSeguimiento the numSeguimiento to set
     */
    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * @return the mejorOfertaBO
     */
    public OfertaBO getMejorOfertaBO() {
        return mejorOfertaBO;
    }

    /**
     * @param mejorOfertaBO the mejorOfertaBO to set
     */
    public void setMejorOfertaBO(OfertaBO mejorOfertaBO) {
        this.mejorOfertaBO = mejorOfertaBO;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the fechaCreacionSubasta
     */
    public Date getFechaCreacionSubasta() {
        return fechaCreacionSubasta;
    }

    /**
     * @param fechaCreacionSubasta the fechaCreacionSubasta to set
     */
    public void setFechaCreacionSubasta(Date fechaCreacionSubasta) {
        this.fechaCreacionSubasta = fechaCreacionSubasta;
    }

    /**
     * @return the fechaMaxSubasta
     */
    public Date getFechaMaxSubasta() {
        return fechaMaxSubasta;
    }

    /**
     * @param fechaMaxSubasta the fechaMaxSubasta to set
     */
    public void setFechaMaxSubasta(Date fechaMaxSubasta) {
        this.fechaMaxSubasta = fechaMaxSubasta;
    }

    /**
     * @return the purchaseOrderBO
     */
    public PurchaseOrderBO getPurchaseOrderBO() {
        return purchaseOrderBO;
    }

    /**
     * @param purchaseOrderBO the purchaseOrderBO to set
     */
    public void setPurchaseOrderBO(PurchaseOrderBO purchaseOrderBO) {
        this.purchaseOrderBO = purchaseOrderBO;
    }

    /**
     * @return the ofertaBOList
     */
    public List<OfertaBO> getOfertaBOList() {
        return ofertaBOList;
    }

    /**
     * @param ofertaBOList the ofertaBOList to set
     */
    public void setOfertaBOList(List<OfertaBO> ofertaBOList) {
        this.ofertaBOList = ofertaBOList;
    }

    /**
     * @return the fabricanteBOList
     */
    public List<FabricanteBO> getFabricanteBOList() {
        return fabricanteBOList;
    }

    /**
     * @param fabricanteBOList the fabricanteBOList to set
     */
    public void setFabricanteBOList(List<FabricanteBO> fabricanteBOList) {
        this.fabricanteBOList = fabricanteBOList;
    }
}
