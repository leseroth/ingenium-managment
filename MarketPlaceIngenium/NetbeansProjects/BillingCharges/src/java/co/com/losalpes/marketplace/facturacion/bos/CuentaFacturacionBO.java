package co.com.losalpes.marketplace.facturacion.bos;

import co.com.losalpes.marketplace.facturacion.MarketPlaceBO;
import java.io.Serializable;
import java.util.*;

public class CuentaFacturacionBO implements MarketPlaceBO, Serializable {

    public static final int PRIMER_CORTE = 1;
    public static final int SEGUNDO_CORTE = 2;
    public static final int TERCER_CORTE = 3;
    
    private Long id;
    private int corte;
    private Date fechaUltimoCorte;
    private String numeroCuenta;
    private ClienteBO cliente;
    private List<FacturaBO> facturaBOList;
    private List<CargoBO> cargoBOList;

    /**
     * Default Constructor
     */
    public CuentaFacturacionBO() {
        facturaBOList = new ArrayList<FacturaBO>();
        cargoBOList = new ArrayList<CargoBO>();
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
     * @return the corte
     */
    public int getCorte() {
        return corte;
    }

    /**
     * @param corte the corte to set
     */
    public void setCorte(int corte) {
        this.corte = corte;
    }

    /**
     * @return the fechaUltimoCorte
     */
    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    /**
     * @param fechaUltimoCorte the fechaUltimoCorte to set
     */
    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the cliente
     */
    public ClienteBO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteBO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the facturaBOList
     */
    public List<FacturaBO> getFacturaBOList() {
        return facturaBOList;
    }

    /**
     * @param facturaBOList the facturaBOList to set
     */
    public void setFacturaBOList(List<FacturaBO> facturaBOList) {
        this.facturaBOList = facturaBOList;
    }

    /**
     * @return the cargoBOList
     */
    public List<CargoBO> getCargoBOList() {
        return cargoBOList;
    }

    /**
     * @param cargoBOList the cargoBOList to set
     */
    public void setCargoBOList(List<CargoBO> cargoBOList) {
        this.cargoBOList = cargoBOList;
    }
}
