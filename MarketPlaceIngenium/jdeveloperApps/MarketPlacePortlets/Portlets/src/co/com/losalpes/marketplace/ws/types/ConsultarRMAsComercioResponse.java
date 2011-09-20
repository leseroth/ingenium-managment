
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarRMAsComercioResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarRMAsComercioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rmas" type="{http://marketplace.losalpes.com.co}ReturnMaterialAdvice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarRMAsComercioResponse", propOrder = {
    "rmas"
})
public class ConsultarRMAsComercioResponse {

    protected List<ReturnMaterialAdvice> rmas;

    /**
     * Gets the value of the rmas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRmas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnMaterialAdvice }
     * 
     * 
     */
    public List<ReturnMaterialAdvice> getRmas() {
        if (rmas == null) {
            rmas = new ArrayList<ReturnMaterialAdvice>();
        }
        return this.rmas;
    }

}