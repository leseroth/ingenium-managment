package co.com.co.com;

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

@WebServiceClient(wsdlLocation="http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl",
  targetNamespace="http://marketplace.losalpes.com.co/GestionCliente",
  name="GestionCliente")
public class GestionCliente_Service
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("co.com.co.com.GestionCliente_Service");
      URL baseUrl = GestionCliente_Service.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            GestionCliente_Service.class.getResource("http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://ecos5.virtual.uniandes.edu.co:7001/marketPlace/proxy/GestionCliente?wsdl",
          e);
    }
  }

  public GestionCliente_Service()
  {
    super(wsdlLocationURL,
          new QName("http://marketplace.losalpes.com.co/GestionCliente",
                    "GestionCliente"));
  }

  public GestionCliente_Service(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="GestionClienteSOAP")
  public co.com.co.com.GestionCliente getGestionClienteSOAP()
  {
    return (co.com.co.com.GestionCliente) super.getPort(new QName("http://marketplace.losalpes.com.co/GestionCliente",
                                                                  "GestionClienteSOAP"),
                                                        co.com.co.com.GestionCliente.class);
  }

  @WebEndpoint(name="GestionClienteSOAP")
  public co.com.co.com.GestionCliente getGestionClienteSOAP(WebServiceFeature... features)
  {
    return (co.com.co.com.GestionCliente) super.getPort(new QName("http://marketplace.losalpes.com.co/GestionCliente",
                                                                  "GestionClienteSOAP"),
                                                        co.com.co.com.GestionCliente.class,
                                                        features);
  }
}
