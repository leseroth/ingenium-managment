(:: pragma bea:global-element-parameter parameter="$consultarDAsFabricanteResponse1" element="ns0:consultarDAsFabricanteResponse" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarDAsFabricanteResponse" location="../../wsdls/gestionDA/GestionDA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/ConsultarDAsFabricanteResponse/";

declare function xf:ConsultarDAsFabricanteResponse($consultarDAsFabricanteResponse1 as element(ns0:consultarDAsFabricanteResponse))
    as element(ns1:consultarDAsFabricanteResponse) {
        <ns1:consultarDAsFabricanteResponse>
            <ns1:das>
                <numSeguimiento>{ data($consultarDAsFabricanteResponse1/return[1]/numSeguimiento) }</numSeguimiento>
                <fechaEmision>{ data($consultarDAsFabricanteResponse1/return[1]/fechaEmision) }</fechaEmision>
                <fechaLlegada>{ data($consultarDAsFabricanteResponse1/return[1]/fechaLlegada) }</fechaLlegada>
                <montoOperacion>{ data($consultarDAsFabricanteResponse1/return[1]/montoOperacion) }</montoOperacion>
                <camiones>{ data($consultarDAsFabricanteResponse1/return[1]/camiones) }</camiones>
                {
                    let $po := $consultarDAsFabricanteResponse1/return[1]/po
                    return
                        <ordenCompra>
                            <fechaMaxima>{ data($po/entrega) }</fechaMaxima>
                            {
                                let $comercio := $po/comercio
                                return
                                    <comercio>
                                        <nombre>{ data($comercio/nombre) }</nombre>
                                        <nit>{ data($comercio/nit) }</nit>
                                    </comercio>
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
                    for $items in $consultarDAsFabricanteResponse1/return[1]/items
                    return
                        <items>
                            {
                                for $cantidad in $items/cantidad
                                return
                                    <cantidad>{ data($cantidad) }</cantidad>
                            }
                            {
                                let $producto := $items/producto
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
                        </items>
                }
                {
                    let $fabricante := $consultarDAsFabricanteResponse1/return[1]/fabricante
                    return
                        <fabricante>
                            <nombre>{ data($fabricante/nombre) }</nombre>
                            <nit>{ data($fabricante/nit) }</nit>
                        </fabricante>
                }
            </ns1:das>
        </ns1:consultarDAsFabricanteResponse>
};

declare variable $consultarDAsFabricanteResponse1 as element(ns0:consultarDAsFabricanteResponse) external;

xf:ConsultarDAsFabricanteResponse($consultarDAsFabricanteResponse1)
