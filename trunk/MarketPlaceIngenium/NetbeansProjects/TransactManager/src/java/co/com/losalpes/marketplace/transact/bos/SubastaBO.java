package co.com.losalpes.marketplace.transact.bos;

import co.com.losalpes.marketplace.transact.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class SubastaBO implements Serializable, MarketPlaceBO {

    private Long id;
    private boolean activa;
    private String numSeguimiento;
    private OfertaBO mejor;
    private PurchaseOrderBO po;
    private List<OfertaBO> ofertas;
    private List<FabricanteBO> fabricantes;

    /**
     * Basic Constructor
     */
    public SubastaBO() {
        ofertas = new ArrayList<OfertaBO>();
        fabricantes = new ArrayList<FabricanteBO>();
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
    public OfertaBO getMejor() {
        return mejor;
    }

    /**
     * @param mejor the mejor to set
     */
    public void setMejor(OfertaBO mejor) {
        this.mejor = mejor;
    }

    /**
     * @return the po
     */
    public PurchaseOrderBO getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrderBO po) {
        this.po = po;
    }

    /**
     * @return the ofertas
     */
    public List<OfertaBO> getOfertas() {
        return ofertas;
    }

    /**
     * @param ofertas the ofertas to set
     */
    public void setOfertas(List<OfertaBO> ofertas) {
        this.ofertas = ofertas;
    }

    /**
     * @return the fabricantes
     */
    public List<FabricanteBO> getFabricantes() {
        return fabricantes;
    }

    /**
     * @param fabricantes the fabricantes to set
     */
    public void setFabricantes(List<FabricanteBO> fabricantes) {
        this.fabricantes = fabricantes;
    }
}
