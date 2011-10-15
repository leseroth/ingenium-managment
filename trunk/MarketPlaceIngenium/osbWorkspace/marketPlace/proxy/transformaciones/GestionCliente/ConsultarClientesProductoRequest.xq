(:: pragma bea:global-element-parameter parameter="$consultarClientesProducto1" element="ns0:consultarClientesProducto" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:AccountWS_AccountQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClientesProductoResquest/";

declare function xf:ConsultarClientesProductoResquest($consultarClientesProducto1 as element(ns0:consultarClientesProducto))
    as element(ns1:AccountWS_AccountQueryPage_Input) {
        <ns1:AccountWS_AccountQueryPage_Input>
            <ns2:ListOfAccount>
                <ns2:Account>
                    <ns2:AccountId/>
                	<ns2:AccountType>{ concat("='",data($consultarClientesProducto1/ns0:tipoCliente),"'") }</ns2:AccountType>
                    <ns2:Status>='Activo'</ns2:Status>
                	<ns2:stNit/>
                	<ns2:AccountName/>
                	<ns2:stCorreo_Electronico/>
                	<ns2:stCodigoPostal/> 
               		<ns2:stCodigoPais/>
                    <ns2:ListOfCustomObject3>
                        <ns2:CustomObject3>
                            <ns2:Name>{ concat("='",data($consultarClientesProducto1/ns0:nombreProducto),"'") }</ns2:Name>
                            <ns2:Type>{ concat("='",data($consultarClientesProducto1/ns0:tipoCategoria),"'") }</ns2:Type>
                        </ns2:CustomObject3>
                    </ns2:ListOfCustomObject3>
                    <ns2:stCodigoPostal/>
                    <ns2:stCodigoPais/>
                </ns2:Account>
            </ns2:ListOfAccount>
        </ns1:AccountWS_AccountQueryPage_Input>
};

declare variable $consultarClientesProducto1 as element(ns0:consultarClientesProducto) external;

xf:ConsultarClientesProductoResquest($consultarClientesProducto1)
