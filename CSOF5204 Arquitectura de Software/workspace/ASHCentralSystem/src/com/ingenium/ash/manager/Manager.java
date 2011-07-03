package com.ingenium.ash.manager;

import com.ingenium.ash.cache.CacheContactInfo;
import com.ingenium.ash.cache.CacheRules;
import com.ingenium.ash.notificator.NotificatorManager;
import com.ingenium.ash.util.Constants;
import com.ingenium.ash.util.Util;
import com.ingenium.ash.valueobjects.ContactInfo;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author Erik Arcos
 */
public class Manager {

    public void processEvent(byte[] event) {
        /*Selecciona del arreglo el byte del tipo de item*/

        byte itemType = event[0];

        if (itemType == Constants.SMOKETYPE) {
            /*Selecciona del arreglo el byte relacionado al status*/
            if (smokeProcess(event[5])) {
                /*Evento de fuego*/
                byte[] codebytes = new byte[]{event[1],event[2],event[3],event[4]};//Arrays.copyOfRange(event, 1, 5);
                int code = Util.convertArraytoInt(codebytes);
                ContactInfo contactInfo = CacheContactInfo.getInfoContact(String.valueOf(code));
                NotificatorManager.notificateClient(contactInfo.email, contactInfo.name, Constants.SMOKE);
            }

        } else if (itemType == Constants.SENSORTYPE) {
            /*Procesar evento*/
            byte[] codebytes = new byte[]{event[1],event[2],event[3],event[4]};//Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            if (sensorProcess(event[5], code)) {
                /*Evento de apertura de puerta o ventana*/
                ContactInfo contactInfo = CacheContactInfo.getInfoContact(String.valueOf(code));
                System.out.println(System.currentTimeMillis());
                NotificatorManager.notificateClient(contactInfo.email, contactInfo.name, Constants.SENSOR);
            }
        } else if (itemType == Constants.RFIDTYPE) {
            /*Procesar evento*/
            byte[] codebytes = Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            if (sensorProcess(event[5], code)) {
                /*RFID en lugar no autorizado*/
                ContactInfo contactInfo = CacheContactInfo.getInfoContact(String.valueOf(code));
                NotificatorManager.notificateClient(contactInfo.email, contactInfo.name, Constants.RFID);
            }
        } else {
            /*No contiene un tipo de item definido*/
        }
    }

    public boolean evaluate(byte[] event) {
        /*Selecciona del arreglo el byte del tipo de item*/

        byte itemType = event[0];

        if (itemType == Constants.SMOKETYPE) {
            /*Selecciona del arreglo el byte relacionado al status*/
            return smokeProcess(event[5]);

        } else if (itemType == Constants.SENSORTYPE) {
            /*Procesar evento*/
            byte[] codebytes = Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            return sensorProcess(event[5], code);
        } else if (itemType == Constants.RFIDTYPE) {
            /*Procesar evento*/
            //System.out.println("RFID");
            byte[] codebytes = Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            return sensorProcess(event[5], code);
        } else {
            /*No contiene un tipo de item definido*/
            return false;
        }
    }

    /**
     *
     * @param array
     * @return
     */
    public static boolean smokeProcess(byte status) {
        if (Constants.SMOKESTATUS == status) {
            return true;
        }

        return false;
    }

    public static boolean sensorProcess(byte status, int code) {
        Calendar c = Calendar.getInstance();
        byte result, rulebyte;
        String rule = String.valueOf(code) + "-" + String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        //System.out.println("key"+rule);
        rulebyte = CacheRules.getStatus(rule);
        //System.out.println("Regla"+rulebyte);
        result = (byte) (rulebyte & status);
        //System.out.println("Result"+result);
        if (result == Constants.ALERT) {
            return true;
        }
        return false;
    }

    public static boolean RFIDProcess(byte status, int code) {
        Calendar c = Calendar.getInstance();
        byte result, rulebyte;
        String rule = String.valueOf(code) + "-" + String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        //System.out.println("key"+rule);
        rulebyte = CacheRules.getStatus(rule);
        //System.out.println("Regla"+rulebyte);
        result = (byte) (rulebyte & status);
        //System.out.println("Result"+result);
        if (result == Constants.ALERT) {
            return true;
        }
        return false;
    }
}
