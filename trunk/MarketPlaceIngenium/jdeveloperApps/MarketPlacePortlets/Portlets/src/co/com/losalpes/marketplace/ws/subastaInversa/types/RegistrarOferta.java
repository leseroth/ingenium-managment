
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistrarOferta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistrarOferta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oferta" type="{http://marketplace.losalpes.com.co}Oferta"/>
 *         &lt;element name="numSeguimientoSub" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrarOferta", propOrder = {
    "oferta",
    "numSeguimientoSub"
})
public class RegistrarOferta {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Oferta oferta;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String numSeguimientoSub;

    /**
     * Gets the value of the oferta property.
     * 
     * @return
     *     possible object is
     *     {@link Oferta }
     *     
     */
    public Oferta getOferta() {
        return oferta;
    }

    /**
     * Sets the value of the oferta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Oferta }
     *     
     */
    public void setOferta(Oferta value) {
        this.oferta = value;
    }

    /**
     * Gets the value of the numSeguimientoSub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimientoSub() {
        return numSeguimientoSub;
    }

    /**
     * Sets the value of the numSeguimientoSub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimientoSub(String value) {
        this.numSeguimientoSub = value;
    }

}
