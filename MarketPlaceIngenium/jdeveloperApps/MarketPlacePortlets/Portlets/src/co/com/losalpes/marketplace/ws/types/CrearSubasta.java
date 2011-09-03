
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for crearSubasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="crearSubasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="po" type="{http://ws.transact.marketplace.losalpes.com.co/}purchaseOrderBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearSubasta", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "po"
})
public class CrearSubasta {

    protected PurchaseOrderBO po;

    /**
     * Gets the value of the po property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public PurchaseOrderBO getPo() {
        return po;
    }

    /**
     * Sets the value of the po property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public void setPo(PurchaseOrderBO value) {
        this.po = value;
    }

}
