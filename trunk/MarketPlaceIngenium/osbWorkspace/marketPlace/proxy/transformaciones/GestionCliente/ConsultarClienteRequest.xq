(:: pragma bea:global-element-parameter parameter="$consultarCliente1" element="ns0:consultarCliente" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)
(:: pragma bea:global-element-return element="ns1:AccountWS_AccountQueryPage_Input" location="../../../business/wsdls/crmOnDemand/Account.wsdl" ::)

declare namespace ns2 = "urn:/crmondemand/xml/account";
declare namespace ns1 = "urn:crmondemand/ws/account/10/2004";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/GestionCliente/ConsultarClienteRequest/";

declare function xf:ConsultarClienteRequest($consultarCliente1 as element(ns0:consultarCliente))
    as element(ns1:AccountWS_AccountQueryPage_Input) {
        <ns1:AccountWS_AccountQueryPage_Input>
            <ns2:ListOfAccount>
                <ns2:Account>
                	<ns2:AccountId></ns2:AccountId>
                	<ns2:AccountName></ns2:AccountName> 
               		<ns2:MainPhone></ns2:MainPhone>
               		<!--Filtrando por el nit-->
                    <ns2:stNit>{concat("='",data($consultarCliente1/ns0:nit),"'")}</ns2:stNit>
               		<ns2:Location></ns2:Location>
               		<ns2:Status></ns2:Status>
               		<ns2:AccountType></ns2:AccountType>
               		<ns2:stNmero_Matricula></ns2:stNmero_Matricula>
               		<ns2:stRazon_Social></ns2:stRazon_Social>  
               		<ns2:nComision></ns2:nComision>   
               		<ns2:stCorreo_Electronico/> 
               		<ns2:stCodigoPostal/> 
               		<ns2:stCodigoPais/>   
               		<ns2:plCategoria/>         
              <ns2:ListOfContact>
                  <ns2:Contact>               
                     <ns2:ContactFirstName></ns2:ContactFirstName> 
                     <ns2:ContactLastName></ns2:ContactLastName>
                     <ns2:AccountId></ns2:AccountId>  
                     <ns2:ContactEmail></ns2:ContactEmail>
                     <ns2:WorkPhone></ns2:WorkPhone>                     
                     <ns2:ContactId></ns2:ContactId>
                     <ns2:stNmero_de_Identificacin></ns2:stNmero_de_Identificacin>
                     <ns2:plTipo_de_Identificacin></ns2:plTipo_de_Identificacin>
                     <ns2:stCelular></ns2:stCelular>
                     <ns2:stDireccion></ns2:stDireccion>
                     <ns2:plEstado_Contacto></ns2:plEstado_Contacto>
                  </ns2:Contact>
               </ns2:ListOfContact>  
              <ns2:ListOfCustomObject3>
                  <ns2:CustomObject3>
                     <ns2:Name></ns2:Name>
                     <ns2:CustomObject3Id></ns2:CustomObject3Id>	
                     <ns2:stCategoria></ns2:stCategoria>
                	 <ns2:stTipo></ns2:stTipo>
                	 <ns2:stReferencia></ns2:stReferencia>
                	 <ns2:stPesoLibras></ns2:stPesoLibras> 
                	 <ns2:plEstado></ns2:plEstado>
                  </ns2:CustomObject3>
               </ns2:ListOfCustomObject3>  
             </ns2:Account> 
            </ns2:ListOfAccount>
        </ns1:AccountWS_AccountQueryPage_Input>
};

declare variable $consultarCliente1 as element(ns0:consultarCliente) external;

xf:ConsultarClienteRequest($consultarCliente1)
