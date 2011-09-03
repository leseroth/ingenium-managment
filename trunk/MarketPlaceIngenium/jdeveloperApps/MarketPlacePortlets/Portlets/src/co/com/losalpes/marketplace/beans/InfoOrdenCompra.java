package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletRequest;

import javax.servlet.ServletRequest;

public class InfoOrdenCompra {
    private OrdenCompraVO orden;
    public InfoOrdenCompra() {
      ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
      System.out.println("Entra al constructor");
      if((OrdenCompraVO)ec.getRequestMap().get("PurchaseOrder")!=null)
       this.setOrden( (OrdenCompraVO)ec.getRequestMap().get("PurchaseOrder"));
    }

    public Object cb1_action() {
        // Add event code here...
        return "inicioOC";
    }

    public void setOrden(OrdenCompraVO orden) {
        
        this.orden = orden;
    }

    public OrdenCompraVO getOrden() {
        return orden;
    }

    public String verSubasta_action() {
        
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        
        Map<String,Object> m=ec.getRequestMap();
        
        if(m==null){
            System.out.println("Error poniendo el valor en el mapa");
        }else{
          System.out.println("orden de compra nulo? "+String.valueOf(this.getOrden()==null));
          m.put("ordenNumSeg", this.getOrden().getNumSeguimiento());
        }
        return "infoSubasta";
    }

    public String infoDA_action() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.getSessionMap().put("OrdenCompra",orden);
        System.out.println("ORDEN EN ORDEN COMPRA"+orden);
        return "infoDA";
    }
}
