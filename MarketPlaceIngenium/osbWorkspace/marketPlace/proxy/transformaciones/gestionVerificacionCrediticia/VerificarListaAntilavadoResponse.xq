(:: pragma bea:global-element-parameter parameter="$verificarListaAntiLavadoResponse1" element="ns0:verificarListaAntiLavadoResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)
(:: pragma bea:global-element-return element="ns1:verificarListaAntilavadoResponse" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaAntilavadoResponse/";

declare function xf:VerificarListaAntilavadoResponse($verificarListaAntiLavadoResponse1 as element(ns0:verificarListaAntiLavadoResponse))
    as element(ns1:verificarListaAntilavadoResponse) {
        <ns1:verificarListaAntilavadoResponse>
            <ns1:validacion>{ data($verificarListaAntiLavadoResponse1/return) }</ns1:validacion>
        </ns1:verificarListaAntilavadoResponse>
};

declare variable $verificarListaAntiLavadoResponse1 as element(ns0:verificarListaAntiLavadoResponse) external;

xf:VerificarListaAntilavadoResponse($verificarListaAntiLavadoResponse1)
