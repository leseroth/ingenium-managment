
package co.com.losalpes.marketplace.ws.confirmacionPago.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numCuenta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numCuenta",
    "valor",
    "descripcion",
    "referencia"
})
@XmlRootElement(name = "process", namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/ConfirmacionPago")
public class Process {

    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/ConfirmacionPago", required = true)
    protected String numCuenta;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/ConfirmacionPago")
    protected long valor;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/ConfirmacionPago", required = true)
    protected String descripcion;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoFacturacion/ConfirmacionPago", required = true)
    protected String referencia;

    /**
     * Gets the value of the numCuenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Sets the value of the numCuenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuenta(String value) {
        this.numCuenta = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     */
    public long getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     */
    public void setValor(long value) {
        this.valor = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the referencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Sets the value of the referencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

}
