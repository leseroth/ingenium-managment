
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarRMAsFabricante complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarRMAsFabricante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarRMAsFabricante", propOrder = {
    "nitFabricante"
})
public class ConsultarRMAsFabricante {

    @XmlElement(required = true)
    protected String nitFabricante;

    /**
     * Gets the value of the nitFabricante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitFabricante() {
        return nitFabricante;
    }

    /**
     * Sets the value of the nitFabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitFabricante(String value) {
        this.nitFabricante = value;
    }

}
