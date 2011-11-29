package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import co.com.losalpes.marketplace.transact.bos.FabricanteBO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static co.com.losalpes.marketplace.transact.util.Util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getFabricanteByNit", query = "select f from Fabricante f where f.nit = :nit"),
    @NamedQuery(name = "getAllFabricantes", query = "SELECT P FROM Fabricante P") // Verificar
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
    @Column
    private String direccion;
    @Column
    private String codPostal;
    @Column
    private String codPais;

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
        direccion = fabricanteBO.getDireccion();
        codPostal = fabricanteBO.getCodPostal();
        codPais = fabricanteBO.getCodPais();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FabricanteBO toBO() {
        FabricanteBO fabricanteBO = new FabricanteBO();
        fabricanteBO.setId(id);
        fabricanteBO.setNombre(nombre);
        fabricanteBO.setNit(nit);
        fabricanteBO.setEmail(email);
        fabricanteBO.setDireccion(getDireccion());
        fabricanteBO.setCodPais(getCodPais());
        fabricanteBO.setCodPostal(getCodPostal());
        return fabricanteBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return !isEmptyString(nit) && !isEmptyString(nombre) && !isEmptyString(email) && !isEmptyString(direccion) && !isEmptyString(codPostal) && !isEmptyString(codPais);
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

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the codPostal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * @param codPostal the codPostal to set
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * @return the codPais
     */
    public String getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }
}
