package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import co.com.losalpes.marketplace.transact.bos.ComercioBO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static co.com.losalpes.marketplace.transact.util.Util.*;

/**
 * Entidad del Comercio
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getComercioByNit", query = "select c from Comercio c where c.nit = :nit"),
    @NamedQuery(name = "consultarComercio", query = "select c from Comercio c") // Verificar
})
public class Comercio implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nit;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @Column
    private String email;
    @Column
    private String codPostal;
    @Column
    private String codPais;

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
        nit = comercioBO.getNit();
        nombre = comercioBO.getNombre();
        direccion = comercioBO.getDireccion();
        telefono = comercioBO.getTelefono();
        email = comercioBO.getEmail();
        codPais = comercioBO.getCodPais();
        codPostal = comercioBO.getCodPostal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComercioBO toBO() {
        ComercioBO comercioBO = new ComercioBO();
        comercioBO.setId(id);
        comercioBO.setNit(nit);
        comercioBO.setNombre(nombre);
        comercioBO.setDireccion(direccion);
        comercioBO.setTelefono(telefono);
        comercioBO.setEmail(email);
        comercioBO.setCodPais(codPais);
        comercioBO.setCodPostal(codPostal);
        return comercioBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return !isEmptyString(nombre) && !isEmptyString(nit) && !isEmptyString(email) && !isEmptyString(direccion) && !isEmptyString(codPostal) && !isEmptyString(codPais);
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
