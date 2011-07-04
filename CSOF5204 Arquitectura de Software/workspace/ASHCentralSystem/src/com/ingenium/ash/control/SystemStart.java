/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorServer;

/**
 *
 * @author Erik Arcos
 */
public class SystemStart {

    private ConnectorServer connServer;

    public static void main(String... args) {
        SystemStart systemStart = new SystemStart();
        systemStart.startSystem();
    }

    private void startSystem() {
        connServer = new ConnectorServer();
        connServer.startServer();
    }
}
