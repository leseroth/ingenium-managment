
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DispatchAdvice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DispatchAdvice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaLlegada" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="montoOperacion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="camiones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ordenCompra" type="{http://marketplace.losalpes.com.co}PurchaseOrder"/>
 *         &lt;element name="items" type="{http://marketplace.losalpes.com.co}Item" maxOccurs="unbounded"/>
 *         &lt;element name="fabricante" type="{http://marketplace.losalpes.com.co}Fabricante"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispatchAdvice", propOrder = {
    "id",
    "numSeguimiento",
    "fechaEmision",
    "fechaLlegada",
    "montoOperacion",
    "camiones",
    "ordenCompra",
    "items",
    "fabricante"
})
public class DispatchAdvice {

    protected Long id;
    protected String numSeguimiento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLlegada;
    protected long montoOperacion;
    @XmlElement(required = true)
    protected String camiones;
    @XmlElement(required = true)
    protected PurchaseOrder ordenCompra;
    @XmlElement(required = true)
    protected List<Item> items;
    @XmlElement(required = true)
    protected Fabricante fabricante;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<Item>();
        }
        return this.items;
    }

    /**
     * Gets the value of the fabricante property.
     * 
     * @return
     *     possible object is
     *     {@link Fabricante }
     *     
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * Sets the value of the fabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fabricante }
     *     
     */
    public void setFabricante(Fabricante value) {
        this.fabricante = value;
    }

}
