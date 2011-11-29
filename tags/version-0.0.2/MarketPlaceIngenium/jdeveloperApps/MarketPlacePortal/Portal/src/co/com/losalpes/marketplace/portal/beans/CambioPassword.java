package co.com.losalpes.marketplace.portal.beans;

import co.com.losalpes.marketplace.ldap.LDAPAuthenticationManagementPortClient;

import co.com.losalpes.marketplace.ldap.UsuarioNoExisteException;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;

public class CambioPassword {
    private String password;
    private String confPassword;
    private boolean pass1=false;
    public CambioPassword() {
    }

    public String cambiar_action() {
        boolean cambiada=false;
                FacesContext fc=FacesContext.getCurrentInstance();
                String usuario=ADFContext.getCurrent().getSecurityContext().getUserName();
                System.out.println("Cambiar contrase?a del usuario "+usuario);
              LDAPAuthenticationManagementPortClient port = new LDAPAuthenticationManagementPortClient();
                try {
                    port.getLdap().cambiarClave(usuario, this.getPassword());
                    cambiada=true;
                    fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                         "Contrase?a Cambiada",
                                                         "La contrase?a para el usuario "+
                                                         usuario+" ha sido cambiada exitosamente!"));
                } catch (UsuarioNoExisteException e) {
                    fc.addMessage(null,new FacesMessage (FacesMessage.SEVERITY_ERROR, 
                                                         "Error al cambiar la contrase?a",
                                                         "No se puede cambiar la contrase?a, el usuario no existe en el autenticador"));
                }
                if(cambiada)
                  return "login_success";
                return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getConfPassword() {
        return confPassword;
    }
    public void inputText_validator(FacesContext facesContext,
                                        UIComponent uIComponent, Object object) {
            if(this.pass1){
              if(!this.getPassword().equals(object)){
                  ((EditableValueHolder)uIComponent).setValid(false);
                  facesContext.addMessage(uIComponent.getClientId(facesContext), new FacesMessage("La contrase?a y su confirmacion no coinciden"));
              }else{
                  if(this.getPassword().length()<6){
                      ((EditableValueHolder)uIComponent).setValid(false);
                      facesContext.addMessage (uIComponent.getClientId(facesContext), new FacesMessage("La contrase?a debe tener al menos 6 caracteres "+this.password));
                      } 
              }
            }else{
                this.pass1=true;
                this.password = (String)object;
            }
        }
}
