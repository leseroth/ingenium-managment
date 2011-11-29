(:: pragma bea:global-element-parameter parameter="$verificarListaInternacionalResponse1" element="ns0:verificarListaInternacionalResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)
(:: pragma bea:global-element-return element="ns1:verificarListaInternacionalResponse" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaInternacionalResponse/";

declare function xf:VerificarListaInternacionalResponse($verificarListaInternacionalResponse1 as element(ns0:verificarListaInternacionalResponse))
    as element(ns1:verificarListaInternacionalResponse) {
        <ns1:verificarListaInternacionalResponse>
            <ns1:validacion>{ data($verificarListaInternacionalResponse1/return) }</ns1:validacion>
        </ns1:verificarListaInternacionalResponse>
};

declare variable $verificarListaInternacionalResponse1 as element(ns0:verificarListaInternacionalResponse) external;

xf:VerificarListaInternacionalResponse($verificarListaInternacionalResponse1)
