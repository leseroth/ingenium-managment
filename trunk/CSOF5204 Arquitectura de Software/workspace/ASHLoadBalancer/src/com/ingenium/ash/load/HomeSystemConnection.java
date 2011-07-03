package com.ingenium.ash.load;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik
 */
public class HomeSystemConnection implements Runnable {
    int idGenerator;
    private Socket socket;
    
    public HomeSystemConnection(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "No se pudo obtener el ouputStream");
        }

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

                LoadBalancer.getInstance().redirectMessage(byteTotal, byteArray);
            } catch (IOException ex) {
                Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al redireccionar el mensaje");
            }
        }
    }
}
