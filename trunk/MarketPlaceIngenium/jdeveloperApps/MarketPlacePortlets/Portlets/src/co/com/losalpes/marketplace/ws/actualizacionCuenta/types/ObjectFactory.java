
package co.com.losalpes.marketplace.ws.actualizacionCuenta.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.loalpes.marketplace.ws.actualizacionCuenta.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.loalpes.marketplace.ws.actualizacionCuenta.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Process }
     * 
     */
    public Process createProcess() {
        return new Process();
    }

    /**
     * Create an instance of {@link ContactoActualizacion }
     * 
     */
    public ContactoActualizacion createContactoActualizacion() {
        return new ContactoActualizacion();
    }

    /**
     * Create an instance of {@link ProductoActualizacion }
     * 
     */
    public ProductoActualizacion createProductoActualizacion() {
        return new ProductoActualizacion();
    }

    /**
     * Create an instance of {@link ProcessResponse }
     * 
     */
    public ProcessResponse createProcessResponse() {
        return new ProcessResponse();
    }

}
