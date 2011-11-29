package co.com.losalpes.marketplace.vos;

public class ItemVO {
    private int cantidad;
    private Long valor; 
    private ProductoVO producto;
    public ItemVO() {
        super();
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public ProductoVO getProducto() {
        return producto;
    }
}
