/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.ws;

import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
import co.com.losalpes.marketplace.pomanager.beans.RmaManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author marketplace
 */
@WebService()
@Stateless()
public class PoManagerRmaManagement {
    @EJB
    private RmaManagementLocal ejbRef;

    @WebMethod(operationName = "registrarRMA")
    public String registrarRMA(@WebParam(name = "rma")
    ReturnMaterialAdviceBO rma) throws BussinessException {
        return ejbRef.registrarRMA(rma);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarRMAsComercio")
    public java.util.List<ReturnMaterialAdviceBO> consultarRMAsComercio(@WebParam(name = "nit")
    String nit) throws BussinessException {
        return ejbRef.consultarRMAsComercio(nit);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarRMAsFabricante")
    public java.util.List<ReturnMaterialAdviceBO> consultarRMAsFabricante(@WebParam(name = "nit")
    String nit) throws BussinessException {
        return ejbRef.consultarRMAsFabricante(nit);
    }
}
