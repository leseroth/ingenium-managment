
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for asignarFabricantesSubasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="asignarFabricantesSubasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimientoSubasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fabricantes" type="{http://ws.transact.marketplace.losalpes.com.co/}fabricanteBO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asignarFabricantesSubasta", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "numSeguimientoSubasta",
    "fabricantes"
})
public class AsignarFabricantesSubasta {

    protected String numSeguimientoSubasta;
    protected List<FabricanteBO> fabricantes;

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
     * {@link FabricanteBO }
     * 
     * 
     */
    public List<FabricanteBO> getFabricantes() {
        if (fabricantes == null) {
            fabricantes = new ArrayList<FabricanteBO>();
        }
        return this.fabricantes;
    }

}
