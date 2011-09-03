package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllProductos", query = "SELECT P FROM Producto P ")
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
     * Attribute precio
     */
    @Column
    protected Long precio;
    /**
     * Attribute tiempoFabricacion
     */
    @Column
    @Temporal(TemporalType.TIME)
    protected Date tiempoFabricacion;

    @OneToOne
    private Fabricante fabricanteAtiende;

    /**
     * Default Constructor
     */
    public Producto() {
        
    }

    /**
     * Simple Constructor
     */
    public Producto(Long id, String aCategoria, String aId, String aNombre, Long aPrecio, Date aTiempoFabricacion) {
        this.id = id;
        this.categoria = aCategoria;
        this.precio = aPrecio;
        this.tiempoFabricacion = aTiempoFabricacion;
    }

    /**
     * BO Constructor
     */
    public Producto(ProductoBO productoBO) {
        this.setId(productoBO.getId());
        this.setCategoria(productoBO.getCategoria());
        this.setNombre(productoBO.getNombre());
        this.setPrecio(productoBO.getPrecio());
        this.setTiempoFabricacion(productoBO.getTiempoFabricacion());
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
        productoBO.setPrecio(this.getPrecio());
        productoBO.setTiempoFabricacion(this.getTiempoFabricacion());

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

    /**
     * Getter method for attribute precio
     * @return attribute precio
     */
    public Long getPrecio() {
        return this.precio;
    }

    /**
     * Setter method for attribute precio
     * @param new value for attribute precio
     */
    public void setPrecio(Long aPrecio) {
        this.precio = aPrecio;
    }

    /**
     * Getter method for attribute tiempoFabricacion
     * @return attribute tiempoFabricacion
     */
    public Date getTiempoFabricacion() {
        return this.tiempoFabricacion;
    }

    /**
     * Setter method for attribute tiempoFabricacion
     * @param new value for attribute tiempoFabricacion
     */
    public void setTiempoFabricacion(Date aTiempoFabricacion) {
        this.tiempoFabricacion = aTiempoFabricacion;
    }

    public Fabricante getFabricanteAtiende() {
        return fabricanteAtiende;
    }

    public void setFabricanteAtiende(Fabricante fabricanteAtiende) {
        this.fabricanteAtiende = fabricanteAtiende;
    }
}
