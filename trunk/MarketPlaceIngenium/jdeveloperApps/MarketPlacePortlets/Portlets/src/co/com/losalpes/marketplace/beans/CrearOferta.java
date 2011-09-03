package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.FabricanteVO;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OfertaVO;
import co.com.losalpes.marketplace.vos.SubastaVO;

import java.security.InvalidParameterException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class CrearOferta {
    private OfertaVO oferta;
    private SubastaVO subasta;
    public CrearOferta() {
        oferta=new OfertaVO();
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
         subasta = (SubastaVO)ec.getRequestMap().get("subasta");
        ItemVO item=subasta.getOrdenCompra().getItem();
        oferta.setItem(item);
    }

    public String crearOferta_action() {
        ServicioProxy servProxy = ServicioProxy.getInstance();
        ExternalContext ec =
            FacesContext.getCurrentInstance().getExternalContext();
        boolean creada = false;
        if (this.subasta == null) {

            subasta = (SubastaVO)ec.getRequestMap().get("subasta");
        }
        this.getOferta().setFabricante((FabricanteVO)servProxy.getClienteByUsername(ec.getUserPrincipal().getName()));
        try {
            servProxy.persistir(this.subasta, this.getOferta());
            creada = true;
        } catch (InvalidParameterException ipe) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage("La oferta no se pudo crear " +
                                                                          ipe.getMessage()));
        }
        if (creada)
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage("Oferta Creada!"));
        return "inicioSubasta";
    }

    public void setOferta(OfertaVO oferta) {
        this.oferta = oferta;
    }

    public OfertaVO getOferta() {
        return oferta;
    }
}
