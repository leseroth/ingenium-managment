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

@WebService()
@Stateless()
public class LDAPAuthenticationManagement {

    @EJB
    private AutenticacionUsuariosLocal ejbRef;

    /**
     * Crea un usuario en Ldap.
     * <ul>
     * <li>El nit es obligatorio</li>
     * <li>El rol es obligatorio y debe ser un rol valido</li>
     * <li>El email es obligatorio</li>
     * <li>El login se autogenera con base al nit y el nombre</li>
     * <li>El password se autogenera</li>
     * </ul>
     * @param nit
     * @param rol
     * @param nombre
     * @param email
     * @param direccion
     * @param telefono
     * @param codPostal
     * @param codPais
     * @return El usuario creado
     * @throws RolNoExisteException En caso de que el rol indicado no exista
     */
    @WebMethod(operationName = "crearUsuario")
    public UsuarioBO crearUsuario(
            @WebParam(name = "nit") String nit,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rol") String rol,
            @WebParam(name = "email") String email,
            @WebParam(name = "direccion") String direccion,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "codPostal") String codPostal,
            @WebParam(name = "codPais") String codPais)
            throws RolNoExisteException {
        return ejbRef.crearUsuario(nit, nombre, rol, email, direccion, telefono, codPostal, codPais);
    }

    /**
     * Actualiza un usuario en el sistema.
     * <ul>
     * <li>La identificacion se hace por medio del nit y el rol</li>
     * <li>El rol debe exisistir</li>
     * <li>El usuario debe existir</li>
     * <li>Solo es posible actualizar el nombre, email, direccion, telefono, codPostal, codPais</li>
     * </ul>
     * @param nit
     * @param nombre
     * @param rol
     * @param email
     * @param direccion
     * @param telefono
     * @param codPostal
     * @param codPais
     * @return
     * @throws RolNoExisteException En caso de que el rol especificado no exista
     * @throws UsuarioNoExisteException En caso de que la pareja nit/rol no exista
     */
    @WebMethod(operationName = "actualizarUsuario")
    public UsuarioBO actualizarUsuario(
            @WebParam(name = "nit") String nit,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rol") String rol,
            @WebParam(name = "email") String email,
            @WebParam(name = "direccion") String direccion,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "codPostal") String codPostal,
            @WebParam(name = "codPais") String codPais)
            throws RolNoExisteException, UsuarioNoExisteException {
        return ejbRef.actualizarUsuario(nit, nombre, rol, email, direccion, telefono, codPostal, codPais);
    }

    @WebMethod(operationName = "autenticar")
    public UsuarioBO autenticar(@WebParam(name = "login") String login,
            @WebParam(name = "password") String password) throws UsuarioNoExisteException {
        return ejbRef.autenticar(login, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarEstadoUsuario")
    public Boolean actualizarEstadoUsuario(@WebParam(name = "login") String login, @WebParam(name = "estado") String estado)
            throws UsuarioNoExisteException, EstadoNoExisteException {
        return ejbRef.actualizarEstado(login, estado);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerNitUsuario")
    public String obtenerNitUsuario(@WebParam(name = "login") String login) throws UsuarioNoExisteException {
        return ejbRef.obtenerNitUsuario(login);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarClave")
    public Boolean cambiarClave(@WebParam(name = "login") String login, @WebParam(name = "nuevaClave") String nuevaClave) throws UsuarioNoExisteException {
        return ejbRef.cambiarClave(login, nuevaClave);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperarClave")
    public Boolean recuperarClave(@WebParam(name = "login") String login, @WebParam(name = "email") String email) throws UsuarioNoExisteException {
        return ejbRef.recuperarClave(login, email);
    }
}
