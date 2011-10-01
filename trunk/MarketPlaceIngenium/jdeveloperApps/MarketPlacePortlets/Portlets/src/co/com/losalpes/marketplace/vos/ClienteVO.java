package co.com.losalpes.marketplace.vos;

import java.util.List;

public class ClienteVO {
    private boolean seleccionado;
    private String nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo;
    private Double calificacion;
    private String razonSocial;
    private String estado;
    private List<ContactoVO> contactos;
    private CuentaFacturacionVO cuentaFact;
    private SolicitudRegistroVO solicitudRegistro;
    private List<ProductoVO> productos;
     
    public ClienteVO() {
        super();
    }
    
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
  
    public boolean isSeleccionado() {
        return seleccionado;
    }
  
    public void setNit(String nit) {
        this.nit = nit;
    }
  
    public String getNit() {
        return nit;
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    public String getNombre() {
        return nombre;
    }
  
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
  
    public String getDireccion() {
        return direccion;
    }
  
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
    public String getTelefono() {
        return telefono;
    }
  
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getEmail() {
        return email;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setContactos(List<ContactoVO> contactos) {
        this.contactos = contactos;
    }

    public List<ContactoVO> getContactos() {
        return contactos;
    }

    public void setCuentaFact(CuentaFacturacionVO cuentaFact) {
        this.cuentaFact = cuentaFact;
    }

    public CuentaFacturacionVO getCuentaFact() {
        return cuentaFact;
    }

    public void setSolicitudRegistro(SolicitudRegistroVO solicitudRegistro) {
        this.solicitudRegistro = solicitudRegistro;
    }

    public SolicitudRegistroVO getSolicitudRegistro() {
        return solicitudRegistro;
    }
    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }
  
    public List<ProductoVO> getProductos() {
        return productos;
    }
}
