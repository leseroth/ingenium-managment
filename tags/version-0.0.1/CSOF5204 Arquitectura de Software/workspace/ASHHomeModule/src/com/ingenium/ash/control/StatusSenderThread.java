package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.security.SignatureCypher;
import com.ingenium.ash.vo.Item;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.ingenium.ash.util.Constants.*;

/**
 *
 * @author Erik Arcos
 */
public class StatusSenderThread implements Runnable {

    private boolean keepAlive;
    private SignatureCypher signatureCypher;
    private HomeModuleMain home;
    private ConnectorClient connClient;

    public StatusSenderThread(HomeModuleMain homeMM, ConnectorClient cClient) {
        keepAlive = true;
        signatureCypher = new SignatureCypher();
        connClient = cClient;
        home = homeMM;
    }

    @Override
    public void run() {
        
        while (keepAlive) {
            try {
                int payloadSize = home.getItemList().size() * ITEM_SIZE;
                ByteBuffer bbPayload = ByteBuffer.allocate(payloadSize);
                for (Item item : home.getItemList().values()) {
                    bbPayload.put(item.encode());
                }
                byte[] payload = bbPayload.array();
                byte[] signedPayload = signatureCypher.cypher(payload);
                int signedPayloadSize = signedPayload.length;
                
                ByteBuffer bbMessage = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + payloadSize + SIZE_INT + signedPayloadSize);
                bbMessage.putShort(home.getHomeIdentifier());
                bbMessage.putInt(payloadSize);
                bbMessage.put(payload);
                bbMessage.putInt(signedPayloadSize);
                bbMessage.put(signedPayload);

                connClient.sendMessage(bbMessage.array());
                
                try {
                    Thread.sleep(HM_REPORT_TIME);
                } catch (InterruptedException ex) {
                }
            } catch (IOException ex) {
                keepAlive = false;
                Logger.getLogger(StatusSenderThread.class.getName()).log(Level.SEVERE, "Se ha perdido la conexion con el servidor");
            } catch(Exception ex) {
                Logger.getLogger(StatusSenderThread.class.getName()).log(Level.SEVERE, "Se ha perdido la conexion con el servidor");
            }
        }
    }

    public void stopThread() {
        keepAlive = false;
    }
}
