<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co"
xmlns:con="urn:/crmondemand/xml/contact" xmlns:ns ="urn:crmondemand/ws/contact/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<soapenv:Body xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<ns:ContactWS_ContactUpdate_Input>	
	  <con:ListOfContact>	
	  <xsl:variable name="idCliente" select="tns:modificarCliente/tns:idCuenta"></xsl:variable>
	  <xsl:for-each select="tns:modificarCliente/tns:cliente/contactos">  
	  <xsl:if test="string(tns:id) != ''">
	  <con:Contact>	  
	  	<con:AccountId><xsl:value-of select="$idCliente"></xsl:value-of></con:AccountId>        
        <con:ContactId><xsl:value-of select="tns:id"></xsl:value-of></con:ContactId>
        <con:stNmero_de_Identificacin><xsl:value-of select="tns:numIdentificacion"></xsl:value-of></con:stNmero_de_Identificacin>
        <con:plTipo_de_Identificacin><xsl:value-of select="tns:tipoIdentificacion"></xsl:value-of></con:plTipo_de_Identificacin>
        <con:ContactFirstName><xsl:value-of select="tns:nombre"></xsl:value-of></con:ContactFirstName>
        <con:ContactLastName><xsl:value-of select="tns:nombre"></xsl:value-of></con:ContactLastName>
        <con:ContactFullName>Nombre</con:ContactFullName>
        <con:CellularPhone><xsl:value-of select="tns:celular"></xsl:value-of></con:CellularPhone>
        <con:ContactEmail><xsl:value-of select="tns:email"></xsl:value-of></con:ContactEmail>        
        <con:WorkPhone><xsl:value-of select="tns:telefono"></xsl:value-of></con:WorkPhone>
        <con:HomePhone><xsl:value-of select ="tns:telefono" ></xsl:value-of></con:HomePhone>   
        <con:plEstado_Contacto><xsl:value-of select ="tns:estado" ></xsl:value-of></con:plEstado_Contacto>  
        <con:stDireccion><xsl:value-of select ="tns:direccion" ></xsl:value-of></con:stDireccion>
        <con:stCelular><xsl:value-of select ="tns:celular" ></xsl:value-of></con:stCelular>  
       </con:Contact>
       </xsl:if>
      </xsl:for-each> 
       </con:ListOfContact>          
    </ns:ContactWS_ContactUpdate_Input>
    </soapenv:Body>
    </xsl:template>
</xsl:stylesheet>