
package com.ingenium.ash.connection;

import java.sql.*;
//import java.util.Properties;
import java.util.Locale;

/**
 * Clase encarga de realizar la conexion con la base de datos
 * @author Sandra Milena Gómez Ríos
 */
public class ConnectionFactory {
    
    private static Connection connection;
    
    /**
     * Se obtiene la conexion con la base de datos
     * @return Connection, informacion de la conexion
     */
    public static Connection getConnection() {
        
        if(connection == null){
            
            String driver="oracle.jdbc.driver.OracleDriver";
            String url="jdbc:oracle:thin:@192.168.0.12:1521:xe";
            String user="aranda";
            String password="abc123";

            try
            {
                Class.forName(driver).newInstance();

                Locale.setDefault(new Locale("es","ES"));
                DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver()); 

                connection = DriverManager.getConnection(url,user ,password);

            } catch (Exception exc) {
                System.err.println("Error al tratar de abrir la base de Datos"+" : "+exc);
            }
        }
        
        return connection;
    }
    
}
