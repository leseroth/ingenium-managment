package co.com.losalpes.marketplace.pomanager.bos;

import co.com.losalpes.marketplace.pomanager.MarketPlaceBO;
import java.io.Serializable;

public class FabricanteBO implements Serializable, MarketPlaceBO {

    private Long id;
    private String nombre;
    private String nit;

    /**
     * Constructor por defecto
     */
    public FabricanteBO() {
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
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
}
