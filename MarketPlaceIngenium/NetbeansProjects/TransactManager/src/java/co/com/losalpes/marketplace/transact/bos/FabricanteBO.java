package co.com.losalpes.marketplace.transact.bos;

/**
 * Fabricante
 */
@SuppressWarnings({"serial", "unused"})
public class FabricanteBO {

    /**
     * Attribute id
     */
    private Long id;

    /**
     * Attribute nombre
     */
    private String nombre;

    private String nit;

    private String email;
	
    /**
     * Basic Constructor
     */
    public FabricanteBO() {
    }

    /**
     * Basic Constructor
     */
    public FabricanteBO(Long aId, String aNombre, String nit, String email) {
        this.id =  aId;
        this.nombre =  aNombre;
        this.email = email;
        this.nit = nit;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}