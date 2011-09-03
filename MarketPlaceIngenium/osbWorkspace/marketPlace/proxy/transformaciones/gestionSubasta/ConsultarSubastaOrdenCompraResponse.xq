(:: pragma bea:global-element-parameter parameter="$consultarSubastaOrdenCompraResponse1" element="ns1:consultarSubastaOrdenCompraResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarSubastaOrdenCompraResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastaOrdenCompraResponse/";

declare function xf:ConsultarSubastaOrdenCompraResponse($consultarSubastaOrdenCompraResponse1 as element(ns1:consultarSubastaOrdenCompraResponse))
    as element(ns0:consultarSubastaOrdenCompraResponse) {
        <ns0:consultarSubastaOrdenCompraResponse>
            <ns0:subasta>
                <numSeguimiento>{ data($consultarSubastaOrdenCompraResponse1/return/numSeguimiento) }</numSeguimiento>
                {
                    let $po := $consultarSubastaOrdenCompraResponse1/return/po
                    return
                        <ordenCompra>
                            {
                                let $item := $po/item
                                return
                                    <item>
                                        {
                                            for $cantidad in $item/cantidad
                                            return
                                                <cantidad>{ data($cantidad) }</cantidad>
                                        }
                                        {
                                            let $producto := $item/producto
                                            return
                                                <producto>
                                                    <nombre>{ data($producto/nombre) }</nombre>
                                                    {
                                                        for $categoria in $producto/categoria
                                                        return
                                                            <categoria>{ data($categoria) }</categoria>
                                                    }
                                                </producto>
                                        }
                                    </item>
                            }
                            <fechaMaxima>{ data($po/entrega) }</fechaMaxima>
                            {
                                let $comercio := $po/comercio
                                return
                                    <comercio>
                                        <nombre>{ data($comercio/nombre) }</nombre>
                                        <nit>{ data($comercio/nit) }</nit>
                                        {
                                            for $direccion in $comercio/direccion
                                            return
                                                <direccion>{ data($direccion) }</direccion>
                                        }
                                        {
                                            for $telefono in $comercio/telefono
                                            return
                                                <telefono>{ data($telefono) }</telefono>
                                        }
                                    </comercio>
                            }
                            {
                                for $fabricante in $po/fabricante
                                return
                                    <fabricanteAtiende>
                                        <nombre>{ data($fabricante/nombre) }</nombre>
                                        <nit>{ data($fabricante/nit) }</nit>
                                        {
                                            for $email in $fabricante/email
                                            return
                                                <email>{ data($email) }</email>
                                        }
                                    </fabricanteAtiende>
                            }
                            {
                                for $numSeguimiento in $po/numSeguimiento
                                return
                                    <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                            }
                            <estado>{ data($po/estado) }</estado>
                        </ordenCompra>
                }
                {
                    let $mejor := $consultarSubastaOrdenCompraResponse1/return/mejor
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
                            <numSeguimiento>{ data($mejor/numSeguimiento) }</numSeguimiento>
                        </mejor>
                }
                {
                    for $ofertas in $consultarSubastaOrdenCompraResponse1/return/ofertas
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
                                        {
                                            for $email in $fabricante/email
                                            return
                                                <email>{ data($email) }</email>
                                        }
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
                            <numSeguimiento>{ data($ofertas/numSeguimiento) }</numSeguimiento>
                        </ofertas>
                }
            </ns0:subasta>
        </ns0:consultarSubastaOrdenCompraResponse>
};

declare variable $consultarSubastaOrdenCompraResponse1 as element(ns1:consultarSubastaOrdenCompraResponse) external;

xf:ConsultarSubastaOrdenCompraResponse($consultarSubastaOrdenCompraResponse1)
