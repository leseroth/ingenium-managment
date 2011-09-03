package co.com.losalpes.marketplace.transact.entities;

import java.io.Serializable;
import javax.persistence.*;
import co.com.losalpes.marketplace.transact.bos.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllProductos", query = "SELECT P FROM Producto P "),
    @NamedQuery(name = "findByNombre", query = "SELECT P FROM Producto P where nombre=:nombre ")
})
/**
 * Producto
 * @author 
 */
public class Producto implements Serializable {
    
    /**
     * Attribute ProductoID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    /**
     * Attribute categoria
     */
    @Column
    protected String categoria;
    /**
     * Attribute nombre
     */
    @Column
    protected String nombre;

    /**
     * Default Constructor
     */
    public Producto() {
    }

    /**
     * Simple Constructor
     */
    public Producto(Long id, String aCategoria, String aId, String aNombre) {
        this.id = id;
        this.categoria = aCategoria;
        this.nombre = aNombre;
    }

    /**
     * BO Constructor
     */
    public Producto(ProductoBO productoBO) {
        this.setId(productoBO.getId());
        this.setCategoria(productoBO.getCategoria());
        this.setNombre(productoBO.getNombre());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public ProductoBO toBO() {

        ProductoBO productoBO = new ProductoBO();
        productoBO.setId(this.getId());
        productoBO.setCategoria(this.getCategoria());
        productoBO.setNombre(this.getNombre());

        return productoBO;
    }

    /**
     * Getter method for attribute productoID
     * @return attribute productoID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute productoID
     * @param new value for attribute productoID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for attribute categoria
     * @return attribute categoria
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**
     * Setter method for attribute categoria
     * @param new value for attribute categoria
     */
    public void setCategoria(String aCategoria) {
        this.categoria = aCategoria;
    }

    /**
     * Getter method for attribute nombre
     * @return attribute nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter method for attribute nombre
     * @param new value for attribute nombre
     */
    public void setNombre(String aNombre) {
        this.nombre = aNombre;
    }
}
