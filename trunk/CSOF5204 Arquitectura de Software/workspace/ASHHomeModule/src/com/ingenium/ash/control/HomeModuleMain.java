package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.vo.Item;
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

    private ConnectorClient connClient;
    private boolean keepAlive;
    private long reportTime = 1000;
    private byte[] homeIdentifier;
    private Map<Integer, Item> itemList;

    public HomeModuleMain(short homeId) {
        homeIdentifier = new byte[2];
        homeIdentifier[0] = (byte)(homeId & 0xff);
        homeIdentifier[1] = (byte)((homeId >> 8) & 0xff);
        itemList = new HashMap<Integer, Item>();
    }

    public void startHomeModule(String server, int port) {
        connClient = new ConnectorClient(server, port);
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

            connClient.sendMessage((byte) (2 + itemList.size()));
            connClient.sendMessage(homeIdentifier);
            for (Item item : itemList.values()) {
                connClient.sendMessage(item.encode());
            }

            diffTime = System.currentTimeMillis() - referenceTime;

            if (diffTime < reportTime) {
                try {
                    Thread.sleep(reportTime - diffTime);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
