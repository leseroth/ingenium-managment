/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package policewebservice;

import java.io.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.tempuri.PoliceService;
import org.xml.sax.InputSource;

/**
 *
 * @author admin
 */
public class NotifyWS {

    /**
     * Notifica a través de un servicio WEB al sisitema de la policia
     * @param homeId
     * @param eventType
     * @param time
     * @param contactName
     * @param contactPhone
     * @param address
     * @param city
     * @return respuesta del sisitema de la policia para que sea procesada
     * @throws UnReportedException Se envia una excepción si no fue posible realizar la notificación
     */
    public static String Notify(String homeId, String eventType, String time, String contactName, String contactPhone, String address, String city) throws UnReportedException {
        try {

            //Preparar Mensaje
            String message = CreateNotification(homeId, eventType, time, contactName, contactPhone, address, city);

            //llamar Servicio
            PoliceService policeService = new PoliceService();
            String xmlResponse = policeService.getPoliceServiceSoap().notifyEvent(message);

            //Capturar Respuesta
            String response = ProcessResponse(xmlResponse);

            return response;

        } catch (Exception e) {
            throw new UnReportedException();
        }


    }

    /**
     * procesa el XML de respuesta del sistema de emergencia
     * @param xmlResponse
     * @return
     */
    public static String ProcessResponse(String xmlResponse) {
        try {

            //crea el documento y parse el string recibido
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlResponse));

            Document doc = db.parse(is);

            //forma la respuesta que envio el sisitema de emergencia
            StringBuilder response = new StringBuilder();

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("homeid");

            for (int index = 0; index < nodeList.getLength(); index++) {
                Node node = nodeList.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    response.append(element.getFirstChild().getNodeValue());
                }
            }

            NodeList nodeList1 = doc.getElementsByTagName("eventtype");

            for (int index = 0; index < nodeList1.getLength(); index++) {
                Node node = nodeList1.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    response.append(element.getFirstChild().getNodeValue());
                }
            }

            NodeList nodeList2 = doc.getElementsByTagName("message");

            for (int index = 0; index < nodeList2.getLength(); index++) {
                Node node = nodeList2.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    response.append(element.getFirstChild().getNodeValue());
                }
            }

            return response.toString();

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Crear el XML para invocar el servicio del sisitema de emergencia
     * @param homeId
     * @param eventType
     * @param time
     * @param contactName
     * @param contactPhone
     * @param address
     * @param city
     * @return retorna una cadena que contienen el documento XML formado con los parametros de ingreso para la notificación
     */
    public static String CreateNotification(String homeId, String eventType, String time, String contactName, String contactPhone, String address, String city) {

        try {
            //Crear XML vacio

            //Document
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            //Crear Arbol

            //Root
            Element root = doc.createElement("notification");
            doc.appendChild(root);

            //Añadir hijo
            Element e1 = doc.createElement("homeid");
            root.appendChild(e1);
            //texto de hijo
            Text t1 = doc.createTextNode(homeId);
            e1.appendChild(t1);

            //Añadir hijo
            Element e2 = doc.createElement("eventtype");
            root.appendChild(e2);
            //texto de hijo
            Text t2 = doc.createTextNode(eventType);
            e2.appendChild(t2);

            //Añadir hijo
            Element e3 = doc.createElement("time");
            root.appendChild(e3);
            //texto de hijo
            Text t3 = doc.createTextNode(time);
            e3.appendChild(t3);

            //Añadir hijo
            Element e4 = doc.createElement("contactname");
            root.appendChild(e4);
            //texto de hijo
            Text t4 = doc.createTextNode(contactName);
            e4.appendChild(t4);

            //Añadir hijo
            Element e5 = doc.createElement("contactphone");
            root.appendChild(e5);
            //texto de hijo
            Text t5 = doc.createTextNode(contactPhone);
            e5.appendChild(t5);

            //Añadir hijo
            Element e6 = doc.createElement("address");
            root.appendChild(e6);
            //texto de hijo
            Text t6 = doc.createTextNode(address);
            e6.appendChild(t6);

            //Añadir hijo
            Element e7 = doc.createElement("city");
            root.appendChild(e7);
            //texto de hijo
            Text t7 = doc.createTextNode(city);
            e7.appendChild(t7);

            /////////////////
            //Resultado XML

            //Establecer transformador
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            //String desde el arbol XML
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();


            //System.out.println(xmlString);
            return xmlString;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
