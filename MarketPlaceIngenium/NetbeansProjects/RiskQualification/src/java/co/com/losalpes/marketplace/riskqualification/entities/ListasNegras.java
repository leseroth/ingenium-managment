/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import co.com.losalpes.marketplace.riskqualification.enums.TipoLista;

/**
 *
 * @author marketplace
 */
@Entity
@NamedQuery (
    name = "getInfoListasNegras",
    query = "SELECT L FROM ListasNegras L WHERE L.nit = :pNit AND L.tipo = :pTipo"
)
public class ListasNegras implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    protected String nit;
    @Column
    protected java.sql.Date fecha;
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
    public ListasNegras(String aNit, java.sql.Date aFechaCreacion, Boolean aEstado,TipoLista tipo) {
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

   public void setTipo(TipoLista tipo) {
        this.tipo =tipo;
    }

   public TipoLista getTipo() {
        return tipo;
    }

}
