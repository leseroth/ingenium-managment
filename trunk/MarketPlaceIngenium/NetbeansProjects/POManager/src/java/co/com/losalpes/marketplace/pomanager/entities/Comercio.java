package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import java.io.Serializable;
import javax.persistence.*;

import static co.com.losalpes.marketplace.pomanager.util.Util.*;

/**
 * Entidad del Comercio
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getComercioByNit", query = "select c from Comercio c where c.nit = :nit")
})
public class Comercio implements Serializable, MarketPlaceEntity {

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
    public Comercio() {
    }

    /**
     * Constructor desde BO
     * @param comercioBO
     */
    public Comercio(ComercioBO comercioBO) {
        id = comercioBO.getId();
        nombre = comercioBO.getNombre();
        nit = comercioBO.getNit();
    }

    @Override
    public ComercioBO toBO() {
        ComercioBO comercioBO = new ComercioBO();
        comercioBO.setId(getId());
        comercioBO.setNombre(getNombre());
        comercioBO.setNit(getNit());
        return comercioBO;
    }

    @Override
    public boolean isInfoComplete() {
        return !isEmptyString(nombre) && !isEmptyString(nit);
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
        if (object instanceof Comercio) {
            Comercio other = (Comercio) object;
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
