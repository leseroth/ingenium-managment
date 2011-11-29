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
@Table(name = "RULE")
@NamedQueries({
    @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r")})
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "RULESTATUS")
    private String rulestatus;
    @Basic(optional = false)
    @Column(name = "STARTTIME")
    private short starttime;
    @Basic(optional = false)
    @Column(name = "ENDTIME")
    private short endtime;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item item;

    public Rule() {
    }

    public Rule(Integer id) {
        this.id = id;
    }

    public Rule(Integer id, String rulestatus, short starttime, short endtime) {
        this.id = id;
        this.rulestatus = rulestatus;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRulestatus() {
        return rulestatus;
    }

    public void setRulestatus(String rulestatus) {
        this.rulestatus = rulestatus;
    }

    public short getStarttime() {
        return starttime;
    }

    public void setStarttime(short starttime) {
        this.starttime = starttime;
    }

    public short getEndtime() {
        return endtime;
    }

    public void setEndtime(short endtime) {
        this.endtime = endtime;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenium.ash.entities.Rule[id=" + id + "]";
    }

}
