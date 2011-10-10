(:: pragma bea:global-element-parameter parameter="$crearSubasta1" element="ns0:crearSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:crearSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/CrearSubastaRequest/";

declare function xf:CrearSubastaRequest($crearSubasta1 as element(ns0:crearSubasta))
    as element(ns1:crearSubasta) {
        <ns1:crearSubasta>
            {
                let $po := $crearSubasta1/ns0:po
                return
                    <po>
                        {
                            let $comercio := $po/comercio
                            return
                                <comercioBO>
                                    <nit>{ data($comercio/nit) }</nit>
                                </comercioBO>
                        }
                        <entrega>{ data($po/fechaMaxima) }</entrega>
                        <estado>{ data($po/estado) }</estado>
                        {
                            let $item := $po/item
                            return
                                <itemPOBO>
                                    <cantidad>{ data($item/cantidad) }</cantidad>
                                    {
                                        let $producto := $item/producto
                                        return
                                            <productoBO>
                                                <categoria>{ data($producto/categoria) }</categoria>
                                                <nombre>{ data($producto/nombre) }</nombre>
                                            </productoBO>
                                    }
                                </itemPOBO>
                        }
                        {
                            for $numSeguimiento in $po/numSeguimiento
                            return
                                <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                        }
                    </po>
            }
        </ns1:crearSubasta>
};

declare variable $crearSubasta1 as element(ns0:crearSubasta) external;

xf:CrearSubastaRequest($crearSubasta1)
