(:: pragma bea:global-element-parameter parameter="$verificarListaAntiLavadoResponse1" element="ns0:verificarListaAntiLavadoResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/VerificacionCrediticia/VerificarListaAntilavadoResponse/";

declare function xf:VerificarListaAntilavadoResponse($verificarListaAntiLavadoResponse1 as element(ns0:verificarListaAntiLavadoResponse))
    as xs:boolean {
        data($verificarListaAntiLavadoResponse1/return)
};

declare variable $verificarListaAntiLavadoResponse1 as element(ns0:verificarListaAntiLavadoResponse) external;

xf:VerificarListaAntilavadoResponse($verificarListaAntiLavadoResponse1)