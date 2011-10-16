package co.com.losalpes.marketplace.transact.exceptions;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;
import static co.com.losalpes.marketplace.transact.util.Util.*;

/**
 * Excepcion generica para manejar los mensajes de error
 * @author Erik
 */
@WebFault
@ApplicationException(rollback = true)
public class BussinessException extends Exception {

    /**
     * Constructor
     * @param msg Mensaje con wildcards ? para reempalzar
     * @param detail Valores que seran colocados en ?
     */
    public BussinessException(String msg, String... detail) {
        super(createMessage(msg, detail));
    }
}
