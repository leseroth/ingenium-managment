package com.ingenium.ash.communication;

import com.ingenium.ash.control.SystemStart;
import com.ingenium.ash.manager.Manager;
import com.ingenium.ash.util.Util;
import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Erik Arcos
 */
public class ConnectorServer implements Runnable {

    private Manager manager;
    private Socket sender;
    private Socket reciever;
    private DataInputStream recieverInputStream;
    private DataOutputStream senderOutputStream;

    /**
     * Starts the server in the defined port
     * 
     * @param port Port number for the server
     * @return null if the start was successful, an error message otherwise. 
     */
    public void startServer() {
        manager = new Manager();
        
        try {
            reciever = new Socket(SystemStart.BALANCER_LOCATION, SystemStart.BALANCER_PORT);
            sender = new Socket(SystemStart.BALANCER_LOCATION, SystemStart.BALANCER_PORT);

            OutputStream os = sender.getOutputStream();
            senderOutputStream = new DataOutputStream(os);
            new Thread(this).start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reportMessageProcessed(int messageIdentifier) {
        try {
            ByteBuffer bb = ByteBuffer.allocate(2);
            bb.putInt(messageIdentifier);
            senderOutputStream.write(bb.array());
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Thread to accept the connections of clients
     */
    @Override
    public void run() {
        try {
            recieverInputStream = new DataInputStream(reciever.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean keepAlive = true;
        while (keepAlive) {
            try {
                short homeId = recieverInputStream.readShort();
                int messageId = recieverInputStream.readInt();
                int payloadSize = recieverInputStream.readInt();
                byte[] payload = new byte[payloadSize];
                recieverInputStream.read(payload);
                
                processMessage(homeId, messageId, payload);
            } catch (SocketException se) {
                //Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha cerrado el socket");
                keepAlive = false;
            } catch (EOFException eofe) {
                //Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha perdido la conexion");
                keepAlive = false;
            } catch (IOException ex) {
                Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
                keepAlive = false;
            } finally {
                try {
                    recieverInputStream.close();
                    senderOutputStream.close();
                    
                    reciever.close();
                    sender.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void processMessage(short homeId, int messageId, byte[] payload) {
        int totalEvent = (payload.length - 2) / 6;
        for (int i = 0; i < totalEvent; i++) {
            manager.processEvent(Arrays.copyOfRange(payload, i * 6 + 2, i * 6 + 8));
        }
        informLoadBalancer(homeId, messageId);
    }
    
    private void informLoadBalancer(short homeId, int messageId){
        try {
            senderOutputStream.writeShort(homeId);
            senderOutputStream.writeInt(messageId);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}