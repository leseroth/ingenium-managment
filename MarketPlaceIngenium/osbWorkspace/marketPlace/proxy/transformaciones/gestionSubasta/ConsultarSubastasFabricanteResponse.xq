(:: pragma bea:global-element-parameter parameter="$consultarSubastasFabricanteResponse1" element="ns1:consultarSubastasFabricanteResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarSubastasFabricanteResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastasFabricanteResponse12/";

declare function xf:ConsultarSubastasFabricanteResponse12($consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse))
    as element(ns0:consultarSubastasFabricanteResponse) {
        <ns0:consultarSubastasFabricanteResponse>
            {
                for $return in $consultarSubastasFabricanteResponse1/return
                return
                    <ns0:subastas>
                        {
                            for $numSeguimiento in $return/numSeguimiento
                            return
                                <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                        }
                        {
                            let $purchaseOrderBO := $return/purchaseOrderBO
                            return
                                <ordenCompra>
                                    {
                                        let $itemPOBO := $purchaseOrderBO/itemPOBO
                                        return
                                            <item>
                                                <cantidad>{ data($itemPOBO/cantidad) }</cantidad>
                                                {
                                                    let $productoBO := $itemPOBO/productoBO
                                                    return
                                                        <producto>
                                                            <nombre>{ data($productoBO/nombre) }</nombre>
                                                            <categoria>{ data($productoBO/categoria) }</categoria>
                                                            {
                                                                for $peso in $productoBO/peso
                                                                return
                                                                    <pesoLibras>{ data($peso) }</pesoLibras>
                                                            }
                                                        </producto>
                                                }
                                            </item>
                                    }
                                </ordenCompra>
                        }
                        {
                            for $ofertaBOList in $return/ofertaBOList
                            return
                                <ofertas>
                                    <numSeguimiento>{ data($ofertaBOList/numSeguimiento) }</numSeguimiento>
                                    <horarioEntrega>{ data($ofertaBOList/fechaEntrega) }</horarioEntrega>
                                    {
                                        for $mensaje in $ofertaBOList/mensaje
                                        return
                                            <mensaje>{ data($mensaje) }</mensaje>
                                    }
                                    {
                                        for $valor in $ofertaBOList/valor
                                        return
                                            <valor>{ data($valor) }</valor>
                                    }
                                    {
                                        for $estadoOferta in $ofertaBOList/estadoOferta
                                        return
                                            <estadoOferta>{ data($estadoOferta) }</estadoOferta>
                                    }
                                </ofertas>
                        }
                    </ns0:subastas>
            }
        </ns0:consultarSubastasFabricanteResponse>
};

declare variable $consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse) external;

xf:ConsultarSubastasFabricanteResponse12($consultarSubastasFabricanteResponse1)
