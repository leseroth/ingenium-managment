package co.com.losalpes.marketplace.ws.contrato;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class Execute_ptClient
{
  @WebServiceRef
  private static AprobarContrato aprobarContrato;

  public static Execute_ptt getExecute_ptt()
  {
    aprobarContrato = new AprobarContrato();
    Execute_ptt execute_ptt = aprobarContrato.getExecute_pt();
    return execute_ptt;
  }
}
