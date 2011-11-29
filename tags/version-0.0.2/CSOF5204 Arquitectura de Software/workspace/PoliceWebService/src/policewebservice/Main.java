/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package policewebservice;



/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String s;
        try {
            s = NotifyWS.notify("1", "1", "junio 23 de 2010", "wail", "3122046679", "calle 5 22 18", "Popayan");
        } catch (UnReportedException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
        NotifyWS.CreateNotification("1", "1", "junio 23 de 2010", "wail", "3122046679", "calle 5 22 18", "Popayan");
        //NotifyWS.ProcessResponse("<response><homeid>1</homeid><eventytype>1</eventytype><message>La policia nacional informa:   Se ha recibido una notificación de tipo: 1 Dirección: calle 5 22 18 Ciudad: Popayan Tiempo aproximado de llegada: 1 minutos</message></response>");
        //String s2 = policeService.getPoliceServiceSoap().notifyEvent(NotifyWS.CreateNotification("2","2","julio 23 de 2010","wail","3122046679","calle 5 22 18","Popayan"));
        //String s3 = policeService.getPoliceServiceSoap().notifyEvent(NotifyWS.CreateNotification("3","3","agosto 23 de 2010","wail","3122046679","calle 5 22 18","Popayan"));


        // TODO code application logic here
    }
}
