/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorProcessor;
import com.ingenium.ash.communication.ConnectorServer;

/**
 *
 * @author Erik Arcos
 */
public class SystemStart {

    private ConnectorServer connServer;
    private ConnectorProcessor connProcessor;
    private static int SERVER_PORT = 4444;

    public static void main(String... args) {
        SystemStart systemStart = new SystemStart();
        systemStart.startSystem();  
    }
    
    private void startSystem(){
        connProcessor = new ConnectorProcessor();
        connServer = new ConnectorServer(connProcessor);
        connServer.startServer(SERVER_PORT);
    }
}