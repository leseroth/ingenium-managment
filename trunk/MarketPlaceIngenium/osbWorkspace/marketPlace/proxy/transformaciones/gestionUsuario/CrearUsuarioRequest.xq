(:: pragma bea:global-element-parameter parameter="$registrarUsuario1" element="ns0:registrarUsuario" location="../../wsdls/gestionUsuario/GestionUsuario.xsd" ::)
(:: pragma bea:global-element-return element="ns1:crearUsuario" location="../../../business/wsdls/LDAP/XMLSchema_-1211761121.xsd" ::)

declare namespace ns1 = "http://ws.ldap.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketplace/proxy/transformaciones/gestionUsuario/CrearUsuarioRequest/";

declare function xf:CrearUsuarioRequest($registrarUsuario1 as element(ns0:registrarUsuario))
    as element(ns1:crearUsuario) {
        <ns1:crearUsuario>
            <nit>{ data($registrarUsuario1/nit) }</nit>
            <rol>{ data($registrarUsuario1/rol) }</rol>
            <nombre>{ data($registrarUsuario1/nombre) }</nombre>
            <email>{ data($registrarUsuario1/email) }</email>
        </ns1:crearUsuario>
};

declare variable $registrarUsuario1 as element(ns0:registrarUsuario) external;

xf:CrearUsuarioRequest($registrarUsuario1)
