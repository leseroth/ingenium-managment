<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://marketplace.losalpes.com.co" 
xmlns:ser="urn:/crmondemand/xml/servicerequest" xmlns:ns ="urn:crmondemand/ws/servicerequest/10/2004" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<soapenv:Body xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<ns:ServiceRequestWS_ServiceRequestUpdate_Input>
	<ser:ListOfServiceRequest>	
	<ser:ServiceRequest> 	
		<ser:ServiceRequestId> <xsl:value-of   select="tns:actualizarSolicitud/tns:idSolicitud"></xsl:value-of></ser:ServiceRequestId>		       
        <ser:plEstado_Solicitud><xsl:value-of select="tns:actualizarSolicitud/tns:solicitud/tns:estado"></xsl:value-of></ser:plEstado_Solicitud>        
        <ser:Cause><xsl:value-of select="tns:actualizarSolicitud/tns:solicitud/tns:causa"></xsl:value-of></ser:Cause>            
    </ser:ServiceRequest>
    </ser:ListOfServiceRequest>
    </ns:ServiceRequestWS_ServiceRequestUpdate_Input>
    </soapenv:Body>
	</xsl:template>
</xsl:stylesheet>