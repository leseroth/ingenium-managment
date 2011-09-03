(:: pragma bea:global-element-parameter parameter="$darGanadorSubastaResponse1" element="ns1:darGanadorSubastaResponse" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)
(:: pragma bea:global-element-return element="ns0:darGanadorSubastaResponse" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/DarGanadorSubastaResponse/";

declare function xf:DarGanadorSubastaResponse($darGanadorSubastaResponse1 as element(ns1:darGanadorSubastaResponse))
    as element(ns0:darGanadorSubastaResponse) {
        <ns0:darGanadorSubastaResponse>
            <ns0:fabricante>
                <nombre>{ data($darGanadorSubastaResponse1/return/nombre) }</nombre>
                <nit>{ data($darGanadorSubastaResponse1/return/nit) }</nit>
                {
                    for $email in $darGanadorSubastaResponse1/return/email
                    return
                        <email>{ data($email) }</email>
                }
            </ns0:fabricante>
        </ns0:darGanadorSubastaResponse>
};

declare variable $darGanadorSubastaResponse1 as element(ns1:darGanadorSubastaResponse) external;

xf:DarGanadorSubastaResponse($darGanadorSubastaResponse1)
