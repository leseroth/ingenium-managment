
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subastaBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subastaBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activa" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fabricanteBOList" type="{http://ws.transact.marketplace.losalpes.com.co/}fabricanteBO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mejorOfertaBO" type="{http://ws.transact.marketplace.losalpes.com.co/}ofertaBO" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ofertaBOList" type="{http://ws.transact.marketplace.losalpes.com.co/}ofertaBO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="purchaseOrderBO" type="{http://ws.transact.marketplace.losalpes.com.co/}purchaseOrderBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subastaBO", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "activa",
    "fabricanteBOList",
    "id",
    "mejorOfertaBO",
    "numSeguimiento",
    "ofertaBOList",
    "purchaseOrderBO"
})
public class SubastaBO {

    protected boolean activa;
    @XmlElement(nillable = true)
    protected List<FabricanteBO> fabricanteBOList;
    protected Long id;
    protected OfertaBO mejorOfertaBO;
    protected String numSeguimiento;
    @XmlElement(nillable = true)
    protected List<OfertaBO> ofertaBOList;
    protected PurchaseOrderBO purchaseOrderBO;

    /**
     * Gets the value of the activa property.
     * 
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Sets the value of the activa property.
     * 
     */
    public void setActiva(boolean value) {
        this.activa = value;
    }

    /**
     * Gets the value of the fabricanteBOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fabricanteBOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFabricanteBOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FabricanteBO }
     * 
     * 
     */
    public List<FabricanteBO> getFabricanteBOList() {
        if (fabricanteBOList == null) {
            fabricanteBOList = new ArrayList<FabricanteBO>();
        }
        return this.fabricanteBOList;
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
     * Gets the value of the mejorOfertaBO property.
     * 
     * @return
     *     possible object is
     *     {@link OfertaBO }
     *     
     */
    public OfertaBO getMejorOfertaBO() {
        return mejorOfertaBO;
    }

    /**
     * Sets the value of the mejorOfertaBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaBO }
     *     
     */
    public void setMejorOfertaBO(OfertaBO value) {
        this.mejorOfertaBO = value;
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
     * Gets the value of the ofertaBOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ofertaBOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfertaBOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OfertaBO }
     * 
     * 
     */
    public List<OfertaBO> getOfertaBOList() {
        if (ofertaBOList == null) {
            ofertaBOList = new ArrayList<OfertaBO>();
        }
        return this.ofertaBOList;
    }

    /**
     * Gets the value of the purchaseOrderBO property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public PurchaseOrderBO getPurchaseOrderBO() {
        return purchaseOrderBO;
    }

    /**
     * Sets the value of the purchaseOrderBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public void setPurchaseOrderBO(PurchaseOrderBO value) {
        this.purchaseOrderBO = value;
    }

}
