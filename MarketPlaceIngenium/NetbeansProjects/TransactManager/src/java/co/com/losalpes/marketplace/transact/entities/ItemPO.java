package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import co.com.losalpes.marketplace.transact.bos.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllItemPOs", query = "SELECT P FROM ItemPO P ")
})
public class ItemPO implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Integer cantidad;
    @OneToOne
    private Producto producto;

    /**
     * Default Constructor
     */
    public ItemPO() {
    }

    /**
     * Constructor desde BO
     * @param itemPOBO
     */
    public ItemPO(ItemPOBO itemPOBO) {
        id = itemPOBO.getId();
        cantidad = itemPOBO.getCantidad();
        producto = new Producto(itemPOBO.getProducto());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemPOBO toBO() {
        ItemPOBO itemPOBO = new ItemPOBO();
        itemPOBO.setId(getId());
        itemPOBO.setCantidad(getCantidad());
        itemPOBO.setProducto(getProducto().toBO());
        return itemPOBO;
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
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
