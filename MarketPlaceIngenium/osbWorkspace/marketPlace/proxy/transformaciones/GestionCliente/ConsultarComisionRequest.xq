(:: pragma bea:global-element-parameter parameter="$consultarComision1" element="ns0:consultarComision" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:AccountWS_AccountQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarComisionRequest/";

declare function xf:ConsultarComisionRequest($consultarComision1 as element(ns0:consultarComision))
    as element(ns1:AccountWS_AccountQueryPage_Input) {
        <ns1:AccountWS_AccountQueryPage_Input>
            <ns2:ListOfAccount>
                <ns2:Account>    
                	<!--Filtrando por el nit-->            	
                    <ns2:stNit>{ concat("='",data($consultarComision1/ns0:nit),"'") }</ns2:stNit>
                    <ns2:nComision></ns2:nComision>
                </ns2:Account>
            </ns2:ListOfAccount>
        </ns1:AccountWS_AccountQueryPage_Input>
};

declare variable $consultarComision1 as element(ns0:consultarComision) external;

xf:ConsultarComisionRequest($consultarComision1)
