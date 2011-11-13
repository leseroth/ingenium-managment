package co.com.losalpes.marketplace.riskqualification.tools;

/*
 *
 * @author marketplace
 */
public class ExternalServices {

    private static int counter = 0;
    /**
     * Calificacion positiva de confecamara
     */
    protected static String CONFECAMARA_POSITIVA = "A";
    /**
     * Calificacion negativa de confecamara
     */
    protected static String CONFECAMARA_NEGATIVA = "D";

    /**
     * Para propositos del ejercicio, los nit que contengan 7, 8 o 9 seran considerados como no validos,
     * si el establecimiento ya existia existe un 50% de posibilidad de que ya no sea valido
     * @param nit Nit a validar
     * @param existente Indica si ya existia
     * @return true si el nit es valido, false en caso contrario.
     */
    static public Boolean nitValidate(String nit, boolean existente) {
        boolean valid = nit.indexOf("7") == -1 && nit.indexOf("8") == -1 && nit.indexOf("9") == -1;
        if (existente) {
            valid = (++counter % 2) == 0;
        }
        return valid;
    }

    /**
     * Para propositos del ejercicio, los nit que contengan 7, 8 o 9 seran considerados como no validos,
     * si el establecimiento ya existia existe un 50% de posibilidad de que ya no sea valido
     * @param nit Nit a validar
     * @param existente Indica si ya existia
     * @return CONFECAMARA_POSITIVA (A) si el nit es valido, CONFECAMARA_NEGATIVA (D) en caso contrario.
     */
    static public String getRating(String nit, boolean existente) {
        return nitValidate(nit, existente) ? CONFECAMARA_POSITIVA : CONFECAMARA_NEGATIVA;
    }
}
