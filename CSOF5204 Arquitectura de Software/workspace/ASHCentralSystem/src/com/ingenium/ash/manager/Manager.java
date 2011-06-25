/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.manager;

import com.ingenium.ash.communication.ManagerInterface;
import com.ingenium.ash.util.Constants;
import com.ingenium.ash.util.Util;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Manager implements ManagerInterface {

    @Override
    public void processEvent(byte[] event) {

        /*Selecciona del arreglo el byte del tipo de item*/

        byte itemType = event[0];

        if (itemType == Constants.SMOKETYPE) {
            /*Selecciona del arreglo el byte relacionado al status*/
            smokeProcess(event[5]);

        } else if (itemType == Constants.SENSORTYPE) {
            /*Procesar evento*/
            byte[] codebytes = Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            sensorProcess(event[5], code);
        } else if (itemType == Constants.RFIDTYPE) {
            /*Procesar evento*/
            byte[] codebytes = Arrays.copyOfRange(event, 1, 5);
            int code = Util.convertArraytoInt(codebytes);
            sensorProcess(event[5], code);
        } else {
            /*No contiene un tipo de item definido*/
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
        byte result = (byte) (Constants.DEFAULTSTATUS & status);
        if (result == Constants.ALERT) {
            return true;
        }
        return false;
    }

    public static boolean RFIDProcess(byte status, int code) {
        byte result = (byte) (Constants.DEFAULTSTATUS & status);
        if (result == Constants.ALERT) {
            return true;
        }
        return false;
    }
}
