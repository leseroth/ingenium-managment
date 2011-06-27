package com.ingenium.ash.communication;

import com.ingenium.ash.communication.util.Util;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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
    private ManagerInterface managerInterface;
    public static int counter;
    public static int closedCounter;
    public static int maxConnections = 10;
    public static List<String> timeTest = new ArrayList<String>();

    public SocketProcessor(Socket s, ManagerInterface mi) {
        socket = s;
        keepAlive = true;
        managerInterface = mi;
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

                long time = System.currentTimeMillis();
                counter++;

                byte[] byteArray = new byte[size];
                dataInputStream.read(byteArray);
                processMessage(byteArray, time);
            } catch (SocketException se) {
                //Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha cerrado el socket");
                keepAlive = false;
            } catch (EOFException eofe) {
                //Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.INFO, "Se ha perdido la conexion");
                keepAlive = false;
            } catch (IOException ex) {
                Logger.getLogger(ConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
                keepAlive = false;
            }
        }

        closedCounter++;
//        if (closedCounter == maxConnections) {
//            for (String s : timeTest) {
//                System.out.println(s);
//            }
//            closedCounter = 0;
//        }

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

    private void processMessage(byte[] info, long time) {
        // TODO processar la informacion enviada
        int totalEvent = (info.length - 2) / 6;
        for (int i = 0; i < totalEvent; i++) {
            managerInterface.processEvent(Arrays.copyOfRange(info, i * 6 + 2, i * 6 + 8), time);
        }
    }
}
