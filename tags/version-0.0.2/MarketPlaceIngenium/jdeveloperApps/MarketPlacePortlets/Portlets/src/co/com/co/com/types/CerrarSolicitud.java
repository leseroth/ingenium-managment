
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CerrarSolicitud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CerrarSolicitud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numRadicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CerrarSolicitud", propOrder = {
    "numRadicacion",
    "estadoSolicitud",
    "causa",
    "estadoCliente",
    "estadoProducto"
})
public class CerrarSolicitud {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String numRadicacion;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoSolicitud;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String causa;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoCliente;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String estadoProducto;

    /**
     * Gets the value of the numRadicacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRadicacion() {
        return numRadicacion;
    }

    /**
     * Sets the value of the numRadicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRadicacion(String value) {
        this.numRadicacion = value;
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
