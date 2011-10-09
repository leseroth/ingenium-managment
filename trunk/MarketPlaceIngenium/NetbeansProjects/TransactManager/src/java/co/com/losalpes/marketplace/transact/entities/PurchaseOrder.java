package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import co.com.losalpes.marketplace.transact.bos.ItemPOBO;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PurchaseOrder implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String numSeguimiento;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date entrega;
    @Column
    private String estado;
    @OneToOne
    private Comercio comercio;
    @OneToOne
    private Fabricante fabricante;
    @OneToMany
    protected List<ItemPO> items;

    /**
     * Default Constructor
     */
    public PurchaseOrder() {
    }

    /**
     * Constructor desde BO
     * @param purchaseOrderBO
     */
    public PurchaseOrder(PurchaseOrderBO purchaseOrderBO) {
        id = purchaseOrderBO.getId();
        entrega = purchaseOrderBO.getEntrega();
        estado = purchaseOrderBO.getEstado();
        numSeguimiento = purchaseOrderBO.getNumSeguimiento();
        if (purchaseOrderBO.getComercio() != null) {
            comercio = new Comercio(purchaseOrderBO.getComercio());
        }
        if (purchaseOrderBO.getFabricante() != null) {
            fabricante = new Fabricante(purchaseOrderBO.getFabricante());
        }
        for (ItemPOBO itemPOBO : purchaseOrderBO.getItemPOBOList()) {
            items.add(new ItemPO(itemPOBO));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrderBO toBO() {
        PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBO();
        purchaseOrderBO.setId(getId());
        purchaseOrderBO.setEntrega(getEntrega());
        purchaseOrderBO.setEstado(getEstado());
        purchaseOrderBO.setNumSeguimiento(getNumSeguimiento());
        if (getComercio() != null) {
            purchaseOrderBO.setComercio(getComercio().toBO());
        }
        if (getFabricante() != null) {
            purchaseOrderBO.setFabricante(getFabricante().toBO());
        }
        for (ItemPO itemPO : items) {
            purchaseOrderBO.getItemPOBOList().add(itemPO.toBO());
        }
        return purchaseOrderBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return true;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the entrega
     */
    public Date getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the numSeguimiento
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * @param numSeguimiento the numSeguimiento to set
     */
    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    /**
     * @return the comercio
     */
    public Comercio getComercio() {
        return comercio;
    }

    /**
     * @param comercio the comercio to set
     */
    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    /**
     * @return the fabricante
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<ItemPO> getItems() {
        return items;
    }

    public void setItems(List<ItemPO> items) {
        this.items = items;
    }
}
