package co.com.losalpes.marketplace.ws.ordenCompraDirecta;

import co.com.losalpes.marketplace.ws.ordenCompraDirecta.types.Process;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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

@WebService(wsdlLocation="http://localhost:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorderdirect_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompra/PurchaseOrderDirect",
  name="PurchaseOrderDirect")
@XmlSeeAlso(
  { co.com.losalpes.marketplace.ws.types.ObjectFactory.class })
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public interface PurchaseOrderDirect
{
  @WebMethod(action="process")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="process")
  @Oneway
  public void process(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompra/PurchaseOrderDirect",
      partName="payload", name="process")
    Process payload);

  @WebMethod(operationName="Aprobar", action="Aprobar")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="Aprobar")
  @Oneway
  public void aprobar(@WebParam(targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompra/PurchaseOrderDirect",
      partName="abcde", name="aprobacion")
    co.com.losalpes.marketplace.ws.ordenCompraDirecta.types.Aprobacion abcde);
}