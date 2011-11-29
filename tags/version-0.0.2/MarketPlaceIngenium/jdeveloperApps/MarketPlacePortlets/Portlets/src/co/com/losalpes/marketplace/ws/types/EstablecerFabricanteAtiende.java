
package co.com.losalpes.marketplace.ws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for establecerFabricanteAtiende complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="establecerFabricanteAtiende">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numSeguimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fabricante" type="{http://ws.pomanager.marketplace.losalpes.com.co/}fabricanteBO" minOccurs="0"/>
 *         &lt;element name="productosAtiende" type="{http://ws.pomanager.marketplace.losalpes.com.co/}productoBO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "establecerFabricanteAtiende", propOrder = {
    "numSeguimiento",
    "fabricante",
    "productosAtiende"
})
public class EstablecerFabricanteAtiende {

    protected String numSeguimiento;
    protected FabricanteBO fabricante;
    protected List<ProductoBO> productosAtiende;

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
     * Gets the value of the productosAtiende property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productosAtiende property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductosAtiende().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductoBO }
     * 
     * 
     */
    public List<ProductoBO> getProductosAtiende() {
        if (productosAtiende == null) {
            productosAtiende = new ArrayList<ProductoBO>();
        }
        return this.productosAtiende;
    }

}
