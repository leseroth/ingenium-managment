package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name="getComercioByNit", query="select c from Comercio c where c.nit = :nit")
})
/**
 * Comercio
 * @author
 */
public class Comercio implements Serializable {

    /**
     * Attribute ComercioID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Attribute nombre
     */
    @Column
    private String nombre;

    @Column
    private String nit;

    /**
     * Default Constructor
     */
    public Comercio() {
        
    }

    /**
     * Simple Constructor
     */
    public Comercio(Long id, String aNombre, String nit) {
        this.id = id;
        this.nombre = aNombre;
        this.nit = nit;
    }

    /**
     * BO Constructor
     */
    public Comercio(ComercioBO comercioBO) {
        this.setId(comercioBO.getId());
        this.setNombre(comercioBO.getNombre());
        this.setNit(comercioBO.getNit());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public ComercioBO toBO() {

        ComercioBO comercioBO = new ComercioBO();
        comercioBO.setId(this.getId());
        comercioBO.setNombre(this.getNombre());
        comercioBO.setNit(this.getNit());

        return comercioBO;
    }

    /**
     * Getter method for attribute comercioID
     * @return attribute comercioID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute comercioID
     * @param new value for attribute comercioID
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
