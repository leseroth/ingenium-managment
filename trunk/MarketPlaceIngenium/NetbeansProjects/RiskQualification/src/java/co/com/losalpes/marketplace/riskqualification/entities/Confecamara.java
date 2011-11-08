package co.com.losalpes.marketplace.riskqualification.entities;

import co.com.losalpes.marketplace.riskqualification.MarketPlaceEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marketplace
 */
@Entity
@NamedQuery(name = "getInfoConfecamara", query = "SELECT C FROM Confecamara C WHERE C.nit = :pNit ORDER by C.fecha desc")
public class Confecamara implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Boolean estado;
    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fecha;
    @Column
    private String nit;

    /**
     * Default Constructor
     */
    public Confecamara() {
    }

    /**
     * Constructor completo
     * @param estado Estado de verificacion
     * @param fecha Fecha de registro
     * @param nit Nit del establecimiento
     */
    public Confecamara(boolean estado, Date fecha, String nit) {
        this.estado = estado;
        this.fecha = fecha;
        this.nit = nit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return estado != null && fecha != null && nit != null && !nit.trim().isEmpty();
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
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
}
