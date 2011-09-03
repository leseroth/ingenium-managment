(:: pragma bea:global-element-parameter parameter="$verificarListaAntilavado1" element="ns1:verificarListaAntilavado" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)
(:: pragma bea:global-element-return element="ns0:verificarListaAntiLavado" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaAntilavadoRequest/";

declare function xf:VerificarListaAntilavadoRequest($verificarListaAntilavado1 as element(ns1:verificarListaAntilavado))
    as element(ns0:verificarListaAntiLavado) {
        <ns0:verificarListaAntiLavado>
            <nit>{ data($verificarListaAntilavado1/ns1:nit) }</nit>
            <reglaVal>{ data($verificarListaAntilavado1/ns1:reglaValidacion) }</reglaVal>
        </ns0:verificarListaAntiLavado>
};

declare variable $verificarListaAntilavado1 as element(ns1:verificarListaAntilavado) external;

xf:VerificarListaAntilavadoRequest($verificarListaAntilavado1)
