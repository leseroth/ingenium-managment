(:: pragma bea:global-element-return element="ns0:CustomObject3WS_CustomObject3QueryPage_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns1 = "urn:/crmondemand/xml/customObject3";
declare namespace ns0 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarProductosActivosRequest/";

declare function xf:ConsultarProductosActivosRequest($string1 as xs:string)
    as element(ns0:CustomObject3WS_CustomObject3QueryPage_Input) {
        
        <ns0:CustomObject3WS_CustomObject3QueryPage_Input>        
            <ns1:ListOfCustomObject3>
                <ns1:CustomObject3>
                    <ns1:AccountId>{ concat("= '",$string1,"'") }</ns1:AccountId>
                    <ns1:plEstado>{ "='Activo'" }</ns1:plEstado>
                    <ns1:CustomObject3Id></ns1:CustomObject3Id>
                    <ns1:Name></ns1:Name>
                	<ns1:stCategoria></ns1:stCategoria>
                	<ns1:stTipo></ns1:stTipo>
                	<ns1:stReferencia></ns1:stReferencia>
                </ns1:CustomObject3>
            </ns1:ListOfCustomObject3>
        </ns0:CustomObject3WS_CustomObject3QueryPage_Input>
       
};

declare variable $string1 as xs:string external;

xf:ConsultarProductosActivosRequest($string1)
