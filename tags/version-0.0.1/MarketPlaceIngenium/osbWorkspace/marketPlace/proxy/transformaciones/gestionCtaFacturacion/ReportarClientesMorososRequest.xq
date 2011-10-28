(:: pragma bea:global-element-parameter parameter="$reportarClientesMorosos1" element="ns0:reportarClientesMorosos" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:reportarClientesMorosos" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/ReportarClientesMorososRequest/";

declare function xf:ReportarClientesMorososRequest($reportarClientesMorosos1 as element(ns0:reportarClientesMorosos))
    as element(ns1:reportarClientesMorosos) {
        <ns1:reportarClientesMorosos>
            <corte>{ data($reportarClientesMorosos1/ns0:corte) }</corte>
        </ns1:reportarClientesMorosos>
};

declare variable $reportarClientesMorosos1 as element(ns0:reportarClientesMorosos) external;

xf:ReportarClientesMorososRequest($reportarClientesMorosos1)
