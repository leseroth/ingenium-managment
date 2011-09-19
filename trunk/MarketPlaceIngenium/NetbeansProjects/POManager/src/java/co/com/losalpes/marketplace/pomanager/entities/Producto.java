package co.com.losalpes.marketplace.pomanager.entities;

import co.com.losalpes.marketplace.pomanager.MarketPlaceEntity;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import static co.com.losalpes.marketplace.pomanager.util.Util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllProductos", query = "select p from Producto p "),
    @NamedQuery(name = "getProductsByFabricante", query = "select p from Producto p where fabricanteAtiende.nit = :nit ")
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
    @OneToOne(optional = true)
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
        if (productoBO.getFabricanteAtiendeBO() != null) {
            fabricanteAtiende = new Fabricante(productoBO.getFabricanteAtiendeBO());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductoBO toBO() {
        ProductoBO productoBO = new ProductoBO();
        productoBO.setId(id);
        productoBO.setCategoria(categoria);
        productoBO.setNombre(nombre);
        productoBO.setPrecio(precio);
        productoBO.setTiempoFabricacion(tiempoFabricacion);
        if (fabricanteAtiende != null) {
            productoBO.setFabricanteAtiendeBO(fabricanteAtiende.toBO());
        }
        return productoBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return !isEmptyString(nombre) && !isEmptyString(categoria) && precio != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
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
