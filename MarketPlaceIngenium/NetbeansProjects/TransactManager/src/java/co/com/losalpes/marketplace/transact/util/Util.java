package co.com.losalpes.marketplace.transact.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static co.com.losalpes.marketplace.transact.util.Constants.*;

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

    /**
     * Lee la llave de uso desde la pagina web de ecocoma
     * (http://www.ecocoma.com/shipping_webservice.aspx)
     * para poder acceder a los servicios web de FedEx
     */
    public static void updateEcocomaKey() {
        String key = null;
        InputStreamReader isReader = null;
        BufferedReader bReader = null;

        try {
            URL url = new URL("http://www.ecocoma.com/shipping_webservice.aspx");
            isReader = new InputStreamReader(url.openStream());
            bReader = new BufferedReader(isReader);
            keySearcher:
            for (;;) {
                String line = bReader.readLine();
                if (line != null && line.indexOf("KeyID :") != -1) {
                    int start = line.lastIndexOf(">SHP") + 1;
                    int end = line.lastIndexOf("</span>");
                    key = line.substring(start, end);
                    break keySearcher;
                }
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }
                if (isReader != null) {
                    isReader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ECOCOMA_KEY = key;
        System.out.println("***** Marketplace : Actualizada la llave de ecocoma " + ECOCOMA_KEY + " *****");
    }
}
