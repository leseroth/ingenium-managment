/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.ldap.ws;

import co.com.losalpes.marketplace.ldap.beans.AutenticacionUsuariosLocal;
import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import co.com.losalpes.marketplace.ldap.exceptions.EstadoNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.RolNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.UsuarioNoExisteException;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author Asistente
 */
@WebService()
@Stateless()
public class LDAPAuthenticationManagement {
    @EJB
    private AutenticacionUsuariosLocal ejbRef;

    @WebMethod(operationName = "autenticar")
    public UsuarioBO autenticar(@WebParam(name = "login") String login,
    @WebParam(name = "password") String password) throws UsuarioNoExisteException {
        return ejbRef.autenticar(login, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearUsuario")
    public UsuarioBO crearUsuario(@WebParam(name = "nit")
    String nit, @WebParam(name = "rol")
    String rol, @WebParam(name = "nombre")
    String nombre, @WebParam(name = "email")
    String email) throws RolNoExisteException {
        return ejbRef.crearUsuario(nit, nombre, rol, email);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarEstadoUsuario")
    public Boolean actualizarEstadoUsuario(@WebParam(name = "login")
    String login, @WebParam(name = "estado") String estado)
    throws UsuarioNoExisteException, EstadoNoExisteException {
        return ejbRef.actualizarEstado(login, estado);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerNitUsuario")
    public String obtenerNitUsuario(@WebParam(name = "login")
    String login) throws UsuarioNoExisteException {
        return ejbRef.obtenerNitUsuario(login);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarClave")
    public Boolean cambiarClave(@WebParam(name = "login")
    String login,@WebParam(name = "nuevaClave")
    String nuevaClave) throws UsuarioNoExisteException {
        return ejbRef.cambiarClave(login, nuevaClave);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperarClave")
    public Boolean recuperarClave(@WebParam(name = "login")
    String login, @WebParam(name = "email")
    String email) throws UsuarioNoExisteException {
        return ejbRef.recuperarClave(login, email);
    }

}
