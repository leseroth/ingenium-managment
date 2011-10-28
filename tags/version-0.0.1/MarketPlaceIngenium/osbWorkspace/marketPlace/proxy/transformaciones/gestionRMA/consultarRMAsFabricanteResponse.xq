(:: pragma bea:global-element-parameter parameter="$consultarRMAsFabricanteResponse1" element="ns0:consultarRMAsFabricanteResponse" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarRMAsFabricanteResponse" location="../../wsdls/gestionRMA/GestionRMA.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionRMA/consultarRMAsFabricanteResponse/";

declare function xf:consultarRMAsFabricanteResponse($consultarRMAsFabricanteResponse1 as element(ns0:consultarRMAsFabricanteResponse))
    as element(ns1:consultarRMAsFabricanteResponse) {
        <ns1:consultarRMAsFabricanteResponse>
            <rma>
                <numSeguimiento>{ data($consultarRMAsFabricanteResponse1/return[1]/numSeguimiento) }</numSeguimiento>
                <causa>{ data($consultarRMAsFabricanteResponse1/return[1]/causa) }</causa>
                <fecha>{ data($consultarRMAsFabricanteResponse1/return[1]/fecha) }</fecha>
                <avisoDespacho>
                    <numSeguimiento>{ data($consultarRMAsFabricanteResponse1/return[1]/da/numSeguimiento) }</numSeguimiento>
                </avisoDespacho>
                <ordenCompra>
                    <fabricanteAtiende>
                        <nombre>{ data($consultarRMAsFabricanteResponse1/return[1]/da/fabricante/nombre) }</nombre>
                        <nit>{ data($consultarRMAsFabricanteResponse1/return[1]/da/fabricante/nit) }</nit>
                    </fabricanteAtiende>
                    {
                        for $numSeguimiento in $consultarRMAsFabricanteResponse1/return[1]/po/numSeguimiento
                        return
                            <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                    }
                </ordenCompra>
            </rma>
        </ns1:consultarRMAsFabricanteResponse>
};

declare variable $consultarRMAsFabricanteResponse1 as element(ns0:consultarRMAsFabricanteResponse) external;

xf:consultarRMAsFabricanteResponse($consultarRMAsFabricanteResponse1)
