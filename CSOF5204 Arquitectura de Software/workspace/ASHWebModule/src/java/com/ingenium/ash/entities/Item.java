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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ITEM")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE")
    private int code;
    @Basic(optional = false)
    @Column(name = "ITEMTYPE")
    private short itemtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<Rule> ruleCollection;
    @JoinColumn(name = "HOMEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Home home;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<Event> eventCollection;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, int code, short itemtype) {
        this.id = id;
        this.code = code;
        this.itemtype = itemtype;
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

    public short getItemtype() {
        return itemtype;
    }

    public void setItemtype(short itemtype) {
        this.itemtype = itemtype;
    }

    public Collection<Rule> getRuleCollection() {
        return ruleCollection;
    }

    public void setRuleCollection(Collection<Rule> ruleCollection) {
        this.ruleCollection = ruleCollection;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenium.ash.entities.Item[id=" + id + "]";
    }

}
