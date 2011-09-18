package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllProductos", query = "SELECT P FROM Producto P ")
})
public class Producto implements Serializable, MarketPlaceEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String categoria;
    @Column
    private String nombre;
    @Column
    private Long precio;
    @Column
    @Temporal(value = TemporalType.TIME)
    private Date tiempoFabricacion;
    @OneToOne
    private Fabricante fabricanteAtiende;

    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * Constructor desde BusinessObjcet
     */
    public Producto(ProductoBO productoBO) {
        id = productoBO.getId();
        categoria = productoBO.getCategoria();
        nombre = productoBO.getNombre();
        precio = productoBO.getPrecio();
        tiempoFabricacion = productoBO.getTiempoFabricacion();
        fabricanteAtiende = new Fabricante(productoBO.getFabricanteAtiendeBO());
    }

    @Override
    public ProductoBO toBO() {
        ProductoBO productoBO = new ProductoBO();
        productoBO.setId(getId());
        productoBO.setCategoria(getCategoria());
        productoBO.setNombre(getNombre());
        productoBO.setPrecio(getPrecio());
        productoBO.setTiempoFabricacion(getTiempoFabricacion());
        productoBO.setFabricanteAtiendeBO(getFabricanteAtiende().toBO());
        return productoBO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof Producto) {
            Producto other = (Producto) object;
            equals = getId() != null && other.getId() != null && getId().equals(other.getId());
        }
        return equals;
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
     * @return the fabricanteAtiende
     */
    public Fabricante getFabricanteAtiende() {
        return fabricanteAtiende;
    }

    /**
     * @param fabricanteAtiende the fabricanteAtiende to set
     */
    public void setFabricanteAtiende(Fabricante fabricanteAtiende) {
        this.fabricanteAtiende = fabricanteAtiende;
    }
}
