package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;

/**
 * BussinessObject del ItemPO
 * @author Erik
 */
public class ItemPOBO implements Serializable, MarketPlaceBO {

    private Long id;
    private Integer cantidad;
    private ProductoBO productoBO;

    /**
     * Constructor por defecto
     */
    public ItemPOBO() {
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
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the productoBO
     */
    public ProductoBO getProductoBO() {
        return productoBO;
    }

    /**
     * @param productoBO the productoBO to set
     */
    public void setProductoBO(ProductoBO productoBO) {
        this.productoBO = productoBO;
    }
}
