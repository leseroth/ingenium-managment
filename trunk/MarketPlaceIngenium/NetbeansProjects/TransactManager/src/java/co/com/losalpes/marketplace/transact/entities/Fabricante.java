package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import java.io.Serializable;
import javax.persistence.*;

import static co.com.losalpes.marketplace.transact.util.Util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllFabricantes", query = "SELECT P FROM Fabricante P"),
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
    @Column
    private String email;

    /**
     * Basic Constructor
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
        email = fabricanteBO.getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FabricanteBO toBO() {
        FabricanteBO fabricanteBO = new FabricanteBO();
        fabricanteBO.setId(getId());
        fabricanteBO.setNombre(getNombre());
        fabricanteBO.setNit(getNit());
        fabricanteBO.setEmail(getEmail());
        return fabricanteBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return true;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
