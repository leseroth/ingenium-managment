package com.ingenium.ash.communication;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik Arcos
 */
public class ConnectorProcessor {

    private List<Socket> connectedSockets;

    public ConnectorProcessor() {
        connectedSockets = new ArrayList<Socket>();
    }
    
    protected void addConnection(Socket socket){
        connectedSockets.add(socket);
    }
    
    /**
     * Returns a list of all the opened connections to this server
     * @return The list of all opened connections to this server
     */
    public List<Socket> getConnectedSockets() {
        return connectedSockets;
    }
}
