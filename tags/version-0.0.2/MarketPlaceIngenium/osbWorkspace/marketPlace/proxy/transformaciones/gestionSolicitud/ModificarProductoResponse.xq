xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$customObject3WS_CustomObject3Update_Output1" element="ns1:CustomObject3WS_CustomObject3Update_Output" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:modificarProductoResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ModificarProductoResponse/";
declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";

declare function xf:ModificarProductoResponse($customObject3WS_CustomObject3Update_Output1 as element(ns1:CustomObject3WS_CustomObject3Update_Output))
    as element(ns0:modificarProductoResponse) {
        let $CustomObject3WS_CustomObject3Update_Output := $customObject3WS_CustomObject3Update_Output1
        return
            <ns0:modificarProductoResponse>
                {
                    let $ListOfCustomObject3 := $CustomObject3WS_CustomObject3Update_Output/ns2:ListOfCustomObject3
                    return
                        <ns0:respuesta>{(empty($ListOfCustomObject3/ns2:CustomObject3[1]/ns2:AccountId))}</ns0:respuesta>
                }
            </ns0:modificarProductoResponse>
};

declare variable $customObject3WS_CustomObject3Update_Output1 as element(ns1:CustomObject3WS_CustomObject3Update_Output) external;

xf:ModificarProductoResponse($customObject3WS_CustomObject3Update_Output1)
