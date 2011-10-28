(:: pragma bea:global-element-parameter parameter="$accountWS_AccountQueryPage_Output1" element="ns0:AccountWS_AccountQueryPage_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)

declare namespace ns1 = "urn:/crmondemand/xml/account";
declare namespace ns0 = "urn:crmondemand/ws/account/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarIdCliente/";

declare function xf:ConsultarIdCliente($accountWS_AccountQueryPage_Output1 as element(ns0:AccountWS_AccountQueryPage_Output))
    as xs:string {
        data($accountWS_AccountQueryPage_Output1/ns1:ListOfAccount/ns1:Account[1]/ns1:AccountId)
};

declare variable $accountWS_AccountQueryPage_Output1 as element(ns0:AccountWS_AccountQueryPage_Output) external;

xf:ConsultarIdCliente($accountWS_AccountQueryPage_Output1)
