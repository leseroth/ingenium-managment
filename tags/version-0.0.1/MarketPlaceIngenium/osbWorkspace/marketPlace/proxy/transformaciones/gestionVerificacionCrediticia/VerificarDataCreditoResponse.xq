(:: pragma bea:global-element-parameter parameter="$vdcResponse1" element="ns0:verificarDataCreditoResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/VerificacionCrediticia/VerificarDataCreditoResponse/";

declare function xf:VerificarDataCreditoResponse($vdcResponse1 as element(ns0:verificarDataCreditoResponse))
    as xs:string {
        data($vdcResponse1/return)
};

declare variable $vdcResponse1 as element(ns0:verificarDataCreditoResponse) external;

xf:VerificarDataCreditoResponse($vdcResponse1)