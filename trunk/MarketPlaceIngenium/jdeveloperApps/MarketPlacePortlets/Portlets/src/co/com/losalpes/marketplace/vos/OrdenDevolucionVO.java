package co.com.losalpes.marketplace.vos;

import java.util.Date;

public class OrdenDevolucionVO {
    private String numSeguimiento;
    private String causa;
    private Date fecha;
    private ItemVO item;
    private AvisoDespachoVO avisoDespacho;
    private OrdenCompraVO ordenCompra;
    
    
    public OrdenDevolucionVO() {
        super();
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setItem(ItemVO item) {
        this.item = item;
    }

    public ItemVO getItem() {
        return item;
    }

    public void setAvisoDespacho(AvisoDespachoVO avisoDespacho) {
        this.avisoDespacho = avisoDespacho;
    }

    public AvisoDespachoVO getAvisoDespacho() {
        return avisoDespacho;
    }

    public void setOrdenCompra(OrdenCompraVO ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public OrdenCompraVO getOrdenCompra() {
        return ordenCompra;
    }
}
