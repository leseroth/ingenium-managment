(:: pragma bea:global-element-parameter parameter="$cerrarSubastaResponse1" element="ns1:cerrarSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:cerrarSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/cerra/";

declare function xf:cerra($cerrarSubastaResponse1 as element(ns1:cerrarSubastaResponse))
    as element(ns0:cerrarSubastaResponse) {
        <ns0:cerrarSubastaResponse>
            <ns0:resultado>{ data($cerrarSubastaResponse1/return) }</ns0:resultado>
        </ns0:cerrarSubastaResponse>
};

declare variable $cerrarSubastaResponse1 as element(ns1:cerrarSubastaResponse) external;

xf:cerra($cerrarSubastaResponse1)