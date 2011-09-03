
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
    "po"
})
public class CrearSubasta {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected PurchaseOrder po;

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

}
