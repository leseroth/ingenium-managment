(:: pragma bea:global-element-parameter parameter="$crearSubasta1" element="ns0:crearSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:crearSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/CrearSubastaRequest/";

declare function xf:CrearSubastaRequest($crearSubasta1 as element(ns0:crearSubasta))
    as element(ns1:crearSubasta) {
        <ns1:crearSubasta>
            <po>
                <comercio>
                    {
                        for $direccion in $crearSubasta1/ns0:po/comercio/direccion
                        return
                            <direccion>{ data($direccion) }</direccion>
                    }
                    <nit>{ data($crearSubasta1/ns0:po/comercio/nit) }</nit>
                    <nombre>{ data($crearSubasta1/ns0:po/comercio/nombre) }</nombre>
                    {
                        for $telefono in $crearSubasta1/ns0:po/comercio/telefono
                        return
                            <telefono>{ data($telefono) }</telefono>
                    }
                </comercio>
                <entrega>{ data($crearSubasta1/ns0:po/fechaMaxima) }</entrega>
                <estado>{ data($crearSubasta1/ns0:po/estado) }</estado>
                <item>
                    {
                        for $cantidad in $crearSubasta1/ns0:po/item/cantidad
                        return
                            <cantidad>{ data($cantidad) }</cantidad>
                    }
                    <producto>
                        {
                            for $categoria in $crearSubasta1/ns0:po/item/producto/categoria
                            return
                                <categoria>{ data($categoria) }</categoria>
                        }
                        <nombre>{ data($crearSubasta1/ns0:po/item/producto/nombre) }</nombre>
                    </producto>
                </item>
            </po>
        </ns1:crearSubasta>
};

declare variable $crearSubasta1 as element(ns0:crearSubasta) external;

xf:CrearSubastaRequest($crearSubasta1)
