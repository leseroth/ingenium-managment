(:: pragma bea:global-element-parameter parameter="$cerrarSubasta1" element="ns0:cerrarSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:cerrarSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/CerrarSubastaRequest/";

declare function xf:CerrarSubastaRequest($cerrarSubasta1 as element(ns0:cerrarSubasta))
    as element(ns1:cerrarSubasta) {
        <ns1:cerrarSubasta>
            <idSubasta>{ data($cerrarSubasta1/ns0:numSeguimientoSub) }</idSubasta>
        </ns1:cerrarSubasta>
};

declare variable $cerrarSubasta1 as element(ns0:cerrarSubasta) external;

xf:CerrarSubastaRequest($cerrarSubasta1)
