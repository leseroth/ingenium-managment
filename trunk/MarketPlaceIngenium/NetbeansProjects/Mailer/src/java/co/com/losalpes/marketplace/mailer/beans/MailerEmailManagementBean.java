/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.beans;

import co.com.losalpes.marketplace.mailer.bos.AttachmentBO;
import co.com.losalpes.marketplace.mailer.bos.EmailBO;
import co.com.losalpes.marketplace.mailer.exceptions.CorreosInvalidosException;
import co.com.losalpes.marketplace.mailer.exceptions.CorruptedAttachmentException;
import co.com.losalpes.marketplace.mailer.exceptions.InternalMailServerException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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

/**
 *
 * @author marketplace
 */
@Stateless
public class MailerEmailManagementBean implements MailerEmailManagementRemote, MailerEmailManagementLocal {
    
    public Boolean sendMail(List<String>to, List<String>cc, List<String>bcc, String subject, String message, String remitente, String password, Collection<String> attachments)throws CorreosInvalidosException, InternalMailServerException, CorruptedAttachmentException
    {
        Boolean respuesta = true;

        List<String> bienFormados = new ArrayList<String>();
        List<String> bienFormadosCC = new ArrayList<String>();
        List<String> bienFormadosBCC = new ArrayList<String>();
        List<String> malFormados= new ArrayList<String>();

        if(to!=null && !to.isEmpty()){
            Object[] verificacion = (Object[])this.verificarFormatoCorreos(to);
            bienFormados = (List<String>)verificacion[0];
            malFormados = (List<String>)verificacion[1];
        }

        if(cc!=null && !cc.isEmpty()){
            Object[] verificacionCC = (Object[])this.verificarFormatoCorreos(cc);
            bienFormadosCC = (List<String>)verificacionCC[0];
            malFormados.addAll((List<String>)verificacionCC[1]);
        }

        if(bcc!=null && !bcc.isEmpty()){
            Object[] verificacionBCC = (Object[])this.verificarFormatoCorreos(bcc);
            bienFormadosBCC = (List<String>)verificacionBCC[0];
            malFormados.addAll((List<String>)verificacionBCC[1]);
        }

        if(bienFormados.size() > 0 || bienFormadosBCC.size() > 0 || bienFormadosCC.size() > 0){
            EmailBO correoElectronico = new EmailBO();
            correoElectronico.setSubject(subject);
            correoElectronico.setBcc(bienFormadosBCC);
            correoElectronico.setCc(bienFormadosCC);
            correoElectronico.setTo(bienFormados);
            correoElectronico.setMessage(message);
            correoElectronico.setFrom(remitente);
            correoElectronico.setPassword(password);
            if(attachments != null && attachments.size()>0){
                List<AttachmentBO> adjuntos = new ArrayList<AttachmentBO>();
                for(String url : attachments){
                    if(!url.equals("")){
                        AttachmentBO arch = new AttachmentBO(url);
                        adjuntos.add(arch);
                    }
                }
                if(adjuntos.size() > 0)
                    correoElectronico.setAttachments(adjuntos);
            }
            enviarCorreo(correoElectronico);
        }

       if(malFormados.size()>0){
            String mensaje = "Aunque se han enviado los correos sin problemas, los siguientes correos destino estan mal formados y no han podido ser enviados: ";
            for(String correoMalFormado : malFormados){
                mensaje += "\n"+correoMalFormado;
            }
            throw new CorreosInvalidosException(mensaje);
        }
        else{
            return respuesta;
        }
    }

    private Object verificarFormatoCorreos(Collection<String> correos){
        ArrayList<String> bienFormados = new ArrayList<String>();
        ArrayList<String> malFormados = new ArrayList<String>();
        for(String correo: correos){
            if(correo.equals(""))
                continue;
            if(correo.length()>320){
                malFormados.add(correo);
                continue;
            }
            if(!correo.contains("@")){
                malFormados.add(correo);
                continue;
            }
            String[] splitUno = correo.split("@");
            String dominio = splitUno[1];
            if(!dominio.contains(".")){
                malFormados.add(correo);
                continue;
            }
            else{
                bienFormados.add(correo);
            }
        }
        Object[] rta = {bienFormados, malFormados};
        return rta;
    }

    private void enviarCorreo(EmailBO correoElectronico) throws InternalMailServerException {
        try
        {
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

            List<String> bienFormados = correoElectronico.getTo();
            for(String email : bienFormados){
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }

            List<String> bienFormadosCC = correoElectronico.getCc();
            for(String email : bienFormadosCC){
                mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
            }

            List<String> bienFormadosBCC = correoElectronico.getBcc();
            for(String email : bienFormadosBCC){
                mimeMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(email));
            }

            List<AttachmentBO> archivosAdjuntos = correoElectronico.getAttachments();
            if(archivosAdjuntos != null && archivosAdjuntos.size()>0){
                for(AttachmentBO archivo : archivosAdjuntos){
                    String ruta = archivo.getUrl();
                    File f = new File(ruta);
                    // Attach the specified file.
                    // We need a multipart message to hold the attachment.
                    try{
                        MimeBodyPart mbp1 = new MimeBodyPart();
                        mbp1.setContent(correoElectronico.getMessage(), "text/html");
                        MimeBodyPart mbp2 = new MimeBodyPart();
                        mbp2.attachFile(f);
                        MimeMultipart mp = new MimeMultipart();
                        mp.addBodyPart(mbp1);
                        mp.addBodyPart(mbp2);
                        mimeMessage.setContent(mp);
                    }
                    catch(Exception e){
                        throw new CorruptedAttachmentException(e.getMessage());
                    }
                }
            }

            mimeMessage.setHeader("X-Mailer", "MarketPlace de los Alpes");
            mimeMessage.setSentDate(new Date());
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(correoElectronico.getFrom(), correoElectronico.getPassword());
            t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new InternalMailServerException(e.getMessage());
        }
    }
}
