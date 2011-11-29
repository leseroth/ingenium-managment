(:: pragma bea:global-element-parameter parameter="$sendMailResponse1" element="ns1:sendMailResponse" location="../../../business/wsdls/mailer/XMLSchema_-24959577.xsd" ::)
(:: pragma bea:global-element-return element="ns0:enviarCorreoElectronicoResponse" location="../../wsdls/gestionCorreoElectronico/GestionCorreoElectronico.xsd" ::)

declare namespace ns1 = "http://ws.mailer.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCorreoElectronico/EnviarCorreoElectronicoResponse/";

declare function xf:EnviarCorreoElectronicoResponse($sendMailResponse1 as element(ns1:sendMailResponse))
    as element(ns0:enviarCorreoElectronicoResponse) {
        <ns0:enviarCorreoElectronicoResponse>
            <ns0:resultado>{ data($sendMailResponse1/return) }</ns0:resultado>
        </ns0:enviarCorreoElectronicoResponse>
};

declare variable $sendMailResponse1 as element(ns1:sendMailResponse) external;

xf:EnviarCorreoElectronicoResponse($sendMailResponse1)
