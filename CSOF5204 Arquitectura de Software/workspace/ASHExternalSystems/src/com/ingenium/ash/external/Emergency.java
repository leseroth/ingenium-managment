package com.ingenium.ash.external;

import com.ingenium.ash.communication.util.Util;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik Arcos
 */
public class Emergency {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static final int port = 4460;

    public static void main(String... args) {
        startSystem();
    }

    private static void startSystem() {
        DataInputStream dataInputStream = null;

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Police.class.getName()).log(Level.SEVERE, null, ex);
        }

        int counter =0;
        while (true) {
            try {
                byte[] byteTotal = new byte[4];
                byteTotal[0] = dataInputStream.readByte();
                byteTotal[1] = dataInputStream.readByte();
                byteTotal[2] = dataInputStream.readByte();
                byteTotal[3] = dataInputStream.readByte();
                int size = Util.byteArrayToInt(byteTotal);

                byte[] byteArray = new byte[size];
                dataInputStream.read(byteArray);

                counter++;
                Logger.getLogger(Emergency.class.getName()).log(Level.WARNING, counter+" "+new String(byteArray));
            } catch (IOException ex) {
                Logger.getLogger(Emergency.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
