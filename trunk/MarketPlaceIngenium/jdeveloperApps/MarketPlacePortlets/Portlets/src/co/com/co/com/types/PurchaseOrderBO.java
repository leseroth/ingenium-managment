
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for purchaseOrderBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="purchaseOrderBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comercioBO" type="{http://ws.transact.marketplace.losalpes.com.co/}comercioBO" minOccurs="0"/>
 *         &lt;element name="entrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemPOBO" type="{http://ws.transact.marketplace.losalpes.com.co/}itemPOBO" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purchaseOrderBO", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "comercioBO",
    "entrega",
    "estado",
    "id",
    "itemPOBO",
    "numSeguimiento"
})
public class PurchaseOrderBO {

    protected ComercioBO comercioBO;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entrega;
    protected String estado;
    protected Long id;
    protected ItemPOBO itemPOBO;
    protected String numSeguimiento;

    /**
     * Gets the value of the comercioBO property.
     * 
     * @return
     *     possible object is
     *     {@link ComercioBO }
     *     
     */
    public ComercioBO getComercioBO() {
        return comercioBO;
    }

    /**
     * Sets the value of the comercioBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComercioBO }
     *     
     */
    public void setComercioBO(ComercioBO value) {
        this.comercioBO = value;
    }

    /**
     * Gets the value of the entrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntrega() {
        return entrega;
    }

    /**
     * Sets the value of the entrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntrega(XMLGregorianCalendar value) {
        this.entrega = value;
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
     * Gets the value of the itemPOBO property.
     * 
     * @return
     *     possible object is
     *     {@link ItemPOBO }
     *     
     */
    public ItemPOBO getItemPOBO() {
        return itemPOBO;
    }

    /**
     * Sets the value of the itemPOBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPOBO }
     *     
     */
    public void setItemPOBO(ItemPOBO value) {
        this.itemPOBO = value;
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

}
