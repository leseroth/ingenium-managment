package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.utils.UsuariosUtils;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.SubastaVO;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.portlet.PortletRequest;
import co.com.losalpes.marketplace.utils.UsuariosUtils;
import co.com.losalpes.marketplace.constants.TipoClienteConstants;

public class InfoSubastas {
    private boolean fabricante = false;
    private SubastaVO subasta;
    private ServicioProxy servProxy;

    public InfoSubastas() {
        servProxy = ServicioProxy.getInstance();
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Object request = ec.getRequest();
        String rol = UsuariosUtils.getInstance().obtenerRolUsuario(((PortletRequest)request).getUserPrincipal().getName());
        if (rol.equals(TipoClienteConstants.FABRICANTE)) {            
            fabricante = true;
        }
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
