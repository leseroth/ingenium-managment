/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.communication.ConnectorClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.TestCase;
import static com.ingenium.ash.util.Constants.*;

public class TestDenialOfService extends TestCase {

    private static short houseId = 777;
    private byte[] message;
    private int totalItems = 40;

    public TestDenialOfService(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        ByteBuffer bb = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + ITEM_SIZE * totalItems);
        bb.putShort(houseId);
        bb.putInt(ITEM_SIZE * totalItems);

        for (int i = 0; i < totalItems; i++) {
            bb.put((byte) 2);
            bb.putInt(i);
            bb.put((byte) 0);
        }

        message = bb.array();
    }

    public void testDenialOfService() {
        ConnectorClient cc = new ConnectorClient();

        for (int i = 0; i < 1000; i++) {
            try {
                cc.sendMessage(message);
                Thread.sleep(10);
            } catch (IOException ex) {
                break;
            } catch (Exception ex) {
                break;
            }
        }
    }
}
