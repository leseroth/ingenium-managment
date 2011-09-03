/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.entities;

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
 *
 * @author marketplace
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getRMAsComercio", query = "select rma from ReturnMaterialAdvice rma where rma.po.comercio.nit = :nit"),
    @NamedQuery(name = "getRMAsFabricante", query = "select rma from ReturnMaterialAdvice rma where rma.da.fabricante.nit = :nit")
})
public class ReturnMaterialAdvice implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public ReturnMaterialAdvice(){
        
    }

    public ReturnMaterialAdvice(ReturnMaterialAdviceBO bo){
         this.causa = bo.getCausa();
         this.fecha = bo.getFecha();
         this.id = bo.getId();
         this.numSeguimiento = bo.getNumSeguimiento().trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public DispatchAdvice getDa() {
        return da;
    }

    public void setDa(DispatchAdvice da) {
        this.da = da;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ItemPO> getItemsDevueltos() {
        return itemsDevueltos;
    }

    public void setItemsDevueltos(List<ItemPO> itemsDevueltos) {
        this.itemsDevueltos = itemsDevueltos;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public PurchaseOrder getPo() {
        return po;
    }

    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    public ReturnMaterialAdviceBO toBO(){
        ReturnMaterialAdviceBO rma = new ReturnMaterialAdviceBO();
        rma.setCausa(causa);
        rma.setDa(da.toBO());
        rma.setFecha(fecha);
        rma.setId(id);
        rma.setNumSeguimiento(numSeguimiento);
        rma.setPo(po.toBO());

        List<ItemPOBO> its = new ArrayList<ItemPOBO>();
        for(int i = 0; i < itemsDevueltos.size(); i++){
            ItemPO it = itemsDevueltos.get(i);
            its.add(it.toBO());
        }
        rma.setItemsDevueltos(its);
        return rma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ReturnMaterialAdvice)) {
            return false;
        }
        ReturnMaterialAdvice other = (ReturnMaterialAdvice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.pomanager.entities.ReturnMaterialAdvice[id=" + id + "]";
    }

}
