package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.MarketPlaceEntity;
import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.bos.FacturaBO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @NamedQuery(name = "getCuentaByNitCliente", query = "select cf from CuentaFacturacion cf where cf.cliente.nit = :nit"),
    // Revisar
    @NamedQuery(name = "getCtaFacturacionByNum", query = "select c from CuentaFacturacion c where c.numeroCuenta = :numero"),
    @NamedQuery(name = "getCuentaFacturacionByCorte", query = "select c from CuentaFacturacion c where c.corte = :corte")
})
public class CuentaFacturacion implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int corte;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoCorte;
    @Column
    private String numeroCuenta;
    @OneToOne
    private Cliente cliente;
    @OneToMany
    private List<Factura> facturaList;
    @OneToMany
    private List<Cargo> cargoList;

    /**
     * Default Constructor
     */
    public CuentaFacturacion() {
        facturaList = new ArrayList<Factura>();
        cargoList = new ArrayList<Cargo>();
    }

    /**
     * BO Constructor
     */
    public CuentaFacturacion(CuentaFacturacionBO cuentaFacturacionBO) {
        this();
        id = cuentaFacturacionBO.getId();
        corte = cuentaFacturacionBO.getCorte();
        fechaUltimoCorte = cuentaFacturacionBO.getFechaUltimoCorte();
        numeroCuenta = cuentaFacturacionBO.getNumeroCuenta();
        if (cuentaFacturacionBO.getCliente() != null) {
            cliente = new Cliente(cuentaFacturacionBO.getCliente());
        }
        for (FacturaBO facturaBO : cuentaFacturacionBO.getFacturaBOList()) {
            facturaList.add(new Factura(facturaBO));
        }
        for (CargoBO cargoBO : cuentaFacturacionBO.getCargoBOList()) {
            cargoList.add(new Cargo(cargoBO));
        }
    }

    /**
     * Inicializa el numero de cuenta y el corte
     */
    public void initCuentaFacturacion(Cliente cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmm");
        numeroCuenta = cliente.getId() + "-" + sdf.format(new Date());
        corte = (int) Math.random() % 3 + 1;
        this.cliente = cliente;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CuentaFacturacionBO toBO() {
        CuentaFacturacionBO cuentaFacturacionBO = new CuentaFacturacionBO();
        cuentaFacturacionBO.setId(getId());
        cuentaFacturacionBO.setCorte(getCorte());
        cuentaFacturacionBO.setFechaUltimoCorte(getFechaUltimoCorte());
        cuentaFacturacionBO.setNumeroCuenta(getNumeroCuenta());
        if (getCliente() != null) {
            cuentaFacturacionBO.setCliente(getCliente().toBO());
        }
        for (Factura factura : getFacturaList()) {
            cuentaFacturacionBO.getFacturaBOList().add(factura.toBO());
        }
        for (Cargo cargo : getCargoList()) {
            cuentaFacturacionBO.getCargoBOList().add(cargo.toBO());
        }
        return cuentaFacturacionBO;
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
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the facturaList
     */
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    /**
     * @param facturaList the facturaList to set
     */
    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    /**
     * @return the cargoList
     */
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    /**
     * @param cargoList the cargoList to set
     */
    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }
}
