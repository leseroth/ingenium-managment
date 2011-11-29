
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarContactoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarContactoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contacto" type="{http://marketplace.losalpes.com.co}Contacto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarContactoResponse", propOrder = {
    "contacto"
})
public class ConsultarContactoResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Contacto contacto;

    /**
     * Gets the value of the contacto property.
     * 
     * @return
     *     possible object is
     *     {@link Contacto }
     *     
     */
    public Contacto getContacto() {
        return contacto;
    }

    /**
     * Sets the value of the contacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacto }
     *     
     */
    public void setContacto(Contacto value) {
        this.contacto = value;
    }

}
