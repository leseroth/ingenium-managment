(:: pragma bea:global-element-parameter parameter="$establecerFabricanteAtiendeResponse1" element="ns0:establecerFabricanteAtiendeResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/EstablecerFabricanteAtiendeResponse/";

declare function xf:EstablecerFabricanteAtiendeResponse($establecerFabricanteAtiendeResponse1 as element(ns0:establecerFabricanteAtiendeResponse))
    as xs:boolean {
        data($establecerFabricanteAtiendeResponse1/return)
};

declare variable $establecerFabricanteAtiendeResponse1 as element(ns0:establecerFabricanteAtiendeResponse) external;

xf:EstablecerFabricanteAtiendeResponse($establecerFabricanteAtiendeResponse1)
