package co.com.losalpes.marketplace.ldap.exceptions;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;

@WebFault
@ApplicationException(rollback = true)
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException(String msg) {
        super(msg);
    }
}
