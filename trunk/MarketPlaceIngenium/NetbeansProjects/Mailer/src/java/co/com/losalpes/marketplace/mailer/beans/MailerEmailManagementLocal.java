package co.com.losalpes.marketplace.mailer.beans;

import co.com.losalpes.marketplace.mailer.exceptions.BussinessException;
import java.util.List;
import javax.ejb.Local;

/**
 * Permite enviar correos electronicos
 * @author marketplace
 */
@Local
public interface MailerEmailManagementLocal {

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
    public String sendMail(
            List<String> to, List<String> cc, List<String> bcc,
            String subject, String message,
            String remitente, String password, List<String> attachments)
            throws BussinessException;
}
