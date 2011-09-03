package co.com.losalpes.marketplace.vos;

public class DocumentoVO {
    
    private String nombre;
    private String url;
    private String tipo;
    
        
    public DocumentoVO() {
        super();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
