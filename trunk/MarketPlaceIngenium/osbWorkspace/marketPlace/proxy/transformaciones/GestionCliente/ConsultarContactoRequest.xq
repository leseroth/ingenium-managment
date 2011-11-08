(:: pragma bea:global-element-parameter parameter="$consultarContacto1" element="ns0:consultarContacto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns2:ContactWS_ContactQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarContactoRequest/";

declare function xf:ConsultarContactoRequest($consultarContacto1 as element(ns0:consultarContacto))
    as element(ns2:ContactWS_ContactQueryPage_Input) {
        <ns2:ContactWS_ContactQueryPage_Input>
            <ns1:ListOfContact>
                <ns1:Contact>
                	<ns1:ContactId></ns1:ContactId>
                	<ns1:ContactFirstName></ns1:ContactFirstName>
                	<ns1:stDireccion></ns1:stDireccion>
                	<ns1:WorkPhone></ns1:WorkPhone>
                	<ns1:CellularPhone></ns1:CellularPhone>
                	<ns1:plEstado_Contacto></ns1:plEstado_Contacto>  
                	<ns1:ContactEmail></ns1:ContactEmail>           
                    <ns1:plTipo_de_Identificacin>{ concat("='",data($consultarContacto1/ns0:tipoDocumento),"'") }</ns1:plTipo_de_Identificacin>
                    <ns1:stNmero_de_Identificacin>{ concat("='",data($consultarContacto1/ns0:documento),"'") }</ns1:stNmero_de_Identificacin>
                    <ns1:stCelular></ns1:stCelular>
                </ns1:Contact>
            </ns1:ListOfContact>
        </ns2:ContactWS_ContactQueryPage_Input>
};

declare variable $consultarContacto1 as element(ns0:consultarContacto) external;

xf:ConsultarContactoRequest($consultarContacto1)
