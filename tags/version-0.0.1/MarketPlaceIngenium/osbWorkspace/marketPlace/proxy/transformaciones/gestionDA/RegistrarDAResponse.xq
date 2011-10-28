(:: pragma bea:global-element-parameter parameter="$registrarDAResponse1" element="ns0:registrarDAResponse" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)
(:: pragma bea:global-element-return element="ns1:registrarDAResponse" location="../../wsdls/gestionDA/GestionDA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/RegistrarDAResponse/";

declare function xf:RegistrarDAResponse($registrarDAResponse1 as element(ns0:registrarDAResponse))
    as element(ns1:registrarDAResponse) {
        <ns1:registrarDAResponse>
            <ns1:numSeguimiento>{ data($registrarDAResponse1/return) }</ns1:numSeguimiento>
        </ns1:registrarDAResponse>
};

declare variable $registrarDAResponse1 as element(ns0:registrarDAResponse) external;

xf:RegistrarDAResponse($registrarDAResponse1)
