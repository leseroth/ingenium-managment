
package co.com.losalpes.marketplace.ws.replicacionPricat.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarCuentaFacturacionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarCuentaFacturacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuentaFacturacion" type="{http://marketplace.losalpes.com.co}CuentaFacturacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarCuentaFacturacionResponse", propOrder = {
    "cuentaFacturacion"
})
public class ConsultarCuentaFacturacionResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected CuentaFacturacion cuentaFacturacion;

    /**
     * Gets the value of the cuentaFacturacion property.
     * 
     * @return
     *     possible object is
     *     {@link CuentaFacturacion }
     *     
     */
    public CuentaFacturacion getCuentaFacturacion() {
        return cuentaFacturacion;
    }

    /**
     * Sets the value of the cuentaFacturacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaFacturacion }
     *     
     */
    public void setCuentaFacturacion(CuentaFacturacion value) {
        this.cuentaFacturacion = value;
    }

}
