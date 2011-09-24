(:: pragma bea:global-element-parameter parameter="$customObject3WS_CustomObject3QueryPage_Output1" element="ns1:CustomObject3WS_CustomObject3QueryPage_Output" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarProductoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarProductoResponse/";

declare function xf:ConsultarProductoResponse($customObject3WS_CustomObject3QueryPage_Output1 as element(ns1:CustomObject3WS_CustomObject3QueryPage_Output))
    as element(ns0:consultarProductoResponse) {
        <ns0:consultarProductoResponse>
            <ns0:producto>
                {
                    for $CustomObject3Id in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:CustomObject3Id
                    return
                        <id>{ data($CustomObject3Id) }</id>
                }
                <nombre>{ data($customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:Name) }</nombre>
                <categoria>{ data($customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stCategoria) }</categoria>
                {
                    for $stTipo in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stTipo
                    return
                        <tipo>{ data($stTipo) }</tipo>
                }
                <estado>{ data($customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:plEstado) }</estado>
                {
                    for $stReferencia in $customObject3WS_CustomObject3QueryPage_Output1/ns2:ListOfCustomObject3/ns2:CustomObject3[1]/ns2:stReferencia
                    return
                        <referencia>{ data($stReferencia) }</referencia>
                }
            </ns0:producto>
        </ns0:consultarProductoResponse>
};

declare variable $customObject3WS_CustomObject3QueryPage_Output1 as element(ns1:CustomObject3WS_CustomObject3QueryPage_Output) external;

xf:ConsultarProductoResponse($customObject3WS_CustomObject3QueryPage_Output1)
