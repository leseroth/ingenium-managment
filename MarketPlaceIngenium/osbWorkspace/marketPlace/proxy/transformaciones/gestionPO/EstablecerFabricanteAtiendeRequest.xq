(:: pragma bea:global-element-parameter parameter="$establecerFabricanteAtiende1" element="ns1:establecerFabricanteAtiende" location="../../wsdls/gestionPO/GestionPO.xsd" ::)
(:: pragma bea:global-element-return element="ns0:establecerFabricanteAtiende" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/EstablecerFabricanteAtiendeRequest/";

declare function xf:EstablecerFabricanteAtiendeRequest($establecerFabricanteAtiende1 as element(ns1:establecerFabricanteAtiende))
    as element(ns0:establecerFabricanteAtiende) {
        <ns0:establecerFabricanteAtiende>
            <numSeguimiento>{ data($establecerFabricanteAtiende1/ns1:numSeguimiento) }</numSeguimiento>
            <fabricante>
                <nit>{ data($establecerFabricanteAtiende1/ns1:fabricante/nit) }</nit>
                <nombre>{ data($establecerFabricanteAtiende1/ns1:fabricante/nombre) }</nombre>
            </fabricante>
            <productosAtiende>
                {
                    for $categoria in $establecerFabricanteAtiende1/ns1:items/producto/categoria
                    return
                        <categoria>{ data($categoria) }</categoria>
                }
                <fabricanteAtiende>
                    <nombre>{ data($establecerFabricanteAtiende1/ns1:items/producto/nombre) }</nombre>
                </fabricanteAtiende>
                <nombre>{ data($establecerFabricanteAtiende1/ns1:items/nombre) }</nombre>
                <precio>{ data($establecerFabricanteAtiende1/ns1:items/valor) }</precio>
            </productosAtiende>
        </ns0:establecerFabricanteAtiende>
};

declare variable $establecerFabricanteAtiende1 as element(ns1:establecerFabricanteAtiende) external;

xf:EstablecerFabricanteAtiendeRequest($establecerFabricanteAtiende1)
