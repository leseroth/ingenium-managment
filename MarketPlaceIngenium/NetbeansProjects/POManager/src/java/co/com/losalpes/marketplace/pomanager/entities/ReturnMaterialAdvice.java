package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
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
 * Entidad de ReturnMaterialAdvice
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getRMAsComercio", query = "select rma from ReturnMaterialAdvice rma where rma.po.comercio.nit = :nit"),
    @NamedQuery(name = "getRMAsFabricante", query = "select rma from ReturnMaterialAdvice rma where rma.da.fabricante.nit = :nit")
})
public class ReturnMaterialAdvice implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String numSeguimiento;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column
    private String causa;
    @OneToMany
    private List<ItemPO> itemsDevueltos;
    @OneToOne
    private PurchaseOrder po;
    @OneToOne
    private DispatchAdvice da;

    /**
     * Constructor por defecto
     */
    public ReturnMaterialAdvice() {
        itemsDevueltos = new ArrayList<ItemPO>();
    }

    /**
     * Constructor desde BussinesObject
     * @param bo
     */
    public ReturnMaterialAdvice(ReturnMaterialAdviceBO returnMaterialAdviceBO) {
        this();
        id = returnMaterialAdviceBO.getId();
        numSeguimiento = returnMaterialAdviceBO.getNumSeguimiento();
        fecha = returnMaterialAdviceBO.getFecha();
        causa = returnMaterialAdviceBO.getCausa();
        for (ItemPOBO itemPOBO : returnMaterialAdviceBO.getItemsDevueltos()) {
            itemsDevueltos.add(new ItemPO(itemPOBO));
        }
        po = new PurchaseOrder(returnMaterialAdviceBO.getPurchaseOrderBO());
        da = new DispatchAdvice(returnMaterialAdviceBO.getDispatchAdviceBO());
    }

    @Override
    public ReturnMaterialAdviceBO toBO() {
        ReturnMaterialAdviceBO returnMaterialAdviceBO = new ReturnMaterialAdviceBO();
        returnMaterialAdviceBO.setId(getId());
        returnMaterialAdviceBO.setNumSeguimiento(getNumSeguimiento());
        returnMaterialAdviceBO.setFecha(getFecha());
        returnMaterialAdviceBO.setCausa(getCausa());

        for (int i = 0; i < getItemsDevueltos().size(); i++) {
            ItemPO it = getItemsDevueltos().get(i);
            returnMaterialAdviceBO.getItemsDevueltos().add(it.toBO());
        }
        if (getPo() != null) {
            returnMaterialAdviceBO.setPurchaseOrderBO(getPo().toBO());
        }
        if (getDa() != null) {
            returnMaterialAdviceBO.setDispatchAdviceBO(getDa().toBO());
        }
        return returnMaterialAdviceBO;
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
     * @return El fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha El fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return El causa
     */
    public String getCausa() {
        return causa;
    }

    /**
     * @param causa El causa
     */
    public void setCausa(String causa) {
        this.causa = causa;
    }

    /**
     * @return El itemsDevueltos
     */
    public List<ItemPO> getItemsDevueltos() {
        return itemsDevueltos;
    }

    /**
     * @param itemsDevueltos El itemsDevueltos
     */
    public void setItemsDevueltos(List<ItemPO> itemsDevueltos) {
        this.itemsDevueltos = itemsDevueltos;
    }

    /**
     * @return El po
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * @param po El po
     */
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    /**
     * @return El da
     */
    public DispatchAdvice getDa() {
        return da;
    }

    /**
     * @param da El da
     */
    public void setDa(DispatchAdvice da) {
        this.da = da;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof ReturnMaterialAdvice) {
            ReturnMaterialAdvice other = (ReturnMaterialAdvice) object;
            equals = id != null && other.id != null && id.equals(other.id);
        }
        return equals;
    }
}
