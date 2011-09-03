
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistrarRMA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistrarRMA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rma" type="{http://marketplace.losalpes.com.co}ReturnMaterialAdvice"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrarRMA", propOrder = {
    "rma"
})
public class RegistrarRMA {

    @XmlElement(required = true)
    protected ReturnMaterialAdvice rma;

    /**
     * Gets the value of the rma property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnMaterialAdvice }
     *     
     */
    public ReturnMaterialAdvice getRma() {
        return rma;
    }

    /**
     * Sets the value of the rma property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnMaterialAdvice }
     *     
     */
    public void setRma(ReturnMaterialAdvice value) {
        this.rma = value;
    }

}
