package co.com.losalpes.marketplace.ws.gestionPO;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class GestionPOSOAPClient
{
  @WebServiceRef
  private static GestionPO_Service gestionPO_Service;

  public static GestionPO getGestionPO()
  {
    gestionPO_Service = new GestionPO_Service();
    GestionPO gestionPO = gestionPO_Service.getGestionPOSOAP();
    return gestionPO;
  }
}
