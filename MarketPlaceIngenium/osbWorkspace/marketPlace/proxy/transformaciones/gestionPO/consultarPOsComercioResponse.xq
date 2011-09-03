(:: pragma bea:global-element-parameter parameter="$consultarPOsComercioResponse1" element="ns0:consultarPOsComercioResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarPOsComercioResponse" location="../../wsdls/gestionPO/GestionPO.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/consultarPOsComercioResponse/";

declare function xf:consultarPOsComercioResponse($consultarPOsComercioResponse1 as element(ns0:consultarPOsComercioResponse))
    as element(ns1:consultarPOsComercioResponse) {
        <ns1:consultarPOsComercioResponse>
            {
                for $return in $consultarPOsComercioResponse1/return
                return
                    <ns1:pos>
                        <item>
                            {
                                for $cantidad in $return/items[1]/cantidad
                                return
                                    <cantidad>{ data($cantidad) }</cantidad>
                            }
                            <producto>
                                <nombre>{ data($return/items[1]/producto/nombre) }</nombre>
                                {
                                    for $categoria in $return/items[1]/producto/categoria
                                    return
                                        <categoria>{ data($categoria) }</categoria>
                                }
                            </producto>
                        </item>
                        <fechaMaxima>{ data($return/entrega) }</fechaMaxima>
                        <tiempoSubasta>{ data($return/entrega) }</tiempoSubasta>
                        <comercio>
                            <nombre>{ data($return/comercio/nombre) }</nombre>
                            <nit>{ data($return/comercio/nit) }</nit>
                        </comercio>
                        <fabricanteAtiende>
                            <nombre>{ data($return/items[1]/producto/fabricanteAtiende/nombre) }</nombre>
                            <nit>{ data($return/items[1]/producto/fabricanteAtiende/nit) }</nit>
                        </fabricanteAtiende>
                        {
                            for $numSeguimiento in $return/numSeguimiento
                            return
                                <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                        }
                        <estado>{ data($return/estado) }</estado>
                        <fecha>{ data($return/entrega) }</fecha>
                    </ns1:pos>
            }
        </ns1:consultarPOsComercioResponse>
};

declare variable $consultarPOsComercioResponse1 as element(ns0:consultarPOsComercioResponse) external;

xf:consultarPOsComercioResponse($consultarPOsComercioResponse1)
