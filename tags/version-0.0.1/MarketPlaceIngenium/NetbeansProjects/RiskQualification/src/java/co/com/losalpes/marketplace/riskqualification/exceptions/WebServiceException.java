/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.exceptions;

/**
 *
 * @author marketplace
 */
public class WebServiceException extends Exception{

    public WebServiceException(){
        super("El servicio no se encuentra en este momento en línea. Por favor, intente mas tarde.");
    }

}
