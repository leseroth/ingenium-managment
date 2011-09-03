/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.exceptions;

/**
 *
 * @author marketplace
 */
public class NitExisteException extends Exception {

    public NitExisteException() {
        super("El nit que se quiere registrar ya existe en el sistema.");
    }

}
