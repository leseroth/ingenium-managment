(:: pragma bea:global-element-parameter parameter="$ordenCompraNoExisteException1" element="ns0:OrdenCompraNoExisteException" location="../../../business/wsdls/poManager/XMLSchema_-633731609.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarPOFault" location="../../wsdls/gestionPO/GestionPO.xsd" ::)

declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "http://ws.pomanager.marketplace.losalpes.com.co/";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionPO/ConsultarPOFault/";

declare function xf:ConsultarPOFault($ordenCompraNoExisteException1 as element(ns0:OrdenCompraNoExisteException))
    as element(ns1:consultarPOFault) {
        <ns1:consultarPOFault>
            <ns1:mensaje>{ data($ordenCompraNoExisteException1/message) }</ns1:mensaje>
        </ns1:consultarPOFault>
};

declare variable $ordenCompraNoExisteException1 as element(ns0:OrdenCompraNoExisteException) external;

xf:ConsultarPOFault($ordenCompraNoExisteException1)
