package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import co.com.losalpes.marketplace.transact.bos.PurchaseOrderBO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date entrega;
    @Column
    private String estado;
    @OneToOne
    private Comercio comercio;
    @OneToOne
    private ItemPO item;

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
        if (purchaseOrderBO.getComercioBO() != null) {
            comercio = new Comercio(purchaseOrderBO.getComercioBO());
        }
        if (purchaseOrderBO.getItemPOBO() != null) {
            item = new ItemPO(purchaseOrderBO.getItemPOBO());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseOrderBO toBO() {
        PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBO();
        purchaseOrderBO.setId(id);
        purchaseOrderBO.setEntrega(entrega);
        purchaseOrderBO.setEstado(estado);
        purchaseOrderBO.setNumSeguimiento(numSeguimiento);
        if (comercio != null) {
            purchaseOrderBO.setComercioBO(comercio.toBO());
        }
        if (item != null) {
            purchaseOrderBO.setItemPOBO(item.toBO());
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
     * @return the item
     */
    public ItemPO getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(ItemPO item) {
        this.item = item;
    }
}
