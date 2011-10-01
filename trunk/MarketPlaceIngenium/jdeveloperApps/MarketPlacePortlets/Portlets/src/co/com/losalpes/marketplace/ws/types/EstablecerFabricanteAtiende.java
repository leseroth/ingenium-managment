
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstablecerFabricanteAtiende complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstablecerFabricanteAtiende">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fabricante" type="{http://marketplace.losalpes.com.co}Fabricante"/>
 *         &lt;element name="items" type="{http://marketplace.losalpes.com.co}Item" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstablecerFabricanteAtiende", propOrder = {
    "numSeguimiento",
    "fabricante",
    "items"
})
public class EstablecerFabricanteAtiende {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String numSeguimiento;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected Fabricante fabricante;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected Item items;

    /**
     * Gets the value of the numSeguimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * Sets the value of the numSeguimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimiento(String value) {
        this.numSeguimiento = value;
    }

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

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItems(Item value) {
        this.items = value;
    }

}
