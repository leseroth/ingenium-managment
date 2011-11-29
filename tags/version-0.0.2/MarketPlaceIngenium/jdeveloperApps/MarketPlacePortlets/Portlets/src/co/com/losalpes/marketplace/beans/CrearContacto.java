package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.ContactoVO;

import co.com.losalpes.marketplace.vos.ProductoVO;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CrearContacto {
    private ContactoVO contacto;
    public CrearContacto() {
        contacto=new ContactoVO();
    }

    public String crearContacto_action() {
        //ServicioProxy.getInstance().persistir(this.contacto);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, 
                           new FacesMessage(FacesMessage.SEVERITY_INFO,
                                            "Contacto Creado!",
                                            "El nuevo contacto ha sido creado, para guardarlo debe guardar los cambios en la información del cliente"));
      ClienteVO cliente = (ClienteVO)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("cliente");
      if(cliente!=null){
          if(cliente.getContactos()==null){
              cliente.setContactos(new ArrayList<ContactoVO>());
              }
          cliente.getContactos().add(this.contacto);//El contacto se persiste con el cliente
          }
       FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("cliente", cliente);
        return "volver";
    }

    public void setContacto(ContactoVO contacto) {
        this.contacto = contacto;
    }

    public ContactoVO getContacto() {
        return contacto;
    }
}
