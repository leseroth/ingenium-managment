package co.com.losalpes.marketplace.ws.gestionDA;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class GestionDASOAPQSPortClient
{
  @WebServiceRef
  private static GestionDASOAPQSService gestionDASOAPQSService;

  public static GestionDA getGestionDA()
  {
    gestionDASOAPQSService = new GestionDASOAPQSService();
    GestionDA gestionDA = gestionDASOAPQSService.getGestionDASOAPQSPort();
    return gestionDA;
  }
}