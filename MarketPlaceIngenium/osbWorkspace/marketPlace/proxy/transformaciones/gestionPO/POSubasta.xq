(:: pragma bea:global-element-parameter parameter="$registrarPO1" element="ns0:registrarPO" location="../../wsdls/gestionPO/PoManagerPoManagementService_schema1.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarPO" location="../../../business/wsdls/poManager/PoManagerPoManagementService_schema1.xsd" ::)

declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/PODirect/";

declare function xf:PODirect($registrarPO1 as element(ns0:registrarPO))
    as element(ns0:registrarPO) {
        <ns0:registrarPO>
            <purchaseOrderBO>
                <comercioBO>
                    {
                        for $nit in $registrarPO1/purchaseOrderBO/comercioBO/nit
                        return
                            <nit>{ data($nit) }</nit>
                    }
                </comercioBO>
                {
                    for $entrega in $registrarPO1/purchaseOrderBO/entrega
                    return
                        <entrega>{ data($entrega) }</entrega>
                }
                <itemPOBOList>
                    {
                        for $cantidad in $registrarPO1/purchaseOrderBO/itemPOBOList[1]/cantidad
                        return
                            <cantidad>{ data($cantidad) }</cantidad>
                    }
                    <productoBO>
                        {
                            for $categoria in $registrarPO1/purchaseOrderBO/itemPOBOList[1]/productoBO/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                        {
                            for $nombre in $registrarPO1/purchaseOrderBO/itemPOBOList[1]/productoBO/nombre
                            return
                                <nombre>{ data($nombre) }</nombre>
                        }
                        {
                            for $precio in $registrarPO1/purchaseOrderBO/itemPOBOList[1]/productoBO/precio
                            return
                                <precio>{ data($precio) }</precio>
                        }
                    </productoBO>
                </itemPOBOList>
            </purchaseOrderBO>
        </ns0:registrarPO>
};

declare variable $registrarPO1 as element(ns0:registrarPO) external;

xf:PODirect($registrarPO1)
