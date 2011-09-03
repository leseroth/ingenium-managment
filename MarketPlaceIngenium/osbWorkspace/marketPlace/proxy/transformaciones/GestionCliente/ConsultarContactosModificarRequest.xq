(:: pragma bea:global-element-parameter parameter="$modificarCliente1" element="ns0:modificarCliente" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns2:ContactWS_ContactQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarContactosModificarRequest/";

declare function xf:ConsultarContactosModificarRequest($modificarCliente1 as element(ns0:modificarCliente))
    as element(ns2:ContactWS_ContactQueryPage_Input) {
        <ns2:ContactWS_ContactQueryPage_Input>
            {
                let $modificarCliente := $modificarCliente1
                return
                    <ns1:ListOfContact>
                        {
                            for $contactos in $modificarCliente/ns0:cliente/contactos
                            return
                                <ns1:Contact>
                                	<ns1:ContactId></ns1:ContactId>
                                    <ns1:plTipo_de_Identificacin>{concat("='",data($contactos/ns0:tipoIdentificacion),"'")}</ns1:plTipo_de_Identificacin>
                                    <ns1:stNmero_de_Identificacin>{concat("='",data($contactos/ns0:numIdentificacion),"'")}</ns1:stNmero_de_Identificacin>
                                </ns1:Contact>
                        }
                    </ns1:ListOfContact>
            }
        </ns2:ContactWS_ContactQueryPage_Input>
};

declare variable $modificarCliente1 as element(ns0:modificarCliente) external;

xf:ConsultarContactosModificarRequest($modificarCliente1)
