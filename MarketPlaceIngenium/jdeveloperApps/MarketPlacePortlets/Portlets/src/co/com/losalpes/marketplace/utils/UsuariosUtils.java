package co.com.losalpes.marketplace.utils;

import java.util.HashMap;
import java.util.Map;

public class UsuariosUtils {
    
    private static UsuariosUtils instance = null;
    Map<String,String> usuarios ;
    
    /**
     * Constructor por defecto de la clase
     */
    private UsuariosUtils(){
        usuarios = new HashMap<String,String>();
        usuarios.put("wi_10", "Comercio");
        usuarios.put("al_53", "Fabricante");
        usuarios.put("sa_30", "Comercio");
    }
    
    /**
     * Metodo encargado de instaciar la clase singleton UtilValidacionRunt
     * @return instacia de la clase UtilValidacionesRunt
     */
    public static UsuariosUtils getInstance()
    {
        if(instance==null){
                instance = new UsuariosUtils();
        }            
        return instance;
    }
    
    public String obtenerRolUsuario(String login){
        if(usuarios.containsKey(login)){
           return usuarios.get(login) ;
        }
        return null;
    }
    
}
