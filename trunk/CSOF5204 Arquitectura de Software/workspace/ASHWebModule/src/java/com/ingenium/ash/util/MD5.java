/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.util;
import java.io.UnsupportedEncodingException;
import java.security.*;
/**
 *
 * Cifra una cadena de texto con MD5
 */
public class MD5 {

    public static String Cipher(String word) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
            byte[] wordBytes = word.getBytes("UTF-8");
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(wordBytes);
            return toHexString(hash);
    }


    public static String toHexString(byte[] bytes)
    {
        char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v/16];
            hexChars[j*2 + 1] = hexArray[v%16];
        }
        return new String(hexChars);
    }
}
