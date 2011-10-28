/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.manager;

import java.nio.ByteBuffer;
import junit.framework.TestCase;

/**
 *
 * @author Usuario
 */
public class MessageTest extends TestCase {

    private Manager manager;
    private byte[] info;

    public MessageTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
       
        manager = new Manager();

        int itemTotal = 10;
        int size = 2 + itemTotal * 6;
        ByteBuffer bb = ByteBuffer.allocate(size);
        bb.putShort((short) 1);

        for (int i = 0; i < itemTotal; i++) {
            bb.put((byte) 2); // tipo
            bb.putInt(i); // id
            if (i == 5) {
                bb.put((byte) 1);
            } else {
                bb.put((byte) 0);
            }
        }

        info = bb.array();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMessage() {

        int totalEvent = (info.length - 2) / 6;
        for (int i = 0; i < totalEvent; i++) {
            ByteBuffer bb = ByteBuffer.allocate(6);
            bb.put(info[i * 6 + 2]);
            bb.put(info[i * 6 + 3]);
            bb.put(info[i * 6 + 4]);
            bb.put(info[i * 6 + 5]);
            bb.put(info[i * 6 + 6]);
            bb.put(info[i * 6 + 7]);
            manager.processEvent(bb.array());
        }
        
    }
}
