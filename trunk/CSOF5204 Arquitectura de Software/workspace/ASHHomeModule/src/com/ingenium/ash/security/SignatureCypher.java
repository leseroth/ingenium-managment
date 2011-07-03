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
public class SignatureCypher {

    public static byte[] Cypher( byte[] chunk ) throws Exception {
        try {
            FileInputStream keyfis = new FileInputStream("src/com/ingenium/ash/privateIngenium");
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();

            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encKey);


            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");

            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);


            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");

            dsa.initSign(privateKey);

            /* Update and sign the data */

            dsa.update(chunk, 0, chunk.length);

            /* Now that all the data to be signed has been read in,
            generate a signature for it */

            return dsa.sign();


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
