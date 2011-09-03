/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.bos.ComercioBO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Comercio
 * @author Asistente
 */
@NamedQueries({
    @NamedQuery(name="consultarComercio", query="select c from Comercio c")
})
@Entity
public class Comercio implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public Comercio(){
        
    }

    public Comercio(ComercioBO comercio){
        this.id = comercio.getId();
        this.nit = comercio.getNit();
        this.nombre = comercio.getNombre();
        this.direccion = comercio.getDireccion();
        this.telefono = comercio.getTelefono();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ComercioBO toBO() {
        ComercioBO c = new ComercioBO();
        c.setDireccion(direccion);
        c.setId(id);
        c.setNit(nit);
        c.setNombre(nombre);
        c.setTelefono(telefono);
        return c;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Comercio)) {
            return false;
        }
        Comercio other = (Comercio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.comercio.entities.Comercio[id=" + id + "]";
    }
}
