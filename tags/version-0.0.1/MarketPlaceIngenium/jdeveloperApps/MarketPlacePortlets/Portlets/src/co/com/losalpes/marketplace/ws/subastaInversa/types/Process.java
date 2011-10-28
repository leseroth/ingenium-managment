
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="fechaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="numSeguimientoSubasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valorProducto" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "fechaEntrega",
    "numSeguimientoSubasta",
    "nitFabricante",
    "valorProducto"
})
@XmlRootElement(name = "process", namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa")
public class Process {

    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEntrega;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String numSeguimientoSubasta;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String nitFabricante;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa")
    protected long valorProducto;

    /**
     * Gets the value of the fechaEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets the value of the fechaEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEntrega(XMLGregorianCalendar value) {
        this.fechaEntrega = value;
    }

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
     * Gets the value of the nitFabricante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitFabricante() {
        return nitFabricante;
    }

    /**
     * Sets the value of the nitFabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitFabricante(String value) {
        this.nitFabricante = value;
    }

    /**
     * Gets the value of the valorProducto property.
     * 
     */
    public long getValorProducto() {
        return valorProducto;
    }

    /**
     * Sets the value of the valorProducto property.
     * 
     */
    public void setValorProducto(long value) {
        this.valorProducto = value;
    }

}
