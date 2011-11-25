(:: pragma bea:global-element-parameter parameter="$verificarListaInternacional1" element="ns1:verificarListaInternacional" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)
(:: pragma bea:global-element-return element="ns0:verificarListaInternacional" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarListaInternacional/";

declare function xf:VerificarListaInternacional($verificarListaInternacional1 as element(ns1:verificarListaInternacional))
    as element(ns0:verificarListaInternacional) {
        <ns0:verificarListaInternacional>
            <nit>{ data($verificarListaInternacional1/ns1:nit) }</nit>
            <reglaVal>{ data($verificarListaInternacional1/ns1:reglaValidacion) }</reglaVal>
            <codPais>{ data($verificarListaInternacional1/ns1:codPais) }</codPais>
        </ns0:verificarListaInternacional>
};

declare variable $verificarListaInternacional1 as element(ns1:verificarListaInternacional) external;

xf:VerificarListaInternacional($verificarListaInternacional1)
