(:: pragma bea:global-element-parameter parameter="$registrarRMA1" element="ns0:registrarRMA" location="../../wsdls/gestionRMA/GestionRMA.xsd" ::)
(:: pragma bea:global-element-return element="ns1:registrarRMA" location="../../../business/wsdls/poManager/XMLSchema_-1810825364.xsd" ::)

declare namespace ns1 = "http://exceptions.pomanager.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/MarketPlaceOSB/proxy/transformaciones/gestionRMA/RegistrarRMARequest/";

declare function xf:RegistrarRMARequest($registrarRMA1 as element(ns0:registrarRMA))
    as element(ns1:registrarRMA) {
        <ns1:registrarRMA>
            <rma>
                <causa>{ data($registrarRMA1/rma/causa) }</causa>
                <fecha>{ data($registrarRMA1/rma/fecha) }</fecha>
                {
                    let $avisoDespacho := $registrarRMA1/rma/avisoDespacho
                    return
                        <da>  
                           <numSeguimiento>{ data($avisoDespacho/numSeguimiento) }</numSeguimiento>
                        </da>                    
                }
                <itemsDevueltos>
                    <id>{ data($registrarRMA1/rma/items[1]/id) }</id>
                    <producto>
                        {
                            for $categoria in $registrarRMA1/rma/items[1]/producto/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                        <id>{ data($registrarRMA1/rma/items[1]/producto/id) }</id>
                        <nombre>{ data($registrarRMA1/rma/items[1]/producto/nombre) }</nombre>
                    </producto>
                </itemsDevueltos>
                <numSeguimiento>{ data($registrarRMA1/rma/numSeguimiento) }</numSeguimiento>
                {
                    let $ordenCompra := $registrarRMA1/rma/ordenCompra
                    return
                        <po>                
                            <numSeguimiento>{ data($ordenCompra/numSeguimiento) }</numSeguimiento>
                        </po>
                }
            </rma>
        </ns1:registrarRMA>
};

declare variable $registrarRMA1 as element(ns0:registrarRMA) external;

xf:RegistrarRMARequest($registrarRMA1)
