(:: pragma bea:global-element-parameter parameter="$modificarContacto1" element="ns0:modificarContacto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns2:ContactWS_ContactUpdate_Input" location="../../../business/wsdls/crmOnDemand/Contact.wsdl" ::)

declare namespace ns2 = "urn:crmondemand/ws/contact/10/2004";
declare namespace ns1 = "urn:/crmondemand/xml/contact";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ModificarContactoRequest/";

declare function xf:ModificarContactoRequest($modificarContacto1 as element(ns0:modificarContacto))
    as element(ns2:ContactWS_ContactUpdate_Input) {
        <ns2:ContactWS_ContactUpdate_Input>
            <ns1:ListOfContact>
                <ns1:Contact>
                    <ns1:ContactId>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:id),"'") }</ns1:ContactId>
                    {
                        for $celular in $modificarContacto1/ns0:contactos/ns0:celular
                        return
                            <ns1:CellularPhone>{ concat("='",data($celular),"'") }</ns1:CellularPhone>
                    }
                    <ns1:ContactEmail>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:email),"'") }</ns1:ContactEmail>
                    <ns1:ContactFirstName>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:nombre),"'") }</ns1:ContactFirstName>
                    <ns1:ContactFullName>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:nombre),"'") }</ns1:ContactFullName>
                    <ns1:ContactLastName>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:nombre),"'") }</ns1:ContactLastName>
                    <ns1:WorkPhone>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:telefono),"'") }</ns1:WorkPhone>
                    <ns1:plTipo_de_Identificacin>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:tipoIdentificacion),"'") }</ns1:plTipo_de_Identificacin>
                    {
                        for $estado in $modificarContacto1/ns0:contactos/ns0:estado
                        return
                            <ns1:plEstado_Contacto>{ concat("='",data($estado),"'") }</ns1:plEstado_Contacto>
                    }
                    <ns1:stNmero_de_Identificacin>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:numIdentificacion),"'") }</ns1:stNmero_de_Identificacin>
                    <ns1:stDireccion>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:direccion),"'") }</ns1:stDireccion>
                    <ns1:stCelular>{ concat("='",data($modificarContacto1/ns0:contactos/ns0:celular),"'") }</ns1:stCelular>                    
                </ns1:Contact>
            </ns1:ListOfContact>
        </ns2:ContactWS_ContactUpdate_Input>
};

declare variable $modificarContacto1 as element(ns0:modificarContacto) external;

xf:ModificarContactoRequest($modificarContacto1)
