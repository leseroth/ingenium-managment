package co.com.losalpes.marketplace.ws.actualizacionCuenta;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class ActualizacionCuenta_ptClient
{
  @WebServiceRef
  private static Actualizacioncuenta_client_ep actualizacioncuenta_client_ep;

  public static ActualizacionCuenta getActualizacionCuenta()
  {
    actualizacioncuenta_client_ep = new Actualizacioncuenta_client_ep();
    ActualizacionCuenta actualizacionCuenta = actualizacioncuenta_client_ep.getActualizacionCuenta_pt();
    return actualizacionCuenta;
  }
}