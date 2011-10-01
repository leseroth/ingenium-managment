
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarComercioPOResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarComercioPOResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comercio" type="{http://marketplace.losalpes.com.co}Comercio" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarComercioPOResponse", propOrder = {
    "comercio"
})
public class ConsultarComercioPOResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected Comercio comercio;

    /**
     * Gets the value of the comercio property.
     * 
     * @return
     *     possible object is
     *     {@link Comercio }
     *     
     */
    public Comercio getComercio() {
        return comercio;
    }

    /**
     * Sets the value of the comercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comercio }
     *     
     */
    public void setComercio(Comercio value) {
        this.comercio = value;
    }

}
