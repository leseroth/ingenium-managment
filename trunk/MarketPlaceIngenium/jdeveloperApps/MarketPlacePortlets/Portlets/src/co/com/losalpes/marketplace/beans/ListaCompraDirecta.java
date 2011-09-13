package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;

import java.security.Principal;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class ListaCompraDirecta {
    private List<OrdenCompraVO> comprasDirectas;
    private HtmlDataTable dt1;
    private ServicioProxy servProxy;
    public ListaCompraDirecta() {
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

        servProxy=ServicioProxy.getInstance();
        comprasDirectas=servProxy.getComprasDirectasUsuario(username);
        dt1=new HtmlDataTable();
    }

    public void setComprasDirectas(List<OrdenCompraVO> comprasDirectas) {
        this.comprasDirectas = comprasDirectas;
    }

    public List<OrdenCompraVO> getComprasDirectas() {
        return comprasDirectas;
    }

    public void setDt1(HtmlDataTable dt1) {
        this.dt1 = dt1;
    }

    public HtmlDataTable getDt1() {
        return dt1;
    }

    public String verInfoCompraDirecta_action() {
      OrdenCompraVO sub=(OrdenCompraVO)dt1.getRowData();
      ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
      Map<String,Object> m=ec.getRequestMap();
      m.put("compraDirecta", sub);
        return "infoCompraDirecta";
    }
}
