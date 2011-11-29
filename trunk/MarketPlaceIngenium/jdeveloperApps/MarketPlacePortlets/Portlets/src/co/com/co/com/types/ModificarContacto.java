
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModificarContacto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModificarContacto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contactos" type="{http://marketplace.losalpes.com.co}Contacto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificarContacto", propOrder = {
    "contactos"
})
public class ModificarContacto {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Contacto contactos;

    /**
     * Gets the value of the contactos property.
     * 
     * @return
     *     possible object is
     *     {@link Contacto }
     *     
     */
    public Contacto getContactos() {
        return contactos;
    }

    /**
     * Sets the value of the contactos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacto }
     *     
     */
    public void setContactos(Contacto value) {
        this.contactos = value;
    }

}
