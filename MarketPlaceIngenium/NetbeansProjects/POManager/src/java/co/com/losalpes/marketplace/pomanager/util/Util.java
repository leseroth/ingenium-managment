package co.com.losalpes.marketplace.pomanager.util;

import co.com.losalpes.marketplace.pomanager.entities.Comercio;
import static co.com.losalpes.marketplace.pomanager.util.Constants.*;

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
}
