(:: pragma bea:global-element-parameter parameter="$consultarPO1" element="ns1:consultarPO" location="../../wsdls/gestionPO/GestionPO.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarPO" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/ConsultarPORequest/";

declare function xf:ConsultarPORequest($consultarPO1 as element(ns1:consultarPO))
    as element(ns0:consultarPO) {
        <ns0:consultarPO>
            <numSeguimiento>{ data($consultarPO1/ns1:numSeguimiento) }</numSeguimiento>
        </ns0:consultarPO>
};

declare variable $consultarPO1 as element(ns1:consultarPO) external;

xf:ConsultarPORequest($consultarPO1)
