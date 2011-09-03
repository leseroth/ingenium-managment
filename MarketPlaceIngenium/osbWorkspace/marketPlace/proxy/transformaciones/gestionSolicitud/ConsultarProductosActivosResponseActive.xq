(:: pragma bea:global-element-parameter parameter="$customObject3WS_CustomObject3QueryPage_Output1" element="ns0:CustomObject3WS_CustomObject3QueryPage_Output" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:CustomObject3WS_CustomObject3Update_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns1 = "urn:/crmondemand/xml/customObject3";
declare namespace ns0 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarProductosActivosResponse/";

declare function xf:ConsultarProductosActivosResponse($customObject3WS_CustomObject3QueryPage_Output1 as element(ns0:CustomObject3WS_CustomObject3QueryPage_Output))
    as element(ns0:CustomObject3WS_CustomObject3Update_Input) {
        
        <ns0:CustomObject3WS_CustomObject3Update_Input>
            {
                let $ListOfCustomObject3 := $customObject3WS_CustomObject3QueryPage_Output1/ns1:ListOfCustomObject3
                return
                    <ns1:ListOfCustomObject3>
                        {
                            for $CustomObject3 in $ListOfCustomObject3/ns1:CustomObject3
                            return
                                <ns1:CustomObject3>
                                    {
                                        for $CustomObject3Id in $CustomObject3/ns1:CustomObject3Id
                                        return
                                            <ns1:CustomObject3Id>{ data($CustomObject3Id) }</ns1:CustomObject3Id>
                                    }
                                    {
                                        for $plEstado in $CustomObject3/ns1:plEstado
                                        return
                                            <ns1:plEstado>Activo</ns1:plEstado>
                                    }
                                </ns1:CustomObject3>
                        }
                    </ns1:ListOfCustomObject3>
            }
        </ns0:CustomObject3WS_CustomObject3Update_Input>
        
};

declare variable $customObject3WS_CustomObject3QueryPage_Output1 as element(ns0:CustomObject3WS_CustomObject3QueryPage_Output) external;

xf:ConsultarProductosActivosResponse($customObject3WS_CustomObject3QueryPage_Output1)
