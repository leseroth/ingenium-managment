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
public class DispatchAdviceBO {

    private Long id;

    private String numSeguimiento;

    private Date fechaEmision;

    private Date fechaLlegada;

    private Long montoOperacion;

    private String camiones;

    private PurchaseOrderBO po;

    private List<ItemPOBO> items;

    private FabricanteBO fabricante;

    public DispatchAdviceBO(){
        
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPOBO> getItems() {
        return items;
    }

    public void setItems(List<ItemPOBO> items) {
        this.items = items;
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

    public PurchaseOrderBO getPo() {
        return po;
    }

    public void setPo(PurchaseOrderBO po) {
        this.po = po;
    }

    public FabricanteBO getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteBO fabricante) {
        this.fabricante = fabricante;
    }
}
