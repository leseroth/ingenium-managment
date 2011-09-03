/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.ldap.utilities;

import java.util.Random;

/**
 *
 * @author marketplace
 */
public class RandomPassword {

    private static final String charset = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String getRandomString(int length) {
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }
}
