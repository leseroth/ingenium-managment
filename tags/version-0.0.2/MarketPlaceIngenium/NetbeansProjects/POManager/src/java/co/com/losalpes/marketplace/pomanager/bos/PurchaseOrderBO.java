package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Bussines Object de PurchaseOrder
 * @author Erik
 */
public class PurchaseOrderBO implements Serializable, MarketPlaceBO {

    private Long id;
    private String numSeguimiento;
    private Date entrega;
    private String estado;
    private ComercioBO comercioBO;
    private FabricanteBO fabricanteBO;
    private List<ItemPOBO> itemPOBOList;

    /**
     * Constructor por defecto
     */
    public PurchaseOrderBO() {
        itemPOBOList = new ArrayList<ItemPOBO>();
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
     * @return El entrega
     */
    public Date getEntrega() {
        return entrega;
    }

    /**
     * @param entrega El entrega
     */
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    /**
     * @return El estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado El estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return El comercioBO
     */
    public ComercioBO getComercioBO() {
        return comercioBO;
    }

    /**
     * @param comercioBO El comercioBO
     */
    public void setComercioBO(ComercioBO comercioBO) {
        this.comercioBO = comercioBO;
    }

    /**
     * @return El fabricanteBO
     */
    public FabricanteBO getFabricanteBO() {
        return fabricanteBO;
    }

    /**
     * @param fabricanteBO El fabricanteBO
     */
    public void setFabricanteBO(FabricanteBO fabricanteBO) {
        this.fabricanteBO = fabricanteBO;
    }

    /**
     * @return El itemPOBOList
     */
    public List<ItemPOBO> getItemPOBOList() {
        return itemPOBOList;
    }

    /**
     * @param itemPOBOList El itemPOBOList
     */
    public void setItemPOBOList(List<ItemPOBO> itemPOBOList) {
        this.itemPOBOList = itemPOBOList;
    }
}
