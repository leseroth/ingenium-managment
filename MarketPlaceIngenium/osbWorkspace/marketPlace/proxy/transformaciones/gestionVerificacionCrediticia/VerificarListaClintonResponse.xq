(:: pragma bea:global-element-parameter parameter="$verificarListaClintonResponse1" element="ns0:verificarListaClintonResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)
(:: pragma bea:global-element-return element="ns1:verificarListaClintonResponse" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaClintonResponse/";

declare function xf:VerificarListaClintonResponse($verificarListaClintonResponse1 as element(ns0:verificarListaClintonResponse))
    as element(ns1:verificarListaClintonResponse) {
        <ns1:verificarListaClintonResponse>
            <ns1:validacion>{ data($verificarListaClintonResponse1/return) }</ns1:validacion>
        </ns1:verificarListaClintonResponse>
};

declare variable $verificarListaClintonResponse1 as element(ns0:verificarListaClintonResponse) external;

xf:VerificarListaClintonResponse($verificarListaClintonResponse1)
