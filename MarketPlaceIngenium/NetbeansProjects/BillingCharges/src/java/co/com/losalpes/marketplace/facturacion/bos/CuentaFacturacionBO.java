/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.bos;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author marketplace
 */
public class CuentaFacturacionBO implements Serializable{

    private Long id;

    private String numeroCuenta;

    private ClienteBO cliente;
    
    private int corte;

    private Date fechaUltimoCorte;

    /**
     * Attribute facturas
     */

    private List<FacturaBO> facturas;

    /**
     * Attribute cargos
     */
   
    private List<CargoBO> cargos;

    /**
     * Default Constructor
     */
    public CuentaFacturacionBO() {
        this.facturas = new ArrayList<FacturaBO>();
        this.cargos = new ArrayList<CargoBO>();
    }

    /**
     * Simple Constructor
     */
    public CuentaFacturacionBO(Long id, int corte) {
        this.id = id;
        this.corte = corte;
        this.facturas = new ArrayList<FacturaBO>();
        this.cargos = new ArrayList<CargoBO>();
    }

    /**
     * Complex Constructor
     */
    public CuentaFacturacionBO(Long id, int corte, List<FacturaBO> aFacturas, List<CargoBO> aCargos) {
        this.id = id;
        this.corte = corte;
        this.facturas = aFacturas;
        this.cargos = aCargos;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteBO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBO cliente) {
        this.cliente = cliente;
    }

    /**
     * Getter method for attribute facturas
     * @return attribute facturas
     */
    public List<FacturaBO> getFacturas() {
        return this.facturas;
    }

    /**
     * Setter method for attribute facturas
     * @param new value for attribute facturas
     */
    public void setFacturas(List<FacturaBO> aFacturas) {
        this.facturas = aFacturas;
    }

    /**
     * Getter method for attribute cargos
     * @return attribute cargos
     */
    public List<CargoBO> getCargos() {
        return this.cargos;
    }

    /**
     * Setter method for attribute cargos
     * @param new value for attribute cargos
     */
    public void setCargos(List<CargoBO> aCargos) {
        this.cargos = aCargos;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }
}
