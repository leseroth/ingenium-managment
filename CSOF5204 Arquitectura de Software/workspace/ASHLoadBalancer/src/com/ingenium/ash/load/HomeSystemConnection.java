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
                int payloadSize = dataInputStream.readInt();
                short homeId = dataInputStream.readShort();
                int messageId = dataInputStream.readInt();          
                byte[] payload = new byte[payloadSize];
                dataInputStream.read(payload);

                LoadBalancer.getInstance().redirectMessage(homeId, messageId, payload);
            } catch (IOException ex) {
                Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, "Error al redireccionar el mensaje");
            }
        }
    }
}
