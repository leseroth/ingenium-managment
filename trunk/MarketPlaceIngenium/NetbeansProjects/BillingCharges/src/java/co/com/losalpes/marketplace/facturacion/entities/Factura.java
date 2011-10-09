/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.bos.FacturaBO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getFacturaFromNumId", query = "select p from Factura p where p.id = :id")
})
/**
 *
 * @author marketplace
 */

public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String url;

    @Column
    private String nombreArchivo;

    @Column
    private Long valorPago;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    /**
     * Default Constructor
     */
    public Factura() {
        this.nombreArchivo = ""+System.currentTimeMillis();
    }

    /**
     * Simple Constructor
     */
    public Factura(Long id, String url) {
        this.id = id;
        this.url = url;
        this.nombreArchivo = ""+System.currentTimeMillis();
    }

    /**
     * BO Constructor
     */
    public Factura(FacturaBO factBO) {
        this.setId(factBO.getId());
        this.setUrl(factBO.getUrl());
        this.setNombreArchivo(factBO.getNombreArchivo());
        this.setFechaFin(factBO.getFechaFin());
        this.setFechaInicio(factBO.getFechaInicio());
        this.setValorPago(factBO.getValorPago());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public FacturaBO toBO() {
        FacturaBO factBO = new FacturaBO();
        factBO.setId(this.getId());
        factBO.setUrl(this.getUrl());
        factBO.setNombreArchivo(this.getNombreArchivo());
        factBO.setFechaFin(this.getFechaFin());
        factBO.setFechaInicio(this.getFechaInicio());
        factBO.setValorPago(this.getValorPago());

        return factBO;
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

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.facturacion.entities.Factura[id=" + id + "]";
    }

}
