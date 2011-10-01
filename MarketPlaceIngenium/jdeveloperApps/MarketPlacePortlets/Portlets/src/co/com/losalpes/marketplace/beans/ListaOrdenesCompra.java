package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import java.security.Principal;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;


public class ListaOrdenesCompra {
    List<OrdenCompraVO> ordenes;
    HtmlDataTable dt1=new HtmlDataTable();
    private String nit;
    private ServicioProxy servProxy;
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
        servProxy=ServicioProxy.getInstance();
        String usuario=userPrincipal.getName();
        boolean comercio=FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Comercio");
        boolean fabricante=FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Fabricante");
        nit=servProxy.getNitByUsername(usuario);
        System.out.println("NIT: "+nit);
        if(comercio)
        ordenes= servProxy.getOrdenCompraByNitComercio(nit);
        if(fabricante)
            ordenes=servProxy.getOrdenCompraByNitFabricante(nit);
    }

    public String crear_action() {
       System.out.println("Crear Orden de Compra");
        return "crear";
    }
    
    public String crearOrdenDirecta_action() {
       System.out.println("Crear Orden de Compra Directa");
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
}
