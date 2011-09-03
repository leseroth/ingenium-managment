
package co.com.losalpes.marketplace.ws.registro.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.losalpes.marketplace.ws.registro.types package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.losalpes.marketplace.ws.registro.types
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
     * Create an instance of {@link ContactoCliente }
     * 
     */
    public ContactoCliente createContactoCliente() {
        return new ContactoCliente();
    }

    /**
     * Create an instance of {@link DocumentoSolicitud }
     * 
     */
    public DocumentoSolicitud createDocumentoSolicitud() {
        return new DocumentoSolicitud();
    }

    /**
     * Create an instance of {@link ProductoSolicitud }
     * 
     */
    public ProductoSolicitud createProductoSolicitud() {
        return new ProductoSolicitud();
    }

}
