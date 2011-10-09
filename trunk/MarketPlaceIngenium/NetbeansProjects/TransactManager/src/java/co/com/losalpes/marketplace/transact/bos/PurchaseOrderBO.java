package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class PurchaseOrderBO implements Serializable, MarketPlaceBO {

    private Long id;
    private Date entrega;
    private String estado;
    private String numSeguimiento;
    private ComercioBO comercio;
    private FabricanteBO fabricante;
    private List<ItemPOBO> itemPOBOList;

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO() {
        itemPOBOList = new ArrayList<ItemPOBO>();
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
     * @return the comercio
     */
    public ComercioBO getComercio() {
        return comercio;
    }

    /**
     * @param comercio the comercio to set
     */
    public void setComercio(ComercioBO comercio) {
        this.comercio = comercio;
    }

    /**
     * @return the fabricante
     */
    public FabricanteBO getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(FabricanteBO fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the itemPOBOList
     */
    public List<ItemPOBO> getItemPOBOList() {
        return itemPOBOList;
    }

    /**
     * @param itemPOBOList the itemPOBOList to set
     */
    public void setItemPOBOList(List<ItemPOBO> itemPOBOList) {
        this.itemPOBOList = itemPOBOList;
    }
}
