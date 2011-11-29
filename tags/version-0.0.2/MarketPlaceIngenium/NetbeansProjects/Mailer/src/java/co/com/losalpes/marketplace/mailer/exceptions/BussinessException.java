package co.com.losalpes.marketplace.mailer.exceptions;

import javax.xml.ws.WebFault;

/**
 * Excepcion generica para manejar los mensajes de error
 * @author Erik
 */
@WebFault
public class BussinessException extends Exception {

    /**
     * Constructor
     * @param msg Mensaje con wildcards ? para reempalzar
     * @param detail Valores que seran colocados en ?
     */
    public BussinessException(String msg, String... detail) {
        super(createMessage(msg, detail));
    }

    /**
     * Crea un mensaje de excepcion
     * @param msg Mensaje con wildcards ? para reempalzar
     * @param detail Valores que seran colocados en ?
     * @return El nuevo string formado
     */
    private static String createMessage(String msg, String... detail) {
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
