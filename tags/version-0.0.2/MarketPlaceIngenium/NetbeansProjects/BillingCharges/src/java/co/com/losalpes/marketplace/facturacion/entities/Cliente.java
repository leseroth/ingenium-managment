package co.com.losalpes.marketplace.facturacion.entities;

import co.com.losalpes.marketplace.facturacion.MarketPlaceEntity;
import co.com.losalpes.marketplace.facturacion.bos.ClienteBO;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "getClienteByNit", query = "select c from Cliente c where c.nit = :nit")})
public class Cliente implements MarketPlaceEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String direccion;
    @Column
    private String email;
    @Column
    private String estado;
    @Column
    private String nit;
    @Column
    private String nombre;

    /**
     * Default Constructor
     */
    public Cliente() {
    }

    /**
     * BO Constructor
     */
    public Cliente(ClienteBO clienteBO) {
        this();
        id = clienteBO.getId();
        direccion = clienteBO.getDireccion();
        email = clienteBO.getEmail();
        estado = clienteBO.getEstado();
        nit = clienteBO.getNit();
        nombre = clienteBO.getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClienteBO toBO() {
        ClienteBO clienteBO = new ClienteBO();
        clienteBO.setId(getId());
        clienteBO.setDireccion(getDireccion());
        clienteBO.setEmail(getEmail());
        clienteBO.setEstado(getEstado());
        clienteBO.setNit(getNit());
        clienteBO.setNombre(getNombre());
        return clienteBO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoComplete() {
        return direccion != null && email != null && estado != null && nit != null && nombre != null;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
