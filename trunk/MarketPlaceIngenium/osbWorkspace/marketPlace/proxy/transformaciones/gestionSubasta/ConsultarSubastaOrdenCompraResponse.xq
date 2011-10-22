(:: pragma bea:global-element-parameter parameter="$consultarSubastaOrdenCompraResponse1" element="ns1:consultarSubastaOrdenCompraResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarSubastaOrdenCompraResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarSubastaOrdenCompraResponse/";

declare function xf:ConsultarSubastaOrdenCompraResponse($consultarSubastaOrdenCompraResponse1 as element(ns1:consultarSubastaOrdenCompraResponse))
    as element(ns0:consultarSubastaOrdenCompraResponse) {
        <ns0:consultarSubastaOrdenCompraResponse>
            <ns0:subasta>
                <activa>{ data($consultarSubastaOrdenCompraResponse1/return/activa) }</activa>
                <numSeguimiento>{ data($consultarSubastaOrdenCompraResponse1/return/numSeguimiento) }</numSeguimiento>
                {
                    let $purchaseOrderBO := $consultarSubastaOrdenCompraResponse1/return/purchaseOrderBO
                    return
                        <ordenCompra>
                            <comercio>
                                {
                                    for $email in $purchaseOrderBO/comercioBO/email
                                    return
                                        <email>{ data($email) }</email>
                                }
                            </comercio>
                        </ordenCompra>
                }
                <mejor>
                    <fabricante>
                        {
                            for $email in $consultarSubastaOrdenCompraResponse1/return/mejorOfertaBO/fabricanteBO/email
                            return
                                <email>{ data($email) }</email>
                        }
                    </fabricante>
                    {
                        for $mensaje in $consultarSubastaOrdenCompraResponse1/return/mejorOfertaBO/mensaje
                        return
                            <mensaje>{ data($mensaje) }</mensaje>
                    }
                    {
                        for $valor in $consultarSubastaOrdenCompraResponse1/return/mejorOfertaBO/valor
                        return
                            <valor>{ data($valor) }</valor>
                    }
                </mejor>
            </ns0:subasta>
        </ns0:consultarSubastaOrdenCompraResponse>
};

declare variable $consultarSubastaOrdenCompraResponse1 as element(ns1:consultarSubastaOrdenCompraResponse) external;

xf:ConsultarSubastaOrdenCompraResponse($consultarSubastaOrdenCompraResponse1)
