package co.com.losalpes.marketplace.ldap.entities;

import co.com.losalpes.marketplace.ldap.MarketPlaceEntity;
import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "consultarUsuarioLoginPsswd", query = "select u from Usuario u where u.login = :login and u.password = :pwd"),
    @NamedQuery(name = "consultarUsuarioLogin", query = "select u from Usuario u where u.login = :login")
})
public class Usuario implements Serializable, MarketPlaceEntity {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String estado;
    @Column
    private String login;
    @Column
    private String nit;
    @Column
    private String password;
    @Column
    private String rol;
    @Column
    private String email;
    @Column
    private String direccion;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String codPostal;
    @Column
    private String codPais;

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /**
     * Constructor desde BO
     * @param usuario
     */
    public Usuario(UsuarioBO usuarioBO) {
        id = usuarioBO.getId();
        estado = usuarioBO.getEstado();
        login = usuarioBO.getLogin();
        nit = usuarioBO.getNit();
        password = usuarioBO.getPassword();
        rol = usuarioBO.getRol();
        email = usuarioBO.getEmail();
        direccion = usuarioBO.getDireccion();
        nombre = usuarioBO.getNombre();
        telefono = usuarioBO.getTelefono();
        codPostal = usuarioBO.getCodPostal();
        codPais = usuarioBO.getCodPais();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioBO toBO() {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(getId());
        usuarioBO.setEstado(getEstado());
        usuarioBO.setLogin(getLogin());
        usuarioBO.setNit(getNit());
        usuarioBO.setPassword(getPassword());
        usuarioBO.setRol(getRol());
        usuarioBO.setEmail(getEmail());
        usuarioBO.setDireccion(getDireccion());
        usuarioBO.setNombre(getNombre());
        usuarioBO.setTelefono(getTelefono());
        usuarioBO.setCodPostal(getCodPostal());
        usuarioBO.setCodPais(getCodPais());
        return usuarioBO;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
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
