
package co.com.losalpes.marketplace;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CuentaFacturacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CuentaFacturacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numReferencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transacciones" type="{http://marketplace.losalpes.com.co}Transaccion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="facturas" type="{http://marketplace.losalpes.com.co}Factura" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaFacturacion", propOrder = {
    "id",
    "numReferencia",
    "transacciones",
    "facturas"
})
public class CuentaFacturacion {

    @XmlElement(namespace = "")
    protected long id;
    @XmlElement(namespace = "", required = true)
    protected String numReferencia;
    @XmlElement(namespace = "")
    protected List<Transaccion> transacciones;
    @XmlElement(namespace = "")
    protected List<Factura> facturas;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the numReferencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumReferencia() {
        return numReferencia;
    }

    /**
     * Sets the value of the numReferencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumReferencia(String value) {
        this.numReferencia = value;
    }

    /**
     * Gets the value of the transacciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transacciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransacciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transaccion }
     * 
     * 
     */
    public List<Transaccion> getTransacciones() {
        if (transacciones == null) {
            transacciones = new ArrayList<Transaccion>();
        }
        return this.transacciones;
    }

    /**
     * Gets the value of the facturas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facturas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacturas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Factura }
     * 
     * 
     */
    public List<Factura> getFacturas() {
        if (facturas == null) {
            facturas = new ArrayList<Factura>();
        }
        return this.facturas;
    }

}
