/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.communication.ConnectorClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import com.ingenium.ash.security.SignatureCypher;
import java.nio.ByteBuffer;
import java.util.Arrays;
import static com.ingenium.ash.util.Constants.*;

/**
 *
 * @author davper
 */
public class TestHouseSignedWrong extends TestCase {

    private static short houseId = 888;
    private byte[] payload;
    private byte[] signedPayload;
    private byte[] goodMessage;
    private byte[] badMessage;
    private int totalItems = 40;

    public TestHouseSignedWrong(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() {
        ByteBuffer bbPayload = ByteBuffer.allocate(ITEM_SIZE * totalItems);
        for (int i = 0; i < totalItems; i++) {
            bbPayload.put((byte) 2);
            bbPayload.putInt(i);
            bbPayload.put((byte) 0);
        }

        payload = bbPayload.array();
        signedPayload = (new SignatureCypher()).cypher(payload);

        ByteBuffer goodBuffer = ByteBuffer.allocate(SIZE_SHORT + SIZE_INT + payload.length + SIZE_INT + signedPayload.length);
        goodBuffer.putShort(houseId);
        goodBuffer.putInt(payload.length);
        goodBuffer.put(payload);
        goodBuffer.putInt(signedPayload.length);
        goodBuffer.put(signedPayload);

        goodMessage = goodBuffer.array();
        badMessage = Arrays.copyOf(goodMessage, goodMessage.length);
        badMessage[badMessage.length - 1] = badMessage[badMessage.length - 1] == 0 ? (byte) 1 : (byte) 0;
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSignature() {
        try {
            ConnectorClient cc = new ConnectorClient();
            cc.sendMessage(goodMessage);
            Thread.sleep(1000);
            cc.sendMessage(badMessage);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestHouseSignedWrong.class.getName()).log(Level.SEVERE, null);
        } catch (IOException ex) {
            Logger.getLogger(TestHouseSignedWrong.class.getName()).log(Level.SEVERE, "Se perdio la conexion con el servidor");
        }
    }
}
