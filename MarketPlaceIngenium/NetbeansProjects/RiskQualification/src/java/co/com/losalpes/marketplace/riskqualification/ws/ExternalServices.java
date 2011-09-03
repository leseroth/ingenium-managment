/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.ws;

import com.sun.faces.taglib.jsf_core.ConvertDateTimeTag;
import java.util.Random;

/*
 *
 * @author marketplace
 */
 public class ExternalServices {


     static private int getRamdomNit() {

         Random generator = new Random();
         int nit = generator.nextInt(900000001) + 100000000;
         return nit;
     }

      static public String getRating(String nit) {

         //Random generator = new Random(); //Pendiente lógica generate letters
         int ramdomNit = getRamdomNit();
         if (Integer.toString(ramdomNit).equals(nit.trim()))
             return "D";//Ramdom con las calificaciones negativas
         else
             return "A";//Ramdom con las calificaciones positivas
     }

      static public Boolean nitValidate(String nit){

         int ramdomNit = getRamdomNit();
         if (Integer.toString(ramdomNit).equals(nit.trim()))
             return false;//Ramdom con las calificaciones negativas
         else
             return true;
      }



}
