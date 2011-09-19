package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad del ItemPO
 * @author Erik
 */
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
     * Constructor por defecto
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
        producto = new Producto(itemPOBO.getProductoBO());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemPOBO toBO() {
        ItemPOBO itemPOBO = new ItemPOBO();
        itemPOBO.setId(getId());
        itemPOBO.setCantidad(getCantidad());
        itemPOBO.setProductoBO(getProducto().toBO());
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
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof ItemPO) {
            ItemPO other = (ItemPO) object;
            equals = getId() != null && other.getId() != null && getId().equals(other.getId());
        }
        return equals;
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
