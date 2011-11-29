
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReturnMaterialAdvice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnMaterialAdvice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="causa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="avisoDespacho" type="{http://marketplace.losalpes.com.co}DispatchAdvice"/>
 *         &lt;element name="ordenCompra" type="{http://marketplace.losalpes.com.co}PurchaseOrder"/>
 *         &lt;element name="items" type="{http://marketplace.losalpes.com.co}Item"/>
 *         &lt;element name="comercio" type="{http://marketplace.losalpes.com.co}Comercio"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnMaterialAdvice", propOrder = {
    "id",
    "numSeguimiento",
    "causa",
    "fecha",
    "avisoDespacho",
    "ordenCompra",
    "items",
    "comercio"
})
public class ReturnMaterialAdvice {

    protected Long id;
    protected String numSeguimiento;
    @XmlElement(required = true)
    protected String causa;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(required = true)
    protected DispatchAdvice avisoDespacho;
    @XmlElement(required = true)
    protected PurchaseOrder ordenCompra;
    @XmlElement(required = true)
    protected Item items;
    @XmlElement(required = true)
    protected Comercio comercio;

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
     * Gets the value of the avisoDespacho property.
     * 
     * @return
     *     possible object is
     *     {@link DispatchAdvice }
     *     
     */
    public DispatchAdvice getAvisoDespacho() {
        return avisoDespacho;
    }

    /**
     * Sets the value of the avisoDespacho property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispatchAdvice }
     *     
     */
    public void setAvisoDespacho(DispatchAdvice value) {
        this.avisoDespacho = value;
    }

    /**
     * Gets the value of the ordenCompra property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrder }
     *     
     */
    public PurchaseOrder getOrdenCompra() {
        return ordenCompra;
    }

    /**
     * Sets the value of the ordenCompra property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrder }
     *     
     */
    public void setOrdenCompra(PurchaseOrder value) {
        this.ordenCompra = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItems(Item value) {
        this.items = value;
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

}
