package co.com.losalpes.marketplace.portal.beans;

import co.com.losalpes.marketplace.ldap.LDAPAuthenticationManagementPortClient;
import co.com.losalpes.marketplace.ldap.UsuarioNoExisteException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class RecuperaPassword {
    private String username;
    private String email;
    public RecuperaPassword() {
    }

    public String recuperar_action() {
        LDAPAuthenticationManagementPortClient port = new LDAPAuthenticationManagementPortClient();
                try {
                    port.getLdap().recuperarClave(username, email);
                } catch (UsuarioNoExisteException e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario no existe!"));
                }
                return "login_success";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
