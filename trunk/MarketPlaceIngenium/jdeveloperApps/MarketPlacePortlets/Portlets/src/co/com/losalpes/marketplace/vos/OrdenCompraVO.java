package co.com.losalpes.marketplace.vos;

import java.util.Date;

public class OrdenCompraVO {
    private String numSeguimiento;
    private String estado;
    private Date fechaMaximaEntrega;
    private Date fechaMaximaSubasta;
    private String prioridad1;
    private String prioridad2;
    private Date fecha;
    private FabricanteVO fabricanteAtiende;
   private ItemVO item;
   
   
    public OrdenCompraVO() {
        super();
    }

   /* public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }*/

    public void setItem(ItemVO item) {
        this.item = item;
    }

    public ItemVO getItem() {
        return item;
    }

    
    public void setFabricanteAtiende(FabricanteVO fabricanteAtiende) {
        this.fabricanteAtiende = fabricanteAtiende;
    }

    public FabricanteVO getFabricanteAtiende() {
        return fabricanteAtiende;
    }

    public void setNumSeguimiento(String numSeguimiento) {
        this.numSeguimiento = numSeguimiento;
    }

    public String getNumSeguimiento() {
        return numSeguimiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setFechaMaximaEntrega(Date fechaMaximaEntrega) {
        this.fechaMaximaEntrega = fechaMaximaEntrega;
    }

    public Date getFechaMaximaEntrega() {
        return fechaMaximaEntrega;
    }

    public void setFechaMaximaSubasta(Date fechaMaximaSubasta) {
        this.fechaMaximaSubasta = fechaMaximaSubasta;
    }

    public Date getFechaMaximaSubasta() {
        return fechaMaximaSubasta;
    }

    public void setPrioridad1(String prioridad1) {
        this.prioridad1 = prioridad1;
    }

    public String getPrioridad1() {
        return prioridad1;
    }

    public void setPrioridad2(String prioridad2) {
        this.prioridad2 = prioridad2;
    }

    public String getPrioridad2() {
        return prioridad2;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
