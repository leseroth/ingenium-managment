package co.com.losalpes.marketplace.riskqualification.tools;

/*
 *
 * @author marketplace
 */
public class ExternalServices {

    private static int counter = 0;

    static public String getRating(String nit) {

        //Random generator = new Random(); //Pendiente lógica generate letters
        int ramdomNit = 1;//getRamdomNit();
        if (Integer.toString(ramdomNit).equals(nit.trim())) {
            return "D";//Ramdom con las calificaciones negativas
        } else {
            return "A";//Ramdom con las calificaciones positivas
        }
    }

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
}
