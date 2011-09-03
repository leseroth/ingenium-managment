(:: pragma bea:global-element-parameter parameter="$registrarOferta1" element="ns0:registrarOferta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:registrarOferta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/RegistrarOfertaRequest/";

declare function xf:RegistrarOfertaRequest($registrarOferta1 as element(ns0:registrarOferta))
    as element(ns1:registrarOferta) {
        <ns1:registrarOferta>
            <numSeguimientoSubasta>{ data($registrarOferta1/ns0:numSeguimientoSub) }</numSeguimientoSubasta>
            {
                let $oferta := $registrarOferta1/ns0:oferta
                return
                    <oferta>
                        {
                            let $fabricante := $oferta/fabricante
                            return
                                <fabricante>
                                    {
                                        for $email in $fabricante/email
                                        return
                                            <email>{ data($email) }</email>
                                    }
                                    <nit>{ data($fabricante/nit) }</nit>
                                    <nombre>{ data($fabricante/nombre) }</nombre>
                                </fabricante>
                        }
                        <fechaEntrega>{ data($oferta/horarioEntrega) }</fechaEntrega>
                        <numSeguimiento>{ data($registrarOferta1/ns0:numSeguimientoSub) }</numSeguimiento>
                        {
                            let $producto := $oferta/item/producto
                            return
                                <productoOfrecido>
                                    {
                                        for $categoria in $producto/categoria
                                        return
                                            <categoria>{ data($categoria) }</categoria>
                                    }
                                    <nombre>{ data($producto/nombre) }</nombre>
                                </productoOfrecido>
                        }
                        <valor>{ data($oferta/item/valor) }</valor>
                    </oferta>
            }
        </ns1:registrarOferta>
};

declare variable $registrarOferta1 as element(ns0:registrarOferta) external;

xf:RegistrarOfertaRequest($registrarOferta1)
