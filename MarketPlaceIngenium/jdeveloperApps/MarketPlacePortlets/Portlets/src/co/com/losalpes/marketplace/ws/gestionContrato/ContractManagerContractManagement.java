package co.com.losalpes.marketplace.ws.gestionContrato;

import java.util.List;

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

@WebService(wsdlLocation="http://localhost:7001/marketPlace/proxy/GestionContrato?wsdl",
  targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
  name="ContractManagerContractManagement")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.types.ObjectFactory.class })
public interface ContractManagerContractManagement
{
  @WebMethod
  @Action(input="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/registrarContratoRequest", fault =
      { @FaultAction(value="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/registrarContrato/Fault/ContratoException",
          className=co.com.losalpes.marketplace.ws.gestionContrato.ContratoException.class) },
    output="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/registrarContratoResponse")
  @ResponseWrapper(localName="registrarContratoResponse", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.RegistrarContratoResponse")
  @RequestWrapper(localName="registrarContrato", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.RegistrarContrato")
  @WebResult(targetNamespace="")
  public Long registrarContrato(@WebParam(targetNamespace="", name="contratoBO")
    co.com.losalpes.marketplace.ws.types.ContratoBO contratoBO)
    throws co.com.losalpes.marketplace.ws.gestionContrato.ContratoException;

  @WebMethod
  @Action(input="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/actualizarContratoRequest", fault =
      { @FaultAction(value="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/actualizarContrato/Fault/ContratoNoExisteException",
          className=co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException.class) },
    output="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/actualizarContratoResponse")
  @ResponseWrapper(localName="actualizarContratoResponse",
    targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ActualizarContratoResponse")
  @RequestWrapper(localName="actualizarContrato", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ActualizarContrato")
  @WebResult(targetNamespace="")
  public boolean actualizarContrato(@WebParam(targetNamespace="", name="contratoBO")
    co.com.losalpes.marketplace.ws.types.ContratoBO contratoBO)
    throws co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException;

  @WebMethod
  @Action(input="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosFabricanteRequest", fault =
      { @FaultAction(value="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosFabricante/Fault/ContratoNoExisteException",
          className=co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException.class) },
    output="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosFabricanteResponse")
  @ResponseWrapper(localName="consultarContratosFabricanteResponse",
    targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContratosFabricanteResponse")
  @RequestWrapper(localName="consultarContratosFabricante",
    targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContratosFabricante")
  @WebResult(targetNamespace="")
  public List<co.com.losalpes.marketplace.ws.types.ContratoBO> consultarContratosFabricante(@WebParam(targetNamespace="",
      name="nit")
    String nit, @WebParam(targetNamespace="", name="estado")
    String estado)
    throws co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException;

  @WebMethod
  @Action(input="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratoRequest", fault =
      { @FaultAction(value="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContrato/Fault/ContratoNoExisteException",
          className=co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException.class) },
    output="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratoResponse")
  @ResponseWrapper(localName="consultarContratoResponse", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContratoResponse")
  @RequestWrapper(localName="consultarContrato", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContrato")
  @WebResult(targetNamespace="")
  public co.com.losalpes.marketplace.ws.types.ContratoBO consultarContrato(@WebParam(targetNamespace="",
      name="idContrato")
    long idContrato)
    throws co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException;

  @WebMethod
  @Action(input="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosComercioRequest", fault =
      { @FaultAction(value="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosComercio/Fault/ContratoNoExisteException",
          className=co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException.class) },
    output="http://ws.contractmanager.marketplace.losalpes.com.co/ContractManagerContractManagement/consultarContratosComercioResponse")
  @ResponseWrapper(localName="consultarContratosComercioResponse",
    targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContratosComercioResponse")
  @RequestWrapper(localName="consultarContratosComercio", targetNamespace="http://ws.contractmanager.marketplace.losalpes.com.co/",
    className="co.com.losalpes.marketplace.ws.types.ConsultarContratosComercio")
  @WebResult(targetNamespace="")
  public List<co.com.losalpes.marketplace.ws.types.ContratoBO> consultarContratosComercio(@WebParam(targetNamespace="",
      name="nit")
    String nit, @WebParam(targetNamespace="", name="estado")
    String estado)
    throws co.com.losalpes.marketplace.ws.gestionContrato.ContratoNoExisteException;
}
