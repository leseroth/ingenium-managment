(:: pragma bea:global-element-parameter parameter="$actualizarEstadoPOResponse1" element="ns0:actualizarEstadoPOResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/ActualizarEstadoPOResponse/";

declare function xf:ActualizarEstadoPOResponse($actualizarEstadoPOResponse1 as element(ns0:actualizarEstadoPOResponse))
    as xs:boolean {
        data($actualizarEstadoPOResponse1/return)
};

declare variable $actualizarEstadoPOResponse1 as element(ns0:actualizarEstadoPOResponse) external;

xf:ActualizarEstadoPOResponse($actualizarEstadoPOResponse1)
