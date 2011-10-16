package co.com.losalpes.marketplace.transact.util;

/**
 *
 * @author Erik
 */
public class Util {

    /**
     * Verifica si un String es nulo o vacio
     * @param str String a evaluar
     * @return true si esta vacio
     */
    public static boolean isEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * Verifica si un Long es nulo o esta en cero
     * @param lng Valor
     * @return true si esta vacio
     */
    public static boolean isEmptyLong(Long lng) {
        return lng == null || lng == 0;
    }

    /**
     * Determina el tiempo en dias maximo empleado por fedex para enviar el paquete.
     * @param mailService Nombre del tipo de servicio
     * @return Tiempo en dias de envio
     */
    public static int getFedexTime(String mailService) {
        int time = 0;

        if (mailService != null && !mailService.isEmpty()) {
            int start = mailService.indexOf("(");
            int end = mailService.indexOf(")");

            if (start != -1 && end != -1) {
                mailService = mailService.toLowerCase().substring(start + 1, end);

                if (mailService.endsWith("days")) {
                    String[] helper = mailService.split(" ");
                    if (helper.length - 2 >= 0) {
                        mailService = helper[helper.length - 2];
                        start = mailService.indexOf("-");
                        if (start == -1) {
                            time = Integer.parseInt(mailService);
                        } else {
                            time = Integer.parseInt(mailService.substring(start + 1));
                        }
                    }
                } else {
                    time = 1;
                }
            }
        }

        return time;
    }

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
