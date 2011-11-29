(:: pragma bea:global-element-parameter parameter="$consultarSubastasFabricanteResponse1" element="ns1:consultarSubastasFabricanteResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarSubastasFabricanteResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastasFabricanteResponse12/";

declare function xf:ConsultarSubastasFabricanteResponse12($consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse))
    as element(ns0:consultarSubastasFabricanteResponse) {
        <ns0:consultarSubastasFabricanteResponse>
            {
                for $return in $consultarSubastasFabricanteResponse1/return
                return
                    <ns0:subastas>
                        <activa>{ data($return/activa) }</activa>
                        {
                            for $numSeguimiento in $return/numSeguimiento
                            return
                                <numSeguimiento>{ data($numSeguimiento) }</numSeguimiento>
                        }
                        <fechaInicio>{ data($return/fechaCreacionSubasta) }</fechaInicio>
                        <fechaTerminacion>{ data($return/fechaMaxSubasta) }</fechaTerminacion>
                        {
                            let $purchaseOrderBO := $return/purchaseOrderBO
                            return
                                <ordenCompra>                                    
                                    {
                                        let $itemPOBO := $purchaseOrderBO/itemPOBO
                                        return
                                            <item>
                                                <cantidad>{ data($itemPOBO/cantidad) }</cantidad>
                                                {
                                                    let $productoBO := $itemPOBO/productoBO
                                                    return
                                                        <producto>
                                                            <nombre>{ data($productoBO/nombre) }</nombre>
                                                            <categoria>{ data($productoBO/categoria) }</categoria>
                                                            {
                                                                for $peso in $productoBO/peso
                                                                return
                                                                    <pesoLibras>{ data($peso) }</pesoLibras>
                                                            }
                                                        </producto>
                                                }
                                            </item>
                                    }
                                    {
                                        let $comercioBO := $purchaseOrderBO/comercioBO
                                        return
                                            <comercio>
                                                <nombre>{ data($comercioBO/nombre) }</nombre>
                                                <nit>{ data($comercioBO/nit) }</nit>
                                            </comercio>
                                    }
                                    <estado>{ data($purchaseOrderBO/estado) }</estado>
                                    <numSeguimiento>{ data($purchaseOrderBO/numSeguimiento) }</numSeguimiento>
                                    <fecha>{ data($purchaseOrderBO/entrega) }</fecha>
                                </ordenCompra>
                        }
                        {
                            for $mejorOfertaBO in $return/mejorOfertaBO
                            return
                                <mejor>
                                    <numSeguimiento>{ data($mejorOfertaBO/numSeguimiento) }</numSeguimiento>
                                    <horarioEntrega>{ data($mejorOfertaBO/fechaEntrega) }</horarioEntrega>
                                    {
                                        let $fabricanteBO := $mejorOfertaBO/fabricanteBO
                                        return
                                            <fabricante>
                                                <nombre>{ data($fabricanteBO/nombre) }</nombre>
                                                <nit>{ data($fabricanteBO/nit) }</nit>
                                                {
                                                    for $direccion in $fabricanteBO/direccion
                                                    return
                                                        <direccion>{ data($direccion) }</direccion>
                                                }
                                                {
                                                    for $email in $fabricanteBO/email
                                                    return
                                                        <email>{ data($email) }</email>
                                                }
                                                {
                                                    for $codPais in $fabricanteBO/codPais
                                                    return
                                                        <codPais>{ data($codPais) }</codPais>
                                                }
                                                {
                                                    for $codPostal in $fabricanteBO/codPostal
                                                    return
                                                        <codPostal>{ data($codPostal) }</codPostal>
                                                }
                                            </fabricante>
                                    }
                                    {
                                        for $mensaje in $mejorOfertaBO/mensaje
                                        return
                                            <mensaje>{ data($mensaje) }</mensaje>
                                    }
                                    {
                                        for $valor in $mejorOfertaBO/valor
                                        return
                                            <valor>{ data($valor) }</valor>
                                    }
                                    {
                                        for $estadoOferta in $mejorOfertaBO/estadoOferta
                                        return
                                            <estadoOferta>{ data($estadoOferta) }</estadoOferta>
                                    }
                                </mejor>
                        }
                        {
                            for $mensaje in $return/mensaje
                            return
                                <mensaje>{ data($mensaje) }</mensaje>
                        }
                        {
                            for $fabricanteBOList in $return/fabricanteBOList
                            return
                                <fabricante>
                                    <nombre>{ data($fabricanteBOList/nombre) }</nombre>
                                    <nit>{ data($fabricanteBOList/nit) }</nit>
                                    {
                                        for $direccion in $fabricanteBOList/direccion
                                        return
                                            <direccion>{ data($direccion) }</direccion>
                                    }
                                    {
                                        for $email in $fabricanteBOList/email
                                        return
                                            <email>{ data($email) }</email>
                                    }
                                    {
                                        for $codPais in $fabricanteBOList/codPais
                                        return
                                            <codPais>{ data($codPais) }</codPais>
                                    }
                                    {
                                        for $codPostal in $fabricanteBOList/codPostal
                                        return
                                            <codPostal>{ data($codPostal) }</codPostal>
                                    }
                                </fabricante>
                        }
                        {
                            for $ofertaBOList in $return/ofertaBOList
                            return
                                <ofertas>
                                    <numSeguimiento>{ data($ofertaBOList/numSeguimiento) }</numSeguimiento>
                                    <horarioEntrega>{ data($ofertaBOList/fechaEntrega) }</horarioEntrega>
                                    {
                                        let $fabricanteBO := $ofertaBOList/fabricanteBO
                                        return
                                            <fabricante>
                                                <nombre>{ data($fabricanteBO/nombre) }</nombre>
                                                <nit>{ data($fabricanteBO/nit) }</nit>
                                                {
                                                    for $direccion in $fabricanteBO/direccion
                                                    return
                                                        <direccion>{ data($direccion) }</direccion>
                                                }
                                                {
                                                    for $email in $fabricanteBO/email
                                                    return
                                                        <email>{ data($email) }</email>
                                                }
                                                {
                                                    for $codPais in $fabricanteBO/codPais
                                                    return
                                                        <codPais>{ data($codPais) }</codPais>
                                                }
                                                {
                                                    for $codPostal in $fabricanteBO/codPostal
                                                    return
                                                        <codPostal>{ data($codPostal) }</codPostal>
                                                }
                                            </fabricante>
                                    }
                                    {
                                        for $valor in $ofertaBOList/valor
                                        return
                                            <valor>{ data($valor) }</valor>
                                    }
                                    {
                                        for $estadoOferta in $ofertaBOList/estadoOferta
                                        return
                                            <estadoOferta>{ data($estadoOferta) }</estadoOferta>
                                    }
                                    {
			                            for $mensaje in $ofertaBOList/mensaje
			                            return
			                                <mensaje>{ data($mensaje) }</mensaje>
			                        }
                                </ofertas>
                        }
                    </ns0:subastas>
            }
        </ns0:consultarSubastasFabricanteResponse>
};

declare variable $consultarSubastasFabricanteResponse1 as element(ns1:consultarSubastasFabricanteResponse) external;

xf:ConsultarSubastasFabricanteResponse12($consultarSubastasFabricanteResponse1)
