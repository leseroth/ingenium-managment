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
}
