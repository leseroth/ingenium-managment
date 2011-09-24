(:: pragma bea:global-element-parameter parameter="$serviceRequestWS_ServiceRequestUpdate_Output1" element="ns0:ServiceRequestWS_ServiceRequestUpdate_Output" location="../../../business/wsdls/crmOnDemand/ServiceRequest.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:actualizarSolicitudResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/servicerequest";
declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "urn:crmondemand/ws/servicerequest/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ActualizarSolicitudResponse/";

declare function xf:ActualizarSolicitudResponse($serviceRequestWS_ServiceRequestUpdate_Output1 as element(ns0:ServiceRequestWS_ServiceRequestUpdate_Output))
    as element(ns1:actualizarSolicitudResponse) {
        let $ListOfServiceRequest := $serviceRequestWS_ServiceRequestUpdate_Output1/ns2:ListOfServiceRequest
        return
            <ns1:actualizarSolicitudResponse>{ not(empty(data($ListOfServiceRequest/ns2:ServiceRequest[1]/ns2:ServiceRequestId))) }</ns1:actualizarSolicitudResponse>
};

declare variable $serviceRequestWS_ServiceRequestUpdate_Output1 as element(ns0:ServiceRequestWS_ServiceRequestUpdate_Output) external;

xf:ActualizarSolicitudResponse($serviceRequestWS_ServiceRequestUpdate_Output1)