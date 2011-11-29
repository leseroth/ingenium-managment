package co.com.losalpes.marketplace.vos;

import java.util.List;

public class CuentaFacturacionVO {
    private String numeroReferencia;
    private List<TransaccionVO> transaccion;
    private List<FacturaVO> facturas;
    
    public CuentaFacturacionVO() {
        super();
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setTransaccion(List<TransaccionVO> transaccion) {
        this.transaccion = transaccion;
    }

    public List<TransaccionVO> getTransaccion() {
        return transaccion;
    }

    public void setFacturas(List<FacturaVO> facturas) {
        this.facturas = facturas;
    }

    public List<FacturaVO> getFacturas() {
        return facturas;
    }
}
