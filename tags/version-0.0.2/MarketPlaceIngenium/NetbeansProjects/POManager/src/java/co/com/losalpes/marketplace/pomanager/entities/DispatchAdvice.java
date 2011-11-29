package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidad de DispatchAdvice
 * @author Erik
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getDaFromNumSeguimiento", query = "select da from DispatchAdvice da where da.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getDaByFabricante", query = "select da from DispatchAdvice da where da.fabricante.nit = :nit"),
    @NamedQuery(name = "getDaByNumSeguimientoPO", query = "select da from DispatchAdvice da where da.po.numSeguimiento = :numSeguimiento")
})
public class DispatchAdvice implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String numSeguimiento;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column
    private Long montoOperacion;
    @Column
    private String camiones;
    @OneToOne
    private PurchaseOrder po;
    @OneToMany
    private List<ItemPO> items;
    @OneToOne
    @Fetch(FetchMode.JOIN)
    private Fabricante fabricante;

    /**
     * Constructor por defecto
     */
    public DispatchAdvice() {
        items = new ArrayList<ItemPO>();
    }

    /**
     * Constructor desde BO
     * @param dispatchAdviceBO
     */
    public DispatchAdvice(DispatchAdviceBO dispatchAdviceBO) {
        id = dispatchAdviceBO.getId();
        numSeguimiento = dispatchAdviceBO.getNumSeguimiento();
        fechaEmision = dispatchAdviceBO.getFechaEmision();
        fechaLlegada = dispatchAdviceBO.getFechaLlegada();
        montoOperacion = dispatchAdviceBO.getMontoOperacion();
        camiones = dispatchAdviceBO.getCamiones();
        if (dispatchAdviceBO.getPo() != null) {
            po = new PurchaseOrder(dispatchAdviceBO.getPo());
        }
        for (ItemPOBO itemPOBO : dispatchAdviceBO.getItems()) {
            items.add(new ItemPO(itemPOBO));
        }
        if (dispatchAdviceBO.getFabricante() != null) {
            fabricante = new Fabricante(dispatchAdviceBO.getFabricante());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DispatchAdviceBO toBO() {
        DispatchAdviceBO dispatchAdviceBO = new DispatchAdviceBO();
        dispatchAdviceBO.setId(getId());
        dispatchAdviceBO.setNumSeguimiento(getNumSeguimiento());
        dispatchAdviceBO.setFechaEmision(getFechaEmision());
        dispatchAdviceBO.setFechaLlegada(getFechaLlegada());
        dispatchAdviceBO.setMontoOperacion(getMontoOperacion());
        dispatchAdviceBO.setCamiones(getCamiones());
        if (getPo() != null) {
            dispatchAdviceBO.setPo(getPo().toBO());
        }
        for (ItemPO item : getItems()) {
            dispatchAdviceBO.getItems().add(item.toBO());
        }
        if (getFabricante() != null) {
            dispatchAdviceBO.setFabricante(getFabricante().toBO());
        }
        return dispatchAdviceBO;
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
        if (object instanceof DispatchAdvice) {
            DispatchAdvice other = (DispatchAdvice) object;
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
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the fechaLlegada
     */
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * @param fechaLlegada the fechaLlegada to set
     */
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return the montoOperacion
     */
    public Long getMontoOperacion() {
        return montoOperacion;
    }

    /**
     * @param montoOperacion the montoOperacion to set
     */
    public void setMontoOperacion(Long montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    /**
     * @return the camiones
     */
    public String getCamiones() {
        return camiones;
    }

    /**
     * @param camiones the camiones to set
     */
    public void setCamiones(String camiones) {
        this.camiones = camiones;
    }

    /**
     * @return the po
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    /**
     * @return the items
     */
    public List<ItemPO> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ItemPO> items) {
        this.items = items;
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
}
