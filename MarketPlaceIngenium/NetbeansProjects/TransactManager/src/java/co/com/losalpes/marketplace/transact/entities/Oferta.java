package co.com.losalpes.marketplace.transact.entities;

import java.io.Serializable;
import javax.persistence.*;

import co.com.losalpes.marketplace.transact.bos.*;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllOfertas", query = "SELECT P FROM Oferta P ")
})
/**
 * Oferta
 * @author 
 */
public class Oferta implements Serializable {

    /**
     * Attribute id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    /**
     * Attribute tiempoOferta
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date fechaEntrega;
    /**
     * Attribute fabricante
     */
    @OneToOne
    protected Fabricante fabricante;

    @OneToOne
    private Producto productoOfrecido;

    @Column
    private Long valor;

    @Column
    private String numSeguimiento;

    /**
     * Default Constructor
     */
    public Oferta() {
       this.numSeguimiento = ""+System.currentTimeMillis();
    }

    /**
     * Complex Constructor
     */
    public Oferta(Long id, Date aTiempoOferta, Fabricante aFabricante, Producto prod, Long valor) {
        this.id = id;
        this.fechaEntrega = aTiempoOferta;
        this.fabricante = aFabricante;
        this.productoOfrecido = prod;
        this.valor = valor;
        this.numSeguimiento = ""+System.currentTimeMillis();
    }

    /**
     * BO Constructor
     */
    public Oferta(OfertaBO ofertaBO) {
        this.setId(ofertaBO.getId());
        this.setFechaEntrega(ofertaBO.getFechaEntrega());
        this.setFabricante(new Fabricante(ofertaBO.getFabricante()));
        this.setProductoOfrecido(new Producto(ofertaBO.getProductoOfrecido()));
        this.setNumSeguimiento(ofertaBO.getNumSeguimiento());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public OfertaBO toBO() {
        OfertaBO ofertaBO = new OfertaBO();
        ofertaBO.setId(this.getId());
        ofertaBO.setFechaEntrega(this.getFechaEntrega());
        ofertaBO.setProductoOfrecido(productoOfrecido.toBO());
        ofertaBO.setNumSeguimiento(this.getNumSeguimiento());
        Fabricante aFabricante = this.getFabricante();
        if (aFabricante != null) {
            ofertaBO.setFabricante(aFabricante.toBO());
        }
        return ofertaBO;
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
     * Getter method for attribute fabricante
     * @return attribute fabricante
     */
    public Fabricante getFabricante() {
        return this.fabricante;
    }

    /**
     * Setter method for attribute fabricante
     * @param new value for attribute fabricante
     */
    public void setFabricante(Fabricante aFabricante) {
        this.fabricante = aFabricante;
    }

    public Producto getProductoOfrecido() {
        return productoOfrecido;
    }

    public void setProductoOfrecido(Producto productoOfrecido) {
        this.productoOfrecido = productoOfrecido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date frechaEntrega) {
        this.fechaEntrega = frechaEntrega;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }
}
