/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.entities;

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
 *
 * @author marketplace
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getDaFromNumSeguimiento", query = "select da from DispatchAdvice da where da.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getDaByFabricante", query = "select da from DispatchAdvice da where da.fabricante.nit = :nit"),
    @NamedQuery(name = "getDaByNumSeguimientoPO", query = "select da from DispatchAdvice da where da.po.numSeguimiento = :numSeguimiento")
})
public class DispatchAdvice implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public DispatchAdvice(){

    }

    public DispatchAdvice(DispatchAdviceBO bo){
        this.camiones = bo.getCamiones();
        this.fechaEmision = bo.getFechaEmision();
        this.fechaLlegada = bo.getFechaLlegada();
        this.id = bo.getId();
        this.montoOperacion = bo.getMontoOperacion();
        this.numSeguimiento = bo.getNumSeguimiento().trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCamiones() {
        return camiones;
    }

    public void setCamiones(String camiones) {
        this.camiones = camiones;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Long getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(Long montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public List<ItemPO> getItems() {
        return items;
    }

    public void setItems(List<ItemPO> items) {
        this.items = items;
    }

    public PurchaseOrder getPo() {
        return po;
    }

    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public DispatchAdviceBO toBO(){
        DispatchAdviceBO da = new DispatchAdviceBO();
        da.setCamiones(camiones);
        da.setFechaEmision(fechaEmision);
        da.setFechaLlegada(fechaLlegada);
        da.setId(id);
        da.setMontoOperacion(montoOperacion);
        da.setNumSeguimiento(numSeguimiento);
        da.setPo(po.toBO());
        da.setFabricante(fabricante.toBO());

        List<ItemPOBO> items = new ArrayList<ItemPOBO>();
        for(int i = 0; i < this.items.size(); i++){
            items.add(this.items.get(i).toBO());
        }
        da.setItems(items);
        return da;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DispatchAdvice)) {
            return false;
        }
        DispatchAdvice other = (DispatchAdvice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.pomanager.entities.DispatchAdvice[id=" + id + "]";
    }
}
