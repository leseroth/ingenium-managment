package co.com.losalpes.marketplace.ldap.utilities;

/**
 *
 * @author Erik
 */
public class Constants {

    /**
     * Enumeracion empleada para identificar los roles
     */
    public enum Rol {

        /**
         * Rol que identifica a un comercio
         */
        Comercio("Comercio"),
        /**
         * Rol que identifica a un fabricante
         */
        Fabricante("Fabricante"),
        /**
         * Rol capaz de realizar reportes
         */
        MPReportes("MP Reportes"),
        /**
         * Rol capaz de realizar consultas
         */
        MPConsultas("MP Consultas");
        String nombre;

        Rol(String nom) {
            nombre = nom;
        }

        /**
         * Retorna el rol identificado por el nombre
         * @param nom Nombre del rol
         * @return El rol, o null en caso de que el rol no exista
         */
        public static Rol getRol(String nom) {
            Rol rol = null;
            rolSearch:
            for (Rol r : Rol.values()) {
                if (r.nombre.equals(nom)) {
                    rol = r;
                    break rolSearch;
                }
            }
            return rol;
        }
    }

    /**
     * Enumeracion empleada para identificar los estados posibles
     */
    public enum Estado {

        Activo, Inactivo;

        /**
         * Retorna el Estado identificado por el nombre
         * @param nom Nombre del Estado
         * @return El Estado, o null en caso de que el Estado no exista
         */
        public static Estado getEstado(String nom) {
            Estado estado = null;
            estadoSearch:
            for (Estado e : Estado.values()) {
                if (e.toString().equals(nom)) {
                    estado = e;
                    break estadoSearch;
                }
            }
            return estado;
        }
    }
}
