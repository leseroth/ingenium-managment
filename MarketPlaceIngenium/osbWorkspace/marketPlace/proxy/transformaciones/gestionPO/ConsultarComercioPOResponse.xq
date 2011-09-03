(:: pragma bea:global-element-parameter parameter="$consultarComercioPorPOResponse1" element="ns0:consultarComercioPorPOResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarComercioPOResponse" location="../../wsdls/gestionPO/GestionPO.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/ConsultarComercioPOResponse/";

declare function xf:ConsultarComercioPOResponse($consultarComercioPorPOResponse1 as element(ns0:consultarComercioPorPOResponse))
    as element(ns1:consultarComercioPOResponse) {
        <ns1:consultarComercioPOResponse>
            <ns1:comercio>
                <nombre>{ data($consultarComercioPorPOResponse1/return/nombre) }</nombre>
                <nit>{ data($consultarComercioPorPOResponse1/return/nit) }</nit>
            </ns1:comercio>
        </ns1:consultarComercioPOResponse>
};

declare variable $consultarComercioPorPOResponse1 as element(ns0:consultarComercioPorPOResponse) external;

xf:ConsultarComercioPOResponse($consultarComercioPorPOResponse1)
