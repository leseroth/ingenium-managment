package co.com.losalpes.marketplace.vos;

import java.util.Date;
import java.util.List;

public class AvisoDespachoVO {
    private String numSeguimiento;
    private Date fechaEmision;
    private Date fechaLlegada;
    private Long montoOperacion;
    private List<String> camiones;
    private OrdenCompraVO ordenCompra;
    private ItemVO item;
    
    public AvisoDespachoVO() {
        super();
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setMontoOperacion(Long montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public Long getMontoOperacion() {
        return montoOperacion;
    }

    public void setCamiones(List<String> camiones) {
        this.camiones = camiones;
    }

    public List<String> getCamiones() {
        return camiones;
    }

    public void setOrdenCompra(OrdenCompraVO ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public OrdenCompraVO getOrdenCompra() {
        return ordenCompra;
    }

    public void setItem(ItemVO item) {
        this.item = item;
    }

    public ItemVO getItem() {
        return item;
    }
}
