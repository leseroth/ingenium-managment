(:: pragma bea:global-element-parameter parameter="$actualizarEstadoPO1" element="ns1:actualizarEstadoPO" location="../../wsdls/gestionPO/PoManagerPoManagementService_schema1.xsd" ::)
(:: pragma bea:global-element-return element="ns0:actualizarEstadoPO" location="../../../business/wsdls/poManager/PoManagerPoManagementService_schema1.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/ActualizarEstadoPO/";

declare function xf:ActualizarEstadoPO($actualizarEstadoPO1 as element(ns1:actualizarEstadoPO))
    as element(ns0:actualizarEstadoPO) {
        <ns0:actualizarEstadoPO>
            <numSeguimiento>{ data($actualizarEstadoPO1/ns1:numSeguimiento) }</numSeguimiento>
            <estado>{ data($actualizarEstadoPO1/ns1:estado) }</estado>
        </ns0:actualizarEstadoPO>
};

declare variable $actualizarEstadoPO1 as element(ns1:actualizarEstadoPO) external;

xf:ActualizarEstadoPO($actualizarEstadoPO1)
