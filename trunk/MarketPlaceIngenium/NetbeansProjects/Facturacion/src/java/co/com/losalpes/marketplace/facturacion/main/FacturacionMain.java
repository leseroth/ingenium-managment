/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.facturacion.main;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marketplace
 */
public class FacturacionMain {

    public static void main(String args[]){
        while(true){
            try {
                Date d = new Date();
                int corte = 0;
                if (d.getDate() + 1 == 1) {
                    corte = 1;
                } else if (d.getDate() + 1 == 11) {
                    corte = 2;
                } else if (d.getDate() + 1 == 21) {
                    corte = 3;
                }
                if (corte != 0) {
                    try {
                        // Call Web Service Operation
                        com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago.FacturacionconfirmacionpagoClientEp service = new com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago.FacturacionconfirmacionpagoClientEp();
                        com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago.FacturacionConfirmacionPago port = service.getFacturacionConfirmacionPagoPt();
                        port.process(corte);
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                }
                //Se ejecuta cada 24 horas (86400000)
                Thread.sleep(86400000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FacturacionMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
