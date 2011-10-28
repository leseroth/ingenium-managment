
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Oferta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Oferta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idSubasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="horarioEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fabricante" type="{http://marketplace.losalpes.com.co}Fabricante"/>
 *         &lt;element name="item" type="{http://marketplace.losalpes.com.co}Item"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Oferta", propOrder = {
    "id",
    "numSeguimiento",
    "idSubasta",
    "horarioEntrega",
    "fabricante",
    "item"
})
public class Oferta {

    protected Long id;
    @XmlElement(required = true)
    protected String numSeguimiento;
    @XmlElement(required = true)
    protected String idSubasta;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar horarioEntrega;
    @XmlElement(required = true)
    protected Fabricante fabricante;
    @XmlElement(required = true)
    protected Item item;

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
     * Gets the value of the idSubasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSubasta() {
        return idSubasta;
    }

    /**
     * Sets the value of the idSubasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSubasta(String value) {
        this.idSubasta = value;
    }

    /**
     * Gets the value of the horarioEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHorarioEntrega() {
        return horarioEntrega;
    }

    /**
     * Sets the value of the horarioEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHorarioEntrega(XMLGregorianCalendar value) {
        this.horarioEntrega = value;
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

}
