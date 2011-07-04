package com.ingenium.ash.communication;

import com.ingenium.ash.manager.Manager;
import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.ingenium.ash.util.Constants.*;

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
            reciever = new Socket(LB_LOCATION, LB_CENTRAL_SYSTEM_SOCKET_PORT);
            sender = new Socket(LB_LOCATION, LB_CENTRAL_SYSTEM_SOCKET_PORT);

            OutputStream os = sender.getOutputStream();
            senderOutputStream = new DataOutputStream(os);
            System.out.println("Se ha registrado un sistema central con el balaneceador de carga");
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
            }
        }

        try {
            recieverInputStream.close();
            senderOutputStream.close();

            reciever.close();
            sender.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processMessage(short homeId, int messageId, byte[] payload) {
        //System.out.println();
        if (SHOW_LOAD_BALANCER) {
            System.out.println("home: " + homeId + " message:" + messageId);
        }
        int totalEvent = (payload.length - 2) / ITEM_SIZE;
        for (int i = 0; i < totalEvent; i++) {
            byte[] itemStatus = Arrays.copyOfRange(payload, i * ITEM_SIZE, (i + 1) * ITEM_SIZE);
            //System.out.print(" " + itemStatus[0] + itemStatus[1] + itemStatus[2] + itemStatus[3] + itemStatus[4] + itemStatus[5]);
            manager.processEvent(itemStatus);
        }
        informLoadBalancer(homeId, messageId);
    }

    private void informLoadBalancer(short homeId, int messageId) {
        try {
            senderOutputStream.writeShort(homeId);
            senderOutputStream.writeInt(messageId);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}