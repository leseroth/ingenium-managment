<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co" 
xmlns:acc="urn:/crmondemand/xml/account" xmlns:ns ="urn:crmondemand/ws/account/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<acc:ListOfAccount>	
	<xsl:for-each select="ns:AccountWS_AccountQueryPage_Output/acc:ListOfAccount/acc:Account/">  
	<acc:Account>
		<acc:AccountId> <xsl:value-of   select="acc:AccountId"></xsl:value-of></acc:AccountId>					
		<acc:AccountName> <xsl:value-of   select="acc:AccountName"></xsl:value-of></acc:AccountName>
		<acc:stNit><xsl:value-of select="acc:stNit"></xsl:value-of></acc:stNit>
		<acc:stCorreo_Electronico><xsl:value-of select="acc:stCorreo_Electronico"></xsl:value-of></acc:stCorreo_Electronico>
		<acc:Location><xsl:value-of select="acc:Location"></xsl:value-of></acc:Location>	
		<acc:MainPhone><xsl:value-of select="acc:MainPhone"></xsl:value-of></acc:MainPhone>   
    </acc:Account> 
    </xsl:for-each>
    </acc:ListOfAccount>   
	</xsl:template>
</xsl:stylesheet>