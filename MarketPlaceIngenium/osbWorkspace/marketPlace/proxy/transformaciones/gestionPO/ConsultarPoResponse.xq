(:: pragma bea:global-element-parameter parameter="$consultarPOResponse1" element="ns0:consultarPOResponse" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarPOResponse" location="../../wsdls/gestionPO/GestionPO.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionPO/ConsultarPoResponse/";

declare function xf:ConsultarPoResponse($consultarPOResponse1 as element(ns0:consultarPOResponse))
    as element(ns1:consultarPOResponse) {
        <ns1:consultarPOResponse>
            <ns1:purchaseOrder>
                {
                    for $id in $consultarPOResponse1/return/id
                    return
                        <id>{ data($id) }</id>
                }
                <item>
                    <id>{ data($consultarPOResponse1/return/items[1]/id) }</id>
                    {
                        for $cantidad in $consultarPOResponse1/return/items[1]/cantidad
                        return
                            <cantidad>{ data($cantidad) }</cantidad>
                    }
                    <producto>
                        <id>{ data($consultarPOResponse1/return/items[1]/producto/id) }</id>
                        <nombre>{ data($consultarPOResponse1/return/items[1]/producto/nombre) }</nombre>
                        {
                            for $categoria in $consultarPOResponse1/return/items[1]/producto/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                    </producto>
                </item>
                <fechaMaxima>{ data($consultarPOResponse1/return/entrega) }</fechaMaxima>
                <comercio>
                    {
                        for $id in $consultarPOResponse1/return/comercio/id
                        return
                            <id>{ data($id) }</id>
                    }
                    <nombre>{ data($consultarPOResponse1/return/comercio/nombre) }</nombre>
                </comercio>
                <estado>{ data($consultarPOResponse1/return/estado) }</estado>
            </ns1:purchaseOrder>
        </ns1:consultarPOResponse>
};

declare variable $consultarPOResponse1 as element(ns0:consultarPOResponse) external;

xf:ConsultarPoResponse($consultarPOResponse1)
