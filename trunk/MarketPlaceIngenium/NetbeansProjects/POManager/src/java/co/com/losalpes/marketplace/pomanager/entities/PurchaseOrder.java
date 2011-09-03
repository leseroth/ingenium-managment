/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllPOs", query = "SELECT P FROM PurchaseOrder P "),
    @NamedQuery(name = "getPoFromNumSeguimiento", query = "select p from PurchaseOrder p where p.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getComercioFromPo", query = "select p.comercio from PurchaseOrder p where p.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getPOsComercio", query = "select po from PurchaseOrder po where po.comercio.nit = :nit")
})
/**
 *
 * @author marketplace
 */
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
    @Column
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
    @OneToMany
    protected List<ItemPO> items;

    /**
     * Default Constructor
     */
    public PurchaseOrder() {
        this.items = new ArrayList<ItemPO>();
    }

    /**
     * Simple Constructor
     */
    public PurchaseOrder(Long id, java.sql.Timestamp aEntrega, String aEstado) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = new Comercio();
        this.items = new ArrayList<ItemPO>();
    }

    /**
     * Complex Constructor
     */
    public PurchaseOrder(Long id, java.sql.Timestamp aEntrega, String aEstado, Comercio aComercio, List<ItemPO> aItems) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = aComercio;
        this.items = aItems;
    }

    /**
     * BO Constructor
     */
    public PurchaseOrder(PurchaseOrderBO pOBO) {
        this.setId(pOBO.getId());
        if (pOBO.getEntrega() != null)
            this.setEntrega(pOBO.getEntrega());
        this.setEstado(pOBO.getEstado());
        this.setComercio(new Comercio(pOBO.getComercio()));

        List<ItemPO> itemsFromBO = new ArrayList<ItemPO>();

        for (ItemPOBO itemPOBO : pOBO.getItems()) {
            itemsFromBO.add(new ItemPO(itemPOBO));
        }
        this.setItems(itemsFromBO);
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
        Comercio aComercio = this.getComercio();
        if (aComercio != null) {
            pOBO.setComercio(aComercio.toBO());
        }
        Collection<ItemPOBO> itemsToBO = new ArrayList<ItemPOBO>();
        for (ItemPO element : this.getItems()) {
            itemsToBO.add(element.toBO());
        }
        pOBO.setItems(itemsToBO);
        pOBO.setNumSeguimiento(this.getNumSeguimiento());

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
    public List<ItemPO> getItems() {
        return this.items;
    }

    /**
     * Setter method for attribute items
     * @param new value for attribute items
     */
    public void setItems(List<ItemPO> aItems) {
        this.items = aItems;
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
        return "co.com.losalpes.marketplace.pomanager.entities.PurchaseOrder[id=" + id + "]";
    }

}
