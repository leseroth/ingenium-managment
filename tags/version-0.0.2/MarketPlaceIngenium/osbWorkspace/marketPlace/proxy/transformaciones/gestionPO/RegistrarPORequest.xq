(:: pragma bea:global-element-parameter parameter="$registrarPO1" element="ns1:registrarPO" location="../../wsdls/gestionPO/GestionPO.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarPO" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketplace/proxy/transformaciones/gestionPO/RegistrarPORequest/";

declare function xf:RegistrarPORequest($registrarPO1 as element(ns1:registrarPO))
    as element(ns0:registrarPO) {
        <ns0:registrarPO>
            <po>
                <comercio>
                    <nit>{ data($registrarPO1/ns1:purchaseOrder/comercio/nit) }</nit>
                    <nombre>{ data($registrarPO1/ns1:purchaseOrder/comercio/nombre) }</nombre>
                </comercio>
                <entrega>{ data($registrarPO1/ns1:purchaseOrder/fechaMaxima) }</entrega>
                <estado>{ data($registrarPO1/ns1:purchaseOrder/estado) }</estado>
                <items>
                    {
                        for $cantidad in $registrarPO1/ns1:purchaseOrder/item/cantidad
                        return
                            <cantidad>{ data($cantidad) }</cantidad>
                    }
                    <producto>
                        {
                            for $categoria in $registrarPO1/ns1:purchaseOrder/item/producto/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                        <nombre>{ data($registrarPO1/ns1:purchaseOrder/item/producto/nombre) }</nombre>
                    </producto>
                </items>
            </po>
        </ns0:registrarPO>
};

declare variable $registrarPO1 as element(ns1:registrarPO) external;

xf:RegistrarPORequest($registrarPO1)
