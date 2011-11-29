package co.com.losalpes.marketplace.riskqualification.entities;

import co.com.losalpes.marketplace.riskqualification.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import co.com.losalpes.marketplace.riskqualification.enums.TipoLista;
import java.util.Date;

/**
 *
 * @author marketplace
 */
@Entity
@NamedQuery(name = "getInfoListasNegras", query = "SELECT L FROM ListasNegras L WHERE L.nit = :pNit AND L.tipo = :pTipo ORDER by L.fecha desc")
public class ListasNegras implements MarketPlaceEntity, Serializable {

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
    private TipoLista tipo;

    /**
     * Default Constructor
     */
    public ListasNegras() {
    }

    /**
     * Constructor Completo
     * @param estado
     * @param fecha
     * @param nit
     * @param tipo
     */
    public ListasNegras(Boolean estado, Date fecha, String nit, TipoLista tipo) {
        this.estado = estado;
        this.fecha = fecha;
        this.nit = nit;
        this.tipo = tipo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return getEstado() != null && getFecha() != null && getNit() != null && getTipo() != null;
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
     * @return the tipo
     */
    public TipoLista getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoLista tipo) {
        this.tipo = tipo;
    }
}
