package com.ingenium.ash.vo;

/**
 *
 * @author Erik Arcos
 */
public class Item {

    private byte itemStatus;
    private byte[] encoded;

    public Item(int itemId, byte itemType) {
        itemStatus = 0;
        encoded = new byte[6];
        encoded[0] = itemType;
        encoded[1] = (byte) (itemId >> 24);
        encoded[2] = (byte) ((itemId << 8) >> 24);
        encoded[3] = (byte) ((itemId << 16) >> 24);
        encoded[4] = (byte) ((itemId << 24) >> 24);
    }
    
    public void setStatus(byte status){
        itemStatus = status;
    }

    public byte[] encode() {
        encoded[5] = itemStatus;
        itemStatus = 0;
        return encoded;
    }
}
