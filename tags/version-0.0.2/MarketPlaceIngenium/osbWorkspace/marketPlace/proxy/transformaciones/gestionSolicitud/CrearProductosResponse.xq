(:: pragma bea:global-element-parameter parameter="$customObject3WS_CustomObject3Insert_Output1" element="ns1:CustomObject3WS_CustomObject3Insert_Output" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:crearProductoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/CrearProductosResponse/";

declare function xf:CrearProductosResponse($customObject3WS_CustomObject3Insert_Output1 as element(ns1:CustomObject3WS_CustomObject3Insert_Output))
    as element(ns0:crearProductoResponse) {
        let $CustomObject3WS_CustomObject3Insert_Output := $customObject3WS_CustomObject3Insert_Output1
        return
            <ns0:crearProductoResponse>
                {
                    let $ListOfCustomObject3 := $CustomObject3WS_CustomObject3Insert_Output/ns2:ListOfCustomObject3
                    return
                        <ns0:respuesta>{(empty($ListOfCustomObject3/ns1:CustomObject3[1]/ns1:AccountId))}</ns0:respuesta>
                }
            </ns0:crearProductoResponse>
};

declare variable $customObject3WS_CustomObject3Insert_Output1 as element(ns1:CustomObject3WS_CustomObject3Insert_Output) external;

xf:CrearProductosResponse($customObject3WS_CustomObject3Insert_Output1)
