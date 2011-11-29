package co.com.losalpes.marketplace.facturacion.util;

/**
 *
 * @author Erik
 */
public class Util {

    /**
     * Crea un mensaje de excepcion
     * @param msg Mensaje con wildcards ? para reempalzar
     * @param detail Valores que seran colocados en ?
     * @return El nuevo string formado
     */
    public static String createMessage(String msg, String... detail) {
        StringBuilder sb = new StringBuilder(msg);
        int counter = 0;

        replace:
        for (;;) {
            int index = sb.indexOf("?");
            if (index == -1) {
                break replace;
            } else {
                if (counter >= detail.length) {
                    break replace;
                } else {
                    sb.deleteCharAt(index);
                    sb.insert(index, detail[counter]);
                    counter++;
                }
            }
        }

        return sb.toString();
    }
}
