package co.com.losalpes.marketplace.ws.ldapRol;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://localhost:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl",
  targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/", name="LDAPAuthenticationManagement")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.ldapRol.types.ObjectFactory.class })
public interface LDAPAuthenticationManagement
{
  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/crearUsuarioRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/crearUsuario/Fault/RolNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.RolNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/crearUsuarioResponse")
  @ResponseWrapper(localName="crearUsuarioResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.CrearUsuarioResponse")
  @RequestWrapper(localName="crearUsuario", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.CrearUsuario")
  @WebResult(targetNamespace="")
  public co.com.losalpes.marketplace.ws.ldapRol.types.UsuarioBO crearUsuario(@WebParam(targetNamespace="",
      name="nit")
    String nit, @WebParam(targetNamespace="", name="nombre")
    String nombre, @WebParam(targetNamespace="", name="rol")
    String rol, @WebParam(targetNamespace="", name="email")
    String email, @WebParam(targetNamespace="", name="direccion")
    String direccion, @WebParam(targetNamespace="", name="telefono")
    String telefono, @WebParam(targetNamespace="", name="codPostal")
    String codPostal, @WebParam(targetNamespace="", name="codPais")
    String codPais)
    throws co.com.losalpes.marketplace.ws.ldapRol.RolNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarUsuarioRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarUsuario/Fault/RolNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.RolNoExisteException.class),
        @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarUsuario/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarUsuarioResponse")
  @ResponseWrapper(localName="actualizarUsuarioResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ActualizarUsuarioResponse")
  @RequestWrapper(localName="actualizarUsuario", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ActualizarUsuario")
  @WebResult(targetNamespace="")
  public co.com.losalpes.marketplace.ws.ldapRol.types.UsuarioBO actualizarUsuario(@WebParam(targetNamespace="",
      name="nit")
    String nit, @WebParam(targetNamespace="", name="nombre")
    String nombre, @WebParam(targetNamespace="", name="rol")
    String rol, @WebParam(targetNamespace="", name="email")
    String email, @WebParam(targetNamespace="", name="direccion")
    String direccion, @WebParam(targetNamespace="", name="telefono")
    String telefono, @WebParam(targetNamespace="", name="codPostal")
    String codPostal, @WebParam(targetNamespace="", name="codPais")
    String codPais)
    throws co.com.losalpes.marketplace.ws.ldapRol.RolNoExisteException, co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/autenticarRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/autenticar/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/autenticarResponse")
  @ResponseWrapper(localName="autenticarResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.AutenticarResponse")
  @RequestWrapper(localName="autenticar", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.Autenticar")
  @WebResult(targetNamespace="")
  public co.com.losalpes.marketplace.ws.ldapRol.types.UsuarioBO autenticar(@WebParam(targetNamespace="",
      name="login")
    String login, @WebParam(targetNamespace="", name="password")
    String password)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarEstadoUsuarioRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarEstadoUsuario/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class),
        @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarEstadoUsuario/Fault/EstadoNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.EstadoNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/actualizarEstadoUsuarioResponse")
  @ResponseWrapper(localName="actualizarEstadoUsuarioResponse",
    targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ActualizarEstadoUsuarioResponse")
  @RequestWrapper(localName="actualizarEstadoUsuario", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ActualizarEstadoUsuario")
  @WebResult(targetNamespace="")
  public Boolean actualizarEstadoUsuario(@WebParam(targetNamespace="",
      name="login")
    String login, @WebParam(targetNamespace="", name="estado")
    String estado)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException, co.com.losalpes.marketplace.ws.ldapRol.EstadoNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerNitUsuarioRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerNitUsuario/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerNitUsuarioResponse")
  @ResponseWrapper(localName="obtenerNitUsuarioResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ObtenerNitUsuarioResponse")
  @RequestWrapper(localName="obtenerNitUsuario", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ObtenerNitUsuario")
  @WebResult(targetNamespace="")
  public String obtenerNitUsuario(@WebParam(targetNamespace="", name="login")
    String login)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/cambiarClaveRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/cambiarClave/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/cambiarClaveResponse")
  @ResponseWrapper(localName="cambiarClaveResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.CambiarClaveResponse")
  @RequestWrapper(localName="cambiarClave", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.CambiarClave")
  @WebResult(targetNamespace="")
  public Boolean cambiarClave(@WebParam(targetNamespace="", name="login")
    String login, @WebParam(targetNamespace="", name="nuevaClave")
    String nuevaClave)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/recuperarClaveRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/recuperarClave/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/recuperarClaveResponse")
  @ResponseWrapper(localName="recuperarClaveResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.RecuperarClaveResponse")
  @RequestWrapper(localName="recuperarClave", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.RecuperarClave")
  @WebResult(targetNamespace="")
  public Boolean recuperarClave(@WebParam(targetNamespace="", name="login")
    String login, @WebParam(targetNamespace="", name="email")
    String email)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;

  @WebMethod
  @Action(input="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerRolRequest", fault =
      { @FaultAction(value="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerRol/Fault/UsuarioNoExisteException",
          className=co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException.class) },
    output="http://ws.ldap.marketplace.losalpes.com.co/LDAPAuthenticationManagement/obtenerRolResponse")
  @ResponseWrapper(localName="obtenerRolResponse", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ObtenerRolResponse")
  @RequestWrapper(localName="obtenerRol", targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.ldapRol.types.ObtenerRol")
  @WebResult(targetNamespace="")
  public String obtenerRol(@WebParam(targetNamespace="", name="nit")
    String nit)
    throws co.com.losalpes.marketplace.ws.ldapRol.UsuarioNoExisteException;
}
