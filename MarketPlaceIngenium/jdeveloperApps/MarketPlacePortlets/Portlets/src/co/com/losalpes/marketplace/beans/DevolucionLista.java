package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.OrdenDevolucionVO;

import com.sun.faces.context.FacesContextImpl;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DevolucionLista {
    private List<OrdenDevolucionVO> devoluciones; 
    public DevolucionLista() {
        Principal userPrincipal=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if(userPrincipal==null){
            FacesContext.getCurrentInstance()
                .addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR
                                                  ,"Error",
                                                  "Error al obtener el nombre del usuario"));
            System.err.println("Error obteniendo el 'principal' del usuario."); 
            return;
        }
        String username=userPrincipal.getName();

        devoluciones=ServicioProxy.getInstance().getOrdenDevolucionByUsernameFabricante(username);
    }

    public void setDevoluciones(List<OrdenDevolucionVO> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public List<OrdenDevolucionVO> getDevoluciones() {
        return devoluciones;
    }
}
