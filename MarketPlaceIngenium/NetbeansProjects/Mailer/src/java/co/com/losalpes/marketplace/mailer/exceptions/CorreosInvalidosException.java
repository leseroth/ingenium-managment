/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.exceptions;

/**
 *
 * @author John Casallas
 */
public class CorreosInvalidosException extends Exception {

    /**
     * Creates a new instance of <code>CorreosInvalidosException</code> without detail message.
     */
    public CorreosInvalidosException() {
    }


    /**
     * Constructs an instance of <code>CorreosInvalidosException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CorreosInvalidosException(String msg) {
        super(msg);
    }
}
