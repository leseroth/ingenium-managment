(:: pragma bea:global-element-parameter parameter="$consultarCuentaFacturacionCliente1" element="ns0:consultarCuentaFacturacionCliente" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarCuentaFacturacionCliente" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/ConsultarCuentaFacturacionClienteRequest/";

declare function xf:ConsultarCuentaFacturacionClienteRequest($consultarCuentaFacturacionCliente1 as element(ns0:consultarCuentaFacturacionCliente))
    as element(ns1:consultarCuentaFacturacionCliente) {
        <ns1:consultarCuentaFacturacionCliente>
            <nit>{ data($consultarCuentaFacturacionCliente1/ns0:nit) }</nit>
        </ns1:consultarCuentaFacturacionCliente>
};

declare variable $consultarCuentaFacturacionCliente1 as element(ns0:consultarCuentaFacturacionCliente) external;

xf:ConsultarCuentaFacturacionClienteRequest($consultarCuentaFacturacionCliente1)
