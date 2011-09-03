/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.bos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author marketplace
 */
public class FacturaBO implements Serializable{

    private Long id;

    /**
     * Attribute estado
     */

    private String url;

    private String nombreArchivo;

    private Long valorPago;

    private Date fechaInicio;

    private Date fechaFin;

    /**
     * Default Constructor
     */
    public FacturaBO() {

    }

    /**
     * Simple Constructor
     */
    public FacturaBO(Long id, String url) {
        this.id = id;
        this.url = url;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Long getValorPago() {
        return valorPago;
    }

    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }
}
