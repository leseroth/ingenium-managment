package co.com.losalpes.marketplace.vos;


import java.util.Date;


public class ContratoVO {
    
    private Integer cantidad;
    private ComercioVO comercio;
    private Date duracion;
    private String estado;
    private FabricanteVO fabricante;
    private Date fechaInicio;
    private Date fechaRegistro;
    private Long id;
    private String periodicidad;
    private Long precio;
    private ProductoVO producto;
    
    public ContratoVO() {
        super();
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer value) {
        this.cantidad = value;
    }
    
    public ComercioVO getComercio() {
        return comercio;
    }
    
    public void setComercio(ComercioVO value) {
        this.comercio = value;
    }
    
    public Date getDuracion() {
        return duracion;
    }
    
    public void setDuracion(Date value) {
        this.duracion = value;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String value) {
        this.estado = value;
    }
    
    public FabricanteVO getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(FabricanteVO value) {
        this.fabricante = value;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(Date value) {
        this.fechaInicio = value;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date value) {
        this.fechaRegistro = value;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long value) {
        this.id = value;
    }
    
    public String getPeriodicidad() {
        return periodicidad;
    }
    
    public void setPeriodicidad(String value) {
        this.periodicidad = value;
    }
    
    public Long getPrecio() {
        return precio;
    }
    
    public void setPrecio(Long value) {
        this.precio = value;
    }
    
    public ProductoVO getProducto() {
        return producto;
    }
    
    public void setProducto(ProductoVO value) {
        this.producto = value;
    }
}
