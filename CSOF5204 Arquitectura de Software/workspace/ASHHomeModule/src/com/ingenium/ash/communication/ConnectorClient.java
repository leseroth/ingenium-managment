package com.ingenium.ash.communication;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.ingenium.ash.util.Constants.*;

public class ConnectorClient {

    private Socket socket;
    private DataOutputStream dataOutputStream;

    public ConnectorClient() {
        try {
            socket = new Socket(LB_LOCATION, LB_HOME_SYSTEM_SOCKET_PORT);
            OutputStream os = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(os);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(byte[] message) {
        try {
            dataOutputStream.write(message);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void killSocket() {
        try {
            dataOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
