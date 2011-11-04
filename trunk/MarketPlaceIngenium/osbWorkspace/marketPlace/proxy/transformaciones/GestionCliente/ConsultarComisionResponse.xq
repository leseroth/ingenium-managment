(:: pragma bea:global-element-parameter parameter="$accountWS_AccountQueryPage_Output1" element="ns1:AccountWS_AccountQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarComisionResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarComisionResponse/";

declare function xf:ConsultarComisionResponse($accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output))
    as element(ns0:consultarComisionResponse) {
        let $AccountWS_AccountQueryPage_Output := $accountWS_AccountQueryPage_Output1,
            $ListOfAccount := $AccountWS_AccountQueryPage_Output/ns2:ListOfAccount
        return
            <ns0:consultarComisionResponse>
            	<ns0:comision>{ string(data($accountWS_AccountQueryPage_Output1/ns2:ListOfAccount/ns2:Account[1]/ns2:nComision )) }</ns0:comision>
            </ns0:consultarComisionResponse>
};

declare variable $accountWS_AccountQueryPage_Output1 as element(ns1:AccountWS_AccountQueryPage_Output) external;

xf:ConsultarComisionResponse($accountWS_AccountQueryPage_Output1)
