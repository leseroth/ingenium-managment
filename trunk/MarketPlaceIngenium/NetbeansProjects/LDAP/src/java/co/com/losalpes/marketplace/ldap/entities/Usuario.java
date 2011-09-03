/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.ldap.entities;

import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Asistente
 */
@NamedQueries({
    @NamedQuery(name="consultarUsuarioLoginPsswd", query="select u from Usuario u where u.login = :login and u.password = :pwd"),
    @NamedQuery(name="consultarUsuarioLogin", query="select u from Usuario u where u.login = :login")
})
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nit;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String rol;

    @Column
    private String estado;

    @Column
    private String email;

    public Usuario(){
        
    }

    public Usuario(UsuarioBO usuario){
        this.id = usuario.getId();
        this.nit = usuario.getNit();
        this.login = usuario.getLogin();
        this.password = usuario.getPassword();
        this.rol = usuario.getRol();
        this.estado = usuario.getEstado();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioBO toBO() {
        UsuarioBO u = new UsuarioBO();
        u.setId(id);
        u.setNit(nit);
        u.setLogin(login);
        u.setPassword(password);
        u.setRol(rol);
        u.setEstado(estado);
        u.setEmail(email);
        return u;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.ldap.entities.Usuario[id=" + id + "]";
    }

}
