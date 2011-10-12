
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarPOResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarPOResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.pomanager.marketplace.losalpes.com.co/}purchaseOrderBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarPOResponse", propOrder = {
    "_return"
})
public class ConsultarPOResponse {

    @XmlElement(name = "return")
    protected PurchaseOrderBO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public PurchaseOrderBO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public void setReturn(PurchaseOrderBO value) {
        this._return = value;
    }

}
