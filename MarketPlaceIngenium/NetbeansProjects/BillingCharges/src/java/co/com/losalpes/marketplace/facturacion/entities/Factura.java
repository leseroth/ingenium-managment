package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.MarketPlaceEntity;
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

@Entity
@NamedQueries({@NamedQuery(name = "getFacturaFromNumId", query = "select p from Factura p where p.id = :id")})
public class Factura implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column
    private String nombreArchivo;
    @Column
    private String url;
    @Column
    private Long valorPago;

    /**
     * Default Constructor
     */
    public Factura() {
    }

    /**
     * BO Constructor
     */
    public Factura(FacturaBO facturaBO) {
        id = facturaBO.getId();
        fechaFin = facturaBO.getFechaFin();
        fechaInicio = facturaBO.getFechaInicio();
        nombreArchivo = facturaBO.getNombreArchivo();
        url = facturaBO.getUrl();
        valorPago = facturaBO.getValorPago();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaBO toBO() {
        FacturaBO factBO = new FacturaBO();
        factBO.setId(getId());
        factBO.setFechaFin(getFechaFin());
        factBO.setFechaInicio(getFechaInicio());
        factBO.setNombreArchivo(getNombreArchivo());
        factBO.setUrl(getUrl());
        factBO.setValorPago(getValorPago());
        return factBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return true;
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
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the valorPago
     */
    public Long getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }
}
