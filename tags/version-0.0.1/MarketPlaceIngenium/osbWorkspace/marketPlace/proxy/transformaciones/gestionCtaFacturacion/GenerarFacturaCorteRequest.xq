(:: pragma bea:global-element-parameter parameter="$generarFacturaCorte1" element="ns0:generarFacturaCorte" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:generarFacturaCorte" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/GenerarFacturaCorteRequest/";

declare function xf:GenerarFacturaCorteRequest($generarFacturaCorte1 as element(ns0:generarFacturaCorte))
    as element(ns1:generarFacturaCorte) {
        <ns1:generarFacturaCorte>
            <corte>{ data($generarFacturaCorte1/ns0:corte) }</corte>
            <plazo>{ data($generarFacturaCorte1/ns0:plazo) }</plazo>
        </ns1:generarFacturaCorte>
};

declare variable $generarFacturaCorte1 as element(ns0:generarFacturaCorte) external;

xf:GenerarFacturaCorteRequest($generarFacturaCorte1)
