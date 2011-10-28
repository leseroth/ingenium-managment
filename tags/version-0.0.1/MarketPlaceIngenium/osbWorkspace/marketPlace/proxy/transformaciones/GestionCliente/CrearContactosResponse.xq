(:: pragma bea:global-element-parameter parameter="$contactWS_ContactInsert_Output1" element="ns2:ContactWS_ContactInsert_Output" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:crearContactoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/CrearContactosResponse/";

declare function xf:CrearContactosResponse($contactWS_ContactInsert_Output1 as element(ns2:ContactWS_ContactInsert_Output))
    as element(ns0:crearContactoResponse) {
        let $Output := $contactWS_ContactInsert_Output1
        return
            <ns0:crearContactoResponse>
                {
                    let $ListOfContact := $Output/ns1:ListOfContact
                    return                   
                          <ns0:respuesta>{not(empty($ListOfContact/ns1:Contact[1]/ns1:AccountId))}</ns0:respuesta>
                }
           </ns0:crearContactoResponse>
};

declare variable $contactWS_ContactInsert_Output1 as element(ns2:ContactWS_ContactInsert_Output) external;

xf:CrearContactosResponse($contactWS_ContactInsert_Output1)
