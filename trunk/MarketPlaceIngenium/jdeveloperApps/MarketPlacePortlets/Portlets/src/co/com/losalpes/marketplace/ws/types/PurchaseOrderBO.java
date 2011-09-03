
package co.com.losalpes.marketplace.ws.types;

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
 *         &lt;element name="comercio" type="{http://ws.transact.marketplace.losalpes.com.co/}comercioBO" minOccurs="0"/>
 *         &lt;element name="entrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fabricante" type="{http://ws.transact.marketplace.losalpes.com.co/}fabricanteBO" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="item" type="{http://ws.transact.marketplace.losalpes.com.co/}itemPOBO" minOccurs="0"/>
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
    "comercio",
    "entrega",
    "estado",
    "fabricante",
    "id",
    "item",
    "numSeguimiento"
})
public class PurchaseOrderBO {

    protected ComercioBO comercio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entrega;
    protected String estado;
    protected FabricanteBO fabricante;
    protected Long id;
    protected ItemPOBO item;
    protected String numSeguimiento;

    /**
     * Gets the value of the comercio property.
     * 
     * @return
     *     possible object is
     *     {@link ComercioBO }
     *     
     */
    public ComercioBO getComercio() {
        return comercio;
    }

    /**
     * Sets the value of the comercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComercioBO }
     *     
     */
    public void setComercio(ComercioBO value) {
        this.comercio = value;
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
     * Gets the value of the fabricante property.
     * 
     * @return
     *     possible object is
     *     {@link FabricanteBO }
     *     
     */
    public FabricanteBO getFabricante() {
        return fabricante;
    }

    /**
     * Sets the value of the fabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link FabricanteBO }
     *     
     */
    public void setFabricante(FabricanteBO value) {
        this.fabricante = value;
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
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link ItemPOBO }
     *     
     */
    public ItemPOBO getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPOBO }
     *     
     */
    public void setItem(ItemPOBO value) {
        this.item = value;
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
