(:: pragma bea:global-element-parameter parameter="$verificarDataCreditoResponse1" element="ns0:verificarDataCreditoResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)
(:: pragma bea:global-element-return element="ns1:verificarDataCreditoResponse" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarDataCreditoResponse/";

declare function xf:VerificarDataCreditoResponse($verificarDataCreditoResponse1 as element(ns0:verificarDataCreditoResponse))
    as element(ns1:verificarDataCreditoResponse) {
        <ns1:verificarDataCreditoResponse>
            <ns1:calificacion>{ data($verificarDataCreditoResponse1/return) }</ns1:calificacion>
        </ns1:verificarDataCreditoResponse>
};

declare variable $verificarDataCreditoResponse1 as element(ns0:verificarDataCreditoResponse) external;

xf:VerificarDataCreditoResponse($verificarDataCreditoResponse1)
