package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.vo.Item;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

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
            referenceTime = System.currentTimeMillis();

            int payloadSize = itemList.size() * Item.ITEM_SIZE;

            ByteBuffer bb = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + payloadSize);
            bb.putShort(homeIdentifier);
            bb.putInt(payloadSize);
            for (Item item : itemList.values()) {
                bb.put(item.encode());
            }
            connClient.sendMessage(bb.array());
            messageCounter++;

            diffTime = System.currentTimeMillis() - referenceTime;

            if (diffTime < reportTime) {
                try {
                    Thread.sleep(reportTime - diffTime);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
