
package com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.3-hudson-757-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "FacturacionConfirmacionPago", targetNamespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/FacturacionConfirmacionPago")
@XmlSeeAlso({
    co.com.losalpes.marketplace.ObjectFactory.class,
    com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago.ObjectFactory.class
})
public interface FacturacionConfirmacionPago {


    /**
     * 
     * @param corte
     */
    @WebMethod(action = "process")
    @Oneway
    @RequestWrapper(localName = "process", targetNamespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/FacturacionConfirmacionPago", className = "com.oracle.xmlns.marketplace_jws.procesofacturacion.facturacionconfirmacionpago.Process")
    public void process(
        @WebParam(name = "corte", targetNamespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/FacturacionConfirmacionPago")
        int corte);

}
