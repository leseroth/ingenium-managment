(:: pragma bea:global-element-parameter parameter="$modificarProducto1" element="ns0:modificarProducto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:CustomObject3WS_CustomObject3Update_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ModificarProductoRequest/";

declare function xf:ModificarProductoRequest($modificarProducto1 as element(ns0:modificarProducto))
    as element(ns1:CustomObject3WS_CustomObject3Update_Input) {
        <ns1:CustomObject3WS_CustomObject3Update_Input>
            <ns2:ListOfCustomObject3>
                <ns2:CustomObject3>
                    {
                        for $id in $modificarProducto1/ns0:producto/id
                        return
                            <ns2:CustomObject3Id>{ data($id) }</ns2:CustomObject3Id>
                    }
                    <ns2:Name>{ data($modificarProducto1/ns0:producto/nombre) }</ns2:Name>
                    <ns2:plEstado>{ data($modificarProducto1/ns0:producto/estado) }</ns2:plEstado>
                    <ns2:stCategoria>{ data($modificarProducto1/ns0:producto/categoria) }</ns2:stCategoria>
                    {
                        for $tipo in $modificarProducto1/ns0:producto/tipo
                        return
                            <ns2:stTipo>{ data($tipo) }</ns2:stTipo>
                    }
                    {
                        for $referencia in $modificarProducto1/ns0:producto/referencia
                        return
                            <ns2:stReferencia>{ data($referencia) }</ns2:stReferencia>
                    }
                    <ns2:stPesoLibras>{ data($modificarProducto1/ns0:producto/pesoLibras) }</ns2:stPesoLibras>
                </ns2:CustomObject3>
            </ns2:ListOfCustomObject3>
        </ns1:CustomObject3WS_CustomObject3Update_Input>
};

declare variable $modificarProducto1 as element(ns0:modificarProducto) external;

xf:ModificarProductoRequest($modificarProducto1)
