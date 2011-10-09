package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;
import co.com.losalpes.marketplace.transact.bos.*;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllSubastas", query = "select s from Subasta s"),
    @NamedQuery(name = "getSubastaFromNumSeguimiento", query = "select s from Subasta s where s.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getSubastaFromOrdenCompra", query = "select s from Subasta s where s.po.numSeguimiento = :numSeguimientoPO")
})
public class Subasta implements Serializable, MarketPlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private boolean activa;
    @Column
    private String numSeguimiento;
    @OneToOne
    private Oferta mejor;
    @OneToOne
    private PurchaseOrder po;
    @OneToMany
    private Collection<Oferta> ofertas;
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

        if (subastaBO.getMejor() != null) {
            mejor = new Oferta(subastaBO.getMejor());
        }
        if (subastaBO.getPo() != null) {
            po = new PurchaseOrder(subastaBO.getPo());
        }
        for (OfertaBO ofertaBO : subastaBO.getOfertas()) {
            ofertas.add(new Oferta(ofertaBO));
        }
        for (FabricanteBO fabricanteBO : subastaBO.getFabricantes()) {
            fabricantes.add(new Fabricante(fabricanteBO));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubastaBO toBO() {
        SubastaBO subastaBO = new SubastaBO();
        subastaBO.setId(getId());
        subastaBO.setActiva(isActiva());
        subastaBO.setNumSeguimiento(getNumSeguimiento());

        if (getMejor() != null) {
            subastaBO.setMejor(getMejor().toBO());
        }
        if (getPo() != null) {
            subastaBO.setPo(getPo().toBO());
        }
        for (Oferta oferta : getOfertas()) {
            subastaBO.getOfertas().add(oferta.toBO());
        }
        for (Fabricante fabricante : getFabricantes()) {
            subastaBO.getFabricantes().add(fabricante.toBO());
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
     * @return the ofertas
     */
    public Collection<Oferta> getOfertas() {
        return ofertas;
    }

    /**
     * @param ofertas the ofertas to set
     */
    public void setOfertas(Collection<Oferta> ofertas) {
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
