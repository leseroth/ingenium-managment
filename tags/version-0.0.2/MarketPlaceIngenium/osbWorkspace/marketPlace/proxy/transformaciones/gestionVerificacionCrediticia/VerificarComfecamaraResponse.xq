(:: pragma bea:global-element-parameter parameter="$verificarComfecamaraResponse1" element="ns0:verificarComfecamaraResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137073593.xsd" ::)
(:: pragma bea:global-element-return element="ns1:verificarComfecamaraResponse" location="../../wsdls/gestionVerificacionCrediticia/GestionVerificacionCrediticia.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionVerificacionCrediticia/VerificarComfecamaraResponse/";

declare function xf:VerificarComfecamaraResponse($verificarComfecamaraResponse1 as element(ns0:verificarComfecamaraResponse))
    as element(ns1:verificarComfecamaraResponse) {
        <ns1:verificarComfecamaraResponse>
            <ns1:validacion>{ data($verificarComfecamaraResponse1/return) }</ns1:validacion>
        </ns1:verificarComfecamaraResponse>
};

declare variable $verificarComfecamaraResponse1 as element(ns0:verificarComfecamaraResponse) external;

xf:VerificarComfecamaraResponse($verificarComfecamaraResponse1)
