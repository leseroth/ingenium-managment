package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.ContactoVO;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class InfoCuentaCliente {
    private ClienteVO cliente; 
    private ServicioProxy servProxy;
    public InfoCuentaCliente() {
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
        this.cliente=servProxy.getClienteByUsername(username);
        ClienteVO clienteExterno = (ClienteVO)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("cliente");
        if(clienteExterno!=null && clienteExterno.getNit().equals(cliente.getNit())){
            cliente=clienteExterno;
              FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("cliente",null);
            }
    }

    public String actualizar_action() {
        System.out.println(this.cliente.getDireccion());
        servProxy.persistir(this.cliente);
        return null;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public String crearContacto_action() {
        Map<String,Object> MapaRequest=FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
        MapaRequest.put("cliente", cliente);
        return "crearContacto";
    }

    public String crearProducto_action() {
      Map<String,Object> MapaRequest=FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
      MapaRequest.put("cliente", cliente);
        return "crearProducto";
    }
}
