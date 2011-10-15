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
                                        for $id in $purchaseOrderBO/id
                                        return
                                            <id>{ data($id) }</id>
                                    }
                                    {
                                        for $numSeguimiento in $purchaseOrderBO/numSeguimiento
                                        return
                                            <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                                    }
                                </ordenCompra>
                        }
                        {
                            for $mejorOfertaBO in $return/mejorOfertaBO
                            return
                                <mejor>
                                    {
                                        for $id in $mejorOfertaBO/id
                                        return
                                            <id>{ data($id) }</id>
                                    }
                                    <numSeguimiento>{ data($mejorOfertaBO/numSeguimiento) }</numSeguimiento>
                                    {
                                        let $fabricanteBO := $mejorOfertaBO/fabricanteBO
                                        return
                                            <fabricante/>
                                    }
                                </mejor>
                        }
                        {
                            for $ofertaBOList in $return/ofertaBOList
                            return
                                <ofertas/>
                        }
                    </ns0:subastas>
            }
        </ns0:consultarSubastasFabricanteResponse>
};

declare variable $consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse) external;

xf:ConsultarSubastasFabricanteResponse12($consultarSubastasFabricanteResponse1)
