package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.SubastaVO;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletRequest;

public class InfoSubastas {
    private boolean fabricante=false;
    private SubastaVO subasta;
    private ServicioProxy servProxy;
    public InfoSubastas() {
        servProxy=ServicioProxy.getInstance();
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        Object request=ec.getRequest();
        if(request instanceof PortletRequest){
            Map<String, Object> mapaUser = (Map<String, Object>)((PortletRequest)request).getAttribute(PortletRequest.USER_INFO);
          System.out.println("El usuario logueado es :"+((PortletRequest)request).getUserPrincipal());
          fabricante=((PortletRequest)request).isUserInRole("Fabricante");
          System.out.println("Comercio"+((PortletRequest)request).isUserInRole("Comercio"));
          System.out.println("y "+(fabricante?"si":"no")+" tiene el rol fabricante");
          System.out.println("Los valores del mapa del usuario son:");
          for(String key:mapaUser.keySet()){
              System.out.println("\tllave "+key+": "+mapaUser.get(key));
            }
        }
        if(!fabricante){
             String numseg = (String)ec.getRequestMap().get("ordenNumSeg");

            try {
                subasta= servProxy.getSubastaByOrdenNumSeguimiento(numseg);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se puede procesar la solicitud "+e.getMessage()));
                e.printStackTrace();
            }
        }else{
            subasta=(SubastaVO)ec.getRequestMap().get("subasta");
          }
        
    }

    public String realizarOferta_action() {
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        ec.getRequestMap().put("subasta",subasta);
        return "crearOferta";
    }

    public void setFabricante(boolean fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isFabricante() {
        return fabricante;
    }

    public void setSubasta(SubastaVO subasta) {
        this.subasta = subasta;
    }

    public SubastaVO getSubasta() {
        return subasta;
    }

    public String volver_action() {
        return "volver";
    }
}
