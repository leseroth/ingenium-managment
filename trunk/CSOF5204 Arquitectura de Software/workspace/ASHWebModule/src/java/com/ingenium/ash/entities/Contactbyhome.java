/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "CONTACTBYHOME")
@NamedQueries({
    @NamedQuery(name = "Contactbyhome.findAll", query = "SELECT c FROM Contactbyhome c")})
public class Contactbyhome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "IDHOME", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Home home;
    @JoinColumn(name = "IDCONTACT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Contact contact;

    public Contactbyhome() {
    }

    public Contactbyhome(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactbyhome)) {
            return false;
        }
        Contactbyhome other = (Contactbyhome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenium.ash.entities.Contactbyhome[id=" + id + "]";
    }

}
