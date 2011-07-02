/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "HOME")
@NamedQueries({
    @NamedQuery(name = "Home.findAll", query = "SELECT h FROM Home h")})
public class Home implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE")
    private int code;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "home")
    private Collection<Person> personCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "home")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "home")
    private Collection<Event> eventCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "home")
    private Collection<Contactbyhome> contactbyhomeCollection;

    public Home() {
    }

    public Home(Integer id) {
        this.id = id;
    }

    public Home(Integer id, int code, String address) {
        this.id = id;
        this.code = code;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    public Collection<Contactbyhome> getContactbyhomeCollection() {
        return contactbyhomeCollection;
    }

    public void setContactbyhomeCollection(Collection<Contactbyhome> contactbyhomeCollection) {
        this.contactbyhomeCollection = contactbyhomeCollection;
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
        if (!(object instanceof Home)) {
            return false;
        }
        Home other = (Home) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenium.ash.entities.Home[id=" + id + "]";
    }

}
