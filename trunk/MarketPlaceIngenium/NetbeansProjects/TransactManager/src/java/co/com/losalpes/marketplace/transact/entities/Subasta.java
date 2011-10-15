package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import java.util.ArrayList;
import co.com.losalpes.marketplace.transact.bos.*;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "getSubastaFromNumSeguimiento", query = "select s from Subasta s where s.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getSubastasByActiva", query = "select s from Subasta s where s.activa = :activa"),
    @NamedQuery(name = "getAllSubastas", query = "select s from Subasta s"), // Verificar
    @NamedQuery(name = "getSubastaFromOrdenCompra", query = "select s from Subasta s where s.po.numSeguimiento = :numSeguimientoPO") // Verificar
})
public class Subasta implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private boolean activa;
    @Column
    private String numSeguimiento;
    @Column
    private String mensaje;
    @OneToOne
    private Oferta mejor;
    @OneToOne
    private PurchaseOrder po;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date fechaCreacionSubasta;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date fechaMaxSubasta;
    @OneToMany
    private List<Oferta> ofertas;
    @OneToMany
    private List<Fabricante> fabricantes;

    /**
     * Default Constructor
     */
    public Subasta() {
        ofertas = new ArrayList<Oferta>();
        fabricantes = new ArrayList<Fabricante>();
    }

    /**
     * Constructor desde BO
     * @param subastaBO
     */
    public Subasta(SubastaBO subastaBO) {
        id = subastaBO.getId();
        activa = subastaBO.isActiva();
        numSeguimiento = subastaBO.getNumSeguimiento();
        fechaCreacionSubasta = subastaBO.getFechaCreacionSubasta();
        fechaMaxSubasta = subastaBO.getFechaMaxSubasta();

        if (subastaBO.getMejorOfertaBO() != null) {
            mejor = new Oferta(subastaBO.getMejorOfertaBO());
        }
        if (subastaBO.getPurchaseOrderBO() != null) {
            po = new PurchaseOrder(subastaBO.getPurchaseOrderBO());
        }
        for (OfertaBO ofertaBO : subastaBO.getOfertaBOList()) {
            ofertas.add(new Oferta(ofertaBO));
        }
        for (FabricanteBO fabricanteBO : subastaBO.getFabricanteBOList()) {
            fabricantes.add(new Fabricante(fabricanteBO));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubastaBO toBO() {
        SubastaBO subastaBO = new SubastaBO();
        subastaBO.setId(id);
        subastaBO.setActiva(activa);
        subastaBO.setNumSeguimiento(numSeguimiento);
        subastaBO.setFechaCreacionSubasta(fechaCreacionSubasta);
        subastaBO.setFechaMaxSubasta(fechaMaxSubasta);

        if (mejor != null) {
            subastaBO.setMejorOfertaBO(mejor.toBO());
        }
        if (po != null) {
            subastaBO.setPurchaseOrderBO(po.toBO());
        }
        for (Oferta oferta : ofertas) {
            subastaBO.getOfertaBOList().add(oferta.toBO());
        }
        for (Fabricante fabricante : fabricantes) {
            subastaBO.getFabricanteBOList().add(fabricante.toBO());
        }
        return subastaBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return true;
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
     * @return the activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
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
     * @return the mejor
     */
    public Oferta getMejor() {
        return mejor;
    }

    /**
     * @param mejor the mejor to set
     */
    public void setMejor(Oferta mejor) {
        this.mejor = mejor;
    }

    /**
     * @return the po
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    /**
     * @return the fechaCreacionSubasta
     */
    public Date getFechaCreacionSubasta() {
        return fechaCreacionSubasta;
    }

    /**
     * @param fechaCreacionSubasta the fechaCreacionSubasta to set
     */
    public void setFechaCreacionSubasta(Date fechaCreacionSubasta) {
        this.fechaCreacionSubasta = fechaCreacionSubasta;
    }

    /**
     * @return the fechaMaxSubasta
     */
    public Date getFechaMaxSubasta() {
        return fechaMaxSubasta;
    }

    /**
     * @param fechaMaxSubasta the fechaMaxSubasta to set
     */
    public void setFechaMaxSubasta(Date fechaMaxSubasta) {
        this.fechaMaxSubasta = fechaMaxSubasta;
    }

    /**
     * @return the ofertas
     */
    public List<Oferta> getOfertas() {
        return ofertas;
    }

    /**
     * @param ofertas the ofertas to set
     */
    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    /**
     * @return the fabricantes
     */
    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    /**
     * @param fabricantes the fabricantes to set
     */
    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
}
