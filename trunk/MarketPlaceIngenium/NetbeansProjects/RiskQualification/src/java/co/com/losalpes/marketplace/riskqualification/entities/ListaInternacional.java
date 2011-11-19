package co.com.losalpes.marketplace.riskqualification.entities;

import co.com.losalpes.marketplace.riskqualification.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * @author marketplace
 */
@Entity
@NamedQuery(name = "getInfoListaInternacional", query = "SELECT L FROM ListaInternacional L WHERE L.nit = :pNit AND L.codPais = :pCodPais ORDER by L.fecha desc")
public class ListaInternacional implements MarketPlaceEntity, Serializable {

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
    @Column
    private String codPais;

    /**
     * Default Constructor
     */
    public ListaInternacional() {
    }

    /**
     * Constructor Completo
     * @param estado
     * @param fecha
     * @param nit
     * @param tipo
     */
    public ListaInternacional(Boolean estado, Date fecha, String nit, String codPais) {
        this.estado = estado;
        this.fecha = fecha;
        this.nit = nit;
        this.codPais = codPais;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return getEstado() != null && getFecha() != null && getNit() != null && getCodPais() != null;
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

    /**
     * @return the codPais
     */
    public String getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }


}
