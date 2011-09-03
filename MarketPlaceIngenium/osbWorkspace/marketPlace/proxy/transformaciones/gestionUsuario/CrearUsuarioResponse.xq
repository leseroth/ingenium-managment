(:: pragma bea:global-element-parameter parameter="$crearUsuarioResponse1" element="ns1:crearUsuarioResponse" location="../../../business/wsdls/LDAP/XMLSchema_-1211761121.xsd" ::)
(:: pragma bea:global-element-return element="ns0:registrarUsuarioResponse" location="../../wsdls/gestionUsuario/GestionUsuario.xsd" ::)

declare namespace ns1 = "http://ws.ldap.marketplace.losalpes.com.co/";
declare namespace ns0 = "http://marketplace.losalpes.com.co";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionUsuario/CrearUsuarioResponse/";

declare function xf:CrearUsuarioResponse($crearUsuarioResponse1 as element(ns1:crearUsuarioResponse))
    as element(ns0:registrarUsuarioResponse) {
        <ns0:registrarUsuarioResponse>
            <login>{ data($crearUsuarioResponse1/return/login) }</login>
            <password>{ data($crearUsuarioResponse1/return/password) }</password>
        </ns0:registrarUsuarioResponse>
};

declare variable $crearUsuarioResponse1 as element(ns1:crearUsuarioResponse) external;

xf:CrearUsuarioResponse($crearUsuarioResponse1)
