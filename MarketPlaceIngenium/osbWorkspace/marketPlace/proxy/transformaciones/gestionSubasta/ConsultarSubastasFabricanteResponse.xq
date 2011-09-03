(:: pragma bea:global-element-parameter parameter="$consultarSubastasFabricanteResponse1" element="ns1:consultarSubastasFabricanteResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarSubastasFabricanteResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastasFabricanteResponse/";

declare function xf:ConsultarSubastasFabricanteResponse($consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse))
    as element(ns0:consultarSubastasFabricanteResponse) {
        <ns0:consultarSubastasFabricanteResponse>
            {
                for $return in $consultarSubastasFabricanteResponse1/return
                return
                    <ns0:subastas>
                        <numSeguimiento>{ data($return/numSeguimiento) }</numSeguimiento>
                        {
                            let $po := $return/po
                            return
                                <ordenCompra>
                                    <fechaMaxima>{ data($po/entrega) }</fechaMaxima>
                                    <estado>{ data($po/estado) }</estado>
                                </ordenCompra>
                        }
                        {
                            let $mejor := $return/mejor
                            return
                                <mejor>
                                    <idSubasta>{ data($mejor/idSubasta) }</idSubasta>
                                    <horarioEntrega>{ data($mejor/fechaEntrega) }</horarioEntrega>
                                    {
                                        let $fabricante := $mejor/fabricante
                                        return
                                            <fabricante>
                                                <nombre>{ data($fabricante/nombre) }</nombre>
                                                <nit>{ data($fabricante/nit) }</nit>
                                                {
                                                    for $email in $fabricante/email
                                                    return
                                                        <email>{ data($email) }</email>
                                                }
                                            </fabricante>
                                    }
                                    <item>
                                        <valor>{ data($mejor/valor) }</valor>
                                        {
                                            let $productoOfrecido := $mejor/productoOfrecido
                                            return
                                                <producto>
                                                    <nombre>{ data($productoOfrecido/nombre) }</nombre>
                                                    {
                                                        for $categoria in $productoOfrecido/categoria
                                                        return
                                                            <categoria>{ data($categoria) }</categoria>
                                                    }
                                                </producto>
                                        }
                                    </item>
                                </mejor>
                        }
                        {
                            for $ofertas in $return/ofertas
                            return
                                <ofertas>
                                    <idSubasta>{ data($ofertas/idSubasta) }</idSubasta>
                                    <horarioEntrega>{ data($ofertas/fechaEntrega) }</horarioEntrega>
                                    {
                                        let $fabricante := $ofertas/fabricante
                                        return
                                            <fabricante>
                                                <nombre>{ data($fabricante/nombre) }</nombre>
                                                <nit>{ data($fabricante/nit) }</nit>
                                            </fabricante>
                                    }
                                    <item>
                                        <valor>{ data($ofertas/valor) }</valor>
                                        {
                                            let $productoOfrecido := $ofertas/productoOfrecido
                                            return
                                                <producto>
                                                    <nombre>{ data($productoOfrecido/nombre) }</nombre>
                                                    {
                                                        for $categoria in $productoOfrecido/categoria
                                                        return
                                                            <categoria>{ data($categoria) }</categoria>
                                                    }
                                                </producto>
                                        }
                                    </item>
                                </ofertas>
                        }
                    </ns0:subastas>
            }
        </ns0:consultarSubastasFabricanteResponse>
};

declare variable $consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse) external;

xf:ConsultarSubastasFabricanteResponse($consultarSubastasFabricanteResponse1)
