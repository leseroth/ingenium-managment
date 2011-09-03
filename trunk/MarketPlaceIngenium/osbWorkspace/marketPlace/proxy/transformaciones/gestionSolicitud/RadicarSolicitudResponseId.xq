(:: pragma bea:global-element-parameter parameter="$serviceRequestWS_ServiceRequestInsert_Output1" element="ns0:ServiceRequestWS_ServiceRequestInsert_Output" location="../../../business/wsdls/crmOnDemand/ServiceRequest.wsdl" ::)

declare namespace ns1 = "urn:/crmondemand/xml/servicerequest";
declare namespace ns0 = "urn:crmondemand/ws/servicerequest/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/RadicarSolicitudResponseId/";


declare function xf:RadicarSolicitudResponseId($serviceRequestWS_ServiceRequestInsert_Output1 as element(ns0:ServiceRequestWS_ServiceRequestInsert_Output))
    as xs:string  {
        data($serviceRequestWS_ServiceRequestInsert_Output1/ns1:ListOfServiceRequest/ns1:ServiceRequest[1]/ns1:ServiceRequestId)
};

declare variable $serviceRequestWS_ServiceRequestInsert_Output1 as element(ns0:ServiceRequestWS_ServiceRequestInsert_Output) external;

xf:RadicarSolicitudResponseId($serviceRequestWS_ServiceRequestInsert_Output1)
