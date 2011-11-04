<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:mar="http://marketplace.losalpes.com.co"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<xsl:output method="xml" version="1.0" encoding="UTF-8"
		indent="yes" />
	<xsl:template match="/">
		<mar:consultarClienteResponse >
			<mar:cliente>
				<xsl:variable name="productos" select="products_clients/mar:consultarProductosClienteResponse/mar:productos"></xsl:variable>
				<xsl:for-each select="products_clients/mar:consultarClienteResponse/mar:cliente">
					<xsl:variable name="contactos" select="contactos"></xsl:variable>
					<id>
						<xsl:value-of select="id"></xsl:value-of>
					</id>
					<nombre>
						<xsl:value-of select="nombre"></xsl:value-of>
					</nombre>
					<nit>
						<xsl:value-of select="nit"></xsl:value-of>
					</nit>
					<direccion>
						<xsl:value-of select="direccion"></xsl:value-of>
					</direccion>
					<telefono>
						<xsl:value-of select="telefono"></xsl:value-of>
					</telefono>
					<email>
						<xsl:value-of select="email"></xsl:value-of>
					</email>
					<razonSocial>
						<xsl:value-of select="razonSocial"></xsl:value-of>
					</razonSocial>
					<estado>					
						<xsl:value-of select="estado"></xsl:value-of>
					</estado>
					<comision>
						<xsl:value-of select="comision"></xsl:value-of>
					</comision>
					<tipo>
						<xsl:value-of select="tipo"></xsl:value-of>
					</tipo>					
					<xsl:copy-of select="$contactos"></xsl:copy-of>	
					<solicitudes>
					<xsl:copy-of select="$productos"></xsl:copy-of>	
					</solicitudes>
								
				</xsl:for-each>
					
			</mar:cliente>
		</mar:consultarClienteResponse>
	</xsl:template>
</xsl:stylesheet>



	   
        
       
        