package co.com.losalpes.marketplace.ws.replicacionPricat;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebService(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoPricat/replicacionpricat_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
  name="ReplicacionPricat")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.replicacionPricat.types.ObjectFactory.class })
public interface ReplicacionPricat
{
  @WebMethod(action="process")
  @Action(input="process")
  @RequestWrapper(localName="process", targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
    className="co.com.losalpes.marketplace.ws.replicacionPricat.types.Process")
  @Oneway
  public void process(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
      name="nitFabricante")
    String nitFabricante, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
      name="nombreProducto")
    String nombreProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
      name="categoriaProducto")
    String categoriaProducto, @WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat",
      name="referenciaProducto")
    String referenciaProducto);
}
