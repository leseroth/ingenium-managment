package co.com.losalpes.marketplace.riskqualification.beans;

import co.com.losalpes.marketplace.riskqualification.exceptions.BussinessException;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface CreditVerificationLocal {

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
    public Boolean verificarComfecamara(String nit, int reglaVal) throws BussinessException;

    public String verificarDataCredito(String nit, int reglaVal) throws BussinessException;

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
    public Boolean verificarListaAntiLavado(String nit, int reglaVal) throws BussinessException;

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
    public Boolean verificarListaClinton(String nit, int reglaVal) throws BussinessException;
}
