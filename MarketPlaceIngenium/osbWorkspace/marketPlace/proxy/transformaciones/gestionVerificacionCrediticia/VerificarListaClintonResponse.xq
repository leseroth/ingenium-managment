(:: pragma bea:global-element-parameter parameter="$verificarListaClintonResponse1" element="ns0:verificarListaClintonResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/VerificacionCrediticia/VerificarListaClintonResponse/";

declare function xf:VerificarListaClintonResponse($verificarListaClintonResponse1 as element(ns0:verificarListaClintonResponse))
    as xs:boolean {
        data($verificarListaClintonResponse1/return)
};

declare variable $verificarListaClintonResponse1 as element(ns0:verificarListaClintonResponse) external;

xf:VerificarListaClintonResponse($verificarListaClintonResponse1)