package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.MarketPlaceEntity;
import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
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
@NamedQueries({@NamedQuery(name = "getCargoFromID", query = "select p from Cargo p where p.id = :id")})
public class Cargo implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private String descripcion;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date fecha;
    @Column
    private String referencia;
    @Column
    private Long valor;

    /**
     * Default Constructor
     */
    public Cargo() {
    }

    /**
     * BO Constructor
     */
    public Cargo(CargoBO cargoBO) {
        id = cargoBO.getId();
        descripcion = cargoBO.getDescripcion();
        fecha = cargoBO.getFecha();
        referencia = cargoBO.getReferencia();
        valor = cargoBO.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoBO toBO() {
        CargoBO cargoBO = new CargoBO();
        cargoBO.setId(getId());
        cargoBO.setDescripcion(getDescripcion());
        cargoBO.setFecha(getFecha());
        cargoBO.setReferencia(getReferencia());
        cargoBO.setValor(getValor());
        return cargoBO;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the valor
     */
    public Long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }
}
