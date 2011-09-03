package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.AvisoDespachoVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.OrdenDevolucionVO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletSession;

import javax.servlet.http.HttpSession;

public class InfoDA {
    private AvisoDespachoVO avisoDespacho;
    private boolean editable=false;
    private ServicioProxy servProxy;
    public InfoDA() {
        servProxy=ServicioProxy.getInstance();
              ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
              Object sesion=ec.getSession(false);
              OrdenCompraVO orden=(OrdenCompraVO)(sesion instanceof PortletSession?((PortletSession)sesion).getAttribute("OrdenCompra"):((HttpSession)sesion).getAttribute("OrdenCompra"));
          Boolean tmpeditable=(Boolean)(sesion instanceof PortletSession?((PortletSession)sesion).getAttribute("editable"):((HttpSession)sesion).getAttribute("editable"));

      
      if(orden==null){
        System.out.println("Orden es null");
      }
        if(tmpeditable!=null){
            editable = tmpeditable;
        }
        if(editable){
            avisoDespacho=new AvisoDespachoVO();
            avisoDespacho.setOrdenCompra(orden);
        }else{
            avisoDespacho=servProxy.getAvisoDespachoByOrdenCompra(orden);
        }
    }

    public String crearRMA_action() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AvisoDespacho", avisoDespacho);
        return "crearRMA";
    }

    public void setAvisoDespacho(AvisoDespachoVO avisoDespacho) {
        this.avisoDespacho = avisoDespacho;
    }

    public AvisoDespachoVO getAvisoDespacho() {
        return avisoDespacho;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public String agregarCamion_action() {
        avisoDespacho.getCamiones().add("");
        return null;
    }
}
