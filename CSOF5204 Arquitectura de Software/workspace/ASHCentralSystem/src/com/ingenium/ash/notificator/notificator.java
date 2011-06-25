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
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Mauricio
 */
public class notificator {

    private static String MAIL_HOST = "smtp.gmail.com";
    private static String MAIL_USER = "mauricio.erazo@gmail.com";
    private static String MAIL_PASSWORD = "";
    private static String TEMPLATE_FILE = "htmlTemplate.html";

    /**
     * Notifica al cliente sobre la alarma que se ha presentado
     * @param idClient Id del cliente
     * @param idEvent Id del evento
     */
    public static void notificateClient(int idClient, int idEvent) {
        try {
            // info cliente
            String customerMail = "";
            String clientName = "";
            String tipoEvento = "";
            String mailBody = readTemplate();
            mailBody = processTemplate(mailBody, clientName, tipoEvento);
            String subject = "Informacion de su sistema";
            sendWarning(idEvent);
            sendMail(customerMail, subject, mailBody);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Envia el correo de notificacion al usuario 
     * @param toAddress Email del destinatario
     * @param subject Asunto del mail
     * @param body CUerpo del mensaje
     */
    private static void sendMail(String toAddress, String subject, String body) {
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true"); // added this line
            props.put("mail.smtp.host", MAIL_HOST);
            props.put("mail.smtp.user", MAIL_USER);
            props.put("mail.smtp.password", MAIL_PASSWORD);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MAIL_USER));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            message.setSubject("sending in a group");
            message.setText("Welcome to JavaMail");
            Transport transport = session.getTransport("smtp");
            transport.connect(MAIL_HOST, MAIL_USER, MAIL_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Envia la notificacion a las autoridades correspondientes
     * @param eventType Tipo de evento
     */
    private static void sendWarning(int eventType) {
        switch (eventType) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }
    }

    /**
     * Procesa la plantilla para incluir la infromacion del cliente
     * @param template Plantilla de envio 
     * @param clientName Nombre del cliente
     * @param eventType Tipo de evento
     * @return Plantilla procesada
     */
    private static String processTemplate(String template, String clientName, String eventType) {

        template.replace("[[SUSCRIPTOR]]", clientName);
        template.replace("[[TIPO]]", eventType);
        template.replace("[[FECHA]]", new Date().toString());
        return template;
    }

    /**
     * Lee el archivo HTML que sirve como plantilla para el envio del correo de notificacion
     * @return String con la plantilla
     * @throws IOException 
     */
    private static String readTemplate() throws IOException {

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(new File(TEMPLATE_FILE));
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }

    }
}
