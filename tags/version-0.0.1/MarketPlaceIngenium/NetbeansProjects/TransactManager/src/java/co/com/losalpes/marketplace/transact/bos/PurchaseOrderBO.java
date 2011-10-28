package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class PurchaseOrderBO implements Serializable, MarketPlaceBO {

    private Long id;
    private Date entrega;
    private String estado;
    private String numSeguimiento;
    private ComercioBO comercioBO;
    private ItemPOBO itemPOBO;

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO() {
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
     * @return the entrega
     */
    public Date getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return the comercioBO
     */
    public ComercioBO getComercioBO() {
        return comercioBO;
    }

    /**
     * @param comercioBO the comercioBO to set
     */
    public void setComercioBO(ComercioBO comercioBO) {
        this.comercioBO = comercioBO;
    }

    /**
     * @return the itemPOBO
     */
    public ItemPOBO getItemPOBO() {
        return itemPOBO;
    }

    /**
     * @param itemPOBO the itemPOBO to set
     */
    public void setItemPOBO(ItemPOBO itemPOBO) {
        this.itemPOBO = itemPOBO;
    }
}
