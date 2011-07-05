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
    private int page;
    
    /**
     * Constructor de la clase 
     */
    public ReportConsolidatedInformationBean(){
        listEvents = new ArrayList<Event>();
        managerConnection = new ManagerConnection();
    }
    
    /*Inicializa la conexion*/
    public String setupInformationConsult(){
        listEvents = new ArrayList<Event>();           
        managerConnection.getConnection();
        page = 1;
        return "reporte";
    }


    /**
     * Consulta los todos los eventos registrados para la casa u oficina seleccionada.
     */    
    public void informationConsult(){

        try{           
           listEvents = managerConnection.eventsGeneratedConsult(getPage());
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

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
    
}
