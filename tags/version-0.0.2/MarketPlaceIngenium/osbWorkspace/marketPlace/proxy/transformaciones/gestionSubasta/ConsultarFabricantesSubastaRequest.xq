(:: pragma bea:global-element-parameter parameter="$consultarFabricantesSubasta1" element="ns0:consultarFabricantesSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarFabricantesSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarFabricantesSubastaRequest/";

declare function xf:ConsultarFabricantesSubastaRequest($consultarFabricantesSubasta1 as element(ns0:consultarFabricantesSubasta))
    as element(ns1:consultarFabricantesSubasta) {
        <ns1:consultarFabricantesSubasta>
            <numSeguimiento>{ data($consultarFabricantesSubasta1/ns0:numSeguimiento) }</numSeguimiento>
        </ns1:consultarFabricantesSubasta>
};

declare variable $consultarFabricantesSubasta1 as element(ns0:consultarFabricantesSubasta) external;

xf:ConsultarFabricantesSubastaRequest($consultarFabricantesSubasta1)
