
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PurchaseOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="item" type="{http://marketplace.losalpes.com.co}Item"/>
 *         &lt;element name="fechaMaxima" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tiempoSubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="comercio" type="{http://marketplace.losalpes.com.co}Comercio"/>
 *         &lt;element name="fabricanteAtiende" type="{http://marketplace.losalpes.com.co}Fabricante" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseOrder", propOrder = {
    "id",
    "numSeguimiento",
    "item",
    "fechaMaxima",
    "tiempoSubasta",
    "comercio",
    "fabricanteAtiende",
    "estado",
    "fecha"
})
public class PurchaseOrder {

    protected Long id;
    protected String numSeguimiento;
    @XmlElement(required = true)
    protected Item item;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaMaxima;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tiempoSubasta;
    @XmlElement(required = true)
    protected Comercio comercio;
    protected Fabricante fabricanteAtiende;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the numSeguimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    /**
     * Sets the value of the numSeguimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSeguimiento(String value) {
        this.numSeguimiento = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItem(Item value) {
        this.item = value;
    }

    /**
     * Gets the value of the fechaMaxima property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaMaxima() {
        return fechaMaxima;
    }

    /**
     * Sets the value of the fechaMaxima property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaMaxima(XMLGregorianCalendar value) {
        this.fechaMaxima = value;
    }

    /**
     * Gets the value of the tiempoSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTiempoSubasta() {
        return tiempoSubasta;
    }

    /**
     * Sets the value of the tiempoSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTiempoSubasta(XMLGregorianCalendar value) {
        this.tiempoSubasta = value;
    }

    /**
     * Gets the value of the comercio property.
     * 
     * @return
     *     possible object is
     *     {@link Comercio }
     *     
     */
    public Comercio getComercio() {
        return comercio;
    }

    /**
     * Sets the value of the comercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comercio }
     *     
     */
    public void setComercio(Comercio value) {
        this.comercio = value;
    }

    /**
     * Gets the value of the fabricanteAtiende property.
     * 
     * @return
     *     possible object is
     *     {@link Fabricante }
     *     
     */
    public Fabricante getFabricanteAtiende() {
        return fabricanteAtiende;
    }

    /**
     * Sets the value of the fabricanteAtiende property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fabricante }
     *     
     */
    public void setFabricanteAtiende(Fabricante value) {
        this.fabricanteAtiende = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
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

}
