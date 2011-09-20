package co.com.losalpes.marketplace.ws.avisoDespacho;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoAvisoDespacho/dispatchadvice_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
  name="DispatchAdvice")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.avisoDespacho.types.ObjectFactory.class })
public interface DispatchAdvice
{
  @WebMethod(action="process")
  @Action(input="process")
  @RequestWrapper(localName="process", targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
    className="co.com.losalpes.marketplace.ws.avisoDespacho.types.Process")
  @Oneway
  public void process(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="fechaEmision")
    XMLGregorianCalendar fechaEmision, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="fechaLlegada")
    XMLGregorianCalendar fechaLlegada, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="montoOperacion")
    long montoOperacion, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="camiones")
    String camiones, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="cantidadProducto")
    int cantidadProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="nombreProducto")
    String nombreProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="categoriaProducto")
    String categoriaProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="referenciaProducto")
    String referenciaProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="numSeguimientoPO")
    String numSeguimientoPO, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="nombreFabricante")
    String nombreFabricante, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="nitFabricante")
    String nitFabricante, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoAvisoDespacho/DispatchAdvice",
      name="emailFabricante")
    String emailFabricante);
}