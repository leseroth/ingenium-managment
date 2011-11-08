(:: pragma bea:global-element-parameter parameter="$crearProducto1" element="ns0:crearProducto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:CustomObject3WS_CustomObject3Insert_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/CrearProductosRequest/";

declare function xf:CrearProductosRequest($crearProducto1 as element(ns0:crearProducto))
    as element(ns1:CustomObject3WS_CustomObject3Insert_Input) {
        <ns1:CustomObject3WS_CustomObject3Insert_Input>
            {
                let $crearProducto := $crearProducto1
                return
                    <ns2:ListOfCustomObject3>
                        {
                            for $productos in $crearProducto/ns0:productos
                            return
                                <ns2:CustomObject3>
                                    <ns2:AccountId>{ concat("='",data($crearProducto/ns0:idCliente),"'") }</ns2:AccountId>
                                    {
                                        for $id in $productos/id
                                        return
                                            <ns2:CustomObject3Id>{ concat("='",data($id),"'") }</ns2:CustomObject3Id>
                                    }
                                    <ns2:Name>{ concat("='",data($productos/nombre),"'") }</ns2:Name>
                                    <ns2:plEstado>{ concat("='",data($productos/estado),"'") }</ns2:plEstado>
                                    <ns2:stCategoria>{ concat("='",data($productos/categoria),"'") }</ns2:stCategoria>
                                    {
                                        for $tipo in $productos/tipo
                                        return
                                            <ns2:stTipo>{ concat("='",data($tipo),"'") }</ns2:stTipo>
                                    }
                                    {
                                        for $referencia in $productos/referencia
                                        return
                                            <ns2:stReferencia>{ concat("='",data($referencia),"'") }</ns2:stReferencia>
                                    }
                                    <ns2:stPesoLibras>{ concat("='",data($productos/pesoLibras),"'") }</ns2:stPesoLibras>
                                </ns2:CustomObject3>
                        }
                    </ns2:ListOfCustomObject3>
            }
        </ns1:CustomObject3WS_CustomObject3Insert_Input>
};

declare variable $crearProducto1 as element(ns0:crearProducto) external;

xf:CrearProductosRequest($crearProducto1)
