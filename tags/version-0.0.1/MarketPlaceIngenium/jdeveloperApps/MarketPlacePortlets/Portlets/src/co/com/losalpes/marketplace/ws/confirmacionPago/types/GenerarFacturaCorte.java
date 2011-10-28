
package co.com.losalpes.marketplace.ws.confirmacionPago.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenerarFacturaCorte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenerarFacturaCorte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="corte" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="plazo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenerarFacturaCorte", propOrder = {
    "corte",
    "plazo"
})
public class GenerarFacturaCorte {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected Integer corte;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected int plazo;

    /**
     * Gets the value of the corte property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorte() {
        return corte;
    }

    /**
     * Sets the value of the corte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorte(Integer value) {
        this.corte = value;
    }

    /**
     * Gets the value of the plazo property.
     * 
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * Sets the value of the plazo property.
     * 
     */
    public void setPlazo(int value) {
        this.plazo = value;
    }

}
