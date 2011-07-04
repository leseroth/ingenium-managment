/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.load.LoadBalancer;
import com.ingenium.ash.security.SignatureCypher;
import com.ingenium.ash.security.SignatureVerifier;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.TestCase;
import static com.ingenium.ash.util.Constants.*;

/**
 *
 * @author Usuario
 */
public class TestSingleMessage2 extends TestCase {

    //LoadBalancer
    private static LoadBalancer loadBalancer = LoadBalancer.getInstance();
    private static short HOUSE_ID = 100;
    private static int MESSAGE_ID = 1;
    private static int totalItems = 40;
    //Info
    private short homeId;
    private byte[] payload;
    private byte[] signedPayload;

    public TestSingleMessage2(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        ByteBuffer bbPayload = ByteBuffer.allocate(ITEM_SIZE * totalItems);
        for (int i = 0; i < totalItems; i++) {
            bbPayload.put((byte) 2);
            bbPayload.putInt(i + HOUSE_ID);
            bbPayload.put((byte) 0);
        }

        payload = bbPayload.array();
        signedPayload = SignatureCypher.Cypher(payload);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMessage() {
        homeId = HOUSE_ID++;

        int csId = 0;
        int msgId = MESSAGE_ID++;
        boolean dos = loadBalancer.verifyDenialOfService(homeId, System.currentTimeMillis());

        try {
            if (dos) {
                System.out.println("Posible ataque de DOS detectado desde la casa " + homeId);
            } else {
                boolean verified = SignatureVerifier.verifySignature(payload, signedPayload);

                if (verified) {
                    csId = loadBalancer.redirectMessage(homeId, msgId, payload);
                } else {
                    System.out.println("No se pudo verificar la firma de la casa " + homeId);
                    throw new IOException();
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }

        String id = LoadBalancer.generateIdentifier(homeId, csId, msgId);
        boolean check = true;
        while (check) {
            for (int i = 0; i < 10000; i++) {
                check = !check;
            }
            check = loadBalancer.checkMessage(id) != null;
        }
    }
}
