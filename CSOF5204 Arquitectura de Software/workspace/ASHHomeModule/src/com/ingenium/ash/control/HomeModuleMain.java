package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.security.SignatureCypher;
import com.ingenium.ash.vo.Item;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import static com.ingenium.ash.util.Constants.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 1B = -128 a 127 
 * 2B = short = -32768 a 32767
 * 4B = int = -2,147,483,648 a 2,147,483,647
 * 
 * @author Erik Arcos
 */
public class HomeModuleMain implements Runnable {

    // Size en bytes de los tipos de datos numericos
    public static final int SIZE_BYTE = 1;
    public static final int SIZE_SHORT = 2;
    public static final int SIZE_INT = 4;
    private ConnectorClient connClient;
    private boolean keepAlive;
    private long reportTime = 1000;
    private short homeIdentifier;
    private Map<Integer, Item> itemList;
    private int messageCounter;

    public HomeModuleMain(short homeId) {
        homeIdentifier = homeId;
        itemList = new HashMap<Integer, Item>();
    }

    public void startHomeModule() {
        connClient = new ConnectorClient();
        keepAlive = true;
        new Thread(this).start();
    }

    public void stopHomeModule() {
        connClient.killSocket();
        keepAlive = false;
    }

    public void addItem(int id, byte type) {
        itemList.put(id, new Item(id, type));
    }

    public void setStatus(int id, byte status) {
        itemList.get(id).setStatus(status);
    }

    @Override
    public void run() {
        long referenceTime, diffTime;
        diffTime = 0;

        while (keepAlive) {
            try {
                referenceTime = System.currentTimeMillis();

                int payloadSize = itemList.size() * ITEM_SIZE;
                ByteBuffer bbPayload = ByteBuffer.allocate(payloadSize);
                for (Item item : itemList.values()) {
                    bbPayload.put(item.encode());
                }
                byte[] payload = bbPayload.array();
                byte[] signedPayload = SignatureCypher.Cypher(payload);
                int signedPayloadSize = signedPayload.length;

                ByteBuffer bbMessage = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + payloadSize + SIZE_INT + signedPayloadSize);
                bbMessage.putShort(homeIdentifier);
                bbMessage.putInt(payloadSize);
                bbMessage.put(payload);
                bbMessage.putInt(signedPayloadSize);
                bbMessage.put(signedPayload);

                connClient.sendMessage(bbMessage.array());
                messageCounter++;

                diffTime = System.currentTimeMillis() - referenceTime;

                if (diffTime < reportTime) {
                    try {
                        Thread.sleep(reportTime - diffTime);
                    } catch (InterruptedException ex) {
                    }
                }
            } catch (IOException ex) {
                keepAlive = false;
                Logger.getLogger(HomeModuleMain.class.getName()).log(Level.SEVERE, "Se ha perdido la conexion con el servidor", ex);
            }
        }
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
