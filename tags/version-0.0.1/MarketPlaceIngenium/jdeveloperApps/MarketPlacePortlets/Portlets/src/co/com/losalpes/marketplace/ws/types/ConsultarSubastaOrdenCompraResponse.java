
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarSubastaOrdenCompraResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarSubastaOrdenCompraResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subasta" type="{http://marketplace.losalpes.com.co}Subasta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarSubastaOrdenCompraResponse", propOrder = {
    "subasta"
})
public class ConsultarSubastaOrdenCompraResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Subasta subasta;

    /**
     * Gets the value of the subasta property.
     * 
     * @return
     *     possible object is
     *     {@link Subasta }
     *     
     */
    public Subasta getSubasta() {
        return subasta;
    }

    /**
     * Sets the value of the subasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subasta }
     *     
     */
    public void setSubasta(Subasta value) {
        this.subasta = value;
    }

}
