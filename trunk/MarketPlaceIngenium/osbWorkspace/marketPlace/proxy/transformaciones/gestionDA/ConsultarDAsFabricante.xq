(:: pragma bea:global-element-parameter parameter="$consultarDAsFabricante1" element="ns1:consultarDAsFabricante" location="../../wsdls/gestionDA/GestionDA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarDAsFabricante" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/ConsultarDAsFabricante/";

declare function xf:ConsultarDAsFabricante($consultarDAsFabricante1 as element(ns1:consultarDAsFabricante))
    as element(ns0:consultarDAsFabricante) {
        <ns0:consultarDAsFabricante>
            <nit>{ data($consultarDAsFabricante1/ns1:nit) }</nit>
        </ns0:consultarDAsFabricante>
};

declare variable $consultarDAsFabricante1 as element(ns1:consultarDAsFabricante) external;

xf:ConsultarDAsFabricante($consultarDAsFabricante1)
