package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import co.com.losalpes.marketplace.transact.bos.*;

import static co.com.losalpes.marketplace.transact.util.Util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "findByCategoriaNombre", query = "select p from Producto p where nombre = :nombre and categoria = :categoria"),
    @NamedQuery(name = "getAllProductos", query = "SELECT P FROM Producto P "), // Verificar
    @NamedQuery(name = "findByNombre", query = "SELECT P FROM Producto P where nombre=:nombre ") // Verificar
})
public class Producto implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String categoria;
    @Column
    private String nombre;

    /**
     * Default Constructor
     */
    public Producto() {
    }

    /**
     * Constructor desde BO
     * @param productoBO
     */
    public Producto(ProductoBO productoBO) {
        id = productoBO.getId();
        categoria = productoBO.getCategoria();
        nombre = productoBO.getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductoBO toBO() {
        ProductoBO productoBO = new ProductoBO();
        productoBO.setId(getId());
        productoBO.setCategoria(getCategoria());
        productoBO.setNombre(getNombre());
        return productoBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return !isEmptyString(nombre) && !isEmptyString(categoria);
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
