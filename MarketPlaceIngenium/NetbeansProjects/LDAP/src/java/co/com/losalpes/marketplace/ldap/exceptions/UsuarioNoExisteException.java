/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.ldap.exceptions;

/**
 *
 * @author Asistente
 */
public class UsuarioNoExisteException extends Exception {
    public UsuarioNoExisteException(String msg) {
        super(msg);
    }
}