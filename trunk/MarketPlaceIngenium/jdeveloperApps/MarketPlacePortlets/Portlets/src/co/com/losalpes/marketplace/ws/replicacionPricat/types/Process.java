
package co.com.losalpes.marketplace.ws.replicacionPricat.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nitFabricante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categoriaProducto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referenciaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nitFabricante",
    "nombreProducto",
    "categoriaProducto",
    "referenciaProducto"
})
@XmlRootElement(name = "process", namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat")
public class Process {

    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat", required = true)
    protected String nitFabricante;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat", required = true)
    protected String nombreProducto;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat", required = true)
    protected String categoriaProducto;
    @XmlElement(namespace = "http://xmlns.oracle.com/MarketPlace_jws/ProcesoPricat/ReplicacionPricat")
    protected String referenciaProducto;

    /**
     * Gets the value of the nitFabricante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitFabricante() {
        return nitFabricante;
    }

    /**
     * Sets the value of the nitFabricante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitFabricante(String value) {
        this.nitFabricante = value;
    }

    /**
     * Gets the value of the nombreProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Sets the value of the nombreProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    /**
     * Gets the value of the categoriaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    /**
     * Sets the value of the categoriaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoriaProducto(String value) {
        this.categoriaProducto = value;
    }

    /**
     * Gets the value of the referenciaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    /**
     * Sets the value of the referenciaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaProducto(String value) {
        this.referenciaProducto = value;
    }

}
