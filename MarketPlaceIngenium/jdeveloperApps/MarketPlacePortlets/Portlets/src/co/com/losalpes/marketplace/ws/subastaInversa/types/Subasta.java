
package co.com.losalpes.marketplace.ws.subastaInversa.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Subasta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subasta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="fechaTerminacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ordenCompra" type="{http://marketplace.losalpes.com.co}PurchaseOrder"/>
 *         &lt;element name="mejor" type="{http://marketplace.losalpes.com.co}Oferta" minOccurs="0"/>
 *         &lt;element name="ofertas" type="{http://marketplace.losalpes.com.co}Oferta" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subasta", propOrder = {
    "id",
    "numSeguimiento",
    "fechaInicio",
    "fechaTerminacion",
    "ordenCompra",
    "mejor",
    "ofertas"
})
public class Subasta {

    protected Long id;
    protected String numSeguimiento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaInicio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaTerminacion;
    @XmlElement(required = true)
    protected PurchaseOrder ordenCompra;
    protected Oferta mejor;
    protected List<Oferta> ofertas;

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
     * Gets the value of the fechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the value of the fechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicio(XMLGregorianCalendar value) {
        this.fechaInicio = value;
    }

    /**
     * Gets the value of the fechaTerminacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTerminacion() {
        return fechaTerminacion;
    }

    /**
     * Sets the value of the fechaTerminacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTerminacion(XMLGregorianCalendar value) {
        this.fechaTerminacion = value;
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
     * Gets the value of the mejor property.
     * 
     * @return
     *     possible object is
     *     {@link Oferta }
     *     
     */
    public Oferta getMejor() {
        return mejor;
    }

    /**
     * Sets the value of the mejor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Oferta }
     *     
     */
    public void setMejor(Oferta value) {
        this.mejor = value;
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
     * {@link Oferta }
     * 
     * 
     */
    public List<Oferta> getOfertas() {
        if (ofertas == null) {
            ofertas = new ArrayList<Oferta>();
        }
        return this.ofertas;
    }

}
