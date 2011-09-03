package co.com.losalpes.marketplace.ws.actualizacionCuenta;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoActualizacionCuenta/actualizacioncuenta_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
  name="ActualizacionCuenta")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.actualizacionCuenta.types.ObjectFactory.class })
public interface ActualizacionCuenta
{
  @WebMethod(action="process")
  @Action(input="process", output="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta/ActualizacionCuenta/processResponse")
  @ResponseWrapper(localName="processResponse", targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
    className="co.com.loalpes.marketplace.ws.actualizacionCuenta.types.ProcessResponse")
  @RequestWrapper(localName="process", targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
    className="co.com.loalpes.marketplace.ws.actualizacionCuenta.types.Process")
  @WebResult(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
    name="resultado")
  public boolean process(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="nit")
    String nit, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="nombre")
    String nombre, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="direccion")
    String direccion, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="telefono")
    String telefono, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="email")
    String email, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="tipo")
    String tipo, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="calificacion")
    double calificacion, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="razonSocial")
    String razonSocial, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="estado")
    String estado, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="contactos")
    List<co.com.losalpes.marketplace.ws.actualizacionCuenta.types.ContactoActualizacion> contactos,
    @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoActualizacionCuenta/ActualizacionCuenta",
      name="productos")
    List<co.com.losalpes.marketplace.ws.actualizacionCuenta.types.ProductoActualizacion> productos);
}
