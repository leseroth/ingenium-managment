package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.CuentaFacturacionVO;
import co.com.losalpes.marketplace.vos.FacturaVO;

import java.security.Principal;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

public class ListaFacturacion {
    private CuentaFacturacionVO cuentaFacturacion;
    private ServicioProxy servProxy;
    private String username;
    private UIData table;
    public ListaFacturacion() {
        table=new UIData();
        Principal userPrincipal=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if(userPrincipal==null){
            FacesContext.getCurrentInstance()
                .addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR
                                                  ,"Error",
                                                  "Error al obtener el nombre del usuario"));
            System.err.println("Error obteniendo el 'principal' del usuario."); 
            return;
        }
        username=userPrincipal.getName();
        servProxy=ServicioProxy.getInstance();
        try {
            cuentaFacturacion=servProxy.getCuentaFacturacion(username);
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                .addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR
                                                  ,"Error",
                                                  "Error al obtener las facturas del usuario"));
            cuentaFacturacion=new CuentaFacturacionVO();
        }
    }

    public void setCuentaFacturacion(CuentaFacturacionVO cuentaFacturacion) {
        this.cuentaFacturacion = cuentaFacturacion;
    }

    public CuentaFacturacionVO getCuentaFacturacion() {
        return cuentaFacturacion;
    }
    public void dialogListener(DialogEvent event){
        if(event.getOutcome().equals("yes")){
            FacturaVO factura=((FacturaVO)table.getRowData());
            servProxy.registrarPagoFactura(cuentaFacturacion.getNumeroReferencia(), factura.getValorPago(), "Pago de factura", ""+System.currentTimeMillis());
            }
    }

    public void setTable(UIData table) {
        this.table = table;
    }

    public UIData getTable() {
        return table;
    }
}
