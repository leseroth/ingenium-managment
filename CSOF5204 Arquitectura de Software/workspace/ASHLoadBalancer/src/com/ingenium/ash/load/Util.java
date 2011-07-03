/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.load;

/**
 *
 * @author Usuario
 */
public class Util {

    public static int byteArrayToInt(byte[] bytes) {
        return (bytes[0] << 24)
                + ((bytes[1] & 0xFF) << 16)
                + ((bytes[2] & 0xFF) << 8)
                + (bytes[3] & 0xFF);
    }
}
