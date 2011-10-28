package co.com.losalpes.marketplace.ws.ldap;

import java.security.cert.X509Certificate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import weblogic.security.SSL.TrustManager;

import weblogic.wsee.security.bst.ClientBSTCredentialProvider;
import weblogic.wsee.security.saml.SAMLTrustCredentialProvider;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.wsee.security.util.CertUtils;

import weblogic.xml.crypto.wss.WSSecurityContext;
import weblogic.xml.crypto.wss.provider.CredentialProvider;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class LDAPAuthenticationManagementPortClient
{
  @WebServiceRef
  private static LDAPAuthenticationManagementService lDAPAuthenticationManagementService;

    public static LDAPAuthenticationManagement getLdap() {
        try {
            lDAPAuthenticationManagementService = new LDAPAuthenticationManagementService();
            LDAPAuthenticationManagement lDAPAuthenticationManagement = lDAPAuthenticationManagementService.getLDAPAuthenticationManagementPort();

            Map<String, Object> requestContext = ((BindingProvider) lDAPAuthenticationManagement).getRequestContext();
            setPortCredentialProviderList(requestContext);

            return lDAPAuthenticationManagement;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Generated("Oracle JDeveloper")
    public static void setPortCredentialProviderList(Map<String, Object> requestContext) throws Exception {
        // TODO - Provide the required values
        String username = "";
        String password = "";
        String clientKeyStore = "";
        String clientKeyStorePassword = "";
        String clientKeyAlias = "";
        String clientKeyPassword = "";
        String serverKeyStore = "";
        String serverKeyStorePassword = "";
        String serverKeyAlias = "";
        List<CredentialProvider> credList = new ArrayList<CredentialProvider>();

        // Add the necessary credential providers to the list

        credList.add(getUNTCredentialProvider(username, password));

        credList.add(getBSTCredentialProvider(clientKeyStore, clientKeyStorePassword, clientKeyAlias, clientKeyPassword, serverKeyStore, serverKeyStorePassword, serverKeyAlias, requestContext));

        credList.add(getSAMLTrustCredentialProvider());

        requestContext.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credList);
    }

    @Generated("Oracle JDeveloper")
    public static CredentialProvider getSAMLTrustCredentialProvider() {
        return new SAMLTrustCredentialProvider();
    }

    @Generated("Oracle JDeveloper")
    public static CredentialProvider getUNTCredentialProvider(String username,
                                                              String password) {
        return new ClientUNTCredentialProvider(username.getBytes(), password.getBytes());
    }

    @Generated("Oracle JDeveloper")
    public static CredentialProvider getBSTCredentialProvider(String clientKeyStore,
                                                              String clientKeyStorePwd,
                                                              String clientKeyAlias,
                                                              String clientKeyPwd,
                                                              String serverKeyStore,
                                                              String serverKeyStorePwd,
                                                              String serverKeyAlias, Map<String, Object> requestContext) throws Exception {
        List serverCertList =
            CertUtils.getCertificate(serverKeyStore, serverKeyStorePwd, serverKeyAlias, "JKS");

        List clientCertList =
            CertUtils.getCertificate(clientKeyStore, clientKeyStorePwd, clientKeyAlias, "JKS");

        final X509Certificate serverCert =
            (serverCertList != null && serverCertList.size() > 0) ? (X509Certificate) serverCertList.get(0) : null;
        final X509Certificate clientCert =
            (clientCertList != null && clientCertList.size() > 0) ? (X509Certificate) clientCertList.get(0) : null;

        requestContext.put(WSSecurityContext.TRUST_MANAGER, new TrustManager()
       {
          public boolean certificateCallback(X509Certificate[] chain,
                                             int validateErr)
          {
             boolean result = (chain != null && chain.length > 0)
                              && (chain[0].equals(serverCert) || chain[0].equals(clientCert));
             return result;
          }
       });

        return new ClientBSTCredentialProvider(clientKeyStore, clientKeyStorePwd, clientKeyAlias, clientKeyPwd, "JKS", serverCert);
    }
}
