package co.com.losalpes.marketplace.ws.registro;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class RegistroEntidad_ptClient
{
  @WebServiceRef
  private static Registroentidad_client_ep registroentidad_client_ep;

  public static RegistroEntidad getRegistroEntidad()
  {
    registroentidad_client_ep = new Registroentidad_client_ep();
    RegistroEntidad registroEntidad = registroentidad_client_ep.getRegistroEntidad_pt();
    return registroEntidad;
  }
}