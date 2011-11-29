
package com.ingenium.ash.transportdata;

import java.util.Date;

/**
 * Clase encargada de almacenar la informaion de un evento
 * @author Sandra Milena Gómez Ríos
 */
public class Event {
    
    /* Identificador de la casa u oficina que genera el evento */
    private String homeOffice;
    
    /* Identificador del evento */
    private String eventName;
    
    /* Fecha en que se ejecutó el evento */
    private String eventDate;
        

     /**
     * Permite obtener el identificador de la casa u oficina
     * @return Date, identificador de la casa u oficina
     */
    public String getHomeOffice() {
        return homeOffice;
    }
    
    /**
     * Permite obtener la fecha en que se ejecuto el evento
     * @return Date, fecha en que se ejecuto el evento
     */
    public String getEventDate() {
        return eventDate;
    }

     /**
     * Permite obtener el identificador del evento
     * @return Date, identificador del evento
     */
    public String getEventName() {
        return eventName;
    }

     /**
     * Permite configurar el identificador de la casa u oficina
     * @param String, identificador de la casa u oficina
     */
    public void setHomeOffice(String homeOffice) {
        this.homeOffice = homeOffice;
    }

     /**
     * Permite configurar la fecha en que se ejecuto el evento
     * @param Date, fecha en que se ejecuto el evento
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Permite configurar el identificador del evento
     * @return Date, identificador del evento
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }    
    
}
