
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
 *         &lt;element name="fabricantes" type="{http://ws.transact.marketplace.losalpes.com.co/}fabricanteBO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mejor" type="{http://ws.transact.marketplace.losalpes.com.co/}ofertaBO" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ofertas" type="{http://ws.transact.marketplace.losalpes.com.co/}ofertaBO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="po" type="{http://ws.transact.marketplace.losalpes.com.co/}purchaseOrderBO" minOccurs="0"/>
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
    "fabricantes",
    "id",
    "mejor",
    "numSeguimiento",
    "ofertas",
    "po"
})
public class SubastaBO {

    @XmlElement(nillable = true)
    protected List<FabricanteBO> fabricantes;
    protected Long id;
    protected OfertaBO mejor;
    protected String numSeguimiento;
    @XmlElement(nillable = true)
    protected List<OfertaBO> ofertas;
    protected PurchaseOrderBO po;

    /**
     * Gets the value of the fabricantes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fabricantes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFabricantes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FabricanteBO }
     * 
     * 
     */
    public List<FabricanteBO> getFabricantes() {
        if (fabricantes == null) {
            fabricantes = new ArrayList<FabricanteBO>();
        }
        return this.fabricantes;
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
     * Gets the value of the mejor property.
     * 
     * @return
     *     possible object is
     *     {@link OfertaBO }
     *     
     */
    public OfertaBO getMejor() {
        return mejor;
    }

    /**
     * Sets the value of the mejor property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaBO }
     *     
     */
    public void setMejor(OfertaBO value) {
        this.mejor = value;
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
     * Gets the value of the ofertas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ofertas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfertas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OfertaBO }
     * 
     * 
     */
    public List<OfertaBO> getOfertas() {
        if (ofertas == null) {
            ofertas = new ArrayList<OfertaBO>();
        }
        return this.ofertas;
    }

    /**
     * Gets the value of the po property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public PurchaseOrderBO getPo() {
        return po;
    }

    /**
     * Sets the value of the po property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseOrderBO }
     *     
     */
    public void setPo(PurchaseOrderBO value) {
        this.po = value;
    }

}
