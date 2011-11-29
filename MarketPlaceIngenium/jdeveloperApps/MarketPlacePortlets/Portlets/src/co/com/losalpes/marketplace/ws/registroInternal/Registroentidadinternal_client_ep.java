package co.com.losalpes.marketplace.ws.registroInternal;

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

@WebServiceClient(wsdlLocation="http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL",
  targetNamespace="http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
  name="registroentidadinternal_client_ep")
public class Registroentidadinternal_client_ep
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("co.com.losalpes.marketplace.ws.registroInternal.Registroentidadinternal_client_ep");
      URL baseUrl =
        Registroentidadinternal_client_ep.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Registroentidadinternal_client_ep.class.getResource("http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://User-PC:7001/soa-infra/services/default/ProcesoRegistroInterNal/registroentidadinternal_client_ep?WSDL",
          e);
    }
  }

  public Registroentidadinternal_client_ep()
  {
    super(wsdlLocationURL,
          new QName("http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
                    "registroentidadinternal_client_ep"));
  }

  public Registroentidadinternal_client_ep(URL wsdlLocation,
                                           QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="RegistroEntidadInterNal_pt")
  public co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal getRegistroEntidadInterNal_pt()
  {
    return (co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
                                                                                                             "RegistroEntidadInterNal_pt"),
                                                                                                   co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal.class);
  }

  @WebEndpoint(name="RegistroEntidadInterNal_pt")
  public co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal getRegistroEntidadInterNal_pt(WebServiceFeature... features)
  {
    return (co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal) super.getPort(new QName("http://xmlns.oracle.com/MarketPlace/ProcesoRegistroInterNal/RegistroEntidadInterNal",
                                                                                                             "RegistroEntidadInterNal_pt"),
                                                                                                   co.com.losalpes.marketplace.ws.registroInternal.RegistroEntidadInterNal.class,
                                                                                                   features);
  }
}
