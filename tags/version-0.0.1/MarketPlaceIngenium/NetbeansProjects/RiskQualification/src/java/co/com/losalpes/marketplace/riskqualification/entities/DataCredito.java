/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.entities;

import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQuery (
    name = "getInfoDataCredito",
    query = "SELECT DC FROM DataCredito DC WHERE DC.nit = :pNit"
)

/**
 *
 * @author marketplace
 */
public class DataCredito implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column
    protected String nit;
    @Column
    protected java.sql.Date fecha;
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
    public DataCredito(String aNit, java.sql.Date aFecha, String aCalificacion) {
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
        this.nit =nit;
    }

   public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
       this.fecha = fecha;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String valor) {
        this.calificacion = valor;
    }

 

}
