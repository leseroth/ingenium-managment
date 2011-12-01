package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.constants.TipoClienteConstants;
import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.utils.UsuariosUtils;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import java.security.Principal;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletRequest;

import co.com.losalpes.marketplace.ws.ldapRol.*;


public class ListaOrdenesCompra {
    List<OrdenCompraVO> ordenes;
    HtmlDataTable dt1=new HtmlDataTable();
    private String nit;
    private ServicioProxy servProxy;
    private boolean comercio;
    
    public ListaOrdenesCompra() {
        
        Principal userPrincipal=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if(userPrincipal==null){
            FacesContext.getCurrentInstance()
                .addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR
                                                  ,"Error",
                                                  "Error al obtener el nombre del usuario"));
            System.err.println("Error obteniendo el 'principal' del usuario."); 
            return;
        }        
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Object request = ec.getRequest();
        String usuario = ((PortletRequest)request).getUserPrincipal().getName();
        
        servProxy=ServicioProxy.getInstance();
        nit=servProxy.getNitByUsername(usuario);
        
        //boolean bcomercio=FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Comercio");
        //boolean bfabricante=FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Fabricante");
        String rol ="";
        try {
            rol = LDAPAuthenticationManagementPortClient.getInstanceLDapRol().obtenerRol(nit);
        } catch (UsuarioNoExisteException e) {
            //TODO
            return;
        }
        //String rol = "Fabricante";//UsuariosUtils.getInstance().obtenerRolUsuario(usuario);
        if (rol.equals(TipoClienteConstants.COMERCIO)) {            
            comercio = true;
            ordenes= servProxy.getOrdenCompraByNitComercio(nit);
        }
        if (rol.equals(TipoClienteConstants.FABRICANTE)) {            
            ordenes=servProxy.getOrdenCompraByNitFabricante(nit);
        }
    }

    public String crear_action() {
        return "crear";
    }
    
    public String crearOrdenDirecta_action() {
        return "crearOrdenDirecta";
    }

    public void setOrdenes(List<OrdenCompraVO> ordenes) {
        this.ordenes = ordenes;
    }

    public List<OrdenCompraVO> getOrdenes() {
        return ordenes;
    }

    public String verOrdenCompra_action() {
        OrdenCompraVO po = (OrdenCompraVO)dt1.getRowData();
        Map<String, Object> req= FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
        Map<String, Object> ses= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        ses.remove("InfoPO");
        req.put("PurchaseOrder", po);
        return "verOrden";
    }

    public void setDt1(HtmlDataTable dt1) {
        this.dt1 = dt1;
    }

    public HtmlDataTable getDt1() {
        return dt1;
    }

    public boolean isComercio() {
        return comercio;
    }
}
