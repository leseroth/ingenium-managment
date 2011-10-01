
package co.com.losalpes.marketplace.ws.avisoDespacho.types;

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
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaLlegada" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="montoOperacion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="camiones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cantidadProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoriaProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referenciaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSeguimientoPO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "fechaEmision",
    "fechaLlegada",
    "montoOperacion",
    "camiones",
    "cantidadProducto",
    "nombreProducto",
    "categoriaProducto",
    "referenciaProducto",
    "numSeguimientoPO",
    "nombreFabricante",
    "nitFabricante",
    "emailFabricante"
})
@XmlRootElement(name = "process")
public class Process {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLlegada;
    protected long montoOperacion;
    @XmlElement(required = true)
    protected String camiones;
    protected int cantidadProducto;
    @XmlElement(required = true)
    protected String nombreProducto;
    @XmlElement(required = true)
    protected String categoriaProducto;
    protected String referenciaProducto;
    @XmlElement(required = true)
    protected String numSeguimientoPO;
    @XmlElement(required = true)
    protected String nombreFabricante;
    @XmlElement(required = true)
    protected String nitFabricante;
    @XmlElement(required = true)
    protected String emailFabricante;

    /**
     * Gets the value of the fechaEmision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets the value of the fechaEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Gets the value of the fechaLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Sets the value of the fechaLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaLlegada(XMLGregorianCalendar value) {
        this.fechaLlegada = value;
    }

    /**
     * Gets the value of the montoOperacion property.
     * 
     */
    public long getMontoOperacion() {
        return montoOperacion;
    }

    /**
     * Sets the value of the montoOperacion property.
     * 
     */
    public void setMontoOperacion(long value) {
        this.montoOperacion = value;
    }

    /**
     * Gets the value of the camiones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamiones() {
        return camiones;
    }

    /**
     * Sets the value of the camiones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamiones(String value) {
        this.camiones = value;
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
     * Gets the value of the referenciaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    /**
     * Sets the value of the referenciaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaProducto(String value) {
        this.referenciaProducto = value;
    }

    /**
     * Gets the value of the numSeguimientoPO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimientoPO() {
        return numSeguimientoPO;
    }

    /**
     * Sets the value of the numSeguimientoPO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimientoPO(String value) {
        this.numSeguimientoPO = value;
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

}
