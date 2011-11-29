
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registrarOferta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registrarOferta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimientoSubasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oferta" type="{http://ws.transact.marketplace.losalpes.com.co/}ofertaBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarOferta", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "numSeguimientoSubasta",
    "oferta"
})
public class RegistrarOferta {

    protected String numSeguimientoSubasta;
    protected OfertaBO oferta;

    /**
     * Gets the value of the numSeguimientoSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimientoSubasta() {
        return numSeguimientoSubasta;
    }

    /**
     * Sets the value of the numSeguimientoSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimientoSubasta(String value) {
        this.numSeguimientoSubasta = value;
    }

    /**
     * Gets the value of the oferta property.
     * 
     * @return
     *     possible object is
     *     {@link OfertaBO }
     *     
     */
    public OfertaBO getOferta() {
        return oferta;
    }

    /**
     * Sets the value of the oferta property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaBO }
     *     
     */
    public void setOferta(OfertaBO value) {
        this.oferta = value;
    }

}
