(:: pragma bea:global-element-parameter parameter="$reportarClientesMorososResponse1" element="ns1:reportarClientesMorososResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:reportarClientesMorososResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/ReportarClientesMorososResponse/";

declare function xf:ReportarClientesMorososResponse($reportarClientesMorososResponse1 as element(ns1:reportarClientesMorososResponse))
    as element(ns0:reportarClientesMorososResponse) {
        <ns0:reportarClientesMorososResponse>
            <ns0:resultado>{ data($reportarClientesMorososResponse1/return) }</ns0:resultado>
        </ns0:reportarClientesMorososResponse>
};

declare variable $reportarClientesMorososResponse1 as element(ns1:reportarClientesMorososResponse) external;

xf:ReportarClientesMorososResponse($reportarClientesMorososResponse1)
