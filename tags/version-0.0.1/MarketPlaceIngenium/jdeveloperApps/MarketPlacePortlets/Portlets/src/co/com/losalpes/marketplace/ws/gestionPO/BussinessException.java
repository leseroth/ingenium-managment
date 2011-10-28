package co.com.losalpes.marketplace.ws.gestionPO;

import javax.xml.ws.WebFault;

@WebFault(faultBean="co.com.losalpes.marketplace.ws.types.BussinessException",
  targetNamespace="http://ws.pomanager.marketplace.losalpes.com.co/",
  name="BussinessException")
public class BussinessException
  extends Exception
{
  private co.com.losalpes.marketplace.ws.types.BussinessException faultInfo;

  public BussinessException(String message,
                            co.com.losalpes.marketplace.ws.types.BussinessException faultInfo)
  {
    super(message);
    this.faultInfo = faultInfo;
  }

  public BussinessException(String message,
                            co.com.losalpes.marketplace.ws.types.BussinessException faultInfo,
                            Throwable t)
  {
    super(message,t);
    this.faultInfo = faultInfo;
  }

  public co.com.losalpes.marketplace.ws.types.BussinessException getFaultInfo()
  {
    return faultInfo;
  }

  public void setFaultInfo(co.com.losalpes.marketplace.ws.types.BussinessException faultInfo)
  {
    this.faultInfo = faultInfo;
  }
}
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)
