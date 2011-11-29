(:: pragma bea:global-element-parameter parameter="$accountWS_AccountQueryPage_Output1" element="ns1:AccountWS_AccountQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarClientesResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClientesResponse/";

declare function xf:ConsultarClientesResponse($accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output))
    as element(ns0:consultarClientesResponse) {
        <ns0:consultarClientesResponse>
            {
                for $Account in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account
                return
                    <ns0:cliente>
                        {
                            for $AccountId in $Account/ns2:AccountId
                            return
                                <id>{ data($AccountId) }</id>
                        }
                        <nombre>{ data($Account/ns2:AccountName) }</nombre>
                        <nit>{ data($Account/ns2:stNit) }</nit>
                        {
                            for $Location in $Account/ns2:Location
                            return
                                <direccion>{ data($Location) }</direccion>
                        }
                        {
                            for $MainPhone in $Account/ns2:MainPhone
                            return
                                <telefono>{ data($MainPhone) }</telefono>
                        }
                        {
                            for $stCorreo_Electronico in $Account/ns2:stCorreo_Electronico
                            return
                                <email>{ data($stCorreo_Electronico) }</email>
                        }
                        {
                            for $ListOfContact in $Account/ns2:ListOfContact,
                                $Contact in $ListOfContact/ns2:Contact
                            return
                                <contactos>
                                    <ns0:id>{ data($Contact/ns2:ContactId) }</ns0:id>
                                    <ns0:numIdentificacion>{ data($Contact/ns2:stNmero_de_Identificacin) }</ns0:numIdentificacion>
                                    <ns0:tipoIdentificacion>{ data($Contact/ns2:plTipo_de_Identificacin) }</ns0:tipoIdentificacion>
                                    <ns0:nombre>{ data($Contact/ns2:ContactFirstName) }</ns0:nombre>
                                    <ns0:direccion>{ data($Contact/ns2:PrimaryStreetAddress) }</ns0:direccion>
                                    <ns0:telefono>{ data($Contact/ns2:WorkPhone) }</ns0:telefono>
                                    {
                                        for $CellularPhone in $Contact/ns2:CellularPhone
                                        return
                                            <ns0:celular>{ data($CellularPhone) }</ns0:celular>
                                    }
                                    <ns0:email>{ data($Contact/ns2:ContactEmail) }</ns0:email>
                                </contactos>
                        }
                        {
                            for $stRazon_Social in $Account/ns2:stRazon_Social
                            return
                                <razonSocial>{ data($stRazon_Social) }</razonSocial>
                        }
                        {
                            for $Status in $Account/ns2:Status
                            return
                                <estado>{ data($Status) }</estado>
                        }
                        {
                            for $AccountType in $Account/ns2:AccountType
                            return
                                <tipo>{ data($AccountType) }</tipo>
                        }
                        <comision>{ string(data($Account/ns2:nComision )) }</comision>
                        <codigoPostal>{ data($Account/ns2:stCodigoPostal) }</codigoPostal> 
               	        <codigoPais>{ data($Account/ns2:stCodigoPais) }</codigoPais>
                    </ns0:cliente>
            }
        </ns0:consultarClientesResponse>
};

declare variable $accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output) external;

xf:ConsultarClientesResponse($accountWS_AccountQueryPage_Output1)
