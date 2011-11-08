package co.com.losalpes.marketplace.riskqualification.entities;

import co.com.losalpes.marketplace.riskqualification.MarketPlaceEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQuery(name = "getInfoDataCredito",
query = "SELECT DC FROM DataCredito DC WHERE DC.nit = :pNit")
/**
 *
 * @author marketplace
 */
public class DataCredito implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column
    protected String nit;
    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date fecha;
    @Column
    protected String calificacion;

    /**
     * Default Constructor
     */
    public DataCredito() {
    }

    /**
     * Simple Constructor
     */
    public DataCredito(String aNit, Date aFecha, String aCalificacion) {
        this.nit = aNit;
        this.fecha = aFecha;
        this.calificacion = aCalificacion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String valor) {
        this.calificacion = valor;
    }

    public boolean isInfoComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
