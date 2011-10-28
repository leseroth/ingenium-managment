
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registrarPO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registrarPO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchaseOrderBO" type="{http://ws.pomanager.marketplace.losalpes.com.co/}purchaseOrderBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarPO", propOrder = {
    "purchaseOrderBO"
})
public class RegistrarPO {

    protected PurchaseOrderBO purchaseOrderBO;

    /**
     * Gets the value of the purchaseOrderBO property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public PurchaseOrderBO getPurchaseOrderBO() {
        return purchaseOrderBO;
    }

    /**
     * Sets the value of the purchaseOrderBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public void setPurchaseOrderBO(PurchaseOrderBO value) {
        this.purchaseOrderBO = value;
    }

}
