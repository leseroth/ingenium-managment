
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="fechaMax" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "po",
    "fechaMax"
})
public class CrearSubasta {

    protected PurchaseOrderBO po;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMax;

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

    /**
     * Gets the value of the fechaMax property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMax() {
        return fechaMax;
    }

    /**
     * Sets the value of the fechaMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMax(XMLGregorianCalendar value) {
        this.fechaMax = value;
    }

}
