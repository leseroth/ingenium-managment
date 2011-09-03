(:: pragma bea:global-element-parameter parameter="$asignarFabricantesSubastaResponse1" element="ns1:asignarFabricantesSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:asignarFabricantesSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/AsignarFabricantesSubastaResponse/";

declare function xf:AsignarFabricantesSubastaResponse($asignarFabricantesSubastaResponse1 as element(ns1:asignarFabricantesSubastaResponse))
    as element(ns0:asignarFabricantesSubastaResponse) {
        <ns0:asignarFabricantesSubastaResponse>
            <ns0:resultado>{ data($asignarFabricantesSubastaResponse1/return) }</ns0:resultado>
        </ns0:asignarFabricantesSubastaResponse>
};

declare variable $asignarFabricantesSubastaResponse1 as element(ns1:asignarFabricantesSubastaResponse) external;

xf:AsignarFabricantesSubastaResponse($asignarFabricantesSubastaResponse1)
