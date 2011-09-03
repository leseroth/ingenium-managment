(:: pragma bea:global-element-parameter parameter="$registrarTransaccionResponse1" element="ns1:registrarTransaccionResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarTransaccionResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/RegistrarTransaccionResponse/";

declare function xf:RegistrarTransaccionResponse($registrarTransaccionResponse1 as element(ns1:registrarTransaccionResponse))
    as element(ns0:registrarTransaccionResponse) {
        <ns0:registrarTransaccionResponse>
            <ns0:resultado>{ data($registrarTransaccionResponse1/return) }</ns0:resultado>
        </ns0:registrarTransaccionResponse>
};

declare variable $registrarTransaccionResponse1 as element(ns1:registrarTransaccionResponse) external;

xf:RegistrarTransaccionResponse($registrarTransaccionResponse1)
