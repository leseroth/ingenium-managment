(:: pragma bea:global-element-parameter parameter="$darGanadorSubastaResponse1" element="ns1:darGanadorSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:darGanadorSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/DarGanadorSubastaResponse/";

declare function xf:DarGanadorSubastaResponse($darGanadorSubastaResponse1 as element(ns1:darGanadorSubastaResponse))
    as element(ns0:darGanadorSubastaResponse) {
        <ns0:darGanadorSubastaResponse>
            {
                let $return := $darGanadorSubastaResponse1/return
                return
                    <ns0:fabricante>
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
                    </ns0:fabricante>
            }
        </ns0:darGanadorSubastaResponse>
};

declare variable $darGanadorSubastaResponse1 as element(ns1:darGanadorSubastaResponse) external;

xf:DarGanadorSubastaResponse($darGanadorSubastaResponse1)
