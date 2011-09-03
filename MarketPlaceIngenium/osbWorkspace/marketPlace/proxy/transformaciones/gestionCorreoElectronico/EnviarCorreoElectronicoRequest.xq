(:: pragma bea:global-element-parameter parameter="$enviarCorreoElectronico1" element="ns0:enviarCorreoElectronico" location="../../wsdls/gestionCorreoElectronico/GestionCorreoElectronico.xsd" ::)
(:: pragma bea:global-element-return element="ns1:sendMail" location="../../../business/wsdls/mailer/XMLSchema_-24959577.xsd" ::)

declare namespace ns1 = "http://ws.mailer.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionCorreoElectronico/EnviarCorreoElectronicoRequest/";

declare function xf:EnviarCorreoElectronicoRequest($enviarCorreoElectronico1 as element(ns0:enviarCorreoElectronico))
    as element(ns1:sendMail) {
        <ns1:sendMail>
            {
                for $to in $enviarCorreoElectronico1/ns0:to
                return
                    <to>{ data($to) }</to>
            }
            {
                for $cc in $enviarCorreoElectronico1/ns0:cc
                return
                    <cc>{ data($cc) }</cc>
            }
            {
                for $bcc in $enviarCorreoElectronico1/ns0:bcc
                return
                    <bcc>{ data($bcc) }</bcc>
            }
            {
                for $subject in $enviarCorreoElectronico1/ns0:subject
                return
                    <subject>{ data($subject) }</subject>
            }
            {
                for $message in $enviarCorreoElectronico1/ns0:message
                return
                    <message>{ data($message) }</message>
            }
            <from>{ data($enviarCorreoElectronico1/ns0:from) }</from>
            <password>{ data($enviarCorreoElectronico1/ns0:password) }</password>
            {
                for $attachments in $enviarCorreoElectronico1/ns0:attachments
                return
                    <attachments>{ data($attachments) }</attachments>
            }
        </ns1:sendMail>
};

declare variable $enviarCorreoElectronico1 as element(ns0:enviarCorreoElectronico) external;

xf:EnviarCorreoElectronicoRequest($enviarCorreoElectronico1)
