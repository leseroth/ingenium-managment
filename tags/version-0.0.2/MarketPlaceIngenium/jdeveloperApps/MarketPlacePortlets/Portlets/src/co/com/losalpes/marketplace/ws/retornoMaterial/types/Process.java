
package co.com.losalpes.marketplace.ws.retornoMaterial.types;

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
 *         &lt;element name="causa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="cantidadProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valorProducto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoriaProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referenciaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSeguimientoPO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numSeguimientoDA" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "causa",
    "fecha",
    "cantidadProducto",
    "valorProducto",
    "nombreProducto",
    "categoriaProducto",
    "referenciaProducto",
    "numSeguimientoPO",
    "numSeguimientoDA"
})
@XmlRootElement(name = "process")
public class Process {

    @XmlElement(required = true)
    protected String causa;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    protected int cantidadProducto;
    protected long valorProducto;
    @XmlElement(required = true)
    protected String nombreProducto;
    @XmlElement(required = true)
    protected String categoriaProducto;
    protected String referenciaProducto;
    @XmlElement(required = true)
    protected String numSeguimientoPO;
    @XmlElement(required = true)
    protected String numSeguimientoDA;

    /**
     * Gets the value of the causa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausa() {
        return causa;
    }

    /**
     * Sets the value of the causa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausa(String value) {
        this.causa = value;
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
     * Gets the value of the numSeguimientoDA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimientoDA() {
        return numSeguimientoDA;
    }

    /**
     * Sets the value of the numSeguimientoDA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimientoDA(String value) {
        this.numSeguimientoDA = value;
    }

}
