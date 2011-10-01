
package co.com.losalpes.marketplace.ws.confirmacionPago.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportarClientesMorosos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportarClientesMorosos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="corte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportarClientesMorosos", propOrder = {
    "corte"
})
public class ReportarClientesMorosos {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected int corte;

    /**
     * Gets the value of the corte property.
     * 
     */
    public int getCorte() {
        return corte;
    }

    /**
     * Sets the value of the corte property.
     * 
     */
    public void setCorte(int value) {
        this.corte = value;
    }

}
