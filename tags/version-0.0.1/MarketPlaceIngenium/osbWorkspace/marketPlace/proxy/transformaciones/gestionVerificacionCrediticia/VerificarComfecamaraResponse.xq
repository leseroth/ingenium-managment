(:: pragma bea:global-element-parameter parameter="$vcResponse1" element="ns0:verificarComfecamaraResponse" location="../../../business/wsdls/RiskQualification/XMLSchema_-2137028766.xsd" ::)

declare namespace ns0 = "http://ws.riskqualification.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/VerificacionCrediticia/VerificarComfecamaraResponse/";

declare function xf:VerificarComfecamaraResponse($vcResponse1 as element(ns0:verificarComfecamaraResponse))
    as xs:boolean {
        data($vcResponse1/return)
};

declare variable $vcResponse1 as element(ns0:verificarComfecamaraResponse) external;

xf:VerificarComfecamaraResponse($vcResponse1)