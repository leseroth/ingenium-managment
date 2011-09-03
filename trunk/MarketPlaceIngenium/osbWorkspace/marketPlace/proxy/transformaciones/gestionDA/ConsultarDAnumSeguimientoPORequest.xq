(:: pragma bea:global-element-parameter parameter="$consultarDAnumSeguimientoPO1" element="ns1:consultarDAnumSeguimientoPO" location="../../wsdls/gestionDA/GestionDA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarDAnumSeguimientoPO" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/ConsultarDAnumSeguimientoPORequest/";

declare function xf:ConsultarDAnumSeguimientoPORequest($consultarDAnumSeguimientoPO1 as element(ns1:consultarDAnumSeguimientoPO))
    as element(ns0:consultarDAnumSeguimientoPO) {
        <ns0:consultarDAnumSeguimientoPO>
            <numSeguimiento>{ data($consultarDAnumSeguimientoPO1/ns1:numSeguimientoPO) }</numSeguimiento>
        </ns0:consultarDAnumSeguimientoPO>
};

declare variable $consultarDAnumSeguimientoPO1 as element(ns1:consultarDAnumSeguimientoPO) external;

xf:ConsultarDAnumSeguimientoPORequest($consultarDAnumSeguimientoPO1)
