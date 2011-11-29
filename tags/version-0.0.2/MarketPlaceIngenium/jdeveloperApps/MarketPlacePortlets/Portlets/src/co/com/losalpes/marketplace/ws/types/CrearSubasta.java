
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CrearSubasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CrearSubasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="po" type="{http://marketplace.losalpes.com.co}PurchaseOrder"/>
 *         &lt;element name="fechaMaxSubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrearSubasta", propOrder = {
    "po",
    "fechaMaxSubasta"
})
public class CrearSubasta {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected PurchaseOrder po;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMaxSubasta;

    /**
     * Gets the value of the po property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrder }
     *     
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * Sets the value of the po property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrder }
     *     
     */
    public void setPo(PurchaseOrder value) {
        this.po = value;
    }

    /**
     * Gets the value of the fechaMaxSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMaxSubasta() {
        return fechaMaxSubasta;
    }

    /**
     * Sets the value of the fechaMaxSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMaxSubasta(XMLGregorianCalendar value) {
        this.fechaMaxSubasta = value;
    }

}
