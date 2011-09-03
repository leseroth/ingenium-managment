/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.entities;

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

//
@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getCargoFromID", query = "select p from Cargo p where p.id = :id")
})
/**
 *
 * @author marketplace
 */

public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String referencia;

    /**
     * Attribute descripcion
     */
    @Column
    protected String descripcion;

    /**
     * Attribute valor
     */
    @Column
    protected Long valor;

    /**
     * Attribute fAlta
     */
    @Column
    @Temporal(TemporalType.DATE)
    protected Date fecha;    

    /**
     * Default Constructor
     */
    public Cargo() {
    }

    /**
     * Simple Constructor
     */
    public Cargo(Long id, String aDescripcion, long aValor, Date fecha, String referencia) {
        this.id = id;
        this.descripcion = aDescripcion;
        this.valor = aValor;
        this.fecha = fecha;
        this.referencia = referencia;
    }

    /**
     * BO Constructor
     */
    public Cargo(CargoBO cargoBO) {
        this.setId(cargoBO.getId());
        this.setValor(cargoBO.getValor());
        this.setDescripcion(cargoBO.getDescripcion());
        this.setReferencia(cargoBO.getReferencia());
        this.setFecha(cargoBO.getFecha());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public CargoBO toBO() {
        CargoBO cargoBO = new CargoBO();

        cargoBO.setId(this.getId());
        cargoBO.setDescripcion(this.getDescripcion());
        cargoBO.setReferencia(this.getReferencia());
        cargoBO.setValor(this.getValor());
        cargoBO.setFecha(this.getFecha());

        return cargoBO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.facturacion.entities.Cargo[id=" + id + "]";
    }

}
