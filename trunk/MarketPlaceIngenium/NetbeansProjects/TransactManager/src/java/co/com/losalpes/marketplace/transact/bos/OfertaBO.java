package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class OfertaBO implements Serializable, MarketPlaceBO {

    private Long id;
    private Date fechaEntrega;
    private String numSeguimiento;
    private Long valor;
    private FabricanteBO fabricante;
    private ProductoBO productoOfrecido;

    /**
     * Basic Constructor
     */
    public OfertaBO() {
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
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the numSeguimiento
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * @param numSeguimiento the numSeguimiento to set
     */
    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
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

    /**
     * @return the fabricante
     */
    public FabricanteBO getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(FabricanteBO fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the productoOfrecido
     */
    public ProductoBO getProductoOfrecido() {
        return productoOfrecido;
    }

    /**
     * @param productoOfrecido the productoOfrecido to set
     */
    public void setProductoOfrecido(ProductoBO productoOfrecido) {
        this.productoOfrecido = productoOfrecido;
    }
}
