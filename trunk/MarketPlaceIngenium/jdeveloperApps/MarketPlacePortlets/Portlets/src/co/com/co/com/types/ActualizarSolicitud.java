
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualizarSolicitud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualizarSolicitud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="solicitud" type="{http://marketplace.losalpes.com.co}SolicitudRegistro"/>
 *         &lt;element name="estadoSolicitud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="causa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualizarSolicitud", propOrder = {
    "solicitud",
    "estadoSolicitud",
    "causa",
    "estadoCliente",
    "estadoProducto"
})
public class ActualizarSolicitud {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected SolicitudRegistro solicitud;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoSolicitud;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String causa;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoCliente;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoProducto;

    /**
     * Gets the value of the solicitud property.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudRegistro }
     *     
     */
    public SolicitudRegistro getSolicitud() {
        return solicitud;
    }

    /**
     * Sets the value of the solicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudRegistro }
     *     
     */
    public void setSolicitud(SolicitudRegistro value) {
        this.solicitud = value;
    }

    /**
     * Gets the value of the estadoSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * Sets the value of the estadoSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSolicitud(String value) {
        this.estadoSolicitud = value;
    }

    /**
     * Gets the value of the causa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausa() {
        return causa;
    }

    /**
     * Sets the value of the causa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausa(String value) {
        this.causa = value;
    }

    /**
     * Gets the value of the estadoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * Sets the value of the estadoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCliente(String value) {
        this.estadoCliente = value;
    }

    /**
     * Gets the value of the estadoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoProducto() {
        return estadoProducto;
    }

    /**
     * Sets the value of the estadoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoProducto(String value) {
        this.estadoProducto = value;
    }

}
