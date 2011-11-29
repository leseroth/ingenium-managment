(:: pragma bea:global-element-parameter parameter="$consultarRMAsComercioResponse1" element="ns0:consultarRMAsComercioResponse" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarRMAsComercioResponse" location="../../wsdls/gestionRMA/GestionRMA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionRMA/consultarRMAsComercioResponse/";

declare function xf:consultarRMAsComercioResponse($consultarRMAsComercioResponse1 as element(ns0:consultarRMAsComercioResponse))
    as element(ns1:consultarRMAsComercioResponse) {
        <ns1:consultarRMAsComercioResponse>
        {
            for $return in $consultarRMAsComercioResponse1/return
                return
            <ns1:rma>
                <numSeguimiento>{ data($return/numSeguimiento) }</numSeguimiento>
                <causa>{ data($return/causa) }</causa>
                <fecha>{ data($return/fecha) }</fecha>
                <avisoDespacho>
                    <numSeguimiento>{ data($consultarRMAsComercioResponse1/return[1]/da/numSeguimiento) }</numSeguimiento>
                </avisoDespacho>
                <ordenCompra>
                    <comercio>
                        <nombre>{ data($return/po/comercio/nombre) }</nombre>
                        <nit>{ data($return/po/comercio/nit) }</nit>
                    </comercio>
                    {
                        for $numSeguimiento in $return/po[1]/numSeguimiento
                        return
                            <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                    }
                </ordenCompra>
            </ns1:rma>
         }
        </ns1:consultarRMAsComercioResponse>
};

declare variable $consultarRMAsComercioResponse1 as element(ns0:consultarRMAsComercioResponse) external;

xf:consultarRMAsComercioResponse($consultarRMAsComercioResponse1)
