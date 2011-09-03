
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registrarContrato complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registrarContrato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contratoBO" type="{http://ws.contractmanager.marketplace.losalpes.com.co/}contratoBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarContrato", propOrder = {
    "contratoBO"
})
public class RegistrarContrato {

    protected ContratoBO contratoBO;

    /**
     * Gets the value of the contratoBO property.
     * 
     * @return
     *     possible object is
     *     {@link ContratoBO }
     *     
     */
    public ContratoBO getContratoBO() {
        return contratoBO;
    }

    /**
     * Sets the value of the contratoBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratoBO }
     *     
     */
    public void setContratoBO(ContratoBO value) {
        this.contratoBO = value;
    }

}
