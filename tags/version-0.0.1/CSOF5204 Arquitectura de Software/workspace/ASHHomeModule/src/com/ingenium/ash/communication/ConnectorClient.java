package com.ingenium.ash.communication;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.ingenium.ash.util.Constants.*;

public class ConnectorClient {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ConnectorClient() {
        try {
            socket = new Socket(LB_LOCATION, LB_HOME_SYSTEM_SOCKET_PORT);
            OutputStream os = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(os);
            InputStream is = socket.getInputStream();
            dataInputStream = new DataInputStream(is);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(byte[] message) throws IOException {
        dataOutputStream.write(message);
    }

    public byte recieveMessage() throws IOException {
        return dataInputStream.readByte();
    }

    public void killSocket() {
        try {
            dataOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
