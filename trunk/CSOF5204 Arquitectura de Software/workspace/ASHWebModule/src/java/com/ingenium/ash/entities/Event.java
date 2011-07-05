/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "EVENT")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EVENTTYPE")
    private short eventtype;
    @Basic(optional = false)
    @Column(name = "EVENTDATE")
    @Temporal(TemporalType.DATE)
    private Date eventdate;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "HOMEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Home home;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Event(Integer id, short eventtype, Date eventdate) {
        this.id = id;
        this.eventtype = eventtype;
        this.eventdate = eventdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getEventtype() {
        return eventtype;
    }

    public void setEventtype(short eventtype) {
        this.eventtype = eventtype;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenium.ash.entities.Event[id=" + id + "]";
    }

}
