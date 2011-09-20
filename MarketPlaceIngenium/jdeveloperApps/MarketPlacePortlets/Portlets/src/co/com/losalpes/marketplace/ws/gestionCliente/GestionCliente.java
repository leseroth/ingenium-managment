package co.com.losalpes.marketplace.ws.gestionCliente;

import co.com.losalpes.marketplace.ws.types.ObjectFactory;

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

@WebService(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/marketPlace/proxy/GestionCliente?wsdl",
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
  public co.com.losalpes.marketplace.ws.types.CrearClienteResponse crearCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="crearCliente")
    co.com.losalpes.marketplace.ws.types.CrearCliente parameters);

  @WebMethod(operationName="CrearContactos", action="http://marketplace.losalpes.com.co/GestionCliente/CrearContactos")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/CrearContactos",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/CrearContactosResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="crearContactoResponse")
  public co.com.losalpes.marketplace.ws.types.CrearContactoResponse crearContactos(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="crearContacto")
    co.com.losalpes.marketplace.ws.types.CrearContacto parameters);

  @WebMethod(operationName="ConsultarCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarClienteResponse")
  public co.com.losalpes.marketplace.ws.types.ConsultarClienteResponse consultarCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarCliente")
    co.com.losalpes.marketplace.ws.types.ConsultarCliente parameters);

  @WebMethod(operationName="ConsultarComision", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarComision")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarComision",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarComisionResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarComisionResponse")
  public co.com.losalpes.marketplace.ws.types.ConsultarComisionResponse consultarComision(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarComision")
    co.com.losalpes.marketplace.ws.types.ConsultarComision parameters);

  @WebMethod(operationName="ModificarCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ModificarCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ModificarCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ModificarClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="modificarClienteResponse")
  public co.com.losalpes.marketplace.ws.types.ModificarClienteResponse modificarCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="modificarCliente")
    co.com.losalpes.marketplace.ws.types.ModificarCliente parameters);

  @WebMethod(operationName="ModificarComision", action="http://marketplace.losalpes.com.co/GestionCliente/ModificarComision")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ModificarComision",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ModificarComisionResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="modificarComisionResponse")
  public co.com.losalpes.marketplace.ws.types.ModificarComisionResponse modificarComision(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="modificarComision")
    co.com.losalpes.marketplace.ws.types.ModificarComision parameters);

  @WebMethod(operationName="ConsultarClientesProducto", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientesProducto")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarClientesProducto",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarClientesProductoResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarClientesProductoResponse")
  public co.com.losalpes.marketplace.ws.types.ConsultarClientesProductoResponse consultarClientesProducto(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarClientesProducto")
    co.com.losalpes.marketplace.ws.types.ConsultarClientesProducto parameters);

  @WebMethod(operationName="RadicarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/RadicarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/RadicarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/RadicarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="radicarSolicitudResponse")
  public co.com.losalpes.marketplace.ws.types.RadicarSolicitudResponse radicarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="radicarSolicitud")
    co.com.losalpes.marketplace.ws.types.RadicarSolicitud parameters);

  @WebMethod(operationName="ActualizarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarSolicitudResponse")
  public co.com.losalpes.marketplace.ws.types.ActualizarSolicitudResponse actualizarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarSolicitud")
    co.com.losalpes.marketplace.ws.types.ActualizarSolicitud parameters);

  @WebMethod(operationName="ActualizarEstadoCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarEstadoClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarEstadoClienteResponse")
  public co.com.losalpes.marketplace.ws.types.ActualizarEstadoClienteResponse actualizarEstadoCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarEstadoCliente")
    co.com.losalpes.marketplace.ws.types.ActualizarEstadoCliente parameters);

  @WebMethod(operationName="ActualizarEstadoSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ActualizarEstadoSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ActualizarEstadoSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="actualizarEstadoSolicitudResponse")
  public co.com.losalpes.marketplace.ws.types.ActualizarEstadoSolicitudResponse actualizarEstadoSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="actualizarEstadoSolicitud")
    co.com.losalpes.marketplace.ws.types.ActualizarEstadoSolicitud parameters);

  @WebMethod(operationName="CerrarSolicitud", action="http://marketplace.losalpes.com.co/GestionCliente/CerrarSolicitud")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/CerrarSolicitud",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/CerrarSolicitudResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="cerrarSolicitudResponse")
  public co.com.losalpes.marketplace.ws.types.CerrarSolicitudResponse cerrarSolicitud(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="cerrarSolicitud")
    co.com.losalpes.marketplace.ws.types.CerrarSolicitud parameters);

  @WebMethod(operationName="ConsultarProductosCliente", action="http://marketplace.losalpes.com.co/GestionCliente/ConsultarProductosCliente")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="http://marketplace.losalpes.com.co/GestionCliente/ConsultarProductosCliente",
    output="http://marketplace.losalpes.com.co/GestionCliente/GestionCliente/ConsultarProductosClienteResponse")
  @WebResult(targetNamespace="http://marketplace.losalpes.com.co",
    partName="parameters", name="consultarProductosClienteResponse")
  public co.com.losalpes.marketplace.ws.types.ConsultarProductosClienteResponse consultarProductosCliente(@WebParam(targetNamespace="http://marketplace.losalpes.com.co",
      partName="parameters", name="consultarProductosCliente")
    co.com.losalpes.marketplace.ws.types.ConsultarProductosCliente parameters);
}