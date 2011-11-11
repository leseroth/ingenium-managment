(:: pragma bea:global-element-parameter parameter="$accountWS_AccountQueryPage_Output1" element="ns1:AccountWS_AccountQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarClienteResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClienteResponse/";

declare function xf:ConsultarClienteResponse($accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output))
    as element(ns0:consultarClienteResponse) {
        <ns0:consultarClienteResponse>
            <ns0:cliente>
                <id>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountId) }</id>
                <nombre>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountName) }</nombre>
                <nit>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stNit) }</nit>
                <codigoPostal>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stCodigoPostal) }</codigoPostal> 
               	<codigoPais>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stCodigoPais) }</codigoPais>
                {
                    for $Location in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:Location
                    return
                        <direccion>{ data($Location) }</direccion>
                }
                {
                    for $MainPhone in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:MainPhone
                    return
                        <telefono>{ data($MainPhone) }</telefono>
                }
                {
                    for $stCorreo_Electronico in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stCorreo_Electronico
                    return
                        <email>{ data($stCorreo_Electronico) }</email>
                }
                {
                    let $ListOfCustomObject30 := $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:ListOfCustomObject3
                    return
                        <solicitudes>
                            {
                                for $ListOfCustomObject3 in $ListOfCustomObject30,
                                    $CustomObject3 in $ListOfCustomObject3/ns2:CustomObject3
                                return
                                    <ns0:productos>
                                        {
                                            for $CustomObject3Id in $CustomObject3/ns2:CustomObject3Id
                                            return
                                                <id>{ data($CustomObject3Id) }</id>
                                        }
                                        <nombre>{ data($CustomObject3/ns2:Name) }</nombre>
                                        <categoria>{ data($CustomObject3/ns2:stCategoria) }</categoria>
                                    </ns0:productos>
                            }
                        </solicitudes>
                }
                {
                    for $ListOfContact in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:ListOfContact,
                        $Contact in $ListOfContact/ns2:Contact
                    return
                        <contactos>
                            <ns0:id>{ data($Contact/ns2:ContactId) }</ns0:id>
                            <ns0:nombre>{ data($Contact/ns2:ContactFirstName) }</ns0:nombre>
                            <ns0:telefono>{ data($Contact/ns2:WorkPhone) }</ns0:telefono>
                            <ns0:email>{ data($Contact/ns2:ContactEmail) }</ns0:email>
                            {
			                    for $stNmero_de_Identificacin in $Contact/ns2:stNmero_de_Identificacin
			                    return
			                        <ns0:numIdentificacion>{ data($stNmero_de_Identificacin) }</ns0:numIdentificacion>
			                }
			                {
			                    for $plTipo_de_Identificacin in $Contact/ns2:plTipo_de_Identificacin
			                    return
			                        <ns0:tipoIdentificacion>{ data($plTipo_de_Identificacin) }</ns0:tipoIdentificacion>
			                }
			                {
			                    for $stDireccion in $Contact/ns2:stDireccion
			                    return
			                        <ns0:direccion>{ data($stDireccion) }</ns0:direccion>
			                }
			                {
			                    for $stCelular in $Contact/ns2:stCelular
			                    return
			                        <ns0:celular>{ data($stCelular) }</ns0:celular>
			                }
			                {
			                    for $plEstado_Contacto in $Contact/ns2:plEstado_Contacto
			                    return
			                        <ns0:estado>{ data($plEstado_Contacto) }</ns0:estado>
			                }
                        </contactos>
                }
                {
                    for $stRazon_Social in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stRazon_Social
                    return
                        <razonSocial>{ data($stRazon_Social) }</razonSocial>
                }
                {
                    for $Status in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:Status
                    return
                        <estado>{ data($Status) }</estado>
                }
                {
                    for $AccountType in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountType
                    return
                        <tipo>{ data($AccountType) }</tipo>
                }
                {
                    for $plCategoria in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:plCategoria
                    return
                        <categoria>{ data($plCategoria) }</categoria>
                }
                <comision>{ string(data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:nComision )) }</comision>
            </ns0:cliente>
        </ns0:consultarClienteResponse>
};

declare variable $accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output) external;

xf:ConsultarClienteResponse($accountWS_AccountQueryPage_Output1)
