(:: pragma bea:global-element-parameter parameter="$serviceRequestWS_ServiceRequestQueryPage_Output1" element="ns0:ServiceRequestWS_ServiceRequestQueryPage_Output" location="../../../business/wsdls/crmOnDemand/ServiceRequest.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:radicarSolicitudResponse" location="../../wsdls/GestionCliente/GestionCliente.xsd" ::)

declare namespace ns2 = "urn:/crmondemand/xml/servicerequest";
declare namespace ns1 = "http://marketplace.losalpes.com.co";
declare namespace ns0 = "urn:crmondemand/ws/servicerequest/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/RadicarSolicitudResponse/";

declare function xf:RadicarSolicitudResponse($serviceRequestWS_ServiceRequestQueryPage_Output1 as element(ns0:ServiceRequestWS_ServiceRequestQueryPage_Output))
    as element(ns1:radicarSolicitudResponse) {
        <ns1:radicarSolicitudResponse>
            <ns1:numRadicacion>{ data($serviceRequestWS_ServiceRequestQueryPage_Output1/ns2:ListOfServiceRequest/ns2:ServiceRequest[1]/ns2:SRNumber) }</ns1:numRadicacion>
        </ns1:radicarSolicitudResponse>
};

declare variable $serviceRequestWS_ServiceRequestQueryPage_Output1 as element(ns0:ServiceRequestWS_ServiceRequestQueryPage_Output) external;

xf:RadicarSolicitudResponse($serviceRequestWS_ServiceRequestQueryPage_Output1)
