package co.com.losalpes.marketplace.transact.bos;

import java.io.Serializable;
import java.util.*;

/**
 * Oferta
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class OfertaBO implements Serializable {
    /**
     * Attribute OfertaID
     */
    private Long id;
    /**
     * Attribute valor
     */
    private Long valor;
    /**
     * Attribute idSubasta
     */
    private String idSubasta;
    /**
     * Attribute tiempoOferta
     */
    private Date fechaEntrega;
    /**
     * Attribute fabricante
     */
    private FabricanteBO fabricante;

    private ProductoBO productoOfrecido;

    private String numSeguimiento;

    /**
     * Basic Constructor
     */
    public OfertaBO() {
    }

    /**
     * Getter method for attribute ofertaID
     * @return attribute ofertaID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute ofertaID
     * @param new value for attribute ofertaID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for attribute valor
     * @return attribute valor
     */
    public Long getValor() {
        return this.valor;
    }

    /**
     * Setter method for attribute valor
     * @param new value for attribute valor
     */
    public void setValor(Long aValor) {
        this.valor = aValor;
    }

    /**
     * Getter method for attribute idSubasta
     * @return attribute idSubasta
     */
    public String getIdSubasta() {
        return this.idSubasta;
    }

    /**
     * Setter method for attribute idSubasta
     * @param new value for attribute idSubasta
     */
    public void setIdSubasta(String aIdSubasta) {
        this.idSubasta = aIdSubasta;
    }

    /**
     * Getter method for attribute fabricante
     * @return attribute fabricante
     */
    public FabricanteBO getFabricante() {
        return this.fabricante;
    }

    /**
     * Setter method for attribute fabricante
     * @param new value for attribute fabricante
     */
    public void setFabricante(FabricanteBO aFabricante) {
        this.fabricante = aFabricante;
    }

    public ProductoBO getProductoOfrecido() {
        return productoOfrecido;
    }

    public void setProductoOfrecido(ProductoBO productoOfrecido) {
        this.productoOfrecido = productoOfrecido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }
}
