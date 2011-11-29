(:: pragma bea:global-element-parameter parameter="$registrarOfertaResponse1" element="ns1:registrarOfertaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarOfertaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/RegistrarOfertaRespons/";

declare function xf:RegistrarOfertaRespons($registrarOfertaResponse1 as element(ns1:registrarOfertaResponse))
    as element(ns0:registrarOfertaResponse) {
        <ns0:registrarOfertaResponse>
            <ns0:resultado>{ data($registrarOfertaResponse1/return) }</ns0:resultado>
        </ns0:registrarOfertaResponse>
};

declare variable $registrarOfertaResponse1 as element(ns1:registrarOfertaResponse) external;

xf:RegistrarOfertaRespons($registrarOfertaResponse1)