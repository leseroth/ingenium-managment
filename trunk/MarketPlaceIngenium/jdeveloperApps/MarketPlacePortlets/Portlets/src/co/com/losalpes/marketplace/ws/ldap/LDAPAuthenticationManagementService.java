package co.com.losalpes.marketplace.ws.ldap;

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

@WebServiceClient(wsdlLocation="http://portal.marketplace.losalpes.com.co:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl",
  targetNamespace="http://ws.ldap.marketplace.losalpes.com.co/", name="LDAPAuthenticationManagementService")
public class LDAPAuthenticationManagementService
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagementService");
      URL baseUrl =
        LDAPAuthenticationManagementService.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            LDAPAuthenticationManagementService.class.getResource("http://portal.marketplace.losalpes.com.co:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://portal.marketplace.losalpes.com.co:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://portal.marketplace.losalpes.com.co:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://portal.marketplace.losalpes.com.co:8148/LDAPAuthenticationManagementService/LDAPAuthenticationManagement?wsdl",
          e);
    }
  }

  public LDAPAuthenticationManagementService()
  {
    super(wsdlLocationURL,
          new QName("http://ws.ldap.marketplace.losalpes.com.co/",
                    "LDAPAuthenticationManagementService"));
  }

  public LDAPAuthenticationManagementService(URL wsdlLocation,
                                             QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="LDAPAuthenticationManagementPort")
  public co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement getLDAPAuthenticationManagementPort()
  {
    return (co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement) super.getPort(new QName("http://ws.ldap.marketplace.losalpes.com.co/",
                                                                                                      "LDAPAuthenticationManagementPort"),
                                                                                            co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement.class);
  }

  @WebEndpoint(name="LDAPAuthenticationManagementPort")
  public co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement getLDAPAuthenticationManagementPort(WebServiceFeature... features)
  {
    return (co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement) super.getPort(new QName("http://ws.ldap.marketplace.losalpes.com.co/",
                                                                                                      "LDAPAuthenticationManagementPort"),
                                                                                            co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement.class,
                                                                                            features);
  }
}
