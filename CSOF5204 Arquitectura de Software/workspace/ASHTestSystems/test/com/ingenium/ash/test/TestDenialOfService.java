/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.communication.ConnectorClient;
import com.ingenium.ash.security.SignatureCypher;
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
        ByteBuffer bbPayload = ByteBuffer.allocate(ITEM_SIZE * totalItems);
        for (int i = 0; i < totalItems; i++) {
            bbPayload.put((byte) 2);
            bbPayload.putInt(i);
            bbPayload.put((byte) 0);
        }

        byte[] payload = bbPayload.array();
        byte[] signedPayload = SignatureCypher.Cypher(payload);

        ByteBuffer buffer = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + payload.length + SIZE_INT + signedPayload.length);
        buffer.putShort(houseId);
        buffer.putInt(payload.length);
        buffer.put(payload);
        buffer.putInt(signedPayload.length);
        buffer.put(signedPayload);
        message = buffer.array();
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
