
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarDAsFabricanteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarDAsFabricanteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="das" type="{http://marketplace.losalpes.com.co}DispatchAdvice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarDAsFabricanteResponse", propOrder = {
    "das"
})
public class ConsultarDAsFabricanteResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected List<DispatchAdvice> das;

    /**
     * Gets the value of the das property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the das property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DispatchAdvice }
     * 
     * 
     */
    public List<DispatchAdvice> getDas() {
        if (das == null) {
            das = new ArrayList<DispatchAdvice>();
        }
        return this.das;
    }

}
