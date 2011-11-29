(:: pragma bea:global-element-parameter parameter="$consultarSubastaOrdenCompra1" element="ns0:consultarSubastaOrdenCompra" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarSubastaOrdenCompra" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastaOrdenCompraRequest/";

declare function xf:ConsultarSubastaOrdenCompraRequest($consultarSubastaOrdenCompra1 as element(ns0:consultarSubastaOrdenCompra))
    as element(ns1:consultarSubastaOrdenCompra) {
        <ns1:consultarSubastaOrdenCompra>
            <numSeguimientoPO>{ data($consultarSubastaOrdenCompra1/ns0:numSeguimientoPO) }</numSeguimientoPO>
        </ns1:consultarSubastaOrdenCompra>
};

declare variable $consultarSubastaOrdenCompra1 as element(ns0:consultarSubastaOrdenCompra) external;

xf:ConsultarSubastaOrdenCompraRequest($consultarSubastaOrdenCompra1)
