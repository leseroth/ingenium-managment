package co.com.losalpes.marketplace.ws.gestionCliente;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class GestionClienteSOAPQSPortClient
{
  @WebServiceRef
  private static GestionClienteSOAPQSService gestionClienteSOAPQSService;

  public static void main(String [] args)
  {
    gestionClienteSOAPQSService = new GestionClienteSOAPQSService();
    GestionCliente gestionCliente = gestionClienteSOAPQSService.getGestionClienteSOAPQSPort();
    // Add your code to call the desired methods.
  }
  public static GestionCliente getGestionCliente()
  {
          gestionClienteSOAPQSService = new GestionClienteSOAPQSService();
          GestionCliente gestionCliente = gestionClienteSOAPQSService.getGestionClienteSOAPQSPort();
          return gestionCliente;
   }
}
