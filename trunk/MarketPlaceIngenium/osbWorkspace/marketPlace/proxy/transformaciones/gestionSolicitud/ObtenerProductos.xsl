<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:ns ="urn:crmondemand/ws/customobject3/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<ListOfCustomObject3 	xmlns:cus ="urn:/crmondemand/xml/customObject3"> 
	<xsl:for-each select="ns:CustomObject3WS_CustomObject3QueryPage_Output/cus:ListOfCustomObject3/cus:CustomObject3/">  
	<cus:CustomObject3>
		<cus:AccountId><xsl:value-of select="cus:AccountId"></xsl:value-of></cus:AccountId>
		<cus:Name><xsl:value-of select="cus:Name"></xsl:value-of></cus:Name> 
		<cus:CustomObject3Id><xsl:value-of select="cus:CustomObject3Id"></xsl:value-of></cus:CustomObject3Id>
		<cus:stCategoria><xsl:value-of select="cus:stCategoria"></xsl:value-of></cus:stCategoria>  
    </cus:CustomObject3> 
    </xsl:for-each>
    </ListOfCustomObject3>    
	</xsl:template>
</xsl:stylesheet>



	   
        
       
        