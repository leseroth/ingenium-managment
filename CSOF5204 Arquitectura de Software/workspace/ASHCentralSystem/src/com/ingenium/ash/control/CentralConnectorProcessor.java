/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorProcessor;
import com.ingenium.ash.communication.SocketProcessor;
import com.ingenium.ash.manager.Manager;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class CentralConnectorProcessor extends ConnectorProcessor {

    @Override
    public void addConnection(Socket socket) {
        SocketProcessor sp = new SocketProcessor(socket, new Manager());
        connectedSockets.add(sp);
        new Thread(sp).start();
    }
}
