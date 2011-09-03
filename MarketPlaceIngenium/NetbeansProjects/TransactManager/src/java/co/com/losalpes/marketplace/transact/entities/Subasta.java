package co.com.losalpes.marketplace.transact.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;
import co.com.losalpes.marketplace.transact.bos.*;
import java.util.List;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name = "getAllSubastas", query = "select s from Subasta s"),
    @NamedQuery(name = "getSubastaFromNumSeguimiento", query = "select s from Subasta s where s.numSeguimiento = :numSeguimiento"),
    @NamedQuery(name = "getSubastaFromOrdenCompra", query = "select s from Subasta s where s.po.numSeguimiento = :numSeguimientoPO")
})
/**
 * Subasta
 * @author 
 */
public class Subasta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Column
    private String numSeguimiento;
    /**
     * Attribute mejor
     */
    @OneToOne
    protected Oferta mejor;

    @Column
    boolean activa;
    /**
     * Attribute ofertas
     */
    @OneToMany
    protected Collection<Oferta> ofertas;
    /**
     * Attribute po
     */
    @OneToOne
    protected PurchaseOrder po;

    @OneToMany
    private List<Fabricante> fabricantes;

    /**
     * Default Constructor
     */
    public Subasta() {
        this.ofertas = new ArrayList<Oferta>();
        this.mejor = new Oferta();
    }

    /**
     * Simple Constructor
     */
    public Subasta(Long id) {
        this.id = id;
        this.mejor = new Oferta();
        this.ofertas = new ArrayList<Oferta>();
        this.po = new PurchaseOrder();
    }

    /**
     * Complex Constructor
     */
    public Subasta(Long id, Oferta mejor, Collection<Oferta> aOfertas, PurchaseOrder aPo) {
        this.id = id;
        this.mejor = mejor;
        this.ofertas = aOfertas;
        this.po = aPo;
    }

    /**
     * BO Constructor
     */
    public Subasta(SubastaBO subastaBO) {
        this.setId(subastaBO.getId());
        this.setMejor(new Oferta(subastaBO.getMejor()));

        Collection<Oferta> ofertasFromBO = new ArrayList<Oferta>();

        for (OfertaBO ofertaBO : subastaBO.getOfertas()) {
            ofertasFromBO.add(new Oferta(ofertaBO));
        }
        this.setOfertas(ofertasFromBO);
        this.setPo(new PurchaseOrder(subastaBO.getPo()));
        this.setNumSeguimiento(subastaBO.getNumSeguimiento());
        List<Fabricante> fabs = new ArrayList<Fabricante>();
        for(int i = 0; i < subastaBO.getFabricantes().size(); i++){
            fabs.add(new Fabricante(subastaBO.getFabricantes().get(i)));
        }
        this.setFabricantes(fabs);
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public SubastaBO toBO() {
        SubastaBO subastaBO = new SubastaBO();
        subastaBO.setId(id);
        subastaBO.setNumSeguimiento(numSeguimiento);
        subastaBO.setMejor(mejor.toBO());
        
        Collection<OfertaBO> ofertasToBO = new ArrayList<OfertaBO>();
        for (Oferta element : this.getOfertas()) {
            ofertasToBO.add(element.toBO());
        }
        subastaBO.setOfertas(ofertasToBO);

        PurchaseOrder aPo = this.getPo();
        if (aPo != null) {
            subastaBO.setPo(aPo.toBO());
        }

        List<FabricanteBO> fabsBO = new ArrayList<FabricanteBO>();
        for(int i = 0; i < fabricantes.size(); i++){
            fabsBO.add(fabricantes.get(i).toBO());
        }
        subastaBO.setFabricantes(fabsBO);

        return subastaBO;
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
    public void setId(Long aid) {
        this.id = aid;
    }

    /**
     * Getter method for attribute mejor
     * @return attribute mejor
     */
    public Oferta getMejor() {
        return this.mejor;
    }

    /**
     * Setter method for attribute mejor
     * @param new value for attribute mejor
     */
    public void setMejor(Oferta mejor) {
        this.mejor = mejor;
    }

    /**
     * Getter method for attribute ofertas
     * @return attribute ofertas
     */
    public Collection<Oferta> getOfertas() {
        return this.ofertas;
    }

    /**
     * Setter method for attribute ofertas
     * @param new value for attribute ofertas
     */
    public void setOfertas(Collection<Oferta> aOfertas) {
        this.ofertas = aOfertas;
    }

    /**
     * Getter method for attribute po
     * @return attribute po
     */
    public PurchaseOrder getPo() {
        return this.po;
    }

    /**
     * Setter method for attribute po
     * @param new value for attribute po
     */
    public void setPo(PurchaseOrder aPo) {
        this.po = aPo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
}
