package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllFabricantes", query = "SELECT P FROM Fabricante P"),
    @NamedQuery(name = "getFabricanteFromNit", query = "select f from Fabricante f where f.nit = :nit")
})
/**
 * Fabricante
 * @author 
 */
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String nombre;

    @Column
    private String nit;

    @Column
    private String email;

    public Fabricante() {
    }

    public Fabricante(Long id, String aNombre, String nit, String email) {
        this.id = id;
        this.nombre = aNombre;
        this.nit = nit;
        this.email = email;
    }

    public Fabricante(FabricanteBO fabricanteBO) {
        this.setId(fabricanteBO.getId());
        this.setNombre(fabricanteBO.getNombre());
        this.setNit(fabricanteBO.getNit());
        this.setEmail(fabricanteBO.getEmail());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public FabricanteBO toBO() {
        FabricanteBO fabricanteBO = new FabricanteBO();
        fabricanteBO.setId(this.getId());
        fabricanteBO.setNombre(this.getNombre());
        fabricanteBO.setNit(this.getNit());
        fabricanteBO.setEmail(this.getEmail());
        return fabricanteBO;
    }

    public Long getId() {
        return id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
