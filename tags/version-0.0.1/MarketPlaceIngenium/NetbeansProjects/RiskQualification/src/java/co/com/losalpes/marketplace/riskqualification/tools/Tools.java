/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.tools;

import java.util.Calendar;

/**
 *
 * @author marketplace
 */
public class Tools {


   public static java.sql.Date getDateCurrent(){

        java.util.Calendar cal = Calendar.getInstance();
        java.sql.Date sqlFecha = new java.sql.Date(cal.getTime().getTime());
        return sqlFecha;
   }

   public static long getDiffDates(Calendar dateIni, Calendar dateLast){

       long milisLast = dateLast.getTimeInMillis();
       long milisIni = dateIni.getTimeInMillis();
       // Calculate difference in milliseconds
       long diff = milisLast - milisIni;
       // Calculate difference in days
       long diffDays = diff / (24 * 60 * 60 * 1000);
       return diffDays;
   }

   public static int safeLongToInt(long l) {
    int i = (int)l;
    if ((long)i != l) {
        throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
    }
    return i;
}


}
