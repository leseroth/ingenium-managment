(:: pragma bea:global-element-parameter parameter="$registrarPOResponse1" element="ns0:registrarPOResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketplace/proxy/transformaciones/gestionPO/RegistrarPOResponse/";

declare function xf:RegistrarPOResponse($registrarPOResponse1 as element(ns0:registrarPOResponse))
    as xs:string {
        data($registrarPOResponse1/return)
};

declare variable $registrarPOResponse1 as element(ns0:registrarPOResponse) external;

xf:RegistrarPOResponse($registrarPOResponse1)
