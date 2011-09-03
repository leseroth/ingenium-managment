/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.exceptions;

/**
 *
 * @author Adminsitrador
 */
public class CorruptedAttachmentException extends Exception {

    /**
     * Creates a new instance of <code>CorruptedAttachmentException</code> without detail message.
     */
    public CorruptedAttachmentException() {
        super("Hubo un problema adjuntando el (los) archivo(s) al correo. El mensaje no es ha enviado\n");
    }


    /**
     * Constructs an instance of <code>CorruptedAttachmentException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CorruptedAttachmentException(String msg) {
        super("Hubo un problema adjuntando el (los) archivo(s) al correo. El mensaje no es ha enviado\n"+msg);
    }
}
