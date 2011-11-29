(:: pragma bea:global-element-parameter parameter="$accountWS_AccountInsert_Output1" element="ns1:AccountWS_AccountInsert_Output" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:crearClienteResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/CrearClienteResponse/";

declare function xf:CrearClienteResponse($accountWS_AccountInsert_Output1 as element(ns1:AccountWS_AccountInsert_Output))
    as element(ns0:crearClienteResponse) {
        let $AccountWS_AccountInsert_Output := $accountWS_AccountInsert_Output1
        return
            <ns0:crearClienteResponse>
                <ns0:idCuenta>{ data($AccountWS_AccountInsert_Output/ns2:ListOfAccount/ns2:Account[1]/ns2:AccountId) }</ns0:idCuenta>
            </ns0:crearClienteResponse>
};

declare variable $accountWS_AccountInsert_Output1 as element(ns1:AccountWS_AccountInsert_Output) external;

xf:CrearClienteResponse($accountWS_AccountInsert_Output1)
