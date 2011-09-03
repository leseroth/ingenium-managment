(:: pragma bea:global-element-parameter parameter="$cambiarEstadoClienteResponse1" element="ns1:cambiarEstadoClienteResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:cambiarEstadoClienteResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/CambiarEstadoClienteResponse/";

declare function xf:CambiarEstadoClienteResponse($cambiarEstadoClienteResponse1 as element(ns1:cambiarEstadoClienteResponse))
    as element(ns0:cambiarEstadoClienteResponse) {
        <ns0:cambiarEstadoClienteResponse>
            <ns0:resultado>{ data($cambiarEstadoClienteResponse1/return) }</ns0:resultado>
        </ns0:cambiarEstadoClienteResponse>
};

declare variable $cambiarEstadoClienteResponse1 as element(ns1:cambiarEstadoClienteResponse) external;

xf:CambiarEstadoClienteResponse($cambiarEstadoClienteResponse1)
