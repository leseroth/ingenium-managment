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
@NamedQuery(name = "getInfoListasNegras",
query = "SELECT L FROM ListasNegras L WHERE L.nit = :pNit AND L.tipo = :pTipo")
public class ListasNegras implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    protected String nit;
    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date fecha;
    @Column
    protected Boolean estado;
    @Column
    protected TipoLista tipo;

    /**
     * Default Constructor
     */
    public ListasNegras() {
    }

    /**
     * Simple Constructor
     */
    public ListasNegras(String aNit, Date aFechaCreacion, Boolean aEstado, TipoLista tipo) {
        this.nit = aNit;
        this.fecha = aFechaCreacion;
        this.estado = aEstado;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setTipo(TipoLista tipo) {
        this.tipo = tipo;
    }

    public TipoLista getTipo() {
        return tipo;
    }

    public boolean isInfoComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
