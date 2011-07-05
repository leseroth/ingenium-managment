/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.connection;

import com.ingenium.ash.transportdata.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 * Clase en cargada de ejecutar consultas de los diferentes reportes de la aplicacion
 * @author Sandra Milena Gómez Ríos
 */
public class ManagerConnection {

    /* Conexion con la base de datos */
    private Connection connection;
    
    /**
     * Constructor de la clase, obtiene la conexion con la base de datos
     */
    public ManagerConnection() {
        connection = ConnectionFactory.getConnection();
    }    
    
    /**
     * Consulta todos los eventos generados
     * @return List, lista de eventos
     */
    public List<Event> eventsGeneratedConsult(int page) {

        String procedure = "{call PROGETREPORTBYHOME(?,?)}";
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        List<Event> result = new ArrayList<Event>();

        try {
            callableStatement = getConnection().prepareCall(procedure);

            // Registramos los parametro de salida OUT
            callableStatement.setInt(1, page);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
            
            // Ejecutamos el procedimiento
            callableStatement.execute();

            // Obtenemos los parametros de salida OUT
            resultSet = (ResultSet) callableStatement.getObject(2);
            
            while (resultSet.next()) {
                Event event = new Event();
                event.setEventDate(resultSet.getString(1));
                event.setEventName(resultSet.getString(2));
                event.setHomeOffice(resultSet.getString(3));
                result.add(event);
            }
            
        } catch (Exception e) {
            System.err.println("Error al generar la consulta del reporte de evento generados: "+" : "+e);
        } 
        return result;
    }
    
    /**
     * Consulta todos los eventos generados
     * @return List, lista de eventos
     */
    public List<Event> homeOfficeConsult() {

        String procedure = "{call PROGETREPORTBYHOME(?)}";
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        List<Event> result = new ArrayList<Event>();

        try {
            callableStatement = getConnection().prepareCall(procedure);

            // Registramos los parametro de salida OUT
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            
            // Ejecutamos el procedimiento
            callableStatement.execute();

            // Obtenemos los parametros de salida OUT
            resultSet = (ResultSet) callableStatement.getObject(1);
            
            while (resultSet.next()) {
                Event event = new Event();
                event.setEventDate(resultSet.getString(1));
                event.setEventName(resultSet.getString(2));
                event.setHomeOffice(resultSet.getString(3));
                result.add(event);
            }
            
        } catch (Exception e) {
            System.err.println("Error al generar la consulta del reporte de evento generados: "+" : "+e);
        } 
        return result;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
