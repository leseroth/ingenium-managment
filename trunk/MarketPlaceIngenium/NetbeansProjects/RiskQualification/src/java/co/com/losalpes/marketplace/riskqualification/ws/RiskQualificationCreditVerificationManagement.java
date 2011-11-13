package co.com.losalpes.marketplace.riskqualification.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.com.losalpes.marketplace.riskqualification.beans.CreditVerificationLocal;
import co.com.losalpes.marketplace.riskqualification.exceptions.BussinessException;

/**
 *
 * @author marketplace
 */
@WebService()
@Stateless()
public class RiskQualificationCreditVerificationManagement {

    @EJB
    private CreditVerificationLocal ejbRef;

    /**
     * Verifica una entidad con las siguientes reglas.
     * <ul>
     * <li>Si la entidad no existe se registra, el nit es obligatorio</li>
     * <li>Si la cantidad de dias del certificado supera a la maxima cantidad de dias se registra nuevamente</li>
     * <li>Si la entidad se registra por primera vez, es verificada solo si su nit no contiene 7, 8, o 9</li>
     * <li>Si ha expirado el certificado de la entidad existe un 50% de posibilidades de que sea certificada</li>
     * </ul>
     * @param nit Nit de la entidad
     * @param reglaVal Maxima cantidad de dias en la que el certificado es valido
     * @return true si la entidad es verificada, false en caso contrario
     * @throws BussinessException Si no se cumple alguna de las reglas anteriores
     */
    @WebMethod(operationName = "verificarComfecamara")
    public Boolean verificarComfecamara(@WebParam(name = "nit") String nit, @WebParam(name = "reglaVal") int reglaVal) throws BussinessException {
        return ejbRef.verificarComfecamara(nit, reglaVal);
    }

    /**
     * Verifica una entidad con las siguientes reglas.
     * <ul>
     * <li>Si la entidad no existe se registra, el nit es obligatorio</li>
     * <li>Si la cantidad de dias del certificado supera a la maxima cantidad de dias se registra nuevamente</li>
     * <li>Si la entidad se registra por primera vez, es verificada solo si su nit no contiene 7, 8, o 9</li>
     * <li>Si ha expirado el certificado de la entidad existe un 50% de posibilidades de que sea certificada</li>
     * </ul>
     * @param nit Nit de la entidad
     * @param reglaVal Maxima cantidad de dias en la que el certificado es valido
     * @return CONFECAMARA_POSITIVA (A) si el nit es valido, CONFECAMARA_NEGATIVA (D) en caso contrario
     * @throws BussinessException Si no se cumple alguna de las reglas anteriores
     */
    @WebMethod(operationName = "verificarDataCredito")
    public String verificarDataCredito(@WebParam(name = "nit") String nit, @WebParam(name = "reglaVal") int reglaVal) throws BussinessException {
        return ejbRef.verificarDataCredito(nit, reglaVal);
    }

    /**
     * Verifica una entidad con las siguientes reglas.
     * <ul>
     * <li>Si la entidad no existe se registra, el nit es obligatorio</li>
     * <li>Si la cantidad de dias del certificado supera a la maxima cantidad de dias se registra nuevamente</li>
     * <li>Si la entidad se registra por primera vez, es verificada solo si su nit no contiene 7, 8, o 9</li>
     * <li>Si ha expirado el certificado de la entidad existe un 50% de posibilidades de que sea certificada</li>
     * </ul>
     * @param nit Nit de la entidad
     * @param reglaVal Maxima cantidad de dias en la que el certificado es valido
     * @return true si la entidad es verificada, false en caso contrario
     * @throws BussinessException Si no se cumple alguna de las reglas anteriores
     */
    @WebMethod(operationName = "verificarListaAntiLavado")
    public Boolean verificarListaAntiLavado(@WebParam(name = "nit") String nit, @WebParam(name = "reglaVal") int reglaVal) throws BussinessException {
        return ejbRef.verificarListaAntiLavado(nit, reglaVal);
    }

    /**
     * Verifica una entidad con las siguientes reglas.
     * <ul>
     * <li>Si la entidad no existe se registra, el nit es obligatorio</li>
     * <li>Si la cantidad de dias del certificado supera a la maxima cantidad de dias se registra nuevamente</li>
     * <li>Si la entidad se registra por primera vez, es verificada solo si su nit no contiene 7, 8, o 9</li>
     * <li>Si ha expirado el certificado de la entidad existe un 50% de posibilidades de que sea certificada</li>
     * </ul>
     * @param nit Nit de la entidad
     * @param reglaVal Maxima cantidad de dias en la que el certificado es valido
     * @return true si la entidad es verificada, false en caso contrario
     * @throws BussinessException Si no se cumple alguna de las reglas anteriores
     */
    @WebMethod(operationName = "verificarListaClinton")
    public Boolean verificarListaClinton(@WebParam(name = "nit") String nit, @WebParam(name = "reglaVal") int reglaVal) throws BussinessException {
        return ejbRef.verificarListaClinton(nit, reglaVal);
    }
}
