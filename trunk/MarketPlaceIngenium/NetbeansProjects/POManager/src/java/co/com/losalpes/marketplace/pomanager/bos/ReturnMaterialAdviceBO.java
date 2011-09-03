/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.bos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author marketplace
 */
public class ReturnMaterialAdviceBO {

    private Long id;

    private String numSeguimiento;

    private Date fecha;

    private String causa;

    private List<ItemPOBO> itemsDevueltos;

    private PurchaseOrderBO po;

    private DispatchAdviceBO da;

    public ReturnMaterialAdviceBO(){
        
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public DispatchAdviceBO getDa() {
        return da;
    }

    public void setDa(DispatchAdviceBO da) {
        this.da = da;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPOBO> getItemsDevueltos() {
        return itemsDevueltos;
    }

    public void setItemsDevueltos(List<ItemPOBO> itemsDevueltos) {
        this.itemsDevueltos = itemsDevueltos;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public PurchaseOrderBO getPo() {
        return po;
    }

    public void setPo(PurchaseOrderBO po) {
        this.po = po;
    }
}
