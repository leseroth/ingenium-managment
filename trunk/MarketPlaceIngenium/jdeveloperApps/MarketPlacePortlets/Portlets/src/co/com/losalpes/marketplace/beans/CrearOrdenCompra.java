package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import co.com.losalpes.marketplace.vos.ProductoVO;

import java.security.InvalidParameterException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class CrearOrdenCompra {
    private int hora;
    private int minutos;
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
        System.out.println("CrearOrdenCompra: productosVO "+productosVO);
        SelectItem tmpSelect;
        if(productosVO!=null){
          for(ProductoVO tmpProd:productosVO){
              tmpSelect=new SelectItem();
              tmpSelect.setLabel(tmpProd.getNombre());
              tmpSelect.setValue(tmpProd);
              productos.add(tmpSelect);
              System.out.println("CrearOrdenCompra: tmpProd.getNombre() "+tmpProd.getNombre());
          }
        }
    }

    public String crearOrden_action() {
        String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        this.getOrden().setFecha(new Date());
        boolean creada=false;
        
        Calendar calendarFechaMax = Calendar.getInstance();
        calendarFechaMax.setTime(orden.getFechaMaximaSubasta());
        calendarFechaMax.set(Calendar.HOUR_OF_DAY, hora);
        calendarFechaMax.set(Calendar.MINUTE, minutos);
        orden.setFechaMaximaSubasta(calendarFechaMax.getTime());
        
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
    
    
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}
