(:: pragma bea:global-element-parameter parameter="$crearSubastaResponse1" element="ns1:crearSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:crearSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/CrearSubastaResponse/";

declare function xf:CrearSubastaResponse($crearSubastaResponse1 as element(ns1:crearSubastaResponse))
    as element(ns0:crearSubastaResponse) {
        <ns0:crearSubastaResponse>
            <ns0:numSeguimientoSub>{ data($crearSubastaResponse1/return) }</ns0:numSeguimientoSub>
        </ns0:crearSubastaResponse>
};

declare variable $crearSubastaResponse1 as element(ns1:crearSubastaResponse) external;

xf:CrearSubastaResponse($crearSubastaResponse1)