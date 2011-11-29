package co.com.losalpes.marketplace.ldap.exceptions;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;

@WebFault
@ApplicationException(rollback = true)
public class RolNoExisteException extends Exception {

    public RolNoExisteException(String msg) {
        super(msg);
    }
}
