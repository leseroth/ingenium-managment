package co.com.losalpes.marketplace.vos;

import java.util.Date;
import java.util.List;

public class OfertaVO {
    private Date fechaEntrega;
    private ItemVO item;
    private FabricanteVO fabricante;
    public OfertaVO() {
        super();
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setItem(ItemVO item) {
        this.item = item;
    }

    public ItemVO getItem() {
        return item;
    }

    public void setFabricante(FabricanteVO fabricante) {
        this.fabricante = fabricante;
    }

    public FabricanteVO getFabricante() {
        return fabricante;
    }
}
