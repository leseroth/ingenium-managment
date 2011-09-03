(:: pragma bea:global-element-parameter parameter="$consultarRMAsComercio1" element="ns1:consultarRMAsComercio" location="../../wsdls/gestionRMA/GestionRMA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarRMAsComercio" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionRMA/consultarRMAsComercio/";

declare function xf:consultarRMAsComercio($consultarRMAsComercio1 as element(ns1:consultarRMAsComercio))
    as element(ns0:consultarRMAsComercio) {
        <ns0:consultarRMAsComercio>
            <nit>{ data($consultarRMAsComercio1/nitComercio) }</nit>
        </ns0:consultarRMAsComercio>
};

declare variable $consultarRMAsComercio1 as element(ns1:consultarRMAsComercio) external;

xf:consultarRMAsComercio($consultarRMAsComercio1)
