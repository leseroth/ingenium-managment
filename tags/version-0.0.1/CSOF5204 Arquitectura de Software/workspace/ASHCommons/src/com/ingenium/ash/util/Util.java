package com.ingenium.ash.util;

/**
 *
 * @author Erik Arcos
 */
public class Util {

    public static int byteArrayToInt(byte[] bytes) {
        return (bytes[0] << 24)
                + ((bytes[1] & 0xFF) << 16)
                + ((bytes[2] & 0xFF) << 8)
                + (bytes[3] & 0xFF);
    }

    /**
     * Convierte un arreglo de bytes a un numero entero.
     * @param array
     * @return
     */
    public static int convertArraytoInt(byte[] array) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (array[i] & 0x000000FF) << shift;
        }

        return value;
    }

    /**
     * Convierte un entero a un arreglo de bytes
     * @param value
     * @return
     */
    public static byte[] convertInttoArray(int value) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }
}
