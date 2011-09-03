<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co" 
xmlns:ser="urn:/crmondemand/xml/servicerequest" xmlns:ns ="urn:crmondemand/ws/servicerequest/10/2004" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<ns:ServiceRequestWS_ServiceRequestInsert_Input>
	<ser:ListOfServiceRequest>	
	<ser:ServiceRequest> 	
		<ser:AccountId> <xsl:value-of select="tns:radicarSolicitud/tns:idCliente"></xsl:value-of></ser:AccountId>
		<ser:SRNumber></ser:SRNumber>        
        <ser:plEstado_Solicitud>Abierta</ser:plEstado_Solicitud>
        <ser:CreatedDate><xsl:value-of select="tns:radicarSolicitud/tns:solicitud/tns:fecha"></xsl:value-of></ser:CreatedDate>
        <ser:Cause><xsl:value-of select="tns:radicarSolicitud/tns:solicitud/tns:causa"></xsl:value-of></ser:Cause>
        <ser:ModifiedDate></ser:ModifiedDate>
        <ser:Description>Descripcion</ser:Description>       
    </ser:ServiceRequest>
    </ser:ListOfServiceRequest>
    </ns:ServiceRequestWS_ServiceRequestInsert_Input>
	</xsl:template>
</xsl:stylesheet>
	
	