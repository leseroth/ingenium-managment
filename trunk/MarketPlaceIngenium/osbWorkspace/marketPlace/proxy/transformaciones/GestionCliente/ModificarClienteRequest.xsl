<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co" 
xmlns:acc="urn:/crmondemand/xml/account" xmlns:ns ="urn:crmondemand/ws/account/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<soapenv:Body xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<ns:AccountWS_AccountUpdate_Input>
	<acc:ListOfAccount>	
	<acc:Account>
		<acc:AccountId> <xsl:value-of   select="tns:modificarCliente/tns:idCuenta"></xsl:value-of></acc:AccountId>					
		<acc:AccountName> <xsl:value-of   select="tns:modificarCliente/tns:cliente/nombre"></xsl:value-of></acc:AccountName>
		<acc:stNit><xsl:value-of select="tns:modificarCliente/tns:cliente/nit"></xsl:value-of></acc:stNit>
        <acc:MainPhone><xsl:value-of select="tns:modificarCliente/tns:cliente/telefono"></xsl:value-of></acc:MainPhone>
        <acc:Location><xsl:value-of select="tns:modificarCliente/tns:cliente/direccion"></xsl:value-of></acc:Location>
        <acc:stNmero_Matricula><xsl:value-of select="tns:modificarCliente/tns:cliente/razonSocial"></xsl:value-of></acc:stNmero_Matricula>
        <acc:Status><xsl:value-of select="tns:modificarCliente/tns:cliente/estado"></xsl:value-of></acc:Status>
        <acc:AccountType><xsl:value-of select="tns:modificarCliente/tns:cliente/tipo"></xsl:value-of></acc:AccountType>
        <acc:stRazon_Social><xsl:value-of select="tns:modificarCliente/tns:cliente/razonSocial"></xsl:value-of></acc:stRazon_Social>
        <acc:stCorreo_Electronico><xsl:value-of select="tns:modificarCliente/tns:cliente/email"></xsl:value-of></acc:stCorreo_Electronico>
        <acc:nComision><xsl:value-of select="tns:modificarCliente/tns:cliente/comision"></xsl:value-of></acc:nComision>   
        <acc:stCodigoPostal><xsl:value-of select="tns:modificarCliente/tns:cliente/codigoPostal"></xsl:value-of></acc:stCodigoPostal>
        <acc:stCodigoPais><xsl:value-of select="tns:modificarCliente/tns:cliente/codigoPais"></xsl:value-of></acc:stCodigoPais> 
        <acc:plCategoria><xsl:value-of select="tns:modificarCliente/tns:cliente/categoria"></xsl:value-of></acc:plCategoria>    
    </acc:Account> 
    </acc:ListOfAccount> 
    </ns:AccountWS_AccountUpdate_Input>
    </soapenv:Body>
	</xsl:template>
</xsl:stylesheet>