/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.exceptions;

/**
 *
 * @author Adminsitrador
 */
public class InternalMailServerException extends Exception {

    /**
     * Creates a new instance of <code>InternalMailServerException</code> without detail message.
     */
    public InternalMailServerException() {
    }


    /**
     * Constructs an instance of <code>InternalMailServerException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InternalMailServerException(String msg) {
        super(msg);
    }
}
