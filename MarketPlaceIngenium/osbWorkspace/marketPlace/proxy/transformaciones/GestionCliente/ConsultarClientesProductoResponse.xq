(:: pragma bea:global-element-parameter parameter="$accountWS_AccountQueryPage_Output1" element="ns1:AccountWS_AccountQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarClientesProductoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClientesProductoResponse/";

declare function xf:ConsultarClientesProductoResponse($accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output))
    as element(ns0:consultarClientesProductoResponse) {
        <ns0:consultarClientesProductoResponse>
            <ns0:cliente>
                <id>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountId) }</id>
                <nombre>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountName) }</nombre>
                <nit>{ data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stNit) }</nit>
                {
                    for $stCorreo_Electronico in $accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:stCorreo_Electronico
                    return
                        <email>{ data($stCorreo_Electronico) }</email>
                }
            </ns0:cliente>
        </ns0:consultarClientesProductoResponse>
};

declare variable $accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output) external;

xf:ConsultarClientesProductoResponse($accountWS_AccountQueryPage_Output1)
