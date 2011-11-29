package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Bussines Objcet de DispatchAdvice
 * @author Erik
 */
public class DispatchAdviceBO implements Serializable, MarketPlaceBO {

    private Long id;
    private String numSeguimiento;
    private Date fechaEmision;
    private Date fechaLlegada;
    private Long montoOperacion;
    private String camiones;
    private PurchaseOrderBO po;
    private List<ItemPOBO> items;
    private FabricanteBO fabricante;

    /**
     * Constructor por defecto
     */
    public DispatchAdviceBO() {
        items = new ArrayList<ItemPOBO>();
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
    public PurchaseOrderBO getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrderBO po) {
        this.po = po;
    }

    /**
     * @return the items
     */
    public List<ItemPOBO> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ItemPOBO> items) {
        this.items = items;
    }

    /**
     * @return the fabricante
     */
    public FabricanteBO getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(FabricanteBO fabricante) {
        this.fabricante = fabricante;
    }
}
