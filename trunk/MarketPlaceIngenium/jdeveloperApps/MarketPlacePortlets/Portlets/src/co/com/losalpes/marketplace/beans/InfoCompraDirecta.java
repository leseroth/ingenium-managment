package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.constants.EstadoCompraDirectaConstants;
import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.SubastaVO;

import java.security.InvalidParameterException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class InfoCompraDirecta {

    private OrdenCompraVO compraDirecta;
    private ServicioProxy servProxy;
    private Long precio;
    
    public InfoCompraDirecta() {                              
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        if((OrdenCompraVO)ec.getRequestMap().get("compraDirecta")!=null)
         this.setCompraDirecta( (OrdenCompraVO)ec.getRequestMap().get("compraDirecta"));
    }

    public boolean aprobarRechazarCompra(String estado) {
        boolean creada=false;
        try{            
            servProxy.aceptarCompraDirecta(compraDirecta.getNumSeguimiento(), estado, precio);
            creada=true;
        }catch(InvalidParameterException ipe){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El estado de la orden de compra no fue actualizado "+ipe.getMessage()));
        }  
        return creada;
    }
    
    public String aprobar() {
        if(aprobarRechazarCompra(EstadoCompraDirectaConstants.ACEPTADO_FABRICANTE)){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orden de compra aprobada!"));
        }
        return "volver";
    }
    
    public String rechazar() {
        if(aprobarRechazarCompra(EstadoCompraDirectaConstants.RECHAZADO_FABRICANTE)){
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orden de compra rechazada!"));
        }
        return "volver";
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setCompraDirecta(OrdenCompraVO compraDirecta) {
        this.compraDirecta = compraDirecta;
    }

    public OrdenCompraVO getCompraDirecta() {
        return compraDirecta;
    }

    public String volver_action() {
        return "volver";
    }
}
