/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.bos.ItemPOBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marketplace
 */
@Entity
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numSeguimiento;
    /**
     * Attribute entrega
     */
    @Temporal(TemporalType.DATE)
    protected Date entrega;
    /**
     * Attribute estado
     */
    @Column
    protected String estado;
    /**
     * Attribute comercio
     */
    @OneToOne
    protected Comercio comercio;
    /**
     * Attribute items
     */
    @OneToOne
    protected ItemPO item;

    /**
     * Default Constructor
     */
    public PurchaseOrder() {

    }

    /**
     * Simple Constructor
     */
    public PurchaseOrder(Long id, Date aEntrega, String aEstado) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = new Comercio();
        this.item = new ItemPO();
    }

    /**
     * Complex Constructor
     */
    public PurchaseOrder(Long id, Date aEntrega, String aEstado, Comercio aComercio, ItemPO aItem, String numSeguimiento) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = aComercio;
        this.item = aItem;
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * BO Constructor
     */
    public PurchaseOrder(PurchaseOrderBO pOBO) {
        this.setId(pOBO.getId());
        this.setEntrega(pOBO.getEntrega());
        this.setEstado(pOBO.getEstado());
        this.setComercio(new Comercio(pOBO.getComercio()));
        this.setItem(new ItemPO(pOBO.getItem()));
        this.setNumSeguimiento(pOBO.getNumSeguimiento());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public PurchaseOrderBO toBO() {

        PurchaseOrderBO pOBO = new PurchaseOrderBO();
        pOBO.setId(this.getId());
        pOBO.setEntrega(this.getEntrega());
        pOBO.setEstado(this.getEstado());
        pOBO.setNumSeguimiento(this.getNumSeguimiento());

        Comercio aComercio = this.getComercio();
        if (aComercio != null)
            pOBO.setComercio(aComercio.toBO());

       pOBO.setItem(item.toBO());
        return pOBO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * Getter method for attribute entrega
     * @return attribute entrega
     */
    public Date getEntrega() {
        return this.entrega;
    }

    /**
     * Setter method for attribute entrega
     * @param new value for attribute entrega
     */
    public void setEntrega(Date aEntrega) {
        this.entrega = aEntrega;
    }

    /**
     * Getter method for attribute estado
     * @return attribute estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Setter method for attribute estado
     * @param new value for attribute estado
     */
    public void setEstado(String aEstado) {
        this.estado = aEstado;
    }

    /**
     * Getter method for attribute comercio
     * @return attribute comercio
     */
    public Comercio getComercio() {
        return this.comercio;
    }

    /**
     * Setter method for attribute comercio
     * @param new value for attribute comercio
     */
    public void setComercio(Comercio aComercio) {
        this.comercio = aComercio;
    }

    /**
     * Getter method for attribute items
     * @return attribute items
     */
    public ItemPO getItem() {
        return this.item;
    }

    /**
     * Setter method for attribute items
     * @param new value for attribute items
     */
    public void setItem(ItemPO aItem) {
        this.item = aItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.transact.entities.PurchaseOrder[id=" + id + "]";
    }

}
