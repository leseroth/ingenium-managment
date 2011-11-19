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

    /**
     * Verifica una entidad internacionalmente con la siguientes reglas.
     * <ul>
     * <li>Si la entidad no existe se registra, el nit es obligatorio</li>
     * <li>Si la cantidad de dias del certificado supera a la maxima cantidad de dias se registra nuevamente</li>
     * <li>Si la entidad se registra por primera vez, es verificada solo si su nit no contiene 7, 8, o 9</li>
     * <li>Si ha expirado el certificado de la entidad existe un 50% de posibilidades de que sea certificada</li>
     * <li>El codigo de pais es de dos letras, por ejemplo, co, uk, eu</li>
     * <li>Si el codigo de pais es PE (Peru) o AR (Argentina) se retorna false</li>
     * </ul>
     * @throws BussinessException
     * @param nit Nit de la entidad
     * @param reglaVal Maxima cantidad de dias en la que el certificado es valido
     * @param codPais Codigo del pais segun la regla <a href="http://es.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>
     * @return true si la entidad es verificada, false en caso contrario
     * @throws BussinessException Si no se cumple alguna de las reglas anteriores
     */
    public Boolean verificarListaInternacional(String nit, int reglaVal, String codPais) throws BussinessException;
}
