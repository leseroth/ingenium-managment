
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AsignarFabricantesSubasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AsignarFabricantesSubasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimientoSubasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fabricantes" type="{http://marketplace.losalpes.com.co}Fabricante" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AsignarFabricantesSubasta", propOrder = {
    "numSeguimientoSubasta",
    "fabricantes"
})
public class AsignarFabricantesSubasta {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String numSeguimientoSubasta;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected List<Fabricante> fabricantes;

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
     * Gets the value of the fabricantes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fabricantes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFabricantes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fabricante }
     * 
     * 
     */
    public List<Fabricante> getFabricantes() {
        if (fabricantes == null) {
            fabricantes = new ArrayList<Fabricante>();
        }
        return this.fabricantes;
    }

}
