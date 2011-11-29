(:: pragma bea:global-element-parameter parameter="$consultarSubastasFabricante1" element="ns0:consultarSubastasFabricante" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarSubastasFabricante" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastasFabricanteRequest/";

declare function xf:ConsultarSubastasFabricanteRequest($consultarSubastasFabricante1 as element(ns0:consultarSubastasFabricante))
    as element(ns1:consultarSubastasFabricante) {
        <ns1:consultarSubastasFabricante>
            <nit>{ data($consultarSubastasFabricante1/ns0:nit) }</nit>
        </ns1:consultarSubastasFabricante>
};

declare variable $consultarSubastasFabricante1 as element(ns0:consultarSubastasFabricante) external;

xf:ConsultarSubastasFabricanteRequest($consultarSubastasFabricante1)
