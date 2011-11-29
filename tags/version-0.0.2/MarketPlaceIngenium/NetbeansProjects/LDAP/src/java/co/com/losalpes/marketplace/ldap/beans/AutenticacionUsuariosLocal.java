package co.com.losalpes.marketplace.ldap.beans;

import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import co.com.losalpes.marketplace.ldap.exceptions.EstadoNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.RolNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.UsuarioNoExisteException;
import javax.ejb.Local;

/**
 *
 * @author Asistente
 */
@Local
public interface AutenticacionUsuariosLocal {

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
    public UsuarioBO crearUsuario(
            String nit, String nombre, String rol, String email, String direccion, String telefono, String codPostal, String codPais)
            throws RolNoExisteException;

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
    public UsuarioBO actualizarUsuario(
            String nit, String nombre, String rol, String email, String direccion, String telefono, String codPostal, String codPais)
            throws RolNoExisteException, UsuarioNoExisteException;

    public UsuarioBO autenticar(String login, String password) throws UsuarioNoExisteException;

    public Boolean actualizarEstado(String login, String estado) throws UsuarioNoExisteException, EstadoNoExisteException;

    public String obtenerNitUsuario(String login) throws UsuarioNoExisteException;

    public Boolean cambiarClave(String login, String nuevaClave) throws UsuarioNoExisteException;

    public Boolean recuperarClave(String login, String email) throws UsuarioNoExisteException;
}
