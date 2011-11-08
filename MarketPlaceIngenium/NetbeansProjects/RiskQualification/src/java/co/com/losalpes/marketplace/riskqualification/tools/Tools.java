package co.com.losalpes.marketplace.riskqualification.tools;

import java.util.Date;

/**
 *
 * @author marketplace
 */
public class Tools {

    /**
     * Calcula la cantidad de dias de diferencia entre las dos fechas
     * @param dateIni Fecha inicial
     * @param dateLast Fecha final
     * @return Cantidad de dias de diferencia entre las dos fechas
     */
    public static int getDiffDates(Date dateIni, Date dateLast) {
        long milisLast = dateLast.getTime();
        long milisIni = dateIni.getTime();

        // Calculate difference in days
        int diff = (int) ((milisLast - milisIni) / (1000 * 60 * 60 * 24));
        return diff;
    }
}
