/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.security;

import java.io.*;
import java.security.*;
import java.security.spec.*;

/**
 *
 * @author PC12345
 */
public class SignatureVerifier {

    public static Boolean VerifySignature(byte[] originalData, byte[] signedData) throws Exception {
        try {
            /* import encoded public key */
            FileInputStream keyfis = new FileInputStream("src/com/ingenium/ash/publicIngenium");
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);

            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            /* create a Signature object and initialize it with the public key */

            Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
            sig.initVerify(pubKey);

            /* Update and verify the data */

            sig.update(originalData, 0, originalData.length);

            return sig.verify(signedData);

        } catch (SignatureException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
