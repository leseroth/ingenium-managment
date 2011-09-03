(:: pragma bea:global-element-parameter parameter="$serviceRequestWS_ServiceRequestQueryPage_Output1" element="ns0:ServiceRequestWS_ServiceRequestQueryPage_Output" location="../../../business/wsdls/crmOnDemand/ServiceRequest.wsdl" ::)

declare namespace ns1 = "urn:/crmondemand/xml/servicerequest";
declare namespace ns0 = "urn:crmondemand/ws/servicerequest/10/2004";
declare namespace xf = "http://tempuri.org/marketPlace/proxy/transformaciones/gestionSolicitud/ConsultarIdCuenta/";

declare function xf:ConsultarIdCuenta($serviceRequestWS_ServiceRequestQueryPage_Output1 as element(ns0:ServiceRequestWS_ServiceRequestQueryPage_Output))
    as xs:string {
        data($serviceRequestWS_ServiceRequestQueryPage_Output1/ns1:ListOfServiceRequest/ns1:ServiceRequest[1]/ns1:AccountId)
};

declare variable $serviceRequestWS_ServiceRequestQueryPage_Output1 as element(ns0:ServiceRequestWS_ServiceRequestQueryPage_Output) external;

xf:ConsultarIdCuenta($serviceRequestWS_ServiceRequestQueryPage_Output1)
