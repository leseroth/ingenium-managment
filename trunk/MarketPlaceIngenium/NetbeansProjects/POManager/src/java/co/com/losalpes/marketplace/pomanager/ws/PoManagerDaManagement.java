package co.com.losalpes.marketplace.pomanager.ws;

import co.com.losalpes.marketplace.pomanager.beans.DaManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
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
public class PoManagerDaManagement {

    @EJB
    private DaManagementLocal ejbRef;

    @WebMethod(operationName = "registrarDA")
    public String registrarDA(@WebParam(name = "da") DispatchAdviceBO da, @WebParam(name = "numSeguimientoPo") String numSeguimientoPo) throws BussinessException {
        return ejbRef.registrarDA(da, numSeguimientoPo);
    }

    @WebMethod(operationName = "consultarDA")
    public DispatchAdviceBO consultarDA(@WebParam(name = "numSeguimiento") String numSeguimiento) throws BussinessException {
        return ejbRef.consultarDA(numSeguimiento);
    }

    @WebMethod(operationName = "consultarDAsFabricante")
    public java.util.List<DispatchAdviceBO> consultarDAsFabricante(@WebParam(name = "nit") String nit) throws BussinessException {
        return ejbRef.consultarDAsFabricante(nit);
    }

    @WebMethod(operationName = "consultarDAnumSeguimientoPO")
    public DispatchAdviceBO consultarDAnumSeguimientoPO(@WebParam(name = "numSeguimiento") String numSeguimiento) throws BussinessException {
        return ejbRef.consultarDAnumSeguimientoPO(numSeguimiento);
    }
}
