package co.com.losalpes.marketplace.ws.avisoDespacho;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class DispatchAdvice_ptClient
{
  @WebServiceRef
  private static Dispatchadvice_client_ep dispatchadvice_client_ep;

  public static DispatchAdvice getAvisoDespacho()
  {
    dispatchadvice_client_ep = new Dispatchadvice_client_ep();
    DispatchAdvice dispatchAdvice = dispatchadvice_client_ep.getDispatchAdvice_pt();
    return dispatchAdvice;
  }
}
