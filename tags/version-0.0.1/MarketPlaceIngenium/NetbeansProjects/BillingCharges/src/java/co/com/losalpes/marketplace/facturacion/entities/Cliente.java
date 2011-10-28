/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings({"serial", "unused", "unchecked"})
@Entity
@NamedQueries({
    @NamedQuery(name="getClienteByNit", query="select c from Cliente c where c.nit = :nit")
})

/**
 * Cliente
 * @author marketplace
 */

public class Cliente implements Serializable {
   /**
     * Attribute ClienteID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    /**
     * Attribute nombre
     */
    @Column
    protected String nombre;
    @Column
    private String nit;

    @Column
    private String direccion;

    @Column
    private String estado;

    @Column
    private String email;

    /**
     * Default Constructor
     */
    public Cliente() {
        this.estado = ClienteBO.OK;
    }

    /**
     * Simple Constructor
     */
    public Cliente(Long id, String aNombre, String direccion, String email) {
        this.id = id;
        this.nombre = aNombre;
        this.direccion = direccion;
        this.estado = ClienteBO.OK;
        this.email = email;
    }

    /**
     * BO Constructor
     */
    public Cliente(ClienteBO clienteBO) {
        this.setId(clienteBO.getId());
        this.setNombre(clienteBO.getNombre());
        this.setDireccion(clienteBO.getDireccion());
        this.setEstado(ClienteBO.OK);
        this.setEmail(clienteBO.getEmail());
    }

    /**
     * Converts the current entity to its BO
     * @param Integer gets the bo tree in depth
     */
    public ClienteBO toBO() {
        ClienteBO clienteBO = new ClienteBO();
        clienteBO.setId(this.getId());
        clienteBO.setNombre(this.getNombre());
        clienteBO.setDireccion(this.getDireccion());
        clienteBO.setEstado(ClienteBO.OK);
        clienteBO.setEmail(this.getEmail());
        return clienteBO;
    }

    /**
     * Getter method for attribute clienteID
     * @return attribute clienteID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter method for attribute clienteID
     * @param new value for attribute clienteID
     */
    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}