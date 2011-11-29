(:: pragma bea:global-element-parameter parameter="$consultarDA1" element="ns1:consultarDA" location="../../wsdls/gestionDA/GestionDA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarDA" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/ConsultarDARequest/";

declare function xf:ConsultarDARequest($consultarDA1 as element(ns1:consultarDA))
    as element(ns0:consultarDA) {
        <ns0:consultarDA>
            <numSeguimiento>{ data($consultarDA1/ns1:numSeguimiento) }</numSeguimiento>
        </ns0:consultarDA>
};

declare variable $consultarDA1 as element(ns1:consultarDA) external;

xf:ConsultarDARequest($consultarDA1)
