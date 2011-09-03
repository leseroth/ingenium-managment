package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllFabricantes", query = "SELECT P FROM Fabricante P "),
    @NamedQuery(name = "getFabricanteFromNit", query="select f from Fabricante f where f.nit = :nit")
})
/**
 * Fabricante
 * @author 
 */
public class Fabricante implements Serializable {
    /**
     * Attribute FabricanteID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    /**
     * Attribute nombre
     */
    @Column
    protected String nombre;

    @Column
    private String nit;
    /**
     * Default Constructor
     */
    public Fabricante() {
        
    }

    /**
     * Simple Constructor
     */
    public Fabricante(Long id, String aNombre) {
        this.id = id;
        this.nombre = aNombre;
    }

    /**
     * BO Constructor
     */
    public Fabricante(FabricanteBO fabricanteBO) {
        this.setId(fabricanteBO.getId());
        this.setNombre(fabricanteBO.getNombre());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public FabricanteBO toBO() {
        FabricanteBO fabricanteBO = new FabricanteBO();
        fabricanteBO.setId(this.getId());
        fabricanteBO.setNombre(this.getNombre());

        return fabricanteBO;
    }

    /**
     * Getter method for attribute fabricanteID
     * @return attribute fabricanteID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute fabricanteID
     * @param new value for attribute fabricanteID
     */
    public void setId(Long id) {
        this.id = id;
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
