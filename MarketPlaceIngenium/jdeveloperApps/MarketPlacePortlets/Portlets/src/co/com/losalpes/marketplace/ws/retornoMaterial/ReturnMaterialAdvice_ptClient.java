package co.com.losalpes.marketplace.ws.retornoMaterial;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class ReturnMaterialAdvice_ptClient
{
  @WebServiceRef
  private static Returnmaterialadvice_client_ep returnmaterialadvice_client_ep;

  public static ReturnMaterialAdvice getRetornoMaterial()
  {
    returnmaterialadvice_client_ep = new Returnmaterialadvice_client_ep();
    ReturnMaterialAdvice returnMaterialAdvice = returnmaterialadvice_client_ep.getReturnMaterialAdvice_pt();
    return returnMaterialAdvice;
  }
}
