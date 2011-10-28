package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Bussines Objcet de ReturnMaterialAdvice
 * @author Erik
 */
public class ReturnMaterialAdviceBO implements Serializable, MarketPlaceBO {

    private Long id;
    private String numSeguimiento;
    private Date fecha;
    private String causa;
    private List<ItemPOBO> itemsDevueltos;
    private PurchaseOrderBO purchaseOrderBO;
    private DispatchAdviceBO dispatchAdviceBO;

    /**
     * Constructor por defecto
     */
    public ReturnMaterialAdviceBO() {
        itemsDevueltos = new ArrayList<ItemPOBO>();
    }

    /**
     * @return El id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El numSeguimiento
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * @param numSeguimiento El numSeguimiento
     */
    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * @return El fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha El fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return El causa
     */
    public String getCausa() {
        return causa;
    }

    /**
     * @param causa El causa
     */
    public void setCausa(String causa) {
        this.causa = causa;
    }

    /**
     * @return El itemsDevueltos
     */
    public List<ItemPOBO> getItemsDevueltos() {
        return itemsDevueltos;
    }

    /**
     * @param itemsDevueltos El itemsDevueltos
     */
    public void setItemsDevueltos(List<ItemPOBO> itemsDevueltos) {
        this.itemsDevueltos = itemsDevueltos;
    }

    /**
     * @return El purchaseOrderBO
     */
    public PurchaseOrderBO getPurchaseOrderBO() {
        return purchaseOrderBO;
    }

    /**
     * @param purchaseOrderBO El purchaseOrderBO
     */
    public void setPurchaseOrderBO(PurchaseOrderBO purchaseOrderBO) {
        this.purchaseOrderBO = purchaseOrderBO;
    }

    /**
     * @return El dispatchAdviceBO
     */
    public DispatchAdviceBO getDispatchAdviceBO() {
        return dispatchAdviceBO;
    }

    /**
     * @param dispatchAdviceBO El dispatchAdviceBO
     */
    public void setDispatchAdviceBO(DispatchAdviceBO dispatchAdviceBO) {
        this.dispatchAdviceBO = dispatchAdviceBO;
    }
}
