/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import junit.framework.TestCase;
import com.ingenium.ash.security.SignatureCypher;
import com.ingenium.ash.security.SignatureVerifier;
import java.nio.ByteBuffer;
import static com.ingenium.ash.util.Constants.*;

/**
 *
 * @author davper
 */
public class TestHouseSignedData extends TestCase {

    private static short houseId = 777;
    private byte[] message;
    private int totalItems = 40;

    public TestHouseSignedData(String testName) {
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

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFirmaTrama() throws Exception {
        byte[] result = (new SignatureCypher()).cypher(message);
        boolean equal = (new SignatureVerifier()).verifySignature(message, result);
        assertEquals(equal, true);
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}e
}
