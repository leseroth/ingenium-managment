package co.com.losalpes.marketplace.vos;

import java.util.Date;
import java.util.List;

public class SolicitudRegistroVO {
    private String numRadicacion;
    private Date fecha;
    private String estado;
    private String causa;
    private List<ProductoVO> productos;
    private List<DocumentoVO> documentos;
                    
    
    public SolicitudRegistroVO() {
        super();
    }

    public void setNumRadicacion(String numRadicacion) {
        this.numRadicacion = numRadicacion;
    }

    public String getNumRadicacion() {
        return numRadicacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }

    public List<ProductoVO> getProductos() {
        return productos;
    }

    public void setDocumentos(List<DocumentoVO> documentos) {
        this.documentos = documentos;
    }

    public List<DocumentoVO> getDocumentos() {
        return documentos;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }
}
