package com.ingenium.ash.report;

import com.ingenium.ash.connection.ManagerConnection;
import com.ingenium.ash.transportdata.Event;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de manejar la lógica de la página que permite consultar la 
 * informacion consoolidad mostrando todos los eventos registrados.
 * 
 * @author Sandra Milena Gómez Ríos
 */

public class ReportConsolidatedInformationBean {
    
    /* Lista con los eventos */
    private List<Event> listEvents;
    /* Administrador de consultar */
    private ManagerConnection managerConnection;
    
    /**
     * Constructor de la clase 
     */
    public ReportConsolidatedInformationBean(){
        listEvents = new ArrayList<Event>();
        managerConnection = new ManagerConnection();
    }
    
    /**
     * Consulta los todos los eventos registrados para la casa u oficina seleccionada.
     */    
    public void informationConsult(){
        try{
           listEvents = new ArrayList<Event>();           
           listEvents = managerConnection.eventsGeneratedConsult();
        } catch(Exception ex){
           System.err.println("Se presentó un error al cargar la lista de casas y oficinas: "+ex);
        }
    }
    
     /**
     * Permite obtener la lista de eventos
     * @return List, lista con los eventos.
     */
    public List<Event> getListEvents() {
        return listEvents;
    }
    
}
