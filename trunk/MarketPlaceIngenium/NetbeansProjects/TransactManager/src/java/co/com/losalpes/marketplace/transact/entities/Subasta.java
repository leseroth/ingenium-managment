package co.com.losalpes.marketplace.transact.entities;

import co.com.losalpes.marketplace.transact.MarketPlaceEntity;
import java.io.Serializable;
import java.util.ArrayList;
import co.com.losalpes.marketplace.transact.bos.*;
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

@Entity
@NamedQueries({
    @NamedQuery(name = "getSubastaFromNumSeguimiento", query = "select s from Subasta s where s.numSeguimiento = :numSeguimiento"), 
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
    @OneToOne
    private Oferta mejor;
    @OneToOne
    private PurchaseOrder po;
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
        subastaBO.setId(getId());
        subastaBO.setActiva(isActiva());
        subastaBO.setNumSeguimiento(getNumSeguimiento());

        if (getMejor() != null) {
            subastaBO.setMejorOfertaBO(getMejor().toBO());
        }
        if (getPo() != null) {
            subastaBO.setPurchaseOrderBO(getPo().toBO());
        }
        for (Oferta oferta : getOfertas()) {
            subastaBO.getOfertaBOList().add(oferta.toBO());
        }
        for (Fabricante fabricante : getFabricantes()) {
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
