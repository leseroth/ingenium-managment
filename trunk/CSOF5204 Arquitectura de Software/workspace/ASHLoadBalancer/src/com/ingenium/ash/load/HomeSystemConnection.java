package com.ingenium.ash.load;

import com.ingenium.ash.security.SignatureVerifier;
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

    private int messageIdGenerator;
    private Socket socket;
    private LoadBalancer loadBalancer = LoadBalancer.getInstance();

    public HomeSystemConnection(Socket s) {
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

        boolean keepAlive = true;
        short homeIdCache = 0;

        while (keepAlive) {
            try {
                messageIdGenerator++;

                short homeId = dataInputStream.readShort();
                int payloadSize = dataInputStream.readInt();
                byte[] payload = new byte[payloadSize];
                dataInputStream.read(payload);
                int signedPayloadSize = dataInputStream.readInt();
                byte[] signedPayload = new byte[signedPayloadSize];
                dataInputStream.read(signedPayload);

                homeIdCache = homeId;

                boolean dos = loadBalancer.verifyDenialOfService(homeId, System.currentTimeMillis());

                if (dos) {
                    System.out.println("Posible ataque de DOS detectado desde la casa " + homeId);
                    socket.close();
                    throw new IOException();
                } else {
                    boolean verified = SignatureVerifier.verifySignature(payload, signedPayload);

                    if (verified) {
                        loadBalancer.redirectMessage(homeId, messageIdGenerator, payload);
                    } else {
                        System.out.println("No se pudo verificar la firma de la casa " + homeId);
                        socket.close();
                        throw new IOException();
                    }
                }
            } catch (IOException ex) {
                String message = "Se ha perdido la conexion con la casa " + homeIdCache;
                Logger.getLogger(LoadBalancer.class.getName()).log(Level.SEVERE, message);
                keepAlive = false;
            }
        }
    }
}
