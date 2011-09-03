package co.com.losalpes.marketplace.pomanager.bos;

import java.io.Serializable;

/**
 * Fabricante
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class FabricanteBO implements Serializable {
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
    public FabricanteBO() {
        
    }

    /**
     * Basic Constructor
     */
    public FabricanteBO(String aNombre) {
        this.nombre = aNombre;
    }

    /**
     * Simple Constructor
     */
    public FabricanteBO(Long aId, String aNombre) {
        this.id = aId;
        this.nombre = aNombre;
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
