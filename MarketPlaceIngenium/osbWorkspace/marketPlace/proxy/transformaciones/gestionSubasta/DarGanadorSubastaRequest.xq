(:: pragma bea:global-element-parameter parameter="$darGanadorSubasta1" element="ns0:darGanadorSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns0:darGanadorSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/DarGanadorSubastaRequest/";

declare function xf:DarGanadorSubastaRequest($darGanadorSubasta1 as element(ns0:darGanadorSubasta))
    as element(ns0:darGanadorSubasta) {
        <ns0:darGanadorSubasta>
            <ns0:numSeguimientoSub>{ data($darGanadorSubasta1/ns0:numSeguimientoSub) }</ns0:numSeguimientoSub>
        </ns0:darGanadorSubasta>
};

declare variable $darGanadorSubasta1 as element(ns0:darGanadorSubasta) external;

xf:DarGanadorSubastaRequest($darGanadorSubasta1)
