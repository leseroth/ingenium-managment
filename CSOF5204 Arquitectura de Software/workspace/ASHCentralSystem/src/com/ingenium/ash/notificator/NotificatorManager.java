/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.notificator;

import com.ingenium.ash.communication.SocketProcessor;
import java.io.*;
import java.net.UnknownHostException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import com.ingenium.ash.util.*;
import java.net.Socket;
import java.nio.ByteBuffer;
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
public class NotificatorManager {

    private static String NOTIFICATION_TEMPLATE;
    private static Session SESSION;
    private static Transport TRANSPORT;
    private static Socket POLICE_SOCKET;
    private static Socket EMERGENCY_SOCKET;
    private static DataOutputStream POLICE_STREAM;
    private static DataOutputStream EMERGENCY_STREAM;
    private static int emergencyCounter = 0;
    private static int policeCounter = 0;

    static {
        try {
            NOTIFICATION_TEMPLATE = readTemplate();

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true"); // added this line
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
            Logger.getLogger(NotificatorManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("No cargo el template");
        }
    }

    static {
        try {
            POLICE_SOCKET = new Socket("localhost", 4450);
            EMERGENCY_SOCKET = new Socket("localhost", 4460);

            POLICE_STREAM = new DataOutputStream(POLICE_SOCKET.getOutputStream());
            EMERGENCY_STREAM = new DataOutputStream(EMERGENCY_SOCKET.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(NotificatorManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotificatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Notifica al cliente sobre la alarma que se ha presentado
     * @param idClient Id del cliente
     * @param idEvent Id del evento
     */
    public static void notificateClient(String customerMail, String clientName, final String tipoEvento, final long time) {

        final String finalClientName = clientName == null ? "Erik Arcos" : clientName;
        final String finalCustomerMail = customerMail == null ? "ercos41@gmail.com" : customerMail;
        final String mailBody = processTemplate("" + NOTIFICATION_TEMPLATE, finalClientName, tipoEvento);
        final String subject = "Informacion de su sistema";

//        new Thread() {
//
//            @Override
//            public void run() {

        if (tipoEvento.equals(Constants.SMOKE)) {
            sendMessage(EMERGENCY_STREAM, "Se ha detectado " + tipoEvento + " en la propiedad de " + finalClientName);
            emergencyCounter++;
        } else {
            sendMessage(POLICE_STREAM, "Se ha detectado " + tipoEvento + " en la propiedad de " + finalClientName);
            policeCounter++;
        }
        long postMessage = System.currentTimeMillis();

        //sendMail(finalCustomerMail, subject, mailBody);
        //long postMail = System.currentTimeMillis();

        SocketProcessor.timeTest.add(emergencyCounter + " " + policeCounter + " " + System.currentTimeMillis() + " " + time + " " + (System.currentTimeMillis() - time));

//            }
//        }.start();
    }

    private static void sendMessage(DataOutputStream dos, String message) {
        try {
            byte[] byteMessage = message.getBytes();
            ByteBuffer bb = ByteBuffer.allocate(4 + byteMessage.length);
            bb.putInt(byteMessage.length);
            bb.put(byteMessage);
            dos.write(bb.array());
        } catch (IOException ex) {
            Logger.getLogger(NotificatorManager.class.getName()).log(Level.SEVERE, null, ex);
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
            //transport.close();
        } catch (Exception ex) {
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

        template = template.replace("[[SUSCRIPTOR]]", clientName);
        template = template.replace("[[TIPO]]", eventType);
        template = template.replace("[[FECHA]]", new Date().toString());
        return template;
    }

    /**
     * Lee el archivo HTML que sirve como plantilla para el envio del correo de notificacion
     * @return String con la plantilla
     * @throws IOException 
     */
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
