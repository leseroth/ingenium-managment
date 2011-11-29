
package co.com.losalpes.marketplace.ws.replicacionPricat.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarCuentaFacturacionClienteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarCuentaFacturacionClienteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuenta" type="{http://marketplace.losalpes.com.co}CuentaFacturacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarCuentaFacturacionClienteResponse", propOrder = {
    "cuenta"
})
public class ConsultarCuentaFacturacionClienteResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected CuentaFacturacion cuenta;

    /**
     * Gets the value of the cuenta property.
     * 
     * @return
     *     possible object is
     *     {@link CuentaFacturacion }
     *     
     */
    public CuentaFacturacion getCuenta() {
        return cuenta;
    }

    /**
     * Sets the value of the cuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaFacturacion }
     *     
     */
    public void setCuenta(CuentaFacturacion value) {
        this.cuenta = value;
    }

}
