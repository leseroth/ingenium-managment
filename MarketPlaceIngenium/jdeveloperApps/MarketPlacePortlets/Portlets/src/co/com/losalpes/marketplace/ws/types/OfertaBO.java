
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ofertaBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ofertaBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fabricanteBO" type="{http://ws.transact.marketplace.losalpes.com.co/}fabricanteBO" minOccurs="0"/>
 *         &lt;element name="fechaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productoOfrecidoBO" type="{http://ws.transact.marketplace.losalpes.com.co/}productoBO" minOccurs="0"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ofertaBO", namespace = "http://ws.transact.marketplace.losalpes.com.co/", propOrder = {
    "fabricanteBO",
    "fechaEntrega",
    "id",
    "numSeguimiento",
    "productoOfrecidoBO",
    "valor"
})
public class OfertaBO {

    protected FabricanteBO fabricanteBO;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEntrega;
    protected Long id;
    protected String numSeguimiento;
    protected ProductoBO productoOfrecidoBO;
    protected Long valor;

    /**
     * Gets the value of the fabricanteBO property.
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
     * Sets the value of the fabricanteBO property.
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
     * Gets the value of the fechaEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets the value of the fechaEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEntrega(XMLGregorianCalendar value) {
        this.fechaEntrega = value;
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
     * Gets the value of the productoOfrecidoBO property.
     * 
     * @return
     *     possible object is
     *     {@link ProductoBO }
     *     
     */
    public ProductoBO getProductoOfrecidoBO() {
        return productoOfrecidoBO;
    }

    /**
     * Sets the value of the productoOfrecidoBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductoBO }
     *     
     */
    public void setProductoOfrecidoBO(ProductoBO value) {
        this.productoOfrecidoBO = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValor(Long value) {
        this.valor = value;
    }

}
