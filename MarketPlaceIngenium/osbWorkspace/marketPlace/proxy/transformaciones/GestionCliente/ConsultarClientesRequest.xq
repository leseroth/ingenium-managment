(:: pragma bea:global-element-parameter parameter="$consultarClientes1" element="ns0:consultarClientes" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:AccountWS_AccountQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClientesRequest/";

declare function xf:ConsultarClientesRequest($consultarClientes1 as element(ns0:consultarClientes))
    as element(ns1:AccountWS_AccountQueryPage_Input) {
        <ns1:AccountWS_AccountQueryPage_Input>
            <ns2:ListOfAccount>
                <ns2:Account>
                	<ns2:AccountId></ns2:AccountId>
                	<ns2:AccountName></ns2:AccountName> 
               		<ns2:AccountType></ns2:AccountType>
               		<ns2:MainPhone></ns2:MainPhone>
                    <ns2:stNit></ns2:stNit>
               		<ns2:Location></ns2:Location>
               		<ns2:Status></ns2:Status>
               		<ns2:AccountType>{concat("='",data($consultarClientes1/ns0:tipoCliente),"'")}</ns2:AccountType>
               		<ns2:stNmero_Matricula></ns2:stNmero_Matricula>
               		<ns2:stRazon_Social></ns2:stRazon_Social>  
               		<ns2:nComision></ns2:nComision>               
		              <ns2:ListOfContact>
		                  <ns2:Contact>               
		                     <ns2:ContactFirstName></ns2:ContactFirstName>                     
		                     <ns2:JobTitle></ns2:JobTitle>           
		                     <ns2:ContactLastName></ns2:ContactLastName>
		                     <ns2:AccountId></ns2:AccountId>  
		                     <ns2:CellularPhone></ns2:CellularPhone>
		                     <ns2:Description></ns2:Description>
		                     <ns2:Department></ns2:Department>
		                     <ns2:ContactEmail></ns2:ContactEmail>
		                     <ns2:ContactRole></ns2:ContactRole>
		                     <ns2:WorkPhone></ns2:WorkPhone>                     
		                     <ns2:ContactId></ns2:ContactId>
		                     <ns2:stNmero_de_Identificacin></ns2:stNmero_de_Identificacin>
		                  </ns2:Contact>
		               </ns2:ListOfContact>  
		              <ns2:ListOfCustomObject3>
		                  <ns2:CustomObject3>
		                     <ns2:Name></ns2:Name>
		                     <ns2:CustomObject3Id></ns2:CustomObject3Id>	 
		                  </ns2:CustomObject3>
		               </ns2:ListOfCustomObject3>                     
                </ns2:Account>
            </ns2:ListOfAccount>
        </ns1:AccountWS_AccountQueryPage_Input>
};

declare variable $consultarClientes1 as element(ns0:consultarClientes) external;

xf:ConsultarClientesRequest($consultarClientes1)
