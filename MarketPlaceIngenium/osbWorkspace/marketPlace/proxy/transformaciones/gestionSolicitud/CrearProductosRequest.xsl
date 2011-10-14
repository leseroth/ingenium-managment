<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co"
xmlns:cus="urn:/crmondemand/xml/customobject3" xmlns:ns ="urn:crmondemand/ws/customobject3/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<soapenv:Body xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<ns:CustomObject3WS_CustomObject3Insert_Input>	
		<cus:ListOfCustomObject3>
		<xsl:variable name="idCliente" select="tns:crearProducto/tns:idCliente"></xsl:variable>
		<xsl:for-each select="tns:crearProducto/tns:solicitud/tns:productos">
		<cus:CustomObject3>
        <cus:AccountId><xsl:value-of select="$idCliente"></xsl:value-of></cus:AccountId>        
        <cus:Name><xsl:value-of select="nombre"></xsl:value-of></cus:Name>
        <cus:stCategoria><xsl:value-of select="categoria"></xsl:value-of></cus:stCategoria>
        <cus:stTipo><xsl:value-of select="tipo"></xsl:value-of></cus:stTipo>         
        <cus:plEstado><xsl:value-of select="estado"></xsl:value-of></cus:plEstado>        
        <cus:stReferencia><xsl:value-of select="referencia"></xsl:value-of></cus:stReferencia>       
        </cus:CustomObject3>
        </xsl:for-each>
        </cus:ListOfCustomObject3>          
    </ns:CustomObject3WS_CustomObject3Insert_Input>
    </soapenv:Body>
    </xsl:template>
</xsl:stylesheet>