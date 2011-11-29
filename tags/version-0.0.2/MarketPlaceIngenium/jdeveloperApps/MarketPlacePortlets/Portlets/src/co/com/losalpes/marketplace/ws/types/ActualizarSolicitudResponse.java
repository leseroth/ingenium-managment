
package co.com.losalpes.marketplace.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualizarSolicitudResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualizarSolicitudResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualizarSolicitudResponse", propOrder = {
    "resultado"
})
public class ActualizarSolicitudResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected boolean resultado;

    /**
     * Gets the value of the resultado property.
     * 
     */
    public boolean isResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     */
    public void setResultado(boolean value) {
        this.resultado = value;
    }

}
