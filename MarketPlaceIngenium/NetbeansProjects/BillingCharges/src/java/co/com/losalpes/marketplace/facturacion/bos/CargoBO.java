/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.bos;

import java.util.Date;

/**
 *
 * @author marketplace
 */
public class CargoBO
{

    /**
     * Id del cargo
     */
    private Long id;
    
    private String referencia;

    /**
     * Attribute descripcion
     */

    private String descripcion;

    /**
     * Attribute valor
     */

    private Long valor;

    /**
     * Attribute fecha
     */
    private Date fecha;

    public CargoBO()
    {

    }

    public CargoBO(long id, String descripcion, Long valor, Date fecha, String referencia) {
        this.id=id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Dar descripción
     * @return descripcion Descripción
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modificar descripción
     * @param descripcion Nueva descripción
     */
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
}
