(:: pragma bea:global-element-parameter parameter="$crearContacto1" element="ns0:crearContacto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns2:ContactWS_ContactInsert_Input" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/CrearContactosRequest/";

declare function xf:CrearContactosRequest($crearContacto1 as element(ns0:crearContacto))
    as element(ns2:ContactWS_ContactInsert_Input) {
        <ns2:ContactWS_ContactInsert_Input>
            {
                let $crearContacto := $crearContacto1
                return
                    <ns1:ListOfContact>
                        {
                            for $contactos in $crearContacto/ns0:contactos
                            return
                                <ns1:Contact>
                                    <ns1:AccountId>{ data($crearContacto/ns0:idCliente) }</ns1:AccountId>
                                    {
                                        for $celular in $contactos/ns0:celular
                                        return
                                            <ns1:CellularPhone>{ data($celular) }</ns1:CellularPhone>
                                    }
                                    <ns1:ContactEmail>{ data($contactos/ns0:email) }</ns1:ContactEmail>                                   
                                    <ns1:ContactFirstName>{ data($contactos/ns0:nombre) }</ns1:ContactFirstName>
                                    <ns1:JobTitle>Titulo</ns1:JobTitle>
                                    <ns1:ContactLastName>{ data($contactos/ns0:nombre) }</ns1:ContactLastName>
                                    <ns1:WorkPhone>{ data($contactos/ns0:telefono) }</ns1:WorkPhone>
                                    <ns1:plTipo_de_Identificacin>{ data($contactos/ns0:tipoIdentificacion) }</ns1:plTipo_de_Identificacin>
                                    <ns1:stNmero_de_Identificacin>{ data($contactos/ns0:numIdentificacion) }</ns1:stNmero_de_Identificacin>
                                    <ns1:HomePhone>{ data($contactos/ns0:telefono) }</ns1:HomePhone>
                                </ns1:Contact>
                        }
                    </ns1:ListOfContact>
            }
        </ns2:ContactWS_ContactInsert_Input>
};

declare variable $crearContacto1 as element(ns0:crearContacto) external;

xf:CrearContactosRequest($crearContacto1)
