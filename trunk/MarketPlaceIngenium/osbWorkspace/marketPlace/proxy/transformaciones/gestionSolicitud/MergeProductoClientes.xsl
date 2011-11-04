<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:ns ="urn:crmondemand/ws/customobject3/10/2004"  xmlns:acc="urn:/crmondemand/xml/account" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:cus ="urn:/crmondemand/xml/customObject3">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>	
	<xsl:template match="/">	
	<ListOfProducts> 
	<xsl:variable name="clienteList"  select="products_clients/acc:ListOfAccount"></xsl:variable>		
	<xsl:for-each select="products_clients/ListOfCustomObject3/cus:CustomObject3"> 	
	<Product>		
		<AccountId><xsl:value-of select="cus:AccountId"></xsl:value-of></AccountId>
		<AccountName><xsl:value-of select="cus:AccountName"></xsl:value-of></AccountName>
		<Name><xsl:value-of select="cus:Name"></xsl:value-of></Name> 
		<ProductId><xsl:value-of select="cus:CustomObject3Id"></xsl:value-of></ProductId>
		<Categoria><xsl:value-of select="cus:stCategoria"></xsl:value-of></Categoria>
		<xsl:copy-of select="$clienteList"></xsl:copy-of>		 
    </Product> 
    </xsl:for-each>
    </ListOfProducts>    
	</xsl:template>
</xsl:stylesheet>



	   
        
       
        