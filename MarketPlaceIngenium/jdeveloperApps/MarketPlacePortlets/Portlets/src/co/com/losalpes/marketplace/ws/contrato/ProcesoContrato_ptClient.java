package co.com.losalpes.marketplace.ws.contrato;

import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.addressing.WSEndpointReference;
import com.sun.xml.ws.developer.WSBindingProvider;
import com.sun.xml.ws.message.StringHeader;

import java.util.UUID;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class ProcesoContrato_ptClient
{
  @WebServiceRef
  private static Procesocontrato_client_ep procesocontrato_client_ep;

  private static final AddressingVersion WS_ADDR_VER = AddressingVersion.W3C;

  public static ProcesoContrato getProcesoContrato()
  {
    procesocontrato_client_ep = new Procesocontrato_client_ep();
    ProcesoContrato procesoContrato = procesocontrato_client_ep.getProcesoContrato_pt();
    return procesoContrato;
  }
}
