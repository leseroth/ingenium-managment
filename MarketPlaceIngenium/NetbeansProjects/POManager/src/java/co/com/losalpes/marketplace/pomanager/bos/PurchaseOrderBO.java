package co.com.losalpes.marketplace.pomanager.bos;

import java.io.Serializable;
import java.util.*;

/**
 * PurchaseOrder
 * @author
 */
public class PurchaseOrderBO implements Serializable {
    /**
     * Attribute POID
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
    private FabricanteBO fabricante;
    /**
     * Attribute items
     */
    private Collection<ItemPOBO> items;

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO() {
        this.items = new ArrayList<ItemPOBO>();
    }

    /**
     * Basic Constructor
     */
    public PurchaseOrderBO(Date aEntrega, String aEstado) {
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.items = new ArrayList<ItemPOBO>();
    }

    /**
     * Simple Constructor
     */
    public PurchaseOrderBO(Long id, Date aEntrega, String aEstado) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = new ComercioBO();
        this.items = new ArrayList<ItemPOBO>();
    }

    /**
     * Complex Constructor
     */
    public PurchaseOrderBO(Long id, java.sql.Date aEntrega, String aEstado, ComercioBO aComercio, FabricanteBO aFabricante, Collection<ItemPOBO> aItems) {
        this.id = id;
        this.entrega = aEntrega;
        this.estado = aEstado;
        this.comercio = aComercio;
        this.items = aItems;
        this.fabricante = aFabricante;
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
     * Getter method for attribute items
     * @return attribute items
     */
    public Collection<ItemPOBO> getItems() {
        return this.items;
    }

    /**
     * Setter method for attribute items
     * @param new value for attribute items
     */
    public void setItems(Collection<ItemPOBO> aItems) {
        this.items = aItems;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public FabricanteBO getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteBO fabricante) {
        this.fabricante = fabricante;
    }

    
}
