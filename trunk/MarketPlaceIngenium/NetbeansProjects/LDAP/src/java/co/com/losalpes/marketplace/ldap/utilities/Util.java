package co.com.losalpes.marketplace.ldap.utilities;

import java.util.Random;

/**
 * Calse que contiene metodos utilitarios que son usados por Ldap
 * @author Erik
 */
public class Util {

    private static final String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random(System.currentTimeMillis());

    public static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = random.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

    public static String getUniqueLogin(String name) {
        String login = "";
        name = name.toLowerCase();
        name = name.replace(" ", "");
        if (name.length() > 6) {
            login = name.substring(0, 6);
        } else {
            login = name;
        }
        login = login + "_" + random.nextInt(1000);
        return login;
    }
}
