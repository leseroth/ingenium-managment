package com.ingenium.ash.util;

/**
 *
 * @author Erik Arcos
 */
public class Constants {
    
    public static final boolean SHOW_LOAD_BALANCER = true;
    public static final boolean ENABLE_MAIL_NOTIFICATION = false;
    public static final boolean EMULATE_EXTERNAL_SYSTEM_NOTIFICATION = true;
    public static final boolean ENABLE_EXTERNAL_SYSTEM_NOTIFICATION = false;

    /**Respresenta el valor del sensor cuando se encuentra una señal de humo**/
    public static final byte SMOKESTATUS = Byte.parseByte("00000001", 2);
    /**Respresenta el valor contra el cual comparar si no existe regla asociada**/
    public static final byte DEFAULTSTATUS = Byte.parseByte("01111111", 2);
    /**Estados de apertura de puertas y ventanas**/
    public static final byte OPENSTATUS = Byte.parseByte("00000001", 2);
    public static final byte CLOSEDSTATUS = Byte.parseByte("00000000", 2);
    /**Posibles Item Types**/
    public static byte RFIDTYPE = Byte.parseByte("00000001", 2);
    public static byte SMOKETYPE = Byte.parseByte("00000010", 2);
    public static byte SENSORTYPE = Byte.parseByte("00000011", 2);
    /**Manejo de alertas**/
    public static final byte OK = Byte.parseByte("00000001", 2);
    public static final byte ALERT = Byte.parseByte("00000000", 2);
    /** Notificador     */
    public static final String MAIL_HOST = "smtp.gmail.com";
    public static final String MAIL_USER = "ingenium.uniandes@gmail.com";
    public static final String MAIL_PASSWORD = "ingenium2011";
    public static final String TEMPLATE_FILE = "htmlTemplate.html";
    /**Eventos**/
    public static final String SMOKE = "Ha ocurrido un incendio";
    public static final String SENSOR = "Se ha abierto una puerta o ventana en su hogar";
    public static final String RFID = "Movimiento no permitido";
    // Size en bytes de los tipos de datos numericos
    public static final int SIZE_BYTE = 1;
    public static final int SIZE_SHORT = 2;
    public static final int SIZE_INT = 4;
    // Posiciones descriptivas de cada servidor
    public static final int LB_CS_IDENTIFIER = 0;
    public static final int LB_CS_SOCKET_SENDER = 1;
    public static final int LB_CS_SOCKET_RECIEVER = 2;
    public static final int LB_CS_SENDER_STREAM = 3;
    public static final int LB_CS_RECIEVED_TIME = 4;
    public static final int LB_CS_TOTAL_INFO = 5;
    // Balanceador de carga
    public static final String LB_LOCATION = "localhost";
    public static final int LB_CENTRAL_SYSTEM_SOCKET_PORT = 4450;
    public static final int LB_HOME_SYSTEM_SOCKET_PORT = 4440;
    // Info de los item
    public static final int ITEM_SIZE = 6;
    // Home module tiempo de reporte en milisegundos
    public static final int HM_REPORT_TIME = 950;
    public static final byte HM_STATUS_NORMAL = 1;
    public static final byte HM_STATUS_NOTIFY = 2;
    public static final byte HM_STATUS_UNVERIFIED = 3;
    // Maximo cantidad de segundos que se espera que se conteste la llamada
    public static final int MAX_SKYPE_SECONDS_WAIT = 30;
}
