package co.com.losalpes.marketplace.pomanager.exceptions;

/**
 *
 * @author Erik
 */
public class BussinessException extends RuntimeException {

    private static String createMessage(String msg, String... detail) {
        if (detail.length != 0) {
            String[] message = msg.split("?");
            StringBuilder sb = new StringBuilder();
            sb.append(message[0]);
            for (int i = 1; i < message.length; i++) {
                sb.append(detail[i - 1]);
                sb.append(message[i]);
            }
            msg = sb.toString();
        }

        return msg;
    }

    public BussinessException(String msg, String... detail) {
        super(createMessage(msg, detail));
    }
}
