
package co.com.losalpes.marketplace.ws.ordenCompraDirecta.types;

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
 *         &lt;element name="fechaMaximaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaMaximaSubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="nitComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direccionComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefonoComercio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cantidadProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoriaProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="precioProducto" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "fechaMaximaEntrega",
    "fechaMaximaSubasta",
    "fecha",
    "nitComercio",
    "nitFabricante",
    "nombreComercio",
    "emailComercio",
    "direccionComercio",
    "telefonoComercio",
    "cantidadProducto",
    "nombreProducto",
    "categoriaProducto",
    "precioProducto"
})
@XmlRootElement(name = "process")
public class Process {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMaximaEntrega;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMaximaSubasta;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(required = true)
    protected String nitComercio;
    @XmlElement(required = true)
    protected String nitFabricante;
    @XmlElement(required = true)
    protected String nombreComercio;
    @XmlElement(required = true)
    protected String emailComercio;
    @XmlElement(required = true)
    protected String direccionComercio;
    @XmlElement(required = true)
    protected String telefonoComercio;
    protected int cantidadProducto;
    @XmlElement(required = true)
    protected String nombreProducto;
    @XmlElement(required = true)
    protected String categoriaProducto;
    protected long precioProducto;

    /**
     * Gets the value of the fechaMaximaEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMaximaEntrega() {
        return fechaMaximaEntrega;
    }

    /**
     * Sets the value of the fechaMaximaEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMaximaEntrega(XMLGregorianCalendar value) {
        this.fechaMaximaEntrega = value;
    }

    /**
     * Gets the value of the fechaMaximaSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMaximaSubasta() {
        return fechaMaximaSubasta;
    }

    /**
     * Sets the value of the fechaMaximaSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMaximaSubasta(XMLGregorianCalendar value) {
        this.fechaMaximaSubasta = value;
    }

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
     * Gets the value of the nitComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitComercio() {
        return nitComercio;
    }

    /**
     * Sets the value of the nitComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitComercio(String value) {
        this.nitComercio = value;
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
     * Gets the value of the nombreComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreComercio() {
        return nombreComercio;
    }

    /**
     * Sets the value of the nombreComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreComercio(String value) {
        this.nombreComercio = value;
    }

    /**
     * Gets the value of the emailComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailComercio() {
        return emailComercio;
    }

    /**
     * Sets the value of the emailComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailComercio(String value) {
        this.emailComercio = value;
    }

    /**
     * Gets the value of the direccionComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionComercio() {
        return direccionComercio;
    }

    /**
     * Sets the value of the direccionComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionComercio(String value) {
        this.direccionComercio = value;
    }

    /**
     * Gets the value of the telefonoComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoComercio() {
        return telefonoComercio;
    }

    /**
     * Sets the value of the telefonoComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoComercio(String value) {
        this.telefonoComercio = value;
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

    /**
     * Gets the value of the precioProducto property.
     * 
     */
    public long getPrecioProducto() {
        return precioProducto;
    }

    /**
     * Sets the value of the precioProducto property.
     * 
     */
    public void setPrecioProducto(long value) {
        this.precioProducto = value;
    }

}
