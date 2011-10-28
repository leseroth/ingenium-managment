package co.com.losalpes.marketplace.vos;

import java.util.Date;

public class TransaccionVO {
    private String referencia;
    private Date fecha;
    private String descripcion;
    private Long valor;
    
    public TransaccionVO() {
        super();
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }
}
