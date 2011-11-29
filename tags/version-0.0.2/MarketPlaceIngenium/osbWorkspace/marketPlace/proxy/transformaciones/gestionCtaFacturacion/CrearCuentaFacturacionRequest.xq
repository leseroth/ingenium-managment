(:: pragma bea:global-element-parameter parameter="$crearCuentaFacturacion1" element="ns0:crearCuentaFacturacion" location="../../wsdls/gestionFacturacion/GestionFacturacion.xsd" ::)
(:: pragma bea:global-element-return element="ns1:crearCuentaFacturacion" location="../../../business/wsdls/BillingCharges/XMLSchema_-403116747.xsd" ::)

declare namespace ns1 = "http://ws.facturacion.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCtaFacturacion/CrearCuentaFacturacionRequest/";

declare function xf:CrearCuentaFacturacionRequest($crearCuentaFacturacion1 as element(ns0:crearCuentaFacturacion))
    as element(ns1:crearCuentaFacturacion) {
        <ns1:crearCuentaFacturacion>
            {
                let $cliente := $crearCuentaFacturacion1/ns0:cliente
                return
                    <cliente>
                        {
                            for $direccion in $cliente/direccion
                            return
                                <direccion>{ data($direccion) }</direccion>
                        }
                        {
                            for $email in $cliente/email
                            return
                                <email>{ data($email) }</email>
                        }
                        <nit>{ data($cliente/nit) }</nit>
                        <nombre>{ data($cliente/nombre) }</nombre>
                    </cliente>
            }
        </ns1:crearCuentaFacturacion>
};

declare variable $crearCuentaFacturacion1 as element(ns0:crearCuentaFacturacion) external;

xf:CrearCuentaFacturacionRequest($crearCuentaFacturacion1)
