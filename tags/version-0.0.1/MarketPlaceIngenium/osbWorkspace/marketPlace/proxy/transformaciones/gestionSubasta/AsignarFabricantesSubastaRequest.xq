(:: pragma bea:global-element-parameter parameter="$asignarFabricantesSubasta1" element="ns0:asignarFabricantesSubasta" location="../../wsdls/gestionSubasta/GestionSubasta.xsd" ::)
(:: pragma bea:global-element-return element="ns1:asignarFabricantesSubasta" location="../../../business/wsdls/transactManager/XMLSchema_765612391.xsd" ::)

declare namespace ns1 = "http://ws.transact.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSubasta/AsignarFabricantesSubastaRequest/";

declare function xf:AsignarFabricantesSubastaRequest($asignarFabricantesSubasta1 as element(ns0:asignarFabricantesSubasta))
    as element(ns1:asignarFabricantesSubasta) {
        <ns1:asignarFabricantesSubasta>
            <numSeguimientoSubasta>{ data($asignarFabricantesSubasta1/ns0:numSeguimientoSubasta) }</numSeguimientoSubasta>
            {
                for $fabricantes in $asignarFabricantesSubasta1/ns0:fabricantes
                return
                    <fabricantes>
                        {
                            for $email in $fabricantes/email
                            return
                                <email>{ data($email) }</email>
                        }
                        <nit>{ data($fabricantes/nit) }</nit>
                        <nombre>{ data($fabricantes/nombre) }</nombre>
                    </fabricantes>
            }
        </ns1:asignarFabricantesSubasta>
};

declare variable $asignarFabricantesSubasta1 as element(ns0:asignarFabricantesSubasta) external;

xf:AsignarFabricantesSubastaRequest($asignarFabricantesSubasta1)
