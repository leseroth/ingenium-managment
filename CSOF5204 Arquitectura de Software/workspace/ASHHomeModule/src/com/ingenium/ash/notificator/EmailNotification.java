/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.notificator;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import com.ingenium.ash.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author Mauricio
 */
public class EmailNotification {

    public static String NOTIFICATION_TEMPLATE;
    private static Session SESSION;
    private static Transport TRANSPORT;

    static {
        try {
            NOTIFICATION_TEMPLATE = readTemplate();

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true"); 
            props.put("mail.smtp.host", Constants.MAIL_HOST);
            props.put("mail.smtp.user", Constants.MAIL_USER);
            props.put("mail.smtp.password", Constants.MAIL_PASSWORD);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);

            Transport transport = session.getTransport("smtp");
            transport.connect(Constants.MAIL_HOST, Constants.MAIL_USER, Constants.MAIL_PASSWORD);

            SESSION = session;
            TRANSPORT = transport;
        } catch (MessagingException ex) {
            Logger.getLogger(EmailNotification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("No cargo el template");
        }
    }

    public static void notificateClient(String customerMail, String clientName) {
        
        final String mailBody = processTemplate("" + NOTIFICATION_TEMPLATE, clientName);
        final String subject = "Informacion de su sistema";

        sendMail(customerMail, subject, mailBody);
    }

    private static void sendMail(String toAddress, String subject, String body) {
        try {
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(body, "text/html")));
            Multipart multipart = new MimeMultipart("related");
            multipart.addBodyPart(bodyPart);

            MimeMessage message = new MimeMessage(SESSION);
            message.setFrom(new InternetAddress(Constants.MAIL_USER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            message.setSubject(subject);
            message.setContent(multipart);

            TRANSPORT.sendMessage(message, message.getAllRecipients());
        } catch (Exception ex) {
        }
    }

    private static String processTemplate(String template, String clientName) {

        template = template.replace("[[SUSCRIPTOR]]", clientName);
        template = template.replace("[[FECHA]]", new Date().toString());
        return template;
    }

    private static String readTemplate() throws IOException {

        FileInputStream stream = null;
        String template = "";
        try {
            File file = new File("src/com/ingenium/ash/notificator/" + Constants.TEMPLATE_FILE);
            if (file.exists()) {
                stream = new FileInputStream(file);
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                template = Charset.defaultCharset().decode(bb).toString();
            }
        } finally {
            stream.close();
        }
        return template;
    }
}
