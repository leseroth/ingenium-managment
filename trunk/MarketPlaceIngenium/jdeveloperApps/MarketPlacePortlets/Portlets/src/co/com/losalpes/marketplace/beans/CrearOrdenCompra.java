package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import co.com.losalpes.marketplace.vos.ProductoVO;

import java.security.InvalidParameterException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class CrearOrdenCompra {
    private OrdenCompraVO orden;
    private List<SelectItem> productos;
    private ServicioProxy servProxy;
    public CrearOrdenCompra() {
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        servProxy=ServicioProxy.getInstance();
        orden=new OrdenCompraVO();
        orden.setItem(new ItemVO());
        productos=new ArrayList<SelectItem>();
        List<ProductoVO> productosVO=servProxy.getProductosByUsername(username);
        SelectItem tmpSelect;
        if(productosVO!=null){
          for(ProductoVO tmpProd:productosVO){
              tmpProd=new ProductoVO();
              tmpSelect=new SelectItem();
              tmpSelect.setLabel(tmpProd.getNombre());
              tmpSelect.setValue(tmpProd);
              productos.add(tmpSelect);
          }
        }
    }

    public String crearOrden_action() {
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        this.getOrden().setFecha(new Date());
        boolean creada=false;
        try{
        servProxy.persistir(this.getOrden(),username);
            creada=true;
        }catch(InvalidParameterException ipe){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orden no creada "+ipe.getMessage()));
                  }
        if(creada){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orden Creada!"));
        }
        return "inicioOC";
    }

    public void setOrden(OrdenCompraVO orden) {
        this.orden = orden;
    }

    public OrdenCompraVO getOrden() {
        return orden;
    }

    public List<SelectItem> getProductos() {
        return productos;
    }

    public String volver_action() {
        // Add event code here...
        return "inicioOC";
    }
}
