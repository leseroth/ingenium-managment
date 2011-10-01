
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarSubastaOrdenCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarSubastaOrdenCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimientoPO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarSubastaOrdenCompra", propOrder = {
    "numSeguimientoPO"
})
public class ConsultarSubastaOrdenCompra {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String numSeguimientoPO;

    /**
     * Gets the value of the numSeguimientoPO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimientoPO() {
        return numSeguimientoPO;
    }

    /**
     * Sets the value of the numSeguimientoPO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimientoPO(String value) {
        this.numSeguimientoPO = value;
    }

}
