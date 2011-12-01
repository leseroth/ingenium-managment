package co.com.losalpes.marketplace.ws.gestionCliente;

import co.com.losalpes.marketplace.ws.types.ActualizarEstadoCliente;
import co.com.losalpes.marketplace.ws.types.ActualizarEstadoClienteResponse;
import co.com.losalpes.marketplace.ws.types.ActualizarEstadoSolicitud;
import co.com.losalpes.marketplace.ws.types.ActualizarEstadoSolicitudResponse;
import co.com.losalpes.marketplace.ws.types.ActualizarSolicitud;
import co.com.losalpes.marketplace.ws.types.ActualizarSolicitudResponse;
import co.com.losalpes.marketplace.ws.types.CerrarSolicitud;
import co.com.losalpes.marketplace.ws.types.CerrarSolicitudResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarCliente;
import co.com.losalpes.marketplace.ws.types.ConsultarClienteResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarClientes;
import co.com.losalpes.marketplace.ws.types.ConsultarClientesProducto;
import co.com.losalpes.marketplace.ws.types.ConsultarClientesProductoResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarClientesResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarComision;
import co.com.losalpes.marketplace.ws.types.ConsultarComisionResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarProductosCliente;
import co.com.losalpes.marketplace.ws.types.ConsultarProductosClienteResponse;
import co.com.losalpes.marketplace.ws.types.CrearCliente;
import co.com.losalpes.marketplace.ws.types.CrearClienteResponse;
import co.com.losalpes.marketplace.ws.types.CrearContacto;
import co.com.losalpes.marketplace.ws.types.CrearContactoResponse;
import co.com.losalpes.marketplace.ws.types.ModificarCliente;
import co.com.losalpes.marketplace.ws.types.ModificarClienteResponse;
import co.com.losalpes.marketplace.ws.types.ModificarComision;
import co.com.losalpes.marketplace.ws.types.ModificarComisionResponse;
import co.com.losalpes.marketplace.ws.types.ObjectFactory;
import co.com.losalpes.marketplace.ws.types.RadicarSolicitud;
import co.com.losalpes.marketplace.ws.types.RadicarSolicitudResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl",
  targetNamespace="http://marketplace.losalpes.com.co/GestionCliente",
  name="GestionCliente")
@XmlSeeAlso(
  { ObjectFactory.class })
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public interface GestionCliente
{
  @WebMethod(operationName="CrearCliente", action="http://marketplace.losalpes.com.co/GestionCliente/CrearCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/CrearCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/CrearClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="crearClienteResponse")
  public CrearClienteResponse crearCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="crearCliente")
    CrearCliente parameters);

  @WebMethod(operationName="CrearContactos", action="http://marketplace.losalpes.com.co/GestionCliente/CrearContactos")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/CrearContactos",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/CrearContactosResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="crearContactoResponse")
  public CrearContactoResponse crearContactos(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="crearContacto")
    CrearContacto parameters);

  @WebMethod(operationName="ConsultarCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarClienteResponse")
  public ConsultarClienteResponse consultarCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarCliente")
    ConsultarCliente parameters);

  @WebMethod(operationName="ConsultarClientes", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientes")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientes",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarClientesResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarClientesResponse")
  public ConsultarClientesResponse consultarClientes(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarClientes")
    ConsultarClientes parameters);

  @WebMethod(operationName="ConsultarComision", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarComision")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarComision",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarComisionResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarComisionResponse")
  public ConsultarComisionResponse consultarComision(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarComision")
    ConsultarComision parameters);

  @WebMethod(operationName="ModificarCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ModificarCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ModificarCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ModificarClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="modificarClienteResponse")
  public ModificarClienteResponse modificarCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="modificarCliente")
    ModificarCliente parameters);

  @WebMethod(operationName="ModificarComision", action="http://marketplace.losalpes.com.co/GestionCliente/ModificarComision")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ModificarComision",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ModificarComisionResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="modificarComisionResponse")
  public ModificarComisionResponse modificarComision(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="modificarComision")
    ModificarComision parameters);

  @WebMethod(operationName="ConsultarClientesProducto", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientesProducto")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientesProducto",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarClientesProductoResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarClientesProductoResponse")
  public ConsultarClientesProductoResponse consultarClientesProducto(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarClientesProducto")
    ConsultarClientesProducto parameters);

  @WebMethod(operationName="RadicarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/RadicarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/RadicarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/RadicarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="radicarSolicitudResponse")
  public RadicarSolicitudResponse radicarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="radicarSolicitud")
    RadicarSolicitud parameters);

  @WebMethod(operationName="ActualizarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarSolicitudResponse")
  public ActualizarSolicitudResponse actualizarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarSolicitud")
    ActualizarSolicitud parameters);

  @WebMethod(operationName="ActualizarEstadoCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarEstadoClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarEstadoClienteResponse")
  public ActualizarEstadoClienteResponse actualizarEstadoCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarEstadoCliente")
    ActualizarEstadoCliente parameters);

  @WebMethod(operationName="ActualizarEstadoSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarEstadoSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarEstadoSolicitudResponse")
  public ActualizarEstadoSolicitudResponse actualizarEstadoSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarEstadoSolicitud")
    ActualizarEstadoSolicitud parameters);

  @WebMethod(operationName="CerrarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/CerrarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/CerrarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/CerrarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="cerrarSolicitudResponse")
  public CerrarSolicitudResponse cerrarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="cerrarSolicitud")
    CerrarSolicitud parameters);

  @WebMethod(operationName="ConsultarProductosCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarProductosCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarProductosCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarProductosClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarProductosClienteResponse")
  public ConsultarProductosClienteResponse consultarProductosCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarProductosCliente")
    ConsultarProductosCliente parameters);
}
