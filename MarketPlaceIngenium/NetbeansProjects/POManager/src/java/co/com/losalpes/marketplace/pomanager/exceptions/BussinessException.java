package co.com.losalpes.marketplace.pomanager.exceptions;

import javax.xml.ws.WebFault;

/**
 *
 * @author Erik
 */
@WebFault
public class BussinessException extends Exception {

    public BussinessException(String msb, String... detail) {
        super(createMessage(msb, detail));
    }

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
