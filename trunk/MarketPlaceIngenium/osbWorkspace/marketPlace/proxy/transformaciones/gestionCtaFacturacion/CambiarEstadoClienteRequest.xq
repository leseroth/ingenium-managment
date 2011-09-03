(:: pragma bea:global-element-parameter parameter="$cambiarEstadoCliente1" element="ns0:cambiarEstadoCliente" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:cambiarEstadoCliente" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/CambiarEstadoClienteRequest/";

declare function xf:CambiarEstadoClienteRequest($cambiarEstadoCliente1 as element(ns0:cambiarEstadoCliente))
    as element(ns1:cambiarEstadoCliente) {
        <ns1:cambiarEstadoCliente>
            <nit>{ data($cambiarEstadoCliente1/ns0:nit) }</nit>
            <estado>{ data($cambiarEstadoCliente1/ns0:estado) }</estado>
        </ns1:cambiarEstadoCliente>
};

declare variable $cambiarEstadoCliente1 as element(ns0:cambiarEstadoCliente) external;

xf:CambiarEstadoClienteRequest($cambiarEstadoCliente1)
