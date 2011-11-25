(:: pragma bea:global-element-parameter parameter="$verificarComfecamara1" element="ns1:verificarComfecamara" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)
(:: pragma bea:global-element-return element="ns0:verificarComfecamara" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarComfecamaraRequest/";

declare function xf:VerificarComfecamaraRequest($verificarComfecamara1 as element(ns1:verificarComfecamara))
    as element(ns0:verificarComfecamara) {
        <ns0:verificarComfecamara>
            <nit>{ data($verificarComfecamara1/ns1:nit) }</nit>
            <reglaVal>{ data($verificarComfecamara1/ns1:reglaValidacion) }</reglaVal>
        </ns0:verificarComfecamara>
};

declare variable $verificarComfecamara1 as element(ns1:verificarComfecamara) external;

xf:VerificarComfecamaraRequest($verificarComfecamara1)
