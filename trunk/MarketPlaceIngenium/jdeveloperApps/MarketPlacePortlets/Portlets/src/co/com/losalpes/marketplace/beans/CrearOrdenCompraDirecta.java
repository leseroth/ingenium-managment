package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.constants.TipoClienteConstants;
import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.ProductoVO;
import co.com.losalpes.marketplace.vos.FabricanteVO;

import java.security.InvalidParameterException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


public class CrearOrdenCompraDirecta {
    private OrdenCompraVO orden;
    private List<SelectItem> productos;
    private ServicioProxy servProxy;
    private List<SelectItem> listaFabricantes;
    private FabricanteVO fabricante;
    private List<OrdenCompraVO> ordenes;
    private boolean mostrarPanel;
    HtmlDataTable dt1=new HtmlDataTable();
    
    public CrearOrdenCompraDirecta() {
        mostrarPanel = false; 
        ordenes = new ArrayList<OrdenCompraVO>();
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        servProxy=ServicioProxy.getInstance();
        orden=new OrdenCompraVO();
        orden.setItem(new ItemVO());
        productos=new ArrayList<SelectItem>();
        listaFabricantes=new ArrayList<SelectItem>();        
        List<FabricanteVO> clientes=servProxy.getFabricantes(TipoClienteConstants.FABRICANTE);
        SelectItem tmpSelect;
        if(clientes!=null){
          for(FabricanteVO tmpCliente:clientes){
              System.out.println(tmpCliente.getNombre());
              tmpSelect=new SelectItem();
              tmpSelect.setLabel(tmpCliente.getNombre());
              tmpSelect.setValue(tmpCliente);
              listaFabricantes.add(tmpSelect);
          }
        }
    }
    
    public String cargar_productos(){
        mostrarPanel = false;
        System.out.println("Entra cargar_productos ");
        productos=new ArrayList<SelectItem>();
        List<ProductoVO> productosVO=servProxy.getProductosByNit(orden.getFabricanteAtiende().getNit());
        SelectItem tmpSelect;
        if(productosVO!=null){
          for(ProductoVO tmpProd:productosVO){
              tmpSelect=new SelectItem();
              tmpSelect.setLabel(tmpProd.getNombre());
              tmpSelect.setValue(tmpProd);
              System.out.println("Nombre Producto: "+tmpProd.getNombre());
              productos.add(tmpSelect);
          }
            mostrarPanel = true;
        }
        System.out.println("Sale cargar_productos ");
        return "crearOrden";
    }

    public String crearOrden_action() {
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        this.getOrden().setFecha(new Date());
        boolean creada=false;
        try{
            System.out.println("Guardar orden compra directa");
            System.out.println("Fabricante: "+getOrden().getFabricanteAtiende().getNombre());
            System.out.println("Fecha maxima de entrega: "+getOrden().getFechaMaximaEntrega());
            System.out.println("Producto: "+getOrden().getItem().getProducto().getNombre());
            System.out.println("Cantidad: "+getOrden().getItem().getCantidad());
            
            servProxy.persistirCompraDirecta(this.getOrden(),username);
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
    
    public FabricanteVO getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(FabricanteVO fabricante) {
        this.fabricante = fabricante;
    }
    
    public List<OrdenCompraVO> getOrdenes() {
        ordenes = new ArrayList<OrdenCompraVO>();
        ordenes.add(orden);
        return ordenes;
    }

    public String volver_action() {
        // Add event code here...
        return "volver";
    }
    
    public void setDt1(HtmlDataTable dt1) {
        this.dt1 = dt1;
    }

    public HtmlDataTable getDt1() {
        return dt1;
    }

    public boolean isMostrarPanel() {
        return mostrarPanel;
    }
}
