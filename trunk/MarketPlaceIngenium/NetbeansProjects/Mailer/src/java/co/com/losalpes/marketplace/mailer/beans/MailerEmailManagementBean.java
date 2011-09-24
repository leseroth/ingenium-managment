package co.com.losalpes.marketplace.mailer.beans;

import co.com.losalpes.marketplace.mailer.bos.EmailBO;
import co.com.losalpes.marketplace.mailer.exceptions.BussinessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static co.com.losalpes.marketplace.mailer.util.Constants.*;

/**
 * Implementa el envio de correo
 * @author marketplace
 */
@Stateless
public class MailerEmailManagementBean implements MailerEmailManagementRemote, MailerEmailManagementLocal {

    /**
     * {@inheritDoc}
     */
    @Override
    public String sendMail(
            List<String> to, List<String> cc, List<String> bcc, String subject, String message,
            String remitente, String password, List<String> attachments)
            throws BussinessException {
        String response = null;

        List<String> bienFormados = new ArrayList<String>();
        List<String> bienFormadosCC = new ArrayList<String>();
        List<String> bienFormadosBCC = new ArrayList<String>();
        List<String> malFormados = new ArrayList<String>();

        if (to != null && !to.isEmpty()) {
            verificarFormatoCorreos(to, bienFormados, malFormados);
        }

        if (cc != null && !cc.isEmpty()) {
            verificarFormatoCorreos(cc, bienFormadosCC, malFormados);
        }

        if (bcc != null && !bcc.isEmpty()) {
            verificarFormatoCorreos(bcc, bienFormadosBCC, malFormados);
        }

        if (!bienFormados.isEmpty() || !bienFormadosCC.isEmpty() || !bienFormadosBCC.isEmpty()) {
            EmailBO email = new EmailBO();
            email.setSubject(subject);
            email.setTo(bienFormados);
            email.setCc(bienFormadosCC);
            email.setBcc(bienFormadosBCC);
            email.setMessage(message);
            email.setFrom(remitente);
            email.setPassword(password);
            email.setAttachments(attachments);
            enviarCorreo(email);
        }

        if (malFormados.isEmpty()) {
            response = "Correos enviados";
        } else {
            response = "Los siguientes correos destino estan mal formados y no han podido ser enviados: ";
            for (String correoMalFormado : malFormados) {
                response += " " + correoMalFormado;
            }
        }

        return response;
    }

    /**
     * Verifica la estructura de los correos que cumplan la expresion regular [a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z\\.]+
     * @param emailList Lista de correos a verificar
     * @param bienFormados Lista que va a contener los correos validos
     * @param malFormados Lista que contiene los correos mal formados
     */
    private void verificarFormatoCorreos(List<String> emailList, List<String> bienFormados, List<String> malFormados) {

        emailVerifier:
        for (String mail : emailList) {
            if (mail == null || mail.isEmpty()) {
                continue emailVerifier;
            } else if (mail.matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z\\.]+")) {
                bienFormados.add(mail);
            } else {
                malFormados.add(mail);
            }
        }
    }

    /**
     * Envia el correo
     * @param correoElectronico Correo a enviar
     * @throws BussinessException Excepcion al adjuntar un correo o enviar el mensaje
     */
    private void enviarCorreo(EmailBO correoElectronico) throws BussinessException {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.user", correoElectronico.getFrom());
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(correoElectronico.getFrom()));
            mimeMessage.setSubject(correoElectronico.getSubject());
            mimeMessage.setContent(correoElectronico.getMessage(), "text/html");

            for (String to : correoElectronico.getTo()) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }

            for (String cc : correoElectronico.getCc()) {
                mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }

            for (String bcc : correoElectronico.getBcc()) {
                mimeMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }

            List<String> archivosAdjuntos = correoElectronico.getAttachments();
            if (archivosAdjuntos != null && archivosAdjuntos.size() > 0) {
                MimeBodyPart messageContent = new MimeBodyPart();
                messageContent.setContent(correoElectronico.getMessage(), "text/html");

                MimeMultipart mainMultipart = new MimeMultipart();
                mainMultipart.addBodyPart(messageContent);

                for (String archivo : archivosAdjuntos) {
                    File file = new File(archivo);
                    try {
                        MimeBodyPart atachment = new MimeBodyPart();
                        atachment.attachFile(file);
                        mainMultipart.addBodyPart(atachment);

                    } catch (Exception e) {
                        throw new BussinessException(EXC_ATTACHMENT, archivo);
                    }
                }

                mimeMessage.setContent(mainMultipart);
            }

            mimeMessage.setHeader("X-Mailer", "MarketPlace de los Alpes");
            mimeMessage.setSentDate(new Date());
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(correoElectronico.getFrom(), correoElectronico.getPassword());
            t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            t.close();
        } catch (BussinessException be) {
            throw be;
        } catch (Exception e) {
            throw new BussinessException(EXC_EMAIL_SEND, e.getMessage());
        }
    }
}
