package com.ingenium.ash.communication;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik Arcos
 */
public class ConnectorProcessor {

    private List<SocketProcessor> connectedSockets;

    public ConnectorProcessor() {
        connectedSockets = new ArrayList<SocketProcessor>();
    }

    protected void addConnection(Socket socket) {
        SocketProcessor sp = new SocketProcessor(socket);
        connectedSockets.add(sp);
        new Thread(sp).start();
    }

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
