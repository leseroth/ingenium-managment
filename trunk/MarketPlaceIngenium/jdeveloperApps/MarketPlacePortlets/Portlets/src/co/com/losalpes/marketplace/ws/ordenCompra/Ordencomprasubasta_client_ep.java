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

@WebServiceClient(wsdlLocation="http://ecos5.virtual.uniandes.edu.co:7001/soa-infra/services/default/ProcesoOrdenCompraSubasta/ordencomprasubasta_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompraSubasta/OrdenCompraSubasta",
  name="ordencomprasubasta_client_ep")
public class Ordencomprasubasta_client_ep
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("co.com.losalpes.marketplace.ws.ordenCompra.Ordencomprasubasta_client_ep");
      URL baseUrl = Ordencomprasubasta_client_ep.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Ordencomprasubasta_client_ep.class.getResource("http://ecos5.virtual.uniandes.edu.co:7001/soa-infra/services/default/ProcesoOrdenCompraSubasta/ordencomprasubasta_client_ep?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://ecos5.virtual.uniandes.edu.co:7001/soa-infra/services/default/ProcesoOrdenCompraSubasta/ordencomprasubasta_client_ep?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://ecos5.virtual.uniandes.edu.co:7001/soa-infra/services/default/ProcesoOrdenCompraSubasta/ordencomprasubasta_client_ep?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://ecos5.virtual.uniandes.edu.co:7001/soa-infra/services/default/ProcesoOrdenCompraSubasta/ordencomprasubasta_client_ep?WSDL",
          e);
    }
  }

  public Ordencomprasubasta_client_ep()
  {
    super(wsdlLocationURL,
          new QName("http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompraSubasta/OrdenCompraSubasta",
                    "ordencomprasubasta_client_ep"));
  }

  public Ordencomprasubasta_client_ep(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="OrdenCompraSubasta_pt")
  public co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta getOrdenCompraSubasta_pt()
  {
    return (co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompraSubasta/OrdenCompraSubasta",
                                                                                                   "OrdenCompraSubasta_pt"),
                                                                                         co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta.class);
  }

  @WebEndpoint(name="OrdenCompraSubasta_pt")
  public co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta getOrdenCompraSubasta_pt(WebServiceFeature... features)
  {
    return (co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace/ProcesoOrdenCompraSubasta/OrdenCompraSubasta",
                                                                                                   "OrdenCompraSubasta_pt"),
                                                                                         co.com.losalpes.marketplace.ws.ordenCompra.OrdenCompraSubasta.class,
                                                                                         features);
  }
}