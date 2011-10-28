(:: pragma bea:global-element-parameter parameter="$consultarRMAsFabricante1" element="ns1:consultarRMAsFabricante" location="../../wsdls/gestionRMA/GestionRMA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarRMAsFabricante" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionRMA/consultarRMASFabricante/";

declare function xf:consultarRMASFabricante($consultarRMAsFabricante1 as element(ns1:consultarRMAsFabricante))
    as element(ns0:consultarRMAsFabricante) {
        <ns0:consultarRMAsFabricante>
            <nit>{ data($consultarRMAsFabricante1/nitComercio) }</nit>
        </ns0:consultarRMAsFabricante>
};

declare variable $consultarRMAsFabricante1 as element(ns1:consultarRMAsFabricante) external;

xf:consultarRMASFabricante($consultarRMAsFabricante1)
