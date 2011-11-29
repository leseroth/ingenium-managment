(:: pragma bea:global-element-parameter parameter="$generarFacturaCorteResponse1" element="ns1:generarFacturaCorteResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:generarFacturaCorteResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/GenerarFacturaCorteResponse/";

declare function xf:GenerarFacturaCorteResponse($generarFacturaCorteResponse1 as element(ns1:generarFacturaCorteResponse))
    as element(ns0:generarFacturaCorteResponse) {
        <ns0:generarFacturaCorteResponse>
            <ns0:resultado>{ data($generarFacturaCorteResponse1/return) }</ns0:resultado>
        </ns0:generarFacturaCorteResponse>
};

declare variable $generarFacturaCorteResponse1 as element(ns1:generarFacturaCorteResponse) external;

xf:GenerarFacturaCorteResponse($generarFacturaCorteResponse1)
