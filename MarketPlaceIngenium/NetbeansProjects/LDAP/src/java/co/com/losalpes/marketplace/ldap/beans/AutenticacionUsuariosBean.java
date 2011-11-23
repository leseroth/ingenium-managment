package co.com.losalpes.marketplace.ldap.beans;

import co.com.losalpes.marketplace.ldap.bos.UsuarioBO;
import co.com.losalpes.marketplace.ldap.entities.Usuario;
import co.com.losalpes.marketplace.ldap.exceptions.EstadoNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.RolNoExisteException;
import co.com.losalpes.marketplace.ldap.exceptions.UsuarioNoExisteException;
import co.com.losalpes.marketplace.ldap.utilities.Util;
import co.com.losalpes.marketplace.mailer.ws.MailSendingManagementService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.ws.WebServiceRef;
import co.com.losalpes.marketplace.ldap.utilities.Constants.*;

@Stateless
public class AutenticacionUsuariosBean implements AutenticacionUsuariosRemote, AutenticacionUsuariosLocal {

    private static final String INGENIUM_EMAIL = "ingenium.uniandes@gmail.com";
    private static final String INGENIUM_EMAIL_PASSWORD = "ingenium2011";
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8148/MailSendingManagementService/MailSendingManagement.wsdl")
    private MailSendingManagementService service;
    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioBO crearUsuario(
            String nit, String nombre, String rol, String email, String direccion, String telefono, String codPostal, String codPais)
            throws RolNoExisteException {

        Rol rolMp = Rol.getRol(rol);
        if (rolMp == null) {
            throw new RolNoExisteException("El rol " + rol + " no existe en el sistema");
        }

        Usuario usuario = new Usuario();
        usuario.setEstado(Estado.Activo.toString());
        usuario.setNombre(nombre);
        usuario.setNit(nit);
        usuario.setRol(rol);
        usuario.setLogin(Util.getUniqueLogin(nombre));
        usuario.setPassword(Util.getRandomString(10));
        usuario.setEmail(email);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);
        usuario.setCodPais(codPais);
        usuario.setCodPostal(codPostal);

        em.persist(usuario);
        em.flush();

        return usuario.toBO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioBO actualizarUsuario(
            String nit, String nombre, String rol, String email, String direccion, String telefono, String codPostal, String codPais)
            throws RolNoExisteException, UsuarioNoExisteException {

        Rol rolMp = Rol.getRol(rol);
        if (rolMp == null) {
            throw new RolNoExisteException("El rol " + rol + " no existe en el sistema");
        }

        Query q = em.createNamedQuery("consultarUsuarioPorNitRol");
        q.setParameter("nit", nit);
        q.setParameter("rol", rol);
        List<Usuario> usuarioList = (List<Usuario>) q.getResultList();
        if (usuarioList.isEmpty()) {
            throw new UsuarioNoExisteException("El usuario especificado no existe en el sistema");
        }

        Usuario usuario = usuarioList.get(0);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);
        usuario.setCodPais(codPais);
        usuario.setCodPostal(codPostal);

        em.persist(usuario);
        return usuario.toBO();
    }

    @Override
    public UsuarioBO autenticar(String login, String password) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLoginPsswd");
        q.setParameter("login", login);
        q.setParameter("pwd", password);
        List<Usuario> usuario = (List<Usuario>) q.getResultList();
        if (usuario.isEmpty()) {
            throw new UsuarioNoExisteException("El usuario especificado no existe en el sistema");
        }
        return usuario.get(0).toBO();
    }

    @Override
    public Boolean actualizarEstado(String login, String estado) throws UsuarioNoExisteException, EstadoNoExisteException {
        if (!estado.equals("Activo") || !estado.equals("Inactivo")) {
            throw new EstadoNoExisteException("El estado " + estado + " no representa un estado válido para el sistema.");
        }
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        Usuario u = (Usuario) q.getSingleResult();
        if (u == null) {
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe en el sistema.");
        }
        u.setEstado(estado);
        em.flush();
        return true;
    }

    @Override
    public String obtenerNitUsuario(String login) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>) q.getResultList();
        if (usuarios.isEmpty()) {
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        }
        return usuarios.get(0).getNit();
    }

    @Override
    public Boolean cambiarClave(String login, String nuevaClave) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>) q.getResultList();
        if (usuarios.isEmpty()) {
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        }
        usuarios.get(0).setPassword(nuevaClave);
        em.flush();
        return true;
    }

    @Override
    public Boolean recuperarClave(String login, String email) throws UsuarioNoExisteException {
        Query q = em.createNamedQuery("consultarUsuarioLogin");
        q.setParameter("login", login);
        List<Usuario> usuarios = (List<Usuario>) q.getResultList();
        if (usuarios.isEmpty()) {
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no existe.");
        }
        if (!usuarios.get(0).getEmail().equals(email)) {
            throw new UsuarioNoExisteException("El usuario con el login " + login + " no posee el email especificado.");
        }
        String newPassword = Util.getRandomString(10);
        usuarios.get(0).setPassword(newPassword);

        try { // Call Web Service Operation
            co.com.losalpes.marketplace.mailer.ws.MailSendingManagement port = service.getMailSendingManagementPort();

            java.util.List<java.lang.String> to = new ArrayList<String>();
            to.add(email);
            java.lang.String subject = "Recuperación de clave";
            java.lang.String message = "Estimado " + login + ":\n\nLa nueva clave para ingresar al portal es " + newPassword + ".\n\nCordialmente,\n\nEl equipo del MarketPlace de los Alpes";

            port.sendMail(to, null, null, subject, message, INGENIUM_EMAIL, INGENIUM_EMAIL_PASSWORD, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }
}
