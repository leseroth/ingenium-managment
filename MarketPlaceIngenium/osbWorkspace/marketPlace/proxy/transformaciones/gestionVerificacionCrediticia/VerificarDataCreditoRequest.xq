(:: pragma bea:global-element-parameter parameter="$verificarDataCredito1" element="ns1:verificarDataCredito" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)
(:: pragma bea:global-element-return element="ns0:verificarDataCredito" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarDataCreditoRequest/";

declare function xf:VerificarDataCreditoRequest($verificarDataCredito1 as element(ns1:verificarDataCredito))
    as element(ns0:verificarDataCredito) {
        <ns0:verificarDataCredito>
            <nit>{ data($verificarDataCredito1/ns1:nit) }</nit>
            <reglaVal>{ data($verificarDataCredito1/ns1:reglaValidacion) }</reglaVal>
        </ns0:verificarDataCredito>
};

declare variable $verificarDataCredito1 as element(ns1:verificarDataCredito) external;

xf:VerificarDataCreditoRequest($verificarDataCredito1)
