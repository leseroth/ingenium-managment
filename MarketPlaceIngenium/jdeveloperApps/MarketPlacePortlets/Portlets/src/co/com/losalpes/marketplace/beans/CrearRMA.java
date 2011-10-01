package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.AvisoDespachoVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.OrdenDevolucionVO;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletSession;

import javax.servlet.http.HttpSession;

public class CrearRMA {
    private OrdenDevolucionVO devolucion;
    public CrearRMA() {
      ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
      Object sesion=ec.getSession(false);
      OrdenCompraVO orden=(OrdenCompraVO)(sesion instanceof PortletSession?((PortletSession)sesion).getAttribute("OrdenCompra"):((HttpSession)sesion).getAttribute("OrdenCompra"));
      AvisoDespachoVO avisoDespacho=(AvisoDespachoVO)(sesion instanceof PortletSession?((PortletSession)sesion).getAttribute("AvisoDespacho"):((HttpSession)sesion).getAttribute("AvisoDespacho"));
        devolucion=new OrdenDevolucionVO();
        devolucion.setOrdenCompra(orden);
        devolucion.setAvisoDespacho(avisoDespacho);
        //TODO: Falta en la vista la cantidad del item. 
    }

    public String crearRMA_action() {
        System.out.println("Orden Compra"+devolucion.getOrdenCompra());
      System.out.println("Aviso Despacho"+devolucion.getAvisoDespacho());
      //TODO:Persistir y mensaje de confirmación
      ServicioProxy servProxy=ServicioProxy.getInstance();
      servProxy.persistir(devolucion);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha creado la Orden de Devolucion para el Aviso de despacho con numero de seguimiento "+devolucion.getAvisoDespacho().getNumSeguimiento()));
        return "inicioOC";
    }

    public void setDevolucion(OrdenDevolucionVO devolucion) {
        this.devolucion = devolucion;
    }

    public OrdenDevolucionVO getDevolucion() {
        return devolucion;
    }
}
