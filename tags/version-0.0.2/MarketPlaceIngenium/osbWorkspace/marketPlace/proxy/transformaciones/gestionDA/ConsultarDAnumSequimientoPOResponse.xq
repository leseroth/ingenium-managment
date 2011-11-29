(:: pragma bea:global-element-parameter parameter="$consultarDAnumSeguimientoPOResponse1" element="ns0:consultarDAnumSeguimientoPOResponse" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarDAnumSeguimientoPOResponse" location="../../wsdls/gestionDA/GestionDA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/ConsultarDAnumSequimientoPOResponse/";

declare function xf:ConsultarDAnumSequimientoPOResponse($consultarDAnumSeguimientoPOResponse1 as element(ns0:consultarDAnumSeguimientoPOResponse))
    as element(ns1:consultarDAnumSeguimientoPOResponse) {
        <ns1:consultarDAnumSeguimientoPOResponse>
            {
                let $return := $consultarDAnumSeguimientoPOResponse1/return
                return
                    <ns1:da>
                        <numSeguimiento>{ data($return/numSeguimiento) }</numSeguimiento>
                        <fechaEmision>{ data($return/fechaEmision) }</fechaEmision>
                        <fechaLlegada>{ data($return/fechaLlegada) }</fechaLlegada>
                        <montoOperacion>{ data($return/montoOperacion) }</montoOperacion>
                        <camiones>{ data($return/camiones) }</camiones>
                        {
                            let $po := $return/po
                            return
                                <ordenCompra>
                                    {
                                        let $items := $po/items[1]
                                        return
                                            <item>
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
                                            </item>
                                    }
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
                                        for $fabricanteAtiende in $po/items[1]/producto/fabricanteAtiende
                                        return
                                            <fabricanteAtiende>
                                                <nombre>{ data($fabricanteAtiende/nombre) }</nombre>
                                                <nit>{ data($fabricanteAtiende/nit) }</nit>
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
                            for $items in $return/items
                            return
                                <items>
                                    <valor>{ data($items/producto/precio) }</valor>
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
                            let $fabricante := $return/fabricante
                            return
                                <fabricante>
                                    <nombre>{ data($fabricante/nombre) }</nombre>
                                    <nit>{ data($fabricante/nit) }</nit>
                                </fabricante>
                        }
                    </ns1:da>
            }
        </ns1:consultarDAnumSeguimientoPOResponse>
};

declare variable $consultarDAnumSeguimientoPOResponse1 as element(ns0:consultarDAnumSeguimientoPOResponse) external;

xf:ConsultarDAnumSequimientoPOResponse($consultarDAnumSeguimientoPOResponse1)
