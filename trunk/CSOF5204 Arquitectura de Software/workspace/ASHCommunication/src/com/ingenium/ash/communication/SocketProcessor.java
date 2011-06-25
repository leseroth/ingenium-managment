package com.ingenium.ash.communication;

import com.ingenium.ash.communication.util.Util;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik Arcos
 */
public class SocketProcessor implements Runnable {

    private Socket socket;
    private boolean keepAlive;
    private DataInputStream dataInputStream;

    public SocketProcessor(Socket s) {
        socket = s;
        keepAlive = true;
    }

    @Override
    public void run() {

        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (keepAlive) {
            try {
                byte[] byteTotal = new byte[4];
                byteTotal[0] = dataInputStream.readByte();
                byteTotal[1] = dataInputStream.readByte();
                byteTotal[2] = dataInputStream.readByte();
                byteTotal[3] = dataInputStream.readByte();
                int size = Util.byteArrayToInt(byteTotal);

                byte[] byteArray = new byte[size];
                dataInputStream.read(byteArray);
                processMessage(byteArray);
            } catch (SocketException se) {
                se.printStackTrace();
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha cerrado el socket");
                keepAlive = false;
            } catch (EOFException eofe) {
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha perdido la conexion");
                keepAlive = false;
            } catch (IOException ex) {
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
                keepAlive = false;
            }
        }

        closeSocket();
    }

    public void closeSocket() {
        try {
            dataInputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processMessage(byte[] info) {
        // TODO processar la informacion enviada
    }
}
