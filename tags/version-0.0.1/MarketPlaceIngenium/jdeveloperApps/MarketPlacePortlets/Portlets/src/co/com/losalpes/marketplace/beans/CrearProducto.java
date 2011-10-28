package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.ProductoVO;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

public class CrearProducto {
    private ProductoVO producto;
    private boolean fabricante;
    public CrearProducto() {
        producto=new ProductoVO();
        fabricante=FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Fabricante");
    }

    public String crear_action() {
      ClienteVO cliente = (ClienteVO)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("cliente");
      if(cliente!=null){
          if(cliente.getProductos()==null){
              cliente.setProductos(new ArrayList<ProductoVO>());
              }
          cliente.getProductos().add(producto);//El producto se persiste con el cliente
          }
       FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("cliente", cliente);
        //ServicioProxy.getInstance().persistir(producto);
        return "volver";
    }

    public String volver_action() {
        // Add event code here...
        return "volver";
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setFabricante(boolean fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isFabricante() {
        return fabricante;
    }
}
