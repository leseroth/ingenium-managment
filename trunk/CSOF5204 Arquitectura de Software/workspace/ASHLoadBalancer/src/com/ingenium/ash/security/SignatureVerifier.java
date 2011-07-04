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
public class SignatureVerifier {

    public static Boolean verifySignature(byte[] originalData, byte[] signedData) {
        boolean verified = false;

        try {
            FileInputStream keyfis = null;
            keyfis = new FileInputStream("src/com/ingenium/ash/publicIngenium");
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
            Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
            sig.initVerify(pubKey);
            sig.update(originalData, 0, originalData.length);
            verified = sig.verify(signedData);
        } catch (SignatureException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (IOException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        }

        return verified;
    }
}
