package com.ingenium.ash.communication;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik Arcos
 */
public abstract class ConnectorProcessor {

    protected List<SocketProcessor> connectedSockets;

    public ConnectorProcessor() {
        connectedSockets = new ArrayList<SocketProcessor>();
    }

    abstract public void addConnection(Socket socket);

    /**
     * Returns a list of all the opened connections to this server
     * @return The list of all opened connections to this server
     */
    public List<SocketProcessor> getConnectedSockets() {
        return connectedSockets;
    }
    
    public void killAllConnections(){
        for(SocketProcessor sp: connectedSockets) {
            sp.closeSocket();
        }
    }
}
