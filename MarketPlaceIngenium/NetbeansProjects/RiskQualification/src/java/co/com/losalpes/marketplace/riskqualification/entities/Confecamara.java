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
    name = "getInfoConfecamara",
    query = "SELECT C FROM Confecamara C WHERE C.nit = :pNit"
)
/**
 *
 * @author marketplace
 */
public class Confecamara implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    protected String nit;
    @Column
    protected java.sql.Date fecha;
    @Column
    protected Boolean estado;

         /**
     * Default Constructor
     */
    public Confecamara() {

    }

     /**
     * Simple Constructor
     */
    public Confecamara(String aNit, java.sql.Date aFechaCreacion, Boolean aEstado) {        
        this.nit = aNit;
        this.fecha = aFechaCreacion;
        this.estado = aEstado;        
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

    public void setFecha(java.sql.Date fecha) {
       this.fecha = fecha;
    }

   public java.sql.Date getFecha() {
        return fecha;
    }

       public void setEstado(Boolean estado) {
        this.estado =estado;
    }

   public Boolean getEstado() {
        return estado;
    }



}
