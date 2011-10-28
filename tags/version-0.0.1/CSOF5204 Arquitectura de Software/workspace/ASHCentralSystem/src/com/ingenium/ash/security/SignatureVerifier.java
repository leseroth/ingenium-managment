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

    public static PublicKey pubKey;

    static {
        try {
            FileInputStream keyfis = new FileInputStream("src/com/ingenium/ash/publicIngenium");
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);
            keyfis.close();
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
            pubKey = keyFactory.generatePublic(pubKeySpec);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PublicKey getPublicKey(){
        return pubKey;
    }
    
    public Boolean verifySignature(byte[] originalData, byte[] signedData) {
        boolean verified = false;

        try {
            Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
            sig.initVerify(getPublicKey());
            sig.update(originalData, 0, originalData.length);
            verified = sig.verify(signedData);
        } catch (SignatureException ex) {
            ex.printStackTrace();
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
            Logger.getLogger(SignatureVerifier.class.getName()).log(Level.SEVERE, null);
        } 

        return verified;
    }
}
