package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad de fabricante
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllFabricantes", query = "SELECT P FROM Fabricante P "),
    @NamedQuery(name = "getFabricanteFromNit", query = "select f from Fabricante f where f.nit = :nit")
})
public class Fabricante implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String nit;

    /**
     * Constructor por defecto
     */
    public Fabricante() {
    }

    /**
     * Constructor desde BO
     * @param fabricanteBO
     */
    public Fabricante(FabricanteBO fabricanteBO) {
        id = fabricanteBO.getId();
        nombre = fabricanteBO.getNombre();
        nit = fabricanteBO.getNit();
    }

    @Override
    public FabricanteBO toBO() {
        FabricanteBO fabricanteBO = new FabricanteBO();
        fabricanteBO.setId(getId());
        fabricanteBO.setNombre(getNombre());
        fabricanteBO.setNit(getNit());
        return fabricanteBO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof Fabricante) {
            Fabricante other = (Fabricante) object;
            equals = getId() != null && other.getId() != null && getId().equals(other.getId());
        }
        return equals;
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

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
}
