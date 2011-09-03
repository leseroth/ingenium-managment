(:: pragma bea:global-element-parameter parameter="$crearCuentaFacturacionResponse1" element="ns1:crearCuentaFacturacionResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:crearCuentaFacturacionResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/CrearCuentaFacturacionResponse/";

declare function xf:CrearCuentaFacturacionResponse($crearCuentaFacturacionResponse1 as element(ns1:crearCuentaFacturacionResponse))
    as element(ns0:crearCuentaFacturacionResponse) {
        <ns0:crearCuentaFacturacionResponse>
            <ns0:numCuenta>{ data($crearCuentaFacturacionResponse1/return) }</ns0:numCuenta>
        </ns0:crearCuentaFacturacionResponse>
};

declare variable $crearCuentaFacturacionResponse1 as element(ns1:crearCuentaFacturacionResponse) external;

xf:CrearCuentaFacturacionResponse($crearCuentaFacturacionResponse1)
