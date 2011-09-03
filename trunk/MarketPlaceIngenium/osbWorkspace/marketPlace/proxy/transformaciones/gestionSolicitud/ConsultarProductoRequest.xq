(:: pragma bea:global-element-return element="ns1:CustomObject3WS_CustomObject3QueryPage_Input" location="../../../business/wsdls/crmOnDemand/CustomObject3.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/customObject3";
declare namespace ns1 = "urn:crmondemand/ws/customobject3/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClienteRequest/";

declare function xf:ConsultarProductosRequest($string1 as xs:string)
    as element(ns1:CustomObject3WS_CustomObject3QueryPage_Input) {
        <ns1:CustomObject3WS_CustomObject3QueryPage_Input>        
            <ns2:ListOfCustomObject3>
                <ns2:CustomObject3>
                     <ns2:Name></ns2:Name>
                     <ns2:CustomObject3Id></ns2:CustomObject3Id>	
                     <ns1:AccountId>{ concat("= '",$string1,"'") }</ns1:AccountId>
                    <ns1:plEstado></ns1:plEstado>
                    <ns1:CustomObject3Id></ns1:CustomObject3Id>
                    <ns1:Name></ns1:Name>
                	<ns1:stCategoria></ns1:stCategoria>
                	<ns1:stTipo></ns1:stTipo>
                	<ns1:stReferencia></ns1:stReferencia>
                </ns2:CustomObject3>
            </ns2:ListOfCustomObject3>
        </ns1:CustomObject3WS_CustomObject3QueryPage_Input>
};

declare variable $string1 as xs:string external;

xf:ConsultarProductosRequest($string1)
