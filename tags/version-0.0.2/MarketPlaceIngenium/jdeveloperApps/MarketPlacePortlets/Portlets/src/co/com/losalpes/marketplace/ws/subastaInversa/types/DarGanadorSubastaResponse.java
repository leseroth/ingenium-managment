
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DarGanadorSubastaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DarGanadorSubastaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fabricante" type="{http://marketplace.losalpes.com.co}Fabricante"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DarGanadorSubastaResponse", propOrder = {
    "fabricante"
})
public class DarGanadorSubastaResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Fabricante fabricante;

    /**
     * Gets the value of the fabricante property.
     * 
     * @return
     *     possible object is
     *     {@link Fabricante }
     *     
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * Sets the value of the fabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fabricante }
     *     
     */
    public void setFabricante(Fabricante value) {
        this.fabricante = value;
    }

}
