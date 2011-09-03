package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllItemPOs", query = "SELECT P FROM ItemPO P ")
})
/**
 * ItemPO
 * @author 
 */
public class ItemPO implements Serializable {

    /**
     * Attribute id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    /**
     * Attribute cantidad
     */
    @Column
    protected Integer cantidad;
    /**
     * Attribute productos
     */
    @OneToOne
    protected Producto producto;

    /**
     * Default Constructor
     */
    public ItemPO() {

    }

    /**
     * Simple Constructor
     */
    public ItemPO(Long id, Integer aCantidad) {
        this.id = id;
        this.cantidad = aCantidad;
    }

    /**
     * BO Constructor
     */
    public ItemPO(ItemPOBO itemPOBO) {
        this.setId(itemPOBO.getId());
        this.setCantidad(itemPOBO.getCantidad());
        this.setProducto(new Producto(itemPOBO.getProducto()));
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public ItemPOBO toBO() {
        ItemPOBO itemPOBO = new ItemPOBO();
        itemPOBO.setId(this.getId());
        itemPOBO.setCantidad(this.getCantidad());
        itemPOBO.setProducto(producto.toBO());

        return itemPOBO;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
