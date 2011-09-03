/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public UsuarioBO autenticar(String login, String password) throws UsuarioNoExisteException;
    public UsuarioBO crearUsuario(String nit, String nombre, String rol, String email) throws RolNoExisteException;
    public Boolean actualizarEstado(String login, String estado) throws UsuarioNoExisteException, EstadoNoExisteException;
    public String obtenerNitUsuario(String login) throws UsuarioNoExisteException;
    public Boolean cambiarClave(String login, String nuevaClave) throws UsuarioNoExisteException;
    public Boolean recuperarClave(String login, String email) throws UsuarioNoExisteException;
}
