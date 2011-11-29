(:: pragma bea:global-element-parameter parameter="$consultarComercioPO1" element="ns1:consultarComercioPO" location="../../wsdls/gestionPO/GestionPO.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarComercioPorPO" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/ConsultarComercioPORequest/";

declare function xf:ConsultarComercioPORequest($consultarComercioPO1 as element(ns1:consultarComercioPO))
    as element(ns0:consultarComercioPorPO) {
        <ns0:consultarComercioPorPO>
            <numSeguimiento>{ data($consultarComercioPO1/ns1:numSeguimientoPO) }</numSeguimiento>
        </ns0:consultarComercioPorPO>
};

declare variable $consultarComercioPO1 as element(ns1:consultarComercioPO) external;

xf:ConsultarComercioPORequest($consultarComercioPO1)
