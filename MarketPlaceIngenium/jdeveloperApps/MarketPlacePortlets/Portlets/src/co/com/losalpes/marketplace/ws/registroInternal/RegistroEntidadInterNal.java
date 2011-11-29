package co.com.losalpes.marketplace.ws.registroInternal;

import co.com.losalpes.marketplace.ws.registroInternal.types.ContactoCliente;
import co.com.losalpes.marketplace.ws.registroInternal.types.DocumentoSolicitud;
import co.com.losalpes.marketplace.ws.registroInternal.types.ObjectFactory;
import co.com.losalpes.marketplace.ws.registroInternal.types.ProductoSolicitud;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
  name="RegistroEntidadInterNal")
@XmlSeeAlso(
  { ObjectFactory.class })
public interface RegistroEntidadInterNal
{
  @WebMethod(action="process")
  @Action(input="process")
  @RequestWrapper(localName="process", targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
    className="co.com.losalpes.marketplace.ws.registroInternal.types.Process")
  @Oneway
  public void process(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="nit")
    String nit, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="nombre")
    String nombre, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="direccion")
    String direccion, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="telefono")
    String telefono, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="email")
    String email, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="tipo")
    String tipo, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="razonSocial")
    String razonSocial, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="contactos")
    List<ContactoCliente> contactos, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="fecha")
    XMLGregorianCalendar fecha, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="documentos")
    List<DocumentoSolicitud> documentos, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="productos")
    List<ProductoSolicitud> productos, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="Categoria")
    String categoria, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="CodPais")
    String codPais, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
      name="CodPostal")
    String codPostal);
}
