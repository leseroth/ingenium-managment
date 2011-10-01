package co.com.losalpes.marketplace.ws.confirmacionPago;

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

public class ConfirmacionPago_ptClient
{
  @WebServiceRef
  private static Confirmacionpago_client_ep confirmacionpago_client_ep;

  private static final AddressingVersion WS_ADDR_VER = AddressingVersion.W3C;

  public static ConfirmacionPago getConfirmacionPago()
  {
    confirmacionpago_client_ep = new Confirmacionpago_client_ep();
    ConfirmacionPago confirmacionPago = confirmacionpago_client_ep.getConfirmacionPago_pt();
    // Get the request context to set the outgoing addressing properties
    WSBindingProvider wsbp = (WSBindingProvider)confirmacionPago;
    WSEndpointReference replyTo =
      new WSEndpointReference("http://<replace with the URL of the callback service>", WS_ADDR_VER);
    String uuid = "uuid:" + UUID.randomUUID();

    wsbp.setOutboundHeaders( new StringHeader(WS_ADDR_VER.messageIDTag, uuid), replyTo.createHeader(WS_ADDR_VER.replyToTag));

    return confirmacionPago;
  }
}
