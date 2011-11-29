(:: pragma bea:global-element-parameter parameter="$darGanadorSubasta1" element="ns0:darGanadorSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:darGanadorSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/DarGanadorSubastaRequest2/";

declare function xf:DarGanadorSubastaRequest2($darGanadorSubasta1 as element(ns0:darGanadorSubasta))
    as element(ns1:darGanadorSubasta) {
        <ns1:darGanadorSubasta>
            <idSubasta>{ data($darGanadorSubasta1/ns0:numSeguimientoSub) }</idSubasta>
        </ns1:darGanadorSubasta>
};

declare variable $darGanadorSubasta1 as element(ns0:darGanadorSubasta) external;

xf:DarGanadorSubastaRequest2($darGanadorSubasta1)
