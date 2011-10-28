(:: pragma bea:global-element-parameter parameter="$consultarProducto1" element="ns0:consultarProducto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:CustomObject3WS_CustomObject3QueryPage_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarProducto/";

declare function xf:ConsultarProducto($consultarProducto1 as element(ns0:consultarProducto))
    as element(ns1:CustomObject3WS_CustomObject3QueryPage_Input) {
        <ns1:CustomObject3WS_CustomObject3QueryPage_Input>
            <ns2:ListOfCustomObject3>
                {
                    let $consultarProducto := $consultarProducto1
                    return
                        <ns2:CustomObject3>
                            <ns2:AccountId>{ concat("= '",data($consultarProducto/ns0:idCliente),"'") }</ns2:AccountId>
                            <ns2:Name>{ concat("= '",data($consultarProducto/ns0:nombreProducto),"'") }</ns2:Name>                            
		                    <ns2:plEstado></ns2:plEstado>
		                    <ns2:CustomObject3Id></ns2:CustomObject3Id>
		                	<ns2:stCategoria></ns2:stCategoria>
		                	<ns2:stTipo></ns2:stTipo>
		                	<ns2:stReferencia></ns2:stReferencia>
		                	<ns2:stPesoLibras></ns2:stPesoLibras>
                        </ns2:CustomObject3>
                }
            </ns2:ListOfCustomObject3>
        </ns1:CustomObject3WS_CustomObject3QueryPage_Input>
};

declare variable $consultarProducto1 as element(ns0:consultarProducto) external;

xf:ConsultarProducto($consultarProducto1)