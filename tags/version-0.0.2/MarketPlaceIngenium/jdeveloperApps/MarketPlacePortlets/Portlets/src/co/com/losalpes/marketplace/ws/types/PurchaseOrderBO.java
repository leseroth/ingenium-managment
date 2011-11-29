
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
 * <p>Java class for purchaseOrderBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="purchaseOrderBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comercioBO" type="{http://ws.pomanager.marketplace.losalpes.com.co/}comercioBO" minOccurs="0"/>
 *         &lt;element name="entrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fabricanteBO" type="{http://ws.pomanager.marketplace.losalpes.com.co/}fabricanteBO" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemPOBOList" type="{http://ws.pomanager.marketplace.losalpes.com.co/}itemPOBO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "purchaseOrderBO", propOrder = {
    "comercioBO",
    "entrega",
    "estado",
    "fabricanteBO",
    "id",
    "itemPOBOList",
    "numSeguimiento"
})
public class PurchaseOrderBO {

    protected ComercioBO comercioBO;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entrega;
    protected String estado;
    protected FabricanteBO fabricanteBO;
    protected Long id;
    @XmlElement(nillable = true)
    protected List<ItemPOBO> itemPOBOList;
    protected String numSeguimiento;

    /**
     * Gets the value of the comercio property.
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
     * Sets the value of the comercio property.
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
     * Gets the value of the fabricante property.
     * 
     * @return
     *     possible object is
     *     {@link FabricanteBO }
     *     
     */
    public FabricanteBO getFabricanteBO() {
        return fabricanteBO;
    }

    /**
     * Sets the value of the fabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link FabricanteBO }
     *     
     */
    public void setFabricanteBO(FabricanteBO value) {
        this.fabricanteBO = value;
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
     * Gets the value of the itemPOBOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemPOBOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemPOBOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPOBO }
     * 
     * 
     */
    public List<ItemPOBO> getItemPOBOList() {
        if (itemPOBOList == null) {
            itemPOBOList = new ArrayList<ItemPOBO>();
        }
        return this.itemPOBOList;
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
