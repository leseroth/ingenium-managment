package co.com.losalpes.marketplace.transact.bos;

import java.io.Serializable;
import java.util.*;
/**
 * PO
 * @author 
 */
public class PurchaseOrderBO implements Serializable {
    /**
     * Attribute id
     */
    private Long id;

    private String numSeguimiento;

    /**
     * Attribute entrega
     */
    private Date entrega;
    /**
     * Attribute estado
     */
    private String estado;
    /**
     * Attribute comercio
     */
    private ComercioBO comercio;
    /**
     * Attribute fabricante
     */
    private FabricanteBO fabricante;
    /**
     * Attribute items
     */
    private ItemPOBO item;

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO() {
    }

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO(java.sql.Date aEntrega, String aEstado, ItemPOBO aItem) {
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.item = aItem;
    }

    /**
     * Simple Constructor
     */
    public PurchaseOrderBO(Long id, java.sql.Date aEntrega, String aEstado, String numSeguimiento) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = new ComercioBO();
        this.fabricante = new FabricanteBO();
        this.item = new ItemPOBO();
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * Complex Constructor
     */
    public PurchaseOrderBO(Long id, java.sql.Date aEntrega, String aEstado, ComercioBO aComercio, FabricanteBO aFabricante, ItemPOBO aItem, String numSeguimiento) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = aComercio;
        this.fabricante = aFabricante;
        this.item = aItem;
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * Getter method for attribute pOID
     * @return attribute pOID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute pOID
     * @param new value for attribute pOID
     */
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
    public ComercioBO getComercio() {
        return this.comercio;
    }

    /**
     * Setter method for attribute comercio
     * @param new value for attribute comercio
     */
    public void setComercio(ComercioBO aComercio) {
        this.comercio = aComercio;
    }

    /**
     * Getter method for attribute fabricante
     * @return attribute fabricante
     */
    public FabricanteBO getFabricante() {
        return this.fabricante;
    }

    /**
     * Setter method for attribute fabricante
     * @param new value for attribute fabricante
     */
    public void setFabricante(FabricanteBO aFabricante) {
        this.fabricante = aFabricante;
    }

    public ItemPOBO getItem() {
        return item;
    }

    public void setItem(ItemPOBO item) {
        this.item = item;
    }
}
