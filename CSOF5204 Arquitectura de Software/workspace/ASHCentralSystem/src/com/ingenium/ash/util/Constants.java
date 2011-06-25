/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.util;

/**
 *
 * @author admin
 */
public class Constants {

    /**Respresenta el valor del sensor cuando se encuentra una señal de humo**/
    public static final byte SMOKESTATUS =   Byte.parseByte("00000001", 2);
    /**Respresenta el valor contra el cual comparar si no existe regla asociada**/
    public static final byte DEFAULTSTATUS = Byte.parseByte("01111111", 2);
    /**Estados de apertura de puertas y ventanas**/
    public static final byte OPENSTATUS =   Byte.parseByte("00000001", 2);
    public static final byte CLOSEDSTATUS = Byte.parseByte("00000000", 2);
    /**Posibles Item Types**/
    public static byte RFIDTYPE =   Byte.parseByte("00000001", 2);
    public static byte SMOKETYPE =  Byte.parseByte("00000010", 2);
    public static byte SENSORTYPE = Byte.parseByte("00000011", 2);
    /**Manejo de alertas**/
    public static final byte OK =    Byte.parseByte("00000001", 2);
    public static final byte ALERT = Byte.parseByte("00000000", 2);
    /** Notificador     */
    public static final String MAIL_HOST = "smtp.gmail.com";
    public static final String MAIL_USER = "ingenium.uniandes@gmail.com";
    public static final String MAIL_PASSWORD = "ingenium2011";
    public static final String TEMPLATE_FILE = "htmlTemplate.html";
    
}
