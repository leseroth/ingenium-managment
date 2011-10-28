/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.bos;

import java.io.Serializable;

/**
 * Cliente
 * @author marketplace
 */
@SuppressWarnings({"serial", "unused"})
public class ClienteBO implements Serializable {

    public static final String REPORTADO = "reportado";
    public static final String OK = "ok";

    /**
     * Attribute id
     */
    private Long id;
    /**
     * Attribute nombre
     */
    private String nombre;

    private String nit;

    private String email;

    private String direccion;

    private String estado;

    /**
     * Basic Constructor
     */

    public ClienteBO() {
        this.estado = OK;
    }

    /**
     * Basic Constructor
     */
    public ClienteBO(String aNombre, String nit, String email) {
        this.nombre = aNombre;
        this.nit = nit;
        this.estado = OK;
        this.email = email;
    }

    /**
     * Simple Constructor
     */
    public ClienteBO(Long aId, String aNombre, String nit, String email) {
        this.id = aId;
        this.nombre = aNombre;
        this.nit = nit;
        this.estado = OK;
        this.email = email;
    }

    public ClienteBO(Long aId, String aNombre, String nit, String aEmail, String direccion, String email) {
        this.id = aId;
        this.nombre = aNombre;
        this.nit = nit;
        this.email = aEmail;
        this.direccion = direccion;
        this.email = email;
        this.estado = OK;
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
    public void setId(Long aId) {
        this.id = aId;
    }

    /**
     * Getter method for attribute nombre
     * @return attribute nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter method for attribute nombre
     * @param new value for attribute nombre
     */
    public void setNombre(String aNombre) {
        this.nombre = aNombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Getter method for attribute nombre
     * @return attribute nombre
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter method for attribute nombre
     * @param new value for attribute nombre
     */
    public void setEmail(String aEmail) {
        this.email = aEmail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

