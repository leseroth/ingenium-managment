package co.com.losalpes.marketplace.vos;

import java.util.Date;

public class FacturaVO {
    private String url;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private long valorPago;
    public FacturaVO() {
        super();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setValorPago(long valorPago) {
        this.valorPago = valorPago;
    }

    public long getValorPago() {
        return valorPago;
    }
}
