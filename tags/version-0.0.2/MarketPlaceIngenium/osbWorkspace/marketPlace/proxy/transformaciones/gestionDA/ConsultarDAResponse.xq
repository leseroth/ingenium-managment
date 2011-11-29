(:: pragma bea:global-element-parameter parameter="$consultarDAResponse1" element="ns0:consultarDAResponse" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarDAResponse" location="../../wsdls/gestionDA/GestionDA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionDA/consultarDAResponse/";

declare function xf:consultarDAResponse($consultarDAResponse1 as element(ns0:consultarDAResponse))
    as element(ns1:consultarDAResponse) {
        <ns1:consultarDAResponse>
            <ns1:da>
                <numSeguimiento>{ data($consultarDAResponse1/return/numSeguimiento) }</numSeguimiento>
                <fechaEmision>{ data($consultarDAResponse1/return/fechaEmision) }</fechaEmision>
                <fechaLlegada>{ data($consultarDAResponse1/return/fechaLlegada) }</fechaLlegada>
                <montoOperacion>{ data($consultarDAResponse1/return/montoOperacion) }</montoOperacion>
                <camiones>{ data($consultarDAResponse1/return/camiones) }</camiones>
                {
                    let $po := $consultarDAResponse1/return/po
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
                <items>
                    {
                        for $cantidad in $consultarDAResponse1/return/items[1]/cantidad
                        return
                            <cantidad>{ data($cantidad) }</cantidad>
                    }
                    <producto>
                        <nombre>{ data($consultarDAResponse1/return/items[1]/producto/nombre) }</nombre>
                        {
                            for $categoria in $consultarDAResponse1/return/items[1]/producto/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                    </producto>
                </items>
                <fabricante>
                    <nombre>{ data($consultarDAResponse1/return/fabricante/nombre) }</nombre>
                    <nit>{ data($consultarDAResponse1/return/fabricante/nit) }</nit>
                </fabricante>
            </ns1:da>
        </ns1:consultarDAResponse>
};

declare variable $consultarDAResponse1 as element(ns0:consultarDAResponse) external;

xf:consultarDAResponse($consultarDAResponse1)
