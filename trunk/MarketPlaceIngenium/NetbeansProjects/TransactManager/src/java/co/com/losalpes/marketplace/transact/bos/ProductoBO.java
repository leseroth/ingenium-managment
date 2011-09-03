//Package declaration
package co.com.losalpes.marketplace.transact.bos;

//Imports required by this class
import java.io.Serializable;

//Start of user code Start additional imports
//End of user code
/**
 * Producto
 * @author
 */
@SuppressWarnings({"serial", "unused"})
public class ProductoBO implements Serializable {

    /**
     * Attribute id
     */
    private Long id;
    /**
     * Attribute categoria
     */
    private String categoria;
    /**
     * Attribute nombre
     */
    private String nombre;

    /**
     * Basic Constructor
     */
    public ProductoBO() {
    }

    /**
     * Basic Constructor
     */
    public ProductoBO(String aCategoria, Long aId, String aNombre) {
        this.categoria = aCategoria;
        this.id = aId;
        this.nombre = aNombre;
    }

    /**
     * Getter method for attribute categoria
     * @return attribute categoria
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**
     * Setter method for attribute categoria
     * @param new value for attribute categoria
     */
    public void setCategoria(String aCategoria) {
        this.categoria = aCategoria;
    }

    /**
     * Getter method for attribute id
     * @return attribute id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute id
     * @param new value for attribute id
     */
    public void setId(Long aId) {
        this.id = aId;
    }

    /**
     * Getter method for attribute nombre
     * @return attribute nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter method for attribute nombre
     * @param new value for attribute nombre
     */
    public void setNombre(String aNombre) {
        this.nombre = aNombre;
    }
}