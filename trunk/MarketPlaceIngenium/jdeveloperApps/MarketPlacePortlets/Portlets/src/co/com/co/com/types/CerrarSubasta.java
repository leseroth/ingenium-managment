
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cerrarSubasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cerrarSubasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSubasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cerrarSubasta", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "idSubasta"
})
public class CerrarSubasta {

    protected String idSubasta;

    /**
     * Gets the value of the idSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSubasta() {
        return idSubasta;
    }

    /**
     * Sets the value of the idSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSubasta(String value) {
        this.idSubasta = value;
    }

}
