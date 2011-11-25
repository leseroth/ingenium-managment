(:: pragma bea:global-element-parameter parameter="$verificarListaClinton1" element="ns1:verificarListaClinton" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)
(:: pragma bea:global-element-return element="ns0:verificarListaClinton" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaClintonRequest/";

declare function xf:VerificarListaClintonRequest($verificarListaClinton1 as element(ns1:verificarListaClinton))
    as element(ns0:verificarListaClinton) {
        <ns0:verificarListaClinton>
            <nit>{ data($verificarListaClinton1/ns1:nit) }</nit>
            <reglaVal>{ data($verificarListaClinton1/ns1:reglaValidacion) }</reglaVal>
        </ns0:verificarListaClinton>
};

declare variable $verificarListaClinton1 as element(ns1:verificarListaClinton) external;

xf:VerificarListaClintonRequest($verificarListaClinton1)
