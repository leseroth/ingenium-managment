(:: pragma bea:global-element-parameter parameter="$consultarCuentaFacturacionClienteResponse1" element="ns1:consultarCuentaFacturacionClienteResponse" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarCuentaFacturacionResponse" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/ConsultarCuentaFacturacionResponse/";

declare function xf:ConsultarCuentaFacturacionResponse($consultarCuentaFacturacionClienteResponse1 as element(ns1:consultarCuentaFacturacionClienteResponse))
    as element(ns0:consultarCuentaFacturacionResponse) {
        <ns0:consultarCuentaFacturacionResponse>
            <ns0:cuentaFacturacion>
                <numReferencia>{ data($consultarCuentaFacturacionClienteResponse1/return/numeroCuenta) }</numReferencia>
                {
                    for $cargos in $consultarCuentaFacturacionClienteResponse1/return/cargos
                    return
                        <transacciones>
                            <referencia>{ data($cargos/referencia) }</referencia>
                            <fecha>{ data($cargos/fecha) }</fecha>
                            <descripcion>{ data($cargos/descripcion) }</descripcion>
                            <valor>{ data($cargos/valor) }</valor>
                        </transacciones>
                }
                {
                    for $facturas in $consultarCuentaFacturacionClienteResponse1/return/facturas
                    return
                        <facturas>
                            <ns0:url>{ data($facturas/url) }</ns0:url>
                            <ns0:nombre>{ data($facturas/nombreArchivo) }</ns0:nombre>
                            <ns0:fechaInicio>{ data($facturas/fechaInicio) }</ns0:fechaInicio>
                            <ns0:fechaFin>{ data($facturas/fechaFin) }</ns0:fechaFin>
                            <ns0:valorPago>{ data($facturas/valorPago) }</ns0:valorPago>
                        </facturas>
                }
            </ns0:cuentaFacturacion>
        </ns0:consultarCuentaFacturacionResponse>
};

declare variable $consultarCuentaFacturacionClienteResponse1 as element(ns1:consultarCuentaFacturacionClienteResponse) external;

xf:ConsultarCuentaFacturacionResponse($consultarCuentaFacturacionClienteResponse1)
