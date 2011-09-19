package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import java.io.Serializable;
import java.util.ArrayList;
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

/**
 * Entidad de PurchaseOrder
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllPOs", query = "SELECT P FROM PurchaseOrder P "),
    @NamedQuery(name = "getPoFromNumSeguimiento", query = "select p from PurchaseOrder p where p.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getComercioFromPo", query = "select p.comercio from PurchaseOrder p where p.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getPOsComercio", query = "select po from PurchaseOrder po where po.comercio.nit = :nit"),
    @NamedQuery(name = "getPOsFabricante", query = "select po from PurchaseOrder po where po.fabricante.nit = :nit")
})
public class PurchaseOrder implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String numSeguimiento;
    @Column
    @Temporal(TemporalType.DATE)
    protected Date entrega;
    @Column
    protected String estado;
    @OneToOne
    protected Comercio comercio;
    @OneToOne
    protected Fabricante fabricante;
    @OneToMany
    protected List<ItemPO> items;

    /**
     * Constructor por defecto
     */
    public PurchaseOrder() {
        items = new ArrayList<ItemPO>();
    }

    /**
     * Constructor desde BO
     * @param purchaseOrderBO
     */
    public PurchaseOrder(PurchaseOrderBO purchaseOrderBO) {
        this();
        id = purchaseOrderBO.getId();
        numSeguimiento = purchaseOrderBO.getNumSeguimiento();
        entrega = purchaseOrderBO.getEntrega();
        estado = purchaseOrderBO.getEstado();

        if (purchaseOrderBO.getComercioBO() != null) {
            comercio = new Comercio(purchaseOrderBO.getComercioBO());
        }
        if (purchaseOrderBO.getFabricanteBO() != null) {
            fabricante = new Fabricante(purchaseOrderBO.getFabricanteBO());
        }
        for (ItemPOBO itemPOBO : purchaseOrderBO.getItemPOBOList()) {
            items.add(new ItemPO(itemPOBO));
        }
    }

    @Override
    public PurchaseOrderBO toBO() {
        PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBO();
        purchaseOrderBO.setId(getId());
        purchaseOrderBO.setNumSeguimiento(getNumSeguimiento());
        purchaseOrderBO.setEntrega(getEntrega());
        purchaseOrderBO.setEstado(getEstado());
        if (comercio != null) {
            purchaseOrderBO.setComercioBO(comercio.toBO());
        }
        if (fabricante != null) {
            purchaseOrderBO.setFabricanteBO(fabricante.toBO());
        }
        for (ItemPO itemPO : items) {
            purchaseOrderBO.getItemPOBOList().add(itemPO.toBO());
        }
        return purchaseOrderBO;
    }

    @Override
    public boolean isInfoComplete() {
        return true;
    }

    /**
     * @return El id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El numSeguimiento
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * @param numSeguimiento El numSeguimiento
     */
    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * @return El entrega
     */
    public Date getEntrega() {
        return entrega;
    }

    /**
     * @param entrega El entrega
     */
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    /**
     * @return El estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado El estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return El comercioBO
     */
    public Comercio getComercio() {
        return comercio;
    }

    /**
     * @param comercioBO El comercio
     */
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    /**
     * @return El fabricanteBO
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricanteBO El fabricante
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return El items
     */
    public List<ItemPO> getItems() {
        return items;
    }

    /**
     * @param items El items
     */
    public void setItems(List<ItemPO> items) {
        this.items = items;
    }

    // Search methods
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof PurchaseOrder) {
            PurchaseOrder other = (PurchaseOrder) object;
            equals = id != null && other.id != null && id.equals(other.id);
        }
        return equals;
    }
}
