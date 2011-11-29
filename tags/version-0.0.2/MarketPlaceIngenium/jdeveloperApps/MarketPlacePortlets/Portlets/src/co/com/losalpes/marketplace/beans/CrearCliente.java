package co.com.losalpes.marketplace.beans;

import co.com.losalpes.marketplace.servicio.ServicioProxy;
import co.com.losalpes.marketplace.vos.ClienteVO;

import co.com.losalpes.marketplace.vos.ContactoVO;

import co.com.losalpes.marketplace.vos.ProductoVO;

import java.io.File;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class CrearCliente {
    private ClienteVO cliente;
    private List<String> documentos;
    private UploadedFile file;

    public CrearCliente() {
        cliente=new ClienteVO();
        cliente.setContactos(new ArrayList<ContactoVO>());
      cliente.setProductos(new ArrayList<ProductoVO>());
        documentos=new ArrayList<String>();
    }

    public String crear_action() {
        boolean creado=false;
        String mensaje="";
        try{
        ServicioProxy.getInstance().persistir(this.cliente);
            creado=true;
        }catch(Exception e){
            e.printStackTrace();
            mensaje+=e.getMessage();
        }
      FacesContext context = FacesContext.getCurrentInstance();
        if(creado){
          this.cliente=new ClienteVO();
          this.cliente.setContactos(new ArrayList<ContactoVO>());
          this.cliente.setProductos(new ArrayList<ProductoVO>());
            context.addMessage(null, new FacesMessage("Cliente Creado Exitosamente"));
            
        }else{
              context.addMessage(null, new FacesMessage("Problema al crear el cliente "+mensaje));
            }
        return null;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public String agregarContacto_action() {
        this.getCliente().getContactos().add(new ContactoVO());
        return null;
    }

    public String agregarProducto_action() {
        this.getCliente().getProductos().add(new ProductoVO());
        return null;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public String adjuntarDocumento_action() {

        if(!file.getFilename().endsWith("pdf"))
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Formato Invalido"));
        else{
          documentos.add(file.getFilename());
         
        }
      return null;
    }
    public void archivoListener(ValueChangeEvent vce){
        file=(UploadedFile)vce.getNewValue();
        }

    public void setDocumentos(List<String> documentos) {
        this.documentos = documentos;
    }

    public List<String> getDocumentos() {
        return documentos;
    }
}
