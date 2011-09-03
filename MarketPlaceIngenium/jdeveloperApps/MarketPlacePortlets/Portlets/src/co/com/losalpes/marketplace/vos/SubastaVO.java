package co.com.losalpes.marketplace.vos;

import java.util.Date;
import java.util.List;

public class SubastaVO {
    private String numSeguimiento;
    private Date fechaInicio;
    private Date fechaTerminacion;
    private List<OfertaVO> ofertas;
    private OfertaVO mejor;
    private OrdenCompraVO ordenCompra;
    public SubastaVO() {
        super();
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setOfertas(List<OfertaVO> ofertas) {
        this.ofertas = ofertas;
    }

    public List<OfertaVO> getOfertas() {
        return ofertas;
    }

    public void setMejor(OfertaVO mejor) {
        this.mejor = mejor;
    }

    public OfertaVO getMejor() {
        return mejor;
    }

    public void setOrdenCompra(OrdenCompraVO ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public OrdenCompraVO getOrdenCompra() {
        return ordenCompra;
    }
}
