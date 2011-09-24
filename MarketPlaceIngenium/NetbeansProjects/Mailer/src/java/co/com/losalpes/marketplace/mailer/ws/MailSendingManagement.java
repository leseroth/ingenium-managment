package co.com.losalpes.marketplace.mailer.ws;

import co.com.losalpes.marketplace.mailer.beans.MailerEmailManagementLocal;
import co.com.losalpes.marketplace.mailer.exceptions.BussinessException;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author marketplace
 */
@WebService()
@Stateless()
public class MailSendingManagement {

    @EJB
    private MailerEmailManagementLocal ejbRef;

    /**
     * Envia un correo electronico a las cuentas indicadas
     * @param to Para
     * @param cc Con copia
     * @param bcc Con copia oculta
     * @param subject Asunto
     * @param message Mensaje
     * @param from Cuenta de envio
     * @param password Password de la cuenta
     * @param attachments Ruta de los archivos adjuntos
     * @return null si todos los correos se envian, un String si habia correos erroneos
     * @throws BussinessException
     */
    @WebMethod(operationName = "sendMail")
    public String sendMail(
            @WebParam(name = "to") List<String> to,
            @WebParam(name = "cc") List<String> cc,
            @WebParam(name = "bcc") List<String> bcc,
            @WebParam(name = "subject") String subject,
            @WebParam(name = "message") String message,
            @WebParam(name = "from") String from,
            @WebParam(name = "password") String password,
            @WebParam(name = "attachments") List<String> attachments)
            throws BussinessException {
        return ejbRef.sendMail(to, cc, bcc, subject, message, from, password, attachments);
    }
}
