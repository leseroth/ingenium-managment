package co.com.losalpes.marketplace.ws.ordenCompra;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

@WebServiceClient(wsdlLocation="http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorder_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace_jws/ProcesoOrdenCompra/PurchaseOrder",
  name="purchaseorder_client_ep")
public class Purchaseorder_client_ep
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("co.com.losalpes.marketplace.ws.ordenCompra.Purchaseorder_client_ep");
      URL baseUrl = Purchaseorder_client_ep.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Purchaseorder_client_ep.class.getResource("http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorder_client_ep?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorder_client_ep?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorder_client_ep?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://portal.marketplace.losalpes.com.co:7001/soa-infra/services/default/ProcesoOrdenCompra/purchaseorder_client_ep?WSDL",
          e);
    }
  }

  public Purchaseorder_client_ep()
  {
    super(wsdlLocationURL,
          new QName("http://xmlns.oracle.com/MarketPlace_jws/ProcesoOrdenCompra/PurchaseOrder",
                    "purchaseorder_client_ep"));
  }

  public Purchaseorder_client_ep(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="PurchaseOrder_pt")
  public co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder getPurchaseOrder_pt()
  {
    return (co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace_jws/ProcesoOrdenCompra/PurchaseOrder",
                                                                                              "PurchaseOrder_pt"),
                                                                                    co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder.class);
  }

  @WebEndpoint(name="PurchaseOrder_pt")
  public co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder getPurchaseOrder_pt(WebServiceFeature... features)
  {
    return (co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace_jws/ProcesoOrdenCompra/PurchaseOrder",
                                                                                              "PurchaseOrder_pt"),
                                                                                    co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder.class,
                                                                                    features);
  }
}