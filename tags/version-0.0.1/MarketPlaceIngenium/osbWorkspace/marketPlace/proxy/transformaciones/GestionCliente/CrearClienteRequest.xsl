<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co" 
xmlns:acc="urn:/crmondemand/xml/account" xmlns:con="urn:/crmondemand/xml/contact" xmlns:ns ="urn:crmondemand/ws/account/10/2004" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<ns:AccountWS_AccountInsert_Input>
	<acc:ListOfAccount>	
	<acc:Account> 	
		<acc:AccountName> <xsl:value-of   select="tns:crearCliente/tns:cliente/nombre"></xsl:value-of></acc:AccountName>
		<acc:stNit><xsl:value-of select="tns:crearCliente/tns:cliente/nit"></xsl:value-of></acc:stNit>
        <acc:Description><xsl:value-of select="tns:crearCliente/tns:cliente/direccion"></xsl:value-of></acc:Description>
        <acc:MainPhone><xsl:value-of select="tns:crearCliente/tns:cliente/telefono"></xsl:value-of></acc:MainPhone>
        <acc:Location><xsl:value-of select="tns:crearCliente/tns:cliente/direccion"></xsl:value-of></acc:Location>
        <acc:stCorreo_Electronico><xsl:value-of select="tns:crearCliente/tns:cliente/email"></xsl:value-of></acc:stCorreo_Electronico>
        <acc:stNmero_Matricula>nro</acc:stNmero_Matricula>
        <acc:Status>Activo</acc:Status>
        <acc:AccountType><xsl:value-of select="tns:crearCliente/tns:cliente/tipo"></xsl:value-of></acc:AccountType>
        <acc:stRazon_Social><xsl:value-of select="tns:crearCliente/tns:cliente/razonSocial"></xsl:value-of></acc:stRazon_Social>
        <acc:nComision><xsl:value-of select="tns:crearCliente/tns:cliente/comision"></xsl:value-of></acc:nComision>
        <acc:stCodigoPostal><xsl:value-of select="tns:crearCliente/tns:cliente/codigoPostal"></xsl:value-of></acc:stCodigoPostal> 
        <acc:stCodigoPais><xsl:value-of select="tns:crearCliente/tns:cliente/codigoPais"></xsl:value-of></acc:stCodigoPais>   
    </acc:Account>
    </acc:ListOfAccount>
    </ns:AccountWS_AccountInsert_Input>
	</xsl:template>
</xsl:stylesheet>