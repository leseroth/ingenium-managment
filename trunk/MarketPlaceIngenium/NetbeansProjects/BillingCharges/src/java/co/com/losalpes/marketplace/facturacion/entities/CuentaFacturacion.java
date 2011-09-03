/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.bos.CargoBO;
import co.com.losalpes.marketplace.facturacion.bos.CuentaFacturacionBO;
import co.com.losalpes.marketplace.facturacion.bos.FacturaBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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


@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
     @NamedQuery(name="getCtaFacturacionByNum", query="select c from CuentaFacturacion c where c.numeroCuenta = :numero"),
     @NamedQuery(name="getCuentaFacturacionByCorte", query="select c from CuentaFacturacion c where c.corte = :corte"),
     @NamedQuery(name="getCuentaByNitCliente", query="select c from CuentaFacturacion c where c.cliente.nit = :nit")
})
/**
 * CtaFacturacion
 * @author marketplace
 */

public class CuentaFacturacion implements Serializable {

    public static final int PRIMER_CORTE = 1;
    public static final int SEGUNDO_CORTE = 2;
    public static final int TERCER_CORTE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numeroCuenta;


    @OneToOne
    private Cliente cliente;

    /**
     * Attribute fCorte
     */
    @Column
    protected int corte;
    
    /**
     * Attribute facturas
     */
    @OneToMany
    protected List<Factura> facturas;

    /**
     * Attribute cargos
     */
    @OneToMany
    protected List<Cargo> cargos;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoCorte;

    /**
     * Default Constructor
     */
    public CuentaFacturacion() {
        String num = ""+System.currentTimeMillis();
        this.numeroCuenta = num.substring(0, 7);
        this.corte = (int)Math.random()%3+1;
        this.facturas = new ArrayList<Factura>();
        this.cargos = new ArrayList<Cargo>();
    }

    /**
     * Simple Constructor
     */
    public CuentaFacturacion(Long id, int corte, String numCuenta) {
        this.id = id;
        this.corte = corte;
        this.numeroCuenta = numCuenta;
        this.facturas = new ArrayList<Factura>();
        this.cargos = new ArrayList<Cargo>();
    }

    /**
     * BO Constructor
     */
    public CuentaFacturacion(CuentaFacturacionBO ctaFactBO) {
        this.setId(ctaFactBO.getId());
        this.setCorte(ctaFactBO.getCorte());
        this.setNumeroCuenta(ctaFactBO.getNumeroCuenta());
        List<Factura> facturasFromBO = new ArrayList<Factura>();
        for (FacturaBO facturaBO : ctaFactBO.getFacturas()) {
            facturasFromBO.add(new Factura(facturaBO));
        }
        this.setFacturas(facturasFromBO);

        List<Cargo> cargosFromBO = new ArrayList<Cargo>();
        for (CargoBO cargoBO : ctaFactBO.getCargos()) {
            cargosFromBO.add(new Cargo(cargoBO));
        }
        this.setCargos(cargosFromBO);
        this.setCliente(new Cliente(ctaFactBO.getCliente()));
        this.setFechaUltimoCorte(ctaFactBO.getFechaUltimoCorte());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public CuentaFacturacionBO toBO() {
        CuentaFacturacionBO ctaFactBO = new CuentaFacturacionBO();
        ctaFactBO.setId(this.getId());
        ctaFactBO.setCorte(this.getCorte());
        ctaFactBO.setNumeroCuenta(this.getNumeroCuenta());
        List<FacturaBO> facturasToBO = new ArrayList<FacturaBO>();
        for (Factura facturaBO : this.getFacturas()) {
            facturasToBO.add(facturaBO.toBO());
        }
        ctaFactBO.setFacturas(facturasToBO);

        List<CargoBO> cargosToBO = new ArrayList<CargoBO>();
        for (Cargo cargoBO : this.getCargos()) {
            cargosToBO.add(cargoBO.toBO());
        }
        ctaFactBO.setCargos(cargosToBO);
        ctaFactBO.setCliente(this.getCliente().toBO());
        ctaFactBO.setFechaUltimoCorte(this.getFechaUltimoCorte());
   
        return ctaFactBO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
    /**
     * Getter method for attribute facturas
     * @return attribute facturas
     */
    public List<Factura> getFacturas() {
        return this.facturas;
    }

    /**
     * Setter method for attribute facturas
     * @param new value for attribute facturas
     */
    public void setFacturas(List<Factura> aFacturas) {
        this.facturas = aFacturas;
    }

    public void adicionarFactura(Factura f){
        facturas.add(f);
    }

    /**
     * Getter method for attribute cargos
     * @return attribute cargos
     */
    public List<Cargo> getCargos() {
        return this.cargos;
    }

    /**
     * Setter method for attribute cargos
     * @param new value for attribute cargos
     */
    public void setCargos(List<Cargo> aCargos) {
        this.cargos = aCargos;
    }

    public void adicionarCargo(Cargo cargo){
        cargos.add(cargo);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CuentaFacturacion)) {
            return false;
        }
        CuentaFacturacion other = (CuentaFacturacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.losalpes.marketplace.facturacion.entities.CtaFacturacion[id=" + id + "]";
    }
}
