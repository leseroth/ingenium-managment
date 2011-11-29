
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsultarClientesProducto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarClientesProducto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarClientesProducto", propOrder = {
    "nombreProducto",
    "tipoCliente",
    "tipoCategoria"
})
public class ConsultarClientesProducto {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String nombreProducto;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String tipoCliente;
    @XmlElement(namespace = "http://marketplace.losalpes.com.co", required = true)
    protected String tipoCategoria;

    /**
     * Gets the value of the nombreProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Sets the value of the nombreProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    /**
     * Gets the value of the tipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Sets the value of the tipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCliente(String value) {
        this.tipoCliente = value;
    }

    /**
     * Gets the value of the tipoCategoria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCategoria() {
        return tipoCategoria;
    }

    /**
     * Sets the value of the tipoCategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCategoria(String value) {
        this.tipoCategoria = value;
    }

}
