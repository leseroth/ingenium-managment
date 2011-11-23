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

    public UsuarioBO autenticar(String login, String password) throws UsuarioNoExisteException;

    public Boolean actualizarEstado(String login, String estado) throws UsuarioNoExisteException, EstadoNoExisteException;

    public String obtenerNitUsuario(String login) throws UsuarioNoExisteException;

    public Boolean cambiarClave(String login, String nuevaClave) throws UsuarioNoExisteException;

    public Boolean recuperarClave(String login, String email) throws UsuarioNoExisteException;
}
