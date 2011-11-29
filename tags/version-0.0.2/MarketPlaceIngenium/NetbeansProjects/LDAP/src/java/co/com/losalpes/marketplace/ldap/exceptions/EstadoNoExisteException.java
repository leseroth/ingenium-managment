package co.com.losalpes.marketplace.ldap.exceptions;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;

@WebFault
@ApplicationException(rollback = true)
public class EstadoNoExisteException extends Exception {

    public EstadoNoExisteException(String msg) {
        super(msg);
    }
}
