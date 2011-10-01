
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
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="numSeguimientoSubasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cantidadProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valorProducto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoriaProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "fecha",
    "fechaEntrega",
    "numSeguimientoSubasta",
    "nitFabricante",
    "nombreFabricante",
    "emailFabricante",
    "cantidadProducto",
    "valorProducto",
    "nombreProducto",
    "categoriaProducto"
})
@XmlRootElement(name = "process", namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa")
public class Process {

    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEntrega;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String numSeguimientoSubasta;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String nitFabricante;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String nombreFabricante;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String emailFabricante;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa")
    protected int cantidadProducto;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa")
    protected long valorProducto;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String nombreProducto;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoSubastaInversa/SubastaInversa", required = true)
    protected String categoriaProducto;

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

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
     * Gets the value of the nombreFabricante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFabricante() {
        return nombreFabricante;
    }

    /**
     * Sets the value of the nombreFabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFabricante(String value) {
        this.nombreFabricante = value;
    }

    /**
     * Gets the value of the emailFabricante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailFabricante() {
        return emailFabricante;
    }

    /**
     * Sets the value of the emailFabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailFabricante(String value) {
        this.emailFabricante = value;
    }

    /**
     * Gets the value of the cantidadProducto property.
     * 
     */
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     * Sets the value of the cantidadProducto property.
     * 
     */
    public void setCantidadProducto(int value) {
        this.cantidadProducto = value;
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
     * Gets the value of the categoriaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    /**
     * Sets the value of the categoriaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoriaProducto(String value) {
        this.categoriaProducto = value;
    }

}
