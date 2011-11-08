<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:ns ="urn:crmondemand/ws/customobject3/10/2004"  xmlns:acc="urn:/crmondemand/xml/account" 
xmlns:ns0 = "http://marketplace.losalpes.com.co"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:cus ="urn:/crmondemand/xml/customObject3">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>	
	<xsl:template match="/">	
	<ns0:consultarClientesProductoResponse>	
	<xsl:for-each select="ListOfProducts/Product">  
	<xsl:variable name="idCliente" select="AccountId"></xsl:variable>
	<xsl:variable name="producto" select="Name"></xsl:variable>
			
		<xsl:for-each select="acc:ListOfAccount/acc:Account/">		
		<xsl:if test="string(acc:AccountId) = $idCliente">
		<ns0:cliente>	
		<id><xsl:value-of select="acc:AccountId"></xsl:value-of></id>
		<nombre><xsl:value-of select="acc:AccountName"></xsl:value-of></nombre>
		<nit><xsl:value-of select="acc:stNit"></xsl:value-of></nit>
		<email><xsl:value-of select="acc:stCorreo_Electronico"></xsl:value-of></email>
		<direccion><xsl:value-of select="acc:Location"></xsl:value-of></direccion>
		<telefono><xsl:value-of select="acc:MainPhone"></xsl:value-of></telefono>
		<codigoPostal><xsl:value-of select="acc:stCodigoPostal"></xsl:value-of></codigoPostal> 
      	<codigoPais><xsl:value-of select="acc:stCodigoPais"></xsl:value-of></codigoPais>
      	<razonSocial><xsl:value-of select="acc:stRazon_Social"></xsl:value-of></razonSocial>
      	<estado><xsl:value-of select="acc:Status"></xsl:value-of></estado>
      	<tipo><xsl:value-of select="acc:AccountType"></xsl:value-of></tipo>
      	<categoria><xsl:value-of select="acc:plCategoria"></xsl:value-of></categoria>
      	<comision><xsl:value-of select="acc:nComision"></xsl:value-of></comision>
		</ns0:cliente>  
		</xsl:if>		 
		</xsl:for-each> 
    </xsl:for-each>
    </ns0:consultarClientesProductoResponse>    
	</xsl:template>
</xsl:stylesheet>



	   
        
       
        