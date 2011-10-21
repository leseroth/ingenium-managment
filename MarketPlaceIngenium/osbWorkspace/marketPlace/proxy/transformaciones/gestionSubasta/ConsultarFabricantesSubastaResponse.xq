(:: pragma bea:global-element-parameter parameter="$consultarFabricantesSubastaResponse1" element="ns1:consultarFabricantesSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarFabricantesSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/ConsultarFabricantesSubastaResponse/";

declare function xf:ConsultarFabricantesSubastaResponse($consultarFabricantesSubastaResponse1 as element(ns1:consultarFabricantesSubastaResponse))
    as element(ns0:consultarFabricantesSubastaResponse) {
        <ns0:consultarFabricantesSubastaResponse>
            {
                for $return in $consultarFabricantesSubastaResponse1/return
                return
                    <ns0:fabricantes>
                        <nombre>{ data($return/nombre) }</nombre>
                        <nit>{ data($return/nit) }</nit>
                        {
                            for $direccion in $return/direccion
                            return
                                <direccion>{ data($direccion) }</direccion>
                        }
                        {
                            for $email in $return/email
                            return
                                <email>{ data($email) }</email>
                        }
                        {
                            for $codPais in $return/codPais
                            return
                                <codPais>{ data($codPais) }</codPais>
                        }
                        {
                            for $codPostal in $return/codPostal
                            return
                                <codPostal>{ data($codPostal) }</codPostal>
                        }
                    </ns0:fabricantes>
            }
        </ns0:consultarFabricantesSubastaResponse>
};

declare variable $consultarFabricantesSubastaResponse1 as element(ns1:consultarFabricantesSubastaResponse) external;

xf:ConsultarFabricantesSubastaResponse($consultarFabricantesSubastaResponse1)
