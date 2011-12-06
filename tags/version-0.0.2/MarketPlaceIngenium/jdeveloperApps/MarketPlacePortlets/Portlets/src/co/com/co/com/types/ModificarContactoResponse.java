
package co.com.co.com.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModificarContactoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModificarContactoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificarContactoResponse", propOrder = {
    "respuesta"
})
public class ModificarContactoResponse {

    @XmlElement(namespace = "http://marketplace.losalpes.com.co")
    protected boolean respuesta;

    /**
     * Gets the value of the respuesta property.
     * 
     */
    public boolean isRespuesta() {
        return respuesta;
    }

    /**
     * Sets the value of the respuesta property.
     * 
     */
    public void setRespuesta(boolean value) {
        this.respuesta = value;
    }

}