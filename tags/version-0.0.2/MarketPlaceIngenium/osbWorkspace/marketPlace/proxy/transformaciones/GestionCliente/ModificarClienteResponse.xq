(:: pragma bea:global-element-parameter parameter="$accountWS_AccountUpdate_Output1" element="ns1:AccountWS_AccountUpdate_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:modificarClienteResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ModificarClienteResponse/";

declare function xf:ModificarClienteResponse($accountWS_AccountUpdate_Output1 as element(ns1:AccountWS_AccountUpdate_Output))
    as element(ns0:modificarClienteResponse) {
        let $AccountWS_AccountUpdate_Output := $accountWS_AccountUpdate_Output1
        return
            <ns0:modificarClienteResponse>
                {
                    let $ListOfAccount := $AccountWS_AccountUpdate_Output/ns2:ListOfAccount
                    return
                        <ns0:resultado>{(empty($ListOfAccount/ns1:Account[1]/ns1:AccountId))}</ns0:resultado>
                }
            </ns0:modificarClienteResponse>
};

declare variable $accountWS_AccountUpdate_Output1 as element(ns1:AccountWS_AccountUpdate_Output) external;

xf:ModificarClienteResponse($accountWS_AccountUpdate_Output1)
