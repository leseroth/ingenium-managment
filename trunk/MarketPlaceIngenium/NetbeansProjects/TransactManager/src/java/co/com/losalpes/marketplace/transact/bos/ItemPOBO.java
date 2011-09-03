package co.com.losalpes.marketplace.transact.bos;

import java.io.Serializable;

/**
 * ItemPO
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class ItemPOBO implements Serializable {

    /**
     * Attribute id
     */
    private Long id;
    /**
     * Attribute cantidad
     */
    private Integer cantidad;
    /**
     * Attribute productos
     */
    private ProductoBO producto;

    /**
     * Basic Constructor
     */
    public ItemPOBO() {
    }

    /**
     * Basic Constructor
     */
    public ItemPOBO(Integer aCantidad) {
        this.cantidad = aCantidad;
    }

    /**
     * Simple Constructor
     */
    public ItemPOBO(Long id, Integer aCantidad) {
        this.id = id;
        this.cantidad = aCantidad;
    }

    /**
     * Complex Constructor
     */
    public ItemPOBO(Long id, Integer aCantidad, ProductoBO aProducto) {
        this.id = id;
        this.cantidad = aCantidad;
        this.producto = aProducto;
    }

    /**
     * Getter method for attribute itemPOID
     * @return attribute itemPOID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute itemPOID
     * @param new value for attribute itemPOID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for attribute cantidad
     * @return attribute cantidad
     */
    public Integer getCantidad() {
        return this.cantidad;
    }

    /**
     * Setter method for attribute cantidad
     * @param new value for attribute cantidad
     */
    public void setCantidad(Integer aCantidad) {
        this.cantidad = aCantidad;
    }

    public ProductoBO getProducto() {
        return producto;
    }

    public void setProducto(ProductoBO producto) {
        this.producto = producto;
    }
}
