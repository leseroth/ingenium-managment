(:: pragma bea:global-element-parameter parameter="$customObject3WS_CustomObject3QueryPage_Output1" element="ns1:CustomObject3WS_CustomObject3QueryPage_Output" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarProductosClienteResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarProductosClienteResponse/";

declare function xf:ConsultarProductosClienteResponse($customObject3WS_CustomObject3QueryPage_Output1 as element(ns1:CustomObject3WS_CustomObject3QueryPage_Output))
    as element(ns0:consultarProductosClienteResponse) {
        <ns0:consultarProductosClienteResponse>
            {
            	for $ListOfCustomObject3 in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3,
                    $CustomObject3 in $ListOfCustomObject3/ns2:CustomObject3
                return
                    <ns0:productos>
                        {
                            for $CustomObject3Id in $CustomObject3/ns2:CustomObject3Id
                            return
                                <id>{ data($CustomObject3Id) }</id>
                        }
                        <nombre>{ data($CustomObject3/ns2:Name) }</nombre>
                        <categoria>{ data($CustomObject3/ns2:stCategoria) }</categoria>
                        {
                            for $stTipo in $CustomObject3/ns2:stTipo
                            return
                                <tipo>{ data($stTipo) }</tipo>
                        }
                        <estado>{ data($CustomObject3/ns2:plEstado) }</estado>
                        {
                            for $stReferencia in $CustomObject3/ns2:stReferencia
                            return
                                <referencia>{ data($stReferencia) }</referencia>
                        }
                        <pesoLibras>{ data($CustomObject3/ns2:nPeso) }</pesoLibras>
                    </ns0:productos>
            }
        </ns0:consultarProductosClienteResponse>
};

declare variable $customObject3WS_CustomObject3QueryPage_Output1 as element(ns1:CustomObject3WS_CustomObject3QueryPage_Output) external;

xf:ConsultarProductosClienteResponse($customObject3WS_CustomObject3QueryPage_Output1)
