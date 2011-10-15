package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import co.com.losalpes.marketplace.transact.bos.*;
import java.util.Date;

import static co.com.losalpes.marketplace.transact.util.Util.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllOfertas", query = "SELECT P FROM Oferta P ")
})
public class Oferta implements Serializable, MarketPlaceEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date fechaEntrega;
    @Column
    private String numSeguimiento;
    @Column
    private Long valor;
    @Column
    private String mensaje;
    @OneToOne
    private Fabricante fabricante;
    @OneToOne
    private Producto productoOfrecido;

    /**
     * Default Constructor
     */
    public Oferta() {
    }

    /**
     * Constructor desde BO
     * @param ofertaBO
     */
    public Oferta(OfertaBO ofertaBO) {
        id = ofertaBO.getId();
        fechaEntrega = ofertaBO.getFechaEntrega();
        numSeguimiento = ofertaBO.getNumSeguimiento();
        valor = ofertaBO.getValor();
        mensaje = ofertaBO.getMensaje();
        if (ofertaBO.getFabricanteBO() != null) {
            fabricante = new Fabricante(ofertaBO.getFabricanteBO());
        }
        if (ofertaBO.getProductoOfrecidoBO() != null) {
            productoOfrecido = new Producto(ofertaBO.getProductoOfrecidoBO());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfertaBO toBO() {
        OfertaBO ofertaBO = new OfertaBO();
        ofertaBO.setId(id);
        ofertaBO.setFechaEntrega(fechaEntrega);
        ofertaBO.setNumSeguimiento(numSeguimiento);
        ofertaBO.setValor(valor);
        ofertaBO.setMensaje(mensaje);
        if (productoOfrecido != null) {
            ofertaBO.setProductoOfrecidoBO(productoOfrecido.toBO());
        }
        if (fabricante != null) {
            ofertaBO.setFabricanteBO(fabricante.toBO());
        }
        return ofertaBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return getFechaEntrega() != null && !isEmptyString(numSeguimiento) && !isEmptyLong(valor) && getFabricante() != null;
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
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the fabricante
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the productoOfrecido
     */
    public Producto getProductoOfrecido() {
        return productoOfrecido;
    }

    /**
     * @param productoOfrecido the productoOfrecido to set
     */
    public void setProductoOfrecido(Producto productoOfrecido) {
        this.productoOfrecido = productoOfrecido;
    }
}
