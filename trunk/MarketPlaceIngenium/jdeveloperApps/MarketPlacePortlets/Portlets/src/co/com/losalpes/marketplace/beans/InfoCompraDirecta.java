package co.com.losalpes.marketplace.beans;


import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.SubastaVO;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class InfoCompraDirecta {
    private boolean fabricante=false;
    private SubastaVO subasta;
    private ServicioProxy servProxy;
    public InfoCompraDirecta() {
       
        
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
