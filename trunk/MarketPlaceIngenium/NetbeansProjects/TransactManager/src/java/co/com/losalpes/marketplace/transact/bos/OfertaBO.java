package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class OfertaBO implements Serializable, MarketPlaceBO {

    private Long id;
    private Date fechaEntrega;
    private String numSeguimiento;
    private Long valor;
    private FabricanteBO fabricanteBO;
    private ProductoBO productoOfrecidoBO;

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
     * @return the fabricanteBO
     */
    public FabricanteBO getFabricanteBO() {
        return fabricanteBO;
    }

    /**
     * @param fabricanteBO the fabricanteBO to set
     */
    public void setFabricanteBO(FabricanteBO fabricanteBO) {
        this.fabricanteBO = fabricanteBO;
    }

    /**
     * @return the productoOfrecidoBO
     */
    public ProductoBO getProductoOfrecidoBO() {
        return productoOfrecidoBO;
    }

    /**
     * @param productoOfrecidoBO the productoOfrecidoBO to set
     */
    public void setProductoOfrecidoBO(ProductoBO productoOfrecidoBO) {
        this.productoOfrecidoBO = productoOfrecidoBO;
    }
}
