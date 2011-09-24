(:: pragma bea:global-element-parameter parameter="$contactWS_ContactQueryPage_Output1" element="ns2:ContactWS_ContactQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarContactoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarContactoResponse/";

declare function xf:ConsultarContactoResponse($contactWS_ContactQueryPage_Output1 as element(ns2:ContactWS_ContactQueryPage_Output))
    as element(ns0:consultarContactoResponse) {
        <ns0:consultarContactoResponse>
            <ns0:contacto>
                <ns0:id>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:ContactId) }</ns0:id>
                <ns0:numIdentificacion>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:stNmero_de_Identificacin) }</ns0:numIdentificacion>
                <ns0:tipoIdentificacion>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:plTipo_de_Identificacin) }</ns0:tipoIdentificacion>
                <ns0:nombre>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:ContactFirstName) }</ns0:nombre>
                <ns0:direccion>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:stDireccion) }</ns0:direccion>
                <ns0:telefono>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:WorkPhone) }</ns0:telefono>
                {
                    for $CellularPhone in $contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:CellularPhone
                    return
                        <ns0:celular>{ data($CellularPhone) }</ns0:celular>
                }
                {
                    for $plEstado_Contacto in $contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:plEstado_Contacto
                    return
                        <ns0:estado>{ data($plEstado_Contacto) }</ns0:estado>
                }
                <ns0:email>{ data($contactWS_ContactQueryPage_Output1/ns1:ListOfContact/ns1:Contact[1]/ns1:ContactEmail) }</ns0:email>
            </ns0:contacto>
        </ns0:consultarContactoResponse>
};

declare variable $contactWS_ContactQueryPage_Output1 as element(ns2:ContactWS_ContactQueryPage_Output) external;

xf:ConsultarContactoResponse($contactWS_ContactQueryPage_Output1)
