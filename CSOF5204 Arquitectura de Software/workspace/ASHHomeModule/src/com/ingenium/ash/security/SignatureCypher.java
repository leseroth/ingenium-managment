/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.security;

import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC12345
 */
public  class SignatureCypher {

    private static PrivateKey privateKey;

    static {
        try {
            FileInputStream keyfis = null;
            keyfis = new FileInputStream("test/com/ingenium/ash/privateIngenium");
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
            privateKey = keyFactory.generatePrivate(privateKeySpec);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PrivateKey getPrivateKey() {
        return privateKey;
    }

    public byte[] cypher(byte[] chunk) {
        byte[] signedChunk = null;

        try {
            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
            dsa.initSign(getPrivateKey());
            /* Update and sign the data */
            dsa.update(chunk, 0, chunk.length);
            /* Now that all the data to be signed has been read in,
            generate a signature for it */
            signedChunk = dsa.sign();
        } catch (SignatureException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(SignatureCypher.class.getName()).log(Level.SEVERE, null, ex);
        }

        return signedChunk;
    }
}
