<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co"
xmlns:cus="urn:/crmondemand/xml/customobject3" xmlns:ns ="urn:crmondemand/ws/customobject3/10/2004"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<soapenv:Body xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<ns:CustomObject3WS_CustomObject3Update_Input>	
		<cus:ListOfCustomObject3>
		<xsl:variable name="idCliente" select="tns:modificarCliente/tns:idCuenta"></xsl:variable>
		<xsl:for-each select="tns:modificarCliente/tns:productos">
		<xsl:if test="string(id) != ''">
		<cus:CustomObject3>
        <cus:AccountId><xsl:value-of select="$idCliente"></xsl:value-of></cus:AccountId>    
        <cus:CustomObject3Id><xsl:value-of select="id"></xsl:value-of></cus:CustomObject3Id>    
        <cus:Name><xsl:value-of select="nombre"></xsl:value-of></cus:Name>
        <cus:stCategoria><xsl:value-of select="tns:categoria"></xsl:value-of></cus:stCategoria>
        <cus:stTipo><xsl:value-of select="tipo"></xsl:value-of></cus:stTipo>         
        <cus:plEstado><xsl:value-of select="estado"></xsl:value-of></cus:plEstado>        
        <cus:stReferencia><xsl:value-of select="referencia"></xsl:value-of></cus:stReferencia>       
        <cus:stPesoLibras><xsl:value-of select="pesoLibras"></xsl:value-of></cus:stPesoLibras>
        </cus:CustomObject3>
       </xsl:if>
        </xsl:for-each>
        </cus:ListOfCustomObject3>          
    </ns:CustomObject3WS_CustomObject3Update_Input>
    </soapenv:Body>
    </xsl:template>
</xsl:stylesheet>