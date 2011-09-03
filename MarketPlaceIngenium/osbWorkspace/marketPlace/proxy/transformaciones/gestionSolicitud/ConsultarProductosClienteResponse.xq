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
                for $CustomObject3 in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3,
                    $ListOfCustomObject3 in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3
                return
                    <ns0:productos>
                        {
                            for $CustomObject3Id in $ListOfCustomObject3/ns2:CustomObject3[1]/ns2:CustomObject3Id
                            return
                                <id>{ data($CustomObject3Id) }</id>
                        }
                        <nombre>{ data($ListOfCustomObject3/ns2:CustomObject3[1]/ns2:Name) }</nombre>
                        <categoria>{ data($ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stCategoria) }</categoria>
                        {
                            for $stTipo in $ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stTipo
                            return
                                <tipo>{ data($stTipo) }</tipo>
                        }
                        <estado>{ data($ListOfCustomObject3/ns2:CustomObject3[1]/ns2:plEstado) }</estado>
                        {
                            for $stReferencia in $ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stReferencia
                            return
                                <referencia>{ data($stReferencia) }</referencia>
                        }
                    </ns0:productos>
            }
        </ns0:consultarProductosClienteResponse>
};

declare variable $customObject3WS_CustomObject3QueryPage_Output1 as element(ns1:CustomObject3WS_CustomObject3QueryPage_Output) external;

xf:ConsultarProductosClienteResponse($customObject3WS_CustomObject3QueryPage_Output1)
