package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
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


public class CrearOrdenCompraDirecta {
    private OrdenCompraVO orden;
    private List<SelectItem> productos;
    private ServicioProxy servProxy;
    private List<SelectItem> listaFabricantes;
    private ClienteVO fabricante;
    
    public CrearOrdenCompraDirecta() {
        
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        servProxy=ServicioProxy.getInstance();
        orden=new OrdenCompraVO();
        orden.setItem(new ItemVO());
        productos=new ArrayList<SelectItem>();
        listaFabricantes=new ArrayList<SelectItem>();
        
        List<ClienteVO> productosVO=servProxy.getFabricantes();
        SelectItem tmpSelect;
        if(productosVO!=null){
          for(ClienteVO tmpCliente:productosVO){
              tmpCliente=new ClienteVO();
              tmpSelect=new SelectItem();
              tmpSelect.setLabel(tmpCliente.getNombre());
              tmpSelect.setValue(tmpCliente);
              productos.add(tmpSelect);
          }
        }
    }
    
    public void cargar_productos(){
        productos=new ArrayList<SelectItem>();
        List<ProductoVO> productosVO=fabricante.getProductos();
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
        return "volver";
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

    public List<SelectItem> getListaFabricantes() {
        return listaFabricantes;
    }
    
    public ClienteVO getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(ClienteVO fabricante) {
        this.fabricante = fabricante;
    }
    
    public List<OrdenCompraVO> getOrdenes() {
        List<OrdenCompraVO> ordenes = new ArrayList<OrdenCompraVO>();
        ordenes.add(orden);
        return ordenes;
    }

    public String volver_action() {
        // Add event code here...
        return "volver";
    }
}
