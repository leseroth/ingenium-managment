(:: pragma bea:global-element-parameter parameter="$contactWS_ContactUpdate_Output1" element="ns2:ContactWS_ContactUpdate_Output" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:modificarContactoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ModificarContactoResponse/";

declare function xf:ModificarContactoResponse($contactWS_ContactUpdate_Output1 as element(ns2:ContactWS_ContactUpdate_Output))
    as element(ns0:modificarContactoResponse) {
        let $ContactWS_ContactUpdate_Output := $contactWS_ContactUpdate_Output1
        return
            <ns0:modificarContactoResponse>
                {
                    let $ListOfContact := $ContactWS_ContactUpdate_Output/ns1:ListOfContact
                    return
                        <ns0:respuesta>{(empty($ListOfContact/ns1:Contact[1]/ns1:ContactEmail))}</ns0:respuesta>
                }
            </ns0:modificarContactoResponse>
};

declare variable $contactWS_ContactUpdate_Output1 as element(ns2:ContactWS_ContactUpdate_Output) external;

xf:ModificarContactoResponse($contactWS_ContactUpdate_Output1)
