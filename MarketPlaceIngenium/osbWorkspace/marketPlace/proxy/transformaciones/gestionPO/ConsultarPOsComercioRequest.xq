(:: pragma bea:global-element-parameter parameter="$consultarPOsComercio1" element="ns1:consultarPOsComercio" location="../../wsdls/gestionPO/GestionPO.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarPOsComercio" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/ConsultarPOsComercioRequest/";

declare function xf:ConsultarPOsComercioRequest($consultarPOsComercio1 as element(ns1:consultarPOsComercio))
    as element(ns0:consultarPOsComercio) {
        <ns0:consultarPOsComercio>
            <nit>{ data($consultarPOsComercio1/ns1:nitComercio) }</nit>
        </ns0:consultarPOsComercio>
};

declare variable $consultarPOsComercio1 as element(ns1:consultarPOsComercio) external;

xf:ConsultarPOsComercioRequest($consultarPOsComercio1)
