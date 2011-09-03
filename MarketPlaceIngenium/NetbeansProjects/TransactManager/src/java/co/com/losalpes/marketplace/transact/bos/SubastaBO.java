package co.com.losalpes.marketplace.transact.bos;

import java.io.Serializable;
import java.util.*;

/**
 * subasta
 * @author 
 */
@SuppressWarnings({"serial", "unused"})
public class SubastaBO implements Serializable {

    /**
     * Attribute subastaID
     */
    private Long id;
    private String numSeguimiento;
    /**
     * Attribute mejor
     */
    private OfertaBO mejor;
    /**
     * Attribute ofertas
     */
    private Collection<OfertaBO> ofertas;
    /**
     * Attribute po
     */
    private PurchaseOrderBO po;

    private List<FabricanteBO> fabricantes;

    /**
     * Basic Constructor
     */
    public SubastaBO() {
        this.ofertas = new ArrayList<OfertaBO>();
        this.fabricantes = new ArrayList<FabricanteBO>();
    }

    /**
     * Simple Constructor
     */
    public SubastaBO(Long id) {
        this.id = id;
        this.mejor = new OfertaBO();
        this.ofertas = new ArrayList<OfertaBO>();
        this.po = new PurchaseOrderBO();
        this.fabricantes = new ArrayList<FabricanteBO>();
    }

    /**
     * Complex Constructor
     */
    public SubastaBO(Long id, OfertaBO mejor, Collection<OfertaBO> aOfertas, PurchaseOrderBO aPo) {
        this.id = id;
        this.mejor = mejor;
        this.ofertas = aOfertas;
        this.po = aPo;
        this.fabricantes = new ArrayList<FabricanteBO>();
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for attribute mejor
     * @return attribute mejor
     */
    public OfertaBO getMejor() {
        return this.mejor;
    }

    /**
     * Setter method for attribute mejor
     * @param new value for attribute mejor
     */
    public void setMejor(OfertaBO mejor) {
        this.mejor = mejor;
    }

    /**
     * Getter method for attribute ofertas
     * @return attribute ofertas
     */
    public Collection<OfertaBO> getOfertas() {
        return this.ofertas;
    }

    /**
     * Setter method for attribute ofertas
     * @param new value for attribute ofertas
     */
    public void setOfertas(Collection<OfertaBO> aOfertas) {
        this.ofertas = aOfertas;
    }

    /**
     * Getter method for attribute po
     * @return attribute po
     */
    public PurchaseOrderBO getPo() {
        return this.po;
    }

    /**
     * Setter method for attribute po
     * @param new value for attribute po
     */
    public void setPo(PurchaseOrderBO aPo) {
        this.po = aPo;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public List<FabricanteBO> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<FabricanteBO> fabricantes) {
        this.fabricantes = fabricantes;
    }
}
