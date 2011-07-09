/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package policewebservice;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.tempuri.PoliceService;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PoliceService policeService = new PoliceService();
        String s;
        try {
            s = NotifyWS.Notify("1", "1", "junio 23 de 2010", "wail", "3122046679", "calle 5 22 18", "Popayan");
            System.out.println(s);
        } catch (UnReportedException ex) {
            System.out.println("Error");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //NotifyWS.ProcessResponse("<response><homeid>1</homeid><eventytype>1</eventytype><message>La policia nacional informa:   Se ha recibido una notificación de tipo: 1 Dirección: calle 5 22 18 Ciudad: Popayan Tiempo aproximado de llegada: 1 minutos</message></response>");
        //String s2 = policeService.getPoliceServiceSoap().notifyEvent(NotifyWS.CreateNotification("2","2","julio 23 de 2010","wail","3122046679","calle 5 22 18","Popayan"));
        //String s3 = policeService.getPoliceServiceSoap().notifyEvent(NotifyWS.CreateNotification("3","3","agosto 23 de 2010","wail","3122046679","calle 5 22 18","Popayan"));
        
        
        // TODO code application logic here
    }

}
