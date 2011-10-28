package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.FabricanteVO;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OfertaVO;
import co.com.losalpes.marketplace.vos.SubastaVO;

import co.com.losalpes.marketplace.ws.types.Cliente;

import java.security.InvalidParameterException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class CrearOferta {
    private OfertaVO oferta;
    private SubastaVO subasta;
    public CrearOferta() {
        oferta=new OfertaVO();
    }

    public String crearOferta_action() {
        ServicioProxy servProxy = ServicioProxy.getInstance();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        boolean creada = false;
        this.getOferta().setFabricante(transformarFabricante(servProxy.getClienteByUsername(ec.getUserPrincipal().getName())));
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
        return "volver";
    }
    
    private FabricanteVO transformarFabricante(ClienteVO f){
            if(f==null)return null;
        FabricanteVO fabVO=new FabricanteVO();
        fabVO.setNit(f.getNit());
        fabVO.setNombre(f.getNombre());
        fabVO.setEmail( f.getEmail());
        fabVO.setTelefono(f.getTelefono());
        fabVO.setDireccion(f.getDireccion());
        return fabVO; 
        }

    public void setOferta(OfertaVO oferta) {
        this.oferta = oferta;
    }

    public OfertaVO getOferta() {
        return oferta;
    }
    
    public void setSubasta(SubastaVO subasta) {
        this.subasta = subasta;
        oferta=new OfertaVO();
        ItemVO item=this.subasta.getOrdenCompra().getItem();
        System.out.println("crearOferta item: "+item);
        oferta.setItem(item);
    }

    public SubastaVO getSubasta() {
        return subasta;
    }

}
