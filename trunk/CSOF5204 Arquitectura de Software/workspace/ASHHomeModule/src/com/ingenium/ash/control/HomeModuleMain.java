package com.ingenium.ash.control;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.vo.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Erik Arcos
 */
public class HomeModuleMain {

    private short homeIdentifier;
    private Map<Integer, Item> itemList;
    private StatusSenderThread senderThread;
    private NotifierRecieverThread recieverThread;
    private ConnectorClient connClient;
    private String owner = "Erik Arcos";
    private String ownerEmail = "ercos41@gmail.com";
    private String ownerSkype = "el_checho1";

    public HomeModuleMain(short homeId) {
        homeIdentifier = homeId;
        itemList = new HashMap<Integer, Item>();
        connClient = new ConnectorClient();
        senderThread = new StatusSenderThread(this, connClient);
        recieverThread = new NotifierRecieverThread(this, connClient);
    }

    public void setOwnerInfo(String owner, String ownerEmail, String ownerSkype) {
        this.owner = owner;
        this.ownerEmail = ownerEmail;
        this.ownerSkype = ownerSkype;
    }

    public void startHomeModule() {
        new Thread(senderThread).start();
        new Thread(recieverThread).start();
    }

    public void stopHomeModule() {
        senderThread.stopThread();
        recieverThread.stopThread();
        connClient.killSocket();
    }

    public void addItem(int id, byte type) {
        itemList.put(id, new Item(id, type));
    }

    public void setStatus(int id, byte status) {
        itemList.get(id).setStatus(status);
    }

    public short getHomeIdentifier() {
        return homeIdentifier;
    }

    public Map<Integer, Item> getItemList() {
        return itemList;
    }

    public String getOwner() {
        return owner;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerSkype() {
        return ownerSkype;
    }
}
