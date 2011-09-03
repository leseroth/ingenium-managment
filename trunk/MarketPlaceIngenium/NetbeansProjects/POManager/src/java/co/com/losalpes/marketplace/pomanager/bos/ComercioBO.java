package co.com.losalpes.marketplace.pomanager.bos;

import java.io.Serializable;

/**
 * Comercio
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class ComercioBO implements Serializable {
    /**
     * Attribute id
     */
    private Long id;
    /**
     * Attribute nombre
     */
    private String nombre;

    private String nit;

    /**
     * Basic Constructor
     */
    public ComercioBO() {
        
    }

    /**
     * Basic Constructor
     */
    public ComercioBO(String aNombre, String nit) {
        this.nombre = aNombre;
        this.nit = nit;
    }

    /**
     * Simple Constructor
     */
    public ComercioBO(Long aId, String aNombre, String nit) {
        this.id = aId;
        this.nombre = aNombre;
        this.nit = nit;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
