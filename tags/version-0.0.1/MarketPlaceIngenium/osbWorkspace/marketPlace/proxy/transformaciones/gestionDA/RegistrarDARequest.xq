(:: pragma bea:global-element-parameter parameter="$registrarDA1" element="ns1:registrarDA" location="../../wsdls/gestionDA/GestionDA.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarDA" location="../../../business/wsdls/poManager/XMLSchema_-1442769241.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionDA/RegistrarDARequest/";

declare function xf:RegistrarDARequest($registrarDA1 as element(ns1:registrarDA))
    as element(ns0:registrarDA) {
        <ns0:registrarDA>
            <da>
                <camiones>{ data($registrarDA1/ns1:da/camiones[1]) }</camiones>
                {
                    let $fabricante := $registrarDA1/ns1:da/fabricante
                    return
                        <fabricante>
                            <nit>{ data($fabricante/nit) }</nit>
                            <nombre>{ data($fabricante/nombre) }</nombre>
                        </fabricante>
                }
                <fechaEmision>{ data($registrarDA1/ns1:da/fechaEmision) }</fechaEmision>
                <fechaLlegada>{ data($registrarDA1/ns1:da/fechaLlegada) }</fechaLlegada>
                {
                    for $items in $registrarDA1/ns1:da/items
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
                                        {
                                            for $categoria in $producto/categoria
                                            return
                                                <categoria>{ data($categoria) }</categoria>
                                        }
                                        <nombre>{ data($producto/nombre) }</nombre>
                                        <precio>{ data($items/valor) }</precio>
                                    </producto>
                            }
                        </items>
                }
                <montoOperacion>{ data($registrarDA1/ns1:da/montoOperacion) }</montoOperacion>
                <numSeguimiento>{ data($registrarDA1/ns1:da/numSeguimiento) }</numSeguimiento>
            </da>
            <numSeguimientoPo>{ data($registrarDA1/ns1:numSeguimientoPo) }</numSeguimientoPo>
        </ns0:registrarDA>
};

declare variable $registrarDA1 as element(ns1:registrarDA) external;

xf:RegistrarDARequest($registrarDA1)
