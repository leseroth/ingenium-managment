package co.com.losalpes.marketplace.transact.util;

import co.com.losalpes.marketplace.transact.entities.Comercio;
import static co.com.losalpes.marketplace.transact.util.Constants.*;

/**
 *
 * @author Erik
 */
public class Util {

    public static final String getNumSeguimiento(Comercio com) {
        String numSeguimiento = null;
        if (com != null) {
            numSeguimiento = com.getNit() + NUM_SEGUIMIENTO_SEPARATOR + System.currentTimeMillis();
        }
        return numSeguimiento;
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmptyLong(Long lng) {
        return lng == null || lng == 0;
    }
}
