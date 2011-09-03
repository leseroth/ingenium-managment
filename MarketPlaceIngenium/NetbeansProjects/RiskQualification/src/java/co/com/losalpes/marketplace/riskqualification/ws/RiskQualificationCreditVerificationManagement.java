/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.ws;

import co.com.losalpes.marketplace.riskqualification.beans.CreditVerificationLocal;
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
public class RiskQualificationCreditVerificationManagement {
    @EJB
    private CreditVerificationLocal ejbRef;
    // Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"    

    @WebMethod(operationName = "verificarDataCredito")
    public String verificarDataCredito(@WebParam(name = "nit")
    String nit, @WebParam(name = "reglaVal")
    int reglaVal) throws Exception {
        return ejbRef.verificarDataCredito(nit, reglaVal);
    }

    @WebMethod(operationName = "verificarComfecamara")
    public Boolean verificarComfecamara(@WebParam(name = "nit")
    String nit, @WebParam(name = "reglaVal")
    int reglaVal) throws Exception {
        return ejbRef.verificarComfecamara(nit, reglaVal);
    }

    @WebMethod(operationName = "verificarListaClinton")
    public Boolean verificarListaClinton(@WebParam(name = "nit")
    String nit, @WebParam(name = "reglaVal")
    int reglaVal) throws Exception {
        return ejbRef.verificarListaClinton(nit, reglaVal);
    }

    @WebMethod(operationName = "verificarListaAntiLavado")
    public Boolean verificarListaAntiLavado(@WebParam(name = "nit")
    String nit, @WebParam(name = "reglaVal")
    int reglaVal) throws Exception {
        return ejbRef.verificarListaAntiLavado(nit, reglaVal);
    }

}
