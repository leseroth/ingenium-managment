package co.com.losalpes.marketplace.ws.gestionRMA;

import co.com.losalpes.marketplace.ws.types.ObjectFactory;
import co.com.losalpes.marketplace.ws.types.ReturnMaterialAdvice;

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

@WebService(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/marketPlace/proxy/GestionRMA?wsdl",
  targetNamespace="http://marketplace.losalpes.com.co/GestionRMA", name="GestionRMA")
@XmlSeeAlso(
  { ObjectFactory.class })
public interface GestionRMA
{
  @WebMethod(action="http://marketplace.losalpes.com.co/GestionRMA/registrarRMA")
  @Action(input="http://marketplace.losalpes.com.co/GestionRMA/registrarRMA",
    output="http://marketplace.losalpes.com.co/GestionRMA/GestionRMA/registrarRMAResponse")
  @ResponseWrapper(localName="registrarRMAResponse", targetNamespace="http://marketplace.losalpes.com.co",
    className="co.com.losalpes.marketplace.ws.types.RegistrarRMAResponse")
  @RequestWrapper(localName="registrarRMA", targetNamespace="http://marketplace.losalpes.com.co",
    className="co.com.losalpes.marketplace.ws.types.RegistrarRMA")
  @WebResult(targetNamespace="", name="numSeguimiento")
  public String registrarRMA(@WebParam(targetNamespace="", name="rma")
    ReturnMaterialAdvice rma);

  @WebMethod(action="http://marketplace.losalpes.com.co/GestionRMA/consultarRMAsComercio")
  @Action(input="http://marketplace.losalpes.com.co/GestionRMA/consultarRMAsComercio",
    output="http://marketplace.losalpes.com.co/GestionRMA/GestionRMA/consultarRMAsComercioResponse")
  @ResponseWrapper(localName="consultarRMAsComercioResponse",
    targetNamespace="http://marketplace.losalpes.com.co", className="co.com.losalpes.marketplace.ws.types.ConsultarRMAsComercioResponse")
  @RequestWrapper(localName="consultarRMAsComercio", targetNamespace="http://marketplace.losalpes.com.co",
    className="co.com.losalpes.marketplace.ws.types.ConsultarRMAsComercio")
  @WebResult(targetNamespace="", name="rmas")
  public List<ReturnMaterialAdvice> consultarRMAsComercio(@WebParam(targetNamespace="",
      name="nitComercio")
    String nitComercio);

  @WebMethod(action="http://marketplace.losalpes.com.co/GestionRMA/consultarRMAsFabricante")
  @Action(input="http://marketplace.losalpes.com.co/GestionRMA/consultarRMAsFabricante",
    output="http://marketplace.losalpes.com.co/GestionRMA/GestionRMA/consultarRMAsFabricanteResponse")
  @ResponseWrapper(localName="consultarRMAsFabricanteResponse",
    targetNamespace="http://marketplace.losalpes.com.co", className="co.com.losalpes.marketplace.ws.types.ConsultarRMAsComercioResponse")
  @RequestWrapper(localName="consultarRMAsFabricante", targetNamespace="http://marketplace.losalpes.com.co",
    className="co.com.losalpes.marketplace.ws.types.ConsultarRMAsComercio")
  @WebResult(targetNamespace="", name="rmas")
  public List<ReturnMaterialAdvice> consultarRMAsFabricante(@WebParam(targetNamespace="",
      name="nitComercio")
    String nitComercio);
}
