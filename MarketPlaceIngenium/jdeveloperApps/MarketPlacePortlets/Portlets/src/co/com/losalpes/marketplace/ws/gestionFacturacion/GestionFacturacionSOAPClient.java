package co.com.losalpes.marketplace.ws.gestionFacturacion;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class GestionFacturacionSOAPClient
{
  @WebServiceRef
  private static GestionFacturacion_Service gestionFacturacion_Service;

  public static GestionFacturacion getGestionFacturacion()
  {
    gestionFacturacion_Service = new GestionFacturacion_Service();
    GestionFacturacion gestionFacturacion = gestionFacturacion_Service.getGestionFacturacionSOAP();
    return gestionFacturacion;
  }
}
