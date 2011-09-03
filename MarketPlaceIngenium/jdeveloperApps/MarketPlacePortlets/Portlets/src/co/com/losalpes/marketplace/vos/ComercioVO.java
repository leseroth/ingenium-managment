package co.com.losalpes.marketplace.vos;

import java.util.List;

public class ComercioVO extends ClienteVO {
    private List<OrdenDevolucionVO> ordenesDevolucion;
    private List<OrdenCompraVO> ordenesCompra;
    public ComercioVO() {
        super();
    }

    public void setOrdenesDevolucion(List<OrdenDevolucionVO> ordenesDevolucion) {
        this.ordenesDevolucion = ordenesDevolucion;
    }

    public List<OrdenDevolucionVO> getOrdenesDevolucion() {
        return ordenesDevolucion;
    }

    public void setOrdenesCompra(List<OrdenCompraVO> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    public List<OrdenCompraVO> getOrdenesCompra() {
        return ordenesCompra;
    }
}
