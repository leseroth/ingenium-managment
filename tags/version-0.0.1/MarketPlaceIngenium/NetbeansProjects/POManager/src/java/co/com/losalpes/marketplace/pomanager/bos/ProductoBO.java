package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;
import java.util.Date;

public class ProductoBO implements Serializable, MarketPlaceBO {

    private Long id;
    private String categoria;
    private String nombre;
    private Long precio;
    private Date tiempoFabricacion;
    private FabricanteBO fabricanteAtiendeBO;

    /**
     * Constructor por defecto
     */
    public ProductoBO() {
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public Long getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    /**
     * @return the tiempoFabricacion
     */
    public Date getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    /**
     * @param tiempoFabricacion the tiempoFabricacion to set
     */
    public void setTiempoFabricacion(Date tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    /**
     * @return the fabricanteAtiendeBO
     */
    public FabricanteBO getFabricanteAtiendeBO() {
        return fabricanteAtiendeBO;
    }

    /**
     * @param fabricanteAtiendeBO the fabricanteAtiendeBO to set
     */
    public void setFabricanteAtiendeBO(FabricanteBO fabricanteAtiendeBO) {
        this.fabricanteAtiendeBO = fabricanteAtiendeBO;
    }
}
