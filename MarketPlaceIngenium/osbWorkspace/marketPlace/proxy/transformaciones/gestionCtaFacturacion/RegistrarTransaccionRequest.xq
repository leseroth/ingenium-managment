(:: pragma bea:global-element-parameter parameter="$registrarTransaccion1" element="ns0:registrarTransaccion" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:registrarTransaccion" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/RegistrarTransaccionRequest/";

declare function xf:RegistrarTransaccionRequest($registrarTransaccion1 as element(ns0:registrarTransaccion))
    as element(ns1:registrarTransaccion) {
        <ns1:registrarTransaccion>
            {
                let $result :=
                    for $transaccion in $registrarTransaccion1/ns0:transaccion
                    return
                        <cargo>
                            <descripcion>{ data($transaccion/descripcion) }</descripcion>
                            <fecha>{ data($transaccion/fecha) }</fecha>
                            <referencia>{ data($transaccion/referencia) }</referencia>
                            <valor>{ data($transaccion/valor) }</valor>
                        </cargo>
                return
                    $result[1]
            }
            <numeroCuenta>{ data($registrarTransaccion1/ns0:numCuenta) }</numeroCuenta>
        </ns1:registrarTransaccion>
};

declare variable $registrarTransaccion1 as element(ns0:registrarTransaccion) external;

xf:RegistrarTransaccionRequest($registrarTransaccion1)
