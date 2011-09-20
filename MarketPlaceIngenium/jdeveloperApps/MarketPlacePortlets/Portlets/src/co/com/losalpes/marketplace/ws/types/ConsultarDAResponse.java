
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarDAResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarDAResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="da" type="{http://marketplace.losalpes.com.co}DispatchAdvice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarDAResponse", propOrder = {
    "da"
})
public class ConsultarDAResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected DispatchAdvice da;

    /**
     * Gets the value of the da property.
     * 
     * @return
     *     possible object is
     *     {@link DispatchAdvice }
     *     
     */
    public DispatchAdvice getDa() {
        return da;
    }

    /**
     * Sets the value of the da property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispatchAdvice }
     *     
     */
    public void setDa(DispatchAdvice value) {
        this.da = value;
    }

}