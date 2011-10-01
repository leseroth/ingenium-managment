package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.SubastaVO;

import java.security.Principal;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ListaSubastas {
    private List<SubastaVO> subastas;
    private HtmlDataTable dt1;
    private ServicioProxy servProxy;
    public ListaSubastas() {
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
        subastas=new ArrayList<SubastaVO>(); //servProxy.getSubastasUsuario(username);
        dt1=new HtmlDataTable();
    }

    public void setSubastas(List<SubastaVO> subastas) {
        this.subastas = subastas;
    }

    public List<SubastaVO> getSubastas() {
        return subastas;
    }

    public void setDt1(HtmlDataTable dt1) {
        this.dt1 = dt1;
    }

    public HtmlDataTable getDt1() {
        return dt1;
    }

    public String verInfoSubasta_action() {
      SubastaVO sub=(SubastaVO)dt1.getRowData();
      ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
      Map<String,Object> m=ec.getRequestMap();
      m.put("subasta", sub);
        return "infoSubasta";
    }
}
