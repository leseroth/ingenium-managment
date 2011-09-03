package co.com.losalpes.marketplace.pomanager.bos;

import java.io.Serializable;
import java.util.*;

/**
 * Producto
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class ProductoBO implements Serializable{
    /**
     * Attribute categoria
     */
    private String categoria;
    /**
     * Attribute id
     */
    private Long id;
    /**
     * Attribute nombre
     */
    private String nombre;
    /**
     * Attribute precio
     */
    private Long precio;
    /**
     * Attribute tiempoFabricacion
     */
    private Date tiempoFabricacion;

    /**
     * Fabricante que atiende el producto en una PO
     */
    private FabricanteBO fabricanteAtiende;

    /**
     * Basic Constructor
     */
    public ProductoBO() {
        
    }

    /**
     * Basic Constructor
     */
    public ProductoBO(String aCategoria, String aNombre, Long aPrecio, Date aTiempoFabricacion) {
        this.categoria = aCategoria;
        this.nombre = aNombre;
        this.precio = aPrecio;
        this.tiempoFabricacion = aTiempoFabricacion;
    }

    /**
     * Simple Constructor
     */
    public ProductoBO(String aCategoria, Long aId, String aNombre, Long aPrecio, Date aTiempoFabricacion) {
        this.categoria = aCategoria;
        this.id = aId;
        this.nombre = aNombre;
        this.precio = aPrecio;
        this.tiempoFabricacion = aTiempoFabricacion;
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
     * Getter method for attribute id
     * @return attribute id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute id
     * @param new value for attribute id
     */
    public void setId(Long aId) {
        this.id = aId;
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

    public FabricanteBO getFabricanteAtiende() {
        return fabricanteAtiende;
    }

    public void setFabricanteAtiende(FabricanteBO fabricanteAtiende) {
        this.fabricanteAtiende = fabricanteAtiende;
    }
}
