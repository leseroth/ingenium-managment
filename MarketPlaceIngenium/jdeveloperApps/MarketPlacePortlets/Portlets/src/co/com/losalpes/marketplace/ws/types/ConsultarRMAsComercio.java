
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarRMAsComercio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarRMAsComercio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nitComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarRMAsComercio", propOrder = {
    "nitComercio"
})
public class ConsultarRMAsComercio {

    @XmlElement(required = true)
    protected String nitComercio;

    /**
     * Gets the value of the nitComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitComercio() {
        return nitComercio;
    }

    /**
     * Sets the value of the nitComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitComercio(String value) {
        this.nitComercio = value;
    }

}
