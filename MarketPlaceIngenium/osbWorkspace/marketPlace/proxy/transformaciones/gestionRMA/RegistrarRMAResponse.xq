(:: pragma bea:global-element-parameter parameter="$registrarRMAResponse1" element="ns0:registrarRMAResponse" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)

declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionRMA/RegistrarRMAResponse/";

declare function xf:RegistrarRMAResponse($registrarRMAResponse1 as element(ns0:registrarRMAResponse))
    as xs:string {
        data($registrarRMAResponse1/return)
};

declare variable $registrarRMAResponse1 as element(ns0:registrarRMAResponse) external;

xf:RegistrarRMAResponse($registrarRMAResponse1)
