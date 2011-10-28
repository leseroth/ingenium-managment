(:: pragma bea:global-element-parameter parameter="$consultarCuentaFacturacion1" element="ns0:consultarCuentaFacturacion" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarCuentaFacturacion" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/ConsultarCuentaFacturacionRequest/";

declare function xf:ConsultarCuentaFacturacionRequest($consultarCuentaFacturacion1 as element(ns0:consultarCuentaFacturacion))
    as element(ns1:consultarCuentaFacturacion) {
        <ns1:consultarCuentaFacturacion>
            <numeroCuenta>{ data($consultarCuentaFacturacion1/ns0:numeroCuenta) }</numeroCuenta>
        </ns1:consultarCuentaFacturacion>
};

declare variable $consultarCuentaFacturacion1 as element(ns0:consultarCuentaFacturacion) external;

xf:ConsultarCuentaFacturacionRequest($consultarCuentaFacturacion1)
