/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.ldap.beans;

import co.com.losalpes.marketplace.gestioncorreoelectronico.GestionCorreoElectronico_Service;
import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import co.com.losalpes.marketplace.ldap.entities.Usuario;
import co.com.losalpes.marketplace.ldap.exceptions.EstadoNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.RolNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.UsuarioNoExisteException;
import co.com.losalpes.marketplace.ldap.utilities.RandomPassword;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Asistente
 */
@Stateless
public class AutenticacionUsuariosBean implements AutenticacionUsuariosRemote, AutenticacionUsuariosLocal {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_7001/marketPlace/proxy/GestionCorreoElectronico.wsdl")
    private GestionCorreoElectronico_Service service;
    @PersistenceContext
    private EntityManager em;

    public UsuarioBO autenticar(String login, String password) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLoginPsswd");
        q.setParameter("login", login);
        q.setParameter("pwd", password);
        List<Usuario> usuario = (List<Usuario>)q.getResultList();
        if(usuario.isEmpty())
            throw new UsuarioNoExisteException("El usuario especificado no existe en el sistema");
        return usuario.get(0).toBO();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public UsuarioBO crearUsuario(String nit, String nombre, String rol, String email) throws RolNoExisteException{
        if(!rol.equals("Comercio") && !rol.equals("Fabricante") && !rol.equals("MP Reportes") && !rol.equals("MP Consultas"))
            throw new RolNoExisteException("El rol "+ rol + " no existe en el sistema");
        Usuario u = new Usuario();
        u.setEstado("Activo");
        u.setNit(nit);
        u.setRol(rol);
        u.setLogin(nombre.substring(0, 2)+"_"+nit.substring(0,2));
        u.setPassword(RandomPassword.getRandomString(10));
        u.setEmail(email);
        persist(u);
        em.flush();
        return u.toBO();
    }

    public Boolean actualizarEstado(String login, String estado) throws UsuarioNoExisteException, EstadoNoExisteException {
        if(!estado.equals("Activo") || !estado.equals("Inactivo"))
            throw new EstadoNoExisteException("El estado "+ estado + " no representa un estado válido para el sistema.");
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        Usuario u = (Usuario)q.getSingleResult();
        if(u == null)
            throw new UsuarioNoExisteException("El usuario con el login "+ login + " no existe en el sistema.");
        u.setEstado(estado);
        em.flush();
        return true;
    }

    public String obtenerNitUsuario(String login) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>)q.getResultList();
        if(usuarios.isEmpty())
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        return usuarios.get(0).getNit();
    }

    public Boolean cambiarClave(String login, String nuevaClave) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>)q.getResultList();
        if(usuarios.isEmpty())
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        usuarios.get(0).setPassword(nuevaClave);
        em.flush();
        return true;
    }

    public Boolean recuperarClave(String login, String email) throws UsuarioNoExisteException{
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>)q.getResultList();
        if(usuarios.isEmpty())
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        if(!usuarios.get(0).getEmail().equals(email))
            throw new UsuarioNoExisteException("El usuario con el login "+login+" no posee el email especificado.");
        String newPassword = RandomPassword.getRandomString(10);
        usuarios.get(0).setPassword(newPassword);

        try { // Call Web Service Operation
            co.com.losalpes.marketplace.gestioncorreoelectronico.GestionCorreoElectronico port = service.getGestionCorreoElectronicoSOAP();
            java.util.List<java.lang.String> to = new ArrayList<String>();
            to.add(email);
            java.lang.String from = "info@marketplace.losalpes.com.co";
            java.lang.String password = "marketplace2011";
            java.lang.String subject = "Recuperación de clave";
            java.lang.String message = "Estimado "+login+":\n\nLa nueva clave para ingresar al portal es "+newPassword
                    +".\n\nCordialmente,\n\nEl equipo del MarketPlace de los Alpes";
            boolean result = port.enviarCorreoElectronico(to, null, null, from, password, subject, message, null);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }
}
