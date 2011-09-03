package co.com.losalpes.marketplace.servicio;


import co.com.losalpes.marketplace.vos.AvisoDespachoVO;
import co.com.losalpes.marketplace.vos.ClienteVO;
import co.com.losalpes.marketplace.vos.ContactoVO;
import co.com.losalpes.marketplace.vos.CuentaFacturacionVO;
import co.com.losalpes.marketplace.vos.DocumentoVO;
import co.com.losalpes.marketplace.vos.FabricanteVO;
import co.com.losalpes.marketplace.vos.FacturaVO;
import co.com.losalpes.marketplace.vos.ItemVO;
import co.com.losalpes.marketplace.vos.OfertaVO;
import co.com.losalpes.marketplace.vos.OrdenCompraVO;
import co.com.losalpes.marketplace.vos.OrdenDevolucionVO;
import co.com.losalpes.marketplace.vos.ProductoVO;
import co.com.losalpes.marketplace.vos.SolicitudRegistroVO;
import co.com.losalpes.marketplace.vos.SubastaVO;
import co.com.losalpes.marketplace.ws.gestionCliente.GestionCliente;
import co.com.losalpes.marketplace.ws.gestionCliente.GestionClienteSOAPQSPortClient;
import co.com.losalpes.marketplace.ws.gestionDA.GestionDA;
import co.com.losalpes.marketplace.ws.gestionDA.GestionDASOAPQSPortClient;
import co.com.losalpes.marketplace.ws.gestionFacturacion.GestionFacturacion;
import co.com.losalpes.marketplace.ws.gestionFacturacion.GestionFacturacionSOAPClient;
import co.com.losalpes.marketplace.ws.gestionPO.GestionPO;
import co.com.losalpes.marketplace.ws.gestionPO.GestionPOSOAPClient;
import co.com.losalpes.marketplace.ws.types.Cliente;
import co.com.losalpes.marketplace.ws.types.PurchaseOrder;
import co.com.losalpes.marketplace.ws.types.ConsultarCliente;
import co.com.losalpes.marketplace.ws.types.ConsultarClienteResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarCuentaFacturacionCliente;
import co.com.losalpes.marketplace.ws.types.ConsultarCuentaFacturacionClienteResponse;
import co.com.losalpes.marketplace.ws.types.ConsultarPOsComercioResponse;
import co.com.losalpes.marketplace.ws.types.Contacto;
import co.com.losalpes.marketplace.ws.types.CuentaFacturacion;
import co.com.losalpes.marketplace.ws.types.DispatchAdvice;
import co.com.losalpes.marketplace.ws.types.Documento;
import co.com.losalpes.marketplace.ws.types.Fabricante;
import co.com.losalpes.marketplace.ws.types.Factura;
import co.com.losalpes.marketplace.ws.types.Item;
import co.com.losalpes.marketplace.ws.types.Oferta;
import co.com.losalpes.marketplace.ws.types.Producto;
import co.com.losalpes.marketplace.ws.registro.types.ProductoSolicitud;
import co.com.losalpes.marketplace.ws.types.PurchaseOrder;
import co.com.losalpes.marketplace.ws.types.ReturnMaterialAdvice;
import co.com.losalpes.marketplace.ws.types.SolicitudRegistro;
import co.com.losalpes.marketplace.ws.types.Subasta;
import co.com.losalpes.marketplace.ws.registro.types.ContactoCliente;
import co.com.losalpes.marketplace.ws.gestionRMA.GestionRMA;
import co.com.losalpes.marketplace.ws.gestionRMA.GestionRMASOAPClient;
import co.com.losalpes.marketplace.ws.gestionSubasta.GestionSubasta;
import co.com.losalpes.marketplace.ws.gestionSubasta.GestionSubastaSOAPQSPortClient;
import co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagement;
import co.com.losalpes.marketplace.ws.ldap.LDAPAuthenticationManagementPortClient;
import co.com.losalpes.marketplace.ws.ldap.UsuarioNoExisteException;

import co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder_ptClient;
import co.com.losalpes.marketplace.ws.registro.RegistroEntidad_ptClient;
import co.com.losalpes.marketplace.ws.retornoMaterial.ReturnMaterialAdvice_ptClient;
import co.com.losalpes.marketplace.ws.subastaInversa.SubastaInversa_ptClient;
import co.com.losalpes.marketplace.ws.avisoDespacho.DispatchAdvice_ptClient;
import co.com.losalpes.marketplace.ws.actualizacionCuenta.ActualizacionCuenta_ptClient;
import co.com.losalpes.marketplace.ws.confirmacionPago.ConfirmacionPago_ptClient;
import co.com.losalpes.marketplace.ws.replicacionPricat.ReplicacionPricat_ptClient;
import co.com.losalpes.marketplace.ws.registro.RegistroEntidad;
import co.com.losalpes.marketplace.ws.subastaInversa.SubastaInversa;
import co.com.losalpes.marketplace.ws.actualizacionCuenta.ActualizacionCuenta;
import co.com.losalpes.marketplace.ws.confirmacionPago.ConfirmacionPago;
import co.com.losalpes.marketplace.ws.replicacionPricat.ReplicacionPricat;

import co.com.losalpes.marketplace.ws.types.ConsultarProductosCliente;
import co.com.losalpes.marketplace.ws.types.ConsultarProductosClienteResponse;

import java.security.InvalidParameterException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang.NotImplementedException;

public final class ServicioProxy {
    private static ServicioProxy INSTANCE=null;
    private LDAPAuthenticationManagement ldap;
    private GestionPO gestionPO;
    private GestionDA gestionDA;
    private GestionRMA gestionRMA;
    private GestionSubasta gestionSubasta;
    private GestionCliente gestionCliente; 
    private GestionFacturacion gestionFacturacion; 
    private SubastaInversa subastaInversa;
    private RegistroEntidad registroEntidad;
    private co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder purchaseOrder;
    private co.com.losalpes.marketplace.ws.avisoDespacho.DispatchAdvice dispatchAdvice;
    private co.com.losalpes.marketplace.ws.retornoMaterial.ReturnMaterialAdvice returnMaterialAdvice;
    private ActualizacionCuenta actualizacionCuenta;
    private ConfirmacionPago confirmacionPago;
    private ReplicacionPricat replicacionPricat;
    
    public static ServicioProxy getInstance(){
        if(INSTANCE==null){
            INSTANCE=new ServicioProxy();
            }
        return INSTANCE;
    }
    private ServicioProxy() {
        super();  
    }
    private LDAPAuthenticationManagement getLdap(){
        if(ldap==null){
            ldap=LDAPAuthenticationManagementPortClient.getLdap();    
        }
        return ldap;    
    }
    private GestionPO getGestionPO(){
        if(gestionPO==null){
            gestionPO=GestionPOSOAPClient.getGestionPO();        
        }
        return gestionPO;
    }
    private GestionDA getGestionDA(){
        if(gestionDA==null){
                gestionDA=GestionDASOAPQSPortClient.getGestionDA();
            }
        return gestionDA;
        }
    private GestionRMA getGestionRMA(){
        if(gestionRMA==null){
            gestionRMA= GestionRMASOAPClient.getGestionRMA();
        }
        return gestionRMA;
    }
    private GestionSubasta getGestionSubasta(){
        if(gestionSubasta==null){
            gestionSubasta= GestionSubastaSOAPQSPortClient.getGestionSubasta();
        }
        return gestionSubasta;
        }
    private GestionCliente getGestionCliente(){
        if(gestionCliente==null){
                gestionCliente=GestionClienteSOAPQSPortClient.getGestionCliente();
            }
        return gestionCliente;
        } 
    private GestionFacturacion getGestionFacturacion(){
        if(gestionFacturacion==null){
                gestionFacturacion=GestionFacturacionSOAPClient.getGestionFacturacion();
            }
        return gestionFacturacion;
        } 
    private SubastaInversa getSubastaInversa(){
        if(subastaInversa==null){
                subastaInversa=SubastaInversa_ptClient.getSubastaInversa();
            }
        return subastaInversa;
        }
    private RegistroEntidad getRegistroEntidad(){
        if(registroEntidad==null){
                registroEntidad=RegistroEntidad_ptClient.getRegistroEntidad();    
            }
        return registroEntidad;
        }
    private co.com.losalpes.marketplace.ws.ordenCompra.PurchaseOrder getPurchaseOrder(){
        if(purchaseOrder==null){
                purchaseOrder=PurchaseOrder_ptClient.getOrdenCompra();
            }
        return purchaseOrder;
        }
    private co.com.losalpes.marketplace.ws.avisoDespacho.DispatchAdvice getDispatchAdvice(){
        if(dispatchAdvice==null){
                dispatchAdvice=DispatchAdvice_ptClient.getAvisoDespacho();
            }
        return dispatchAdvice;
        }
    private co.com.losalpes.marketplace.ws.retornoMaterial.ReturnMaterialAdvice getReturnMaterialAdvice(){
        if(returnMaterialAdvice==null){
                returnMaterialAdvice=ReturnMaterialAdvice_ptClient.getRetornoMaterial();
            }
        return returnMaterialAdvice;
        }
    private ActualizacionCuenta getActualizacionCuenta(){
        if(actualizacionCuenta==null){
                actualizacionCuenta=ActualizacionCuenta_ptClient.getActualizacionCuenta();
            }
        return actualizacionCuenta;
        }
    private ConfirmacionPago getConfirmacionPago(){
        if(confirmacionPago==null){
                confirmacionPago=ConfirmacionPago_ptClient.getConfirmacionPago();
            }
        return confirmacionPago;
        }
    private ReplicacionPricat getReplicacionPricat(){
        if(replicacionPricat==null){
                replicacionPricat=ReplicacionPricat_ptClient.getReplicacionPricat();
            }
        return replicacionPricat;
        }
    public String getNitByUsername(String username){
        String nit;
        try {
            nit=getLdap().obtenerNitUsuario(username);
        } catch (UsuarioNoExisteException e) {
            nit=null;
        }
        return nit;
        }
    public List<OrdenCompraVO> getOrdenCompraByNitComercio(String nit){
        List<OrdenCompraVO> ordenesVO=new ArrayList<OrdenCompraVO>();
        ConsultarPOsComercioResponse ccposr;
        List<PurchaseOrder> pos = getGestionPO().consultarPOsComercio(nit);
        for(PurchaseOrder po : pos){
            ordenesVO.add(transformOrdenCompra(po));
            }
        return ordenesVO;
        }
  public List<OrdenCompraVO> getOrdenCompraByNitFabricante(String nit){
      List<OrdenCompraVO> ordenesVO=new ArrayList<OrdenCompraVO>();
        List<Subasta> subastasFabricante = getGestionSubasta().consultarSubastasFabricante(nit);
        for(Subasta s:subastasFabricante){
            ordenesVO.add(transformOrdenCompra(s.getOrdenCompra()));
            }
        return ordenesVO;
  }
    public List<SubastaVO> getSubastasUsuario(String username){
        String nit;
        nit = this.getNitByUsername(username);
        List<SubastaVO> subastas=new ArrayList<SubastaVO>();
        List<Subasta> subastasFabricante = getGestionSubasta().consultarSubastasFabricante(nit);
        for(Subasta s:subastasFabricante){
            subastas.add(transformarSubasta(s));
            }        
        return subastas; 
        }
    public List<OrdenDevolucionVO> getOrdenDevolucionByUsernameFabricante(String username){
        String nit;
        nit = this.getNitByUsername(username);
        List<OrdenDevolucionVO> devoluciones=new ArrayList<OrdenDevolucionVO>();
        List<ReturnMaterialAdvice> rmaFabricante = getGestionRMA().consultarRMAsFabricante(nit);
        for(ReturnMaterialAdvice rma:rmaFabricante){
            devoluciones.add(transformarRMA(rma));            
            }
        return devoluciones;
        }
  public SubastaVO getSubastaByOrdenNumSeguimiento(String numSeguimiento)throws Exception{
      try{
        return transformarSubasta(getGestionSubasta().consultarSubastaOrdenCompra(numSeguimiento));
      }catch(Exception e){
          throw e;
          }
      }
  public AvisoDespachoVO getAvisoDespachoByOrdenCompra(OrdenCompraVO orden){
      AvisoDespachoVO da;
      da=transformarAvisoDespacho( getGestionDA().consultarDAnumSeguimientoPO(orden.getNumSeguimiento()));
      return da;
      }
  public List<AvisoDespachoVO> getAvisosDespachoByUsernameFabricante(String username){
      List<AvisoDespachoVO> das=new ArrayList<AvisoDespachoVO>();
        List<DispatchAdvice> dasFabricante = getGestionDA().consultarDAsFabricante(username);
        for(DispatchAdvice da:dasFabricante){
            das.add(transformarAvisoDespacho(da));
            }
        return das;
      }
  public ClienteVO getClienteByUsername(String username){
      String nit=this.getNitByUsername(username);
      ClienteVO cliente=new ClienteVO();
      ConsultarCliente parameters=new ConsultarCliente();
      parameters.setNit(nit);
      ConsultarClienteResponse ccr= getGestionCliente().consultarCliente(parameters);
      cliente=transformarCliente(ccr.getCliente());
      return cliente;
      }
  public CuentaFacturacionVO getCuentaFacturacion(String username) throws Exception{
      String nit=getNitByUsername(username);
      try{
        CuentaFacturacion cuenta = getGestionFacturacion().consultarCuentaFacturacionCliente(nit);
        return transformarCuentaFacturacion(cuenta);
      }catch(Exception e){
          throw e;
          }
      }
    public List<ProductoVO> getProductosByUsername(String username){
        List<ProductoVO> productos=new ArrayList<ProductoVO>();
        ConsultarProductosCliente parameters=new ConsultarProductosCliente();
        parameters.setNit(getNitByUsername(username));
        ConsultarProductosClienteResponse clienteResponse = getGestionCliente().consultarProductosCliente(parameters);
        List<Producto> prs=clienteResponse.getProductos();
        for(Producto p:prs){
            productos.add(transformarProducto(p));
        }
        return productos;
    }
  public void persistir(Object obj){
      throw new NotImplementedException();
      }
  public void persistir(OrdenCompraVO orden, String username){
      if(orden==null||orden.getItem()==null||orden.getItem().getProducto()==null){
          throw new InvalidParameterException("Debe existir una orden con un item y un producto");
          }
          
      ClienteVO comercio=getClienteByUsername(username);
      getPurchaseOrder().process(toXMLGregorianCalendar(orden.getFechaMaximaEntrega()), toXMLGregorianCalendar(orden.getFechaMaximaSubasta()), toXMLGregorianCalendar(new Date()), comercio.getNit(), comercio.getNombre(), comercio.getEmail(), comercio.getDireccion(), comercio.getTelefono(), orden.getItem().getCantidad(), orden.getItem().getProducto().getNombre(), orden.getItem().getProducto().getCategoria());
      }
  public void persistir(AvisoDespachoVO ad, String nombreUsuarioFabricante){
      ClienteVO fabricante=getClienteByUsername(nombreUsuarioFabricante);
      if(ad.getItem()==null){
          throw new  InvalidParameterException("el item no puede ser nulo");
          }
      if(fabricante==null){
          throw new InvalidParameterException("Problema con el usuario, no es un fabricante valido");
          }
      String camiones="";
      if(ad.getCamiones()!=null)
          for(String camion:ad.getCamiones()){
              if(camiones.equals("")){
                  camiones=camion;
              }else{
                  camiones+=","+camion;
                  }
            }
      getDispatchAdvice().process(toXMLGregorianCalendar(ad.getFechaEmision()), toXMLGregorianCalendar( ad.getFechaLlegada()), ad.getMontoOperacion(), ad.getCamiones().toString(), ad.getItem().getCantidad(),ad.getItem().getProducto().getNombre(), ad.getItem().getProducto().getCategoria(), ad.getItem().getProducto().getReferencia(), ad.getOrdenCompra().getNumSeguimiento(), fabricante.getNombre(), fabricante.getNit(),fabricante.getEmail());
      }
  public void persistir(ClienteVO cliente){
      List<ContactoCliente> contactos=new ArrayList<ContactoCliente> ();
      if(cliente.getContactos()!=null)
          for(ContactoVO contactovo:cliente.getContactos()){
              contactos.add(transformarContactoCliente(contactovo));
              }
      List<ProductoSolicitud> productos=new  ArrayList<ProductoSolicitud> ();
        if(cliente.getProductos()!=null)
            for(ProductoVO productovo:cliente.getProductos()){
                productos.add(transformarProductoSolicitud(productovo));
                }
      getRegistroEntidad().process(cliente.getNit(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(),cliente.getEmail(), cliente.getTipo(),cliente.getRazonSocial(), contactos, toXMLGregorianCalendar(new Date()),null, productos);
      }
  
  /**
   * Persistir una oferta 
   * @param subasta Subasta a la que est� ofertando
   * @param oferta oferta que realiza. 
   * */
  public void persistir(SubastaVO subasta, OfertaVO oferta){
      if(oferta.getFabricante()==null){
          throw new InvalidParameterException("El fabricante no puede ser nulo");
          }
      if(oferta==null||oferta.getItem()==null||oferta.getItem().getProducto()==null){
            throw new InvalidParameterException("No puede persistir una oferta sin item o sin producto");
          }
      XMLGregorianCalendar fecha=toXMLGregorianCalendar(subasta.getFechaInicio());
      XMLGregorianCalendar fechaEntrega=toXMLGregorianCalendar( subasta.getFechaTerminacion());
      FabricanteVO fabricante=oferta.getFabricante();
      
      getSubastaInversa().process(fecha, fechaEntrega, subasta.getNumSeguimiento(),fabricante.getNit(), fabricante.getNombre(), fabricante.getEmail(), oferta.getItem().getCantidad(), oferta.getItem().getValor(), oferta.getItem().getProducto().getNombre(), oferta.getItem().getProducto().getCategoria());
      }
    private OrdenCompraVO transformOrdenCompra(PurchaseOrder oc){
        if(oc==null)return null;
        OrdenCompraVO ocVO=new OrdenCompraVO();
        ocVO.setEstado(oc.getEstado());
        ocVO.setFechaMaximaEntrega(oc.getFechaMaxima().toGregorianCalendar().getTime());
        ocVO.setFabricanteAtiende(transformarFabricante(oc.getFabricanteAtiende()));
        ocVO.setItem(transformarItem(oc.getItem()));
        ocVO.setFechaMaximaSubasta( oc.getTiempoSubasta().toGregorianCalendar().getTime());
        ocVO.setFecha(oc.getFechaMaxima().toGregorianCalendar().getTime());
        return ocVO;
        }
    private FabricanteVO transformarFabricante(Fabricante f){
        FabricanteVO fabVO=new FabricanteVO();
        fabVO.setNit(f.getNit());
        fabVO.setNombre(f.getNombre());
        fabVO.setEmail( f.getEmail());
        fabVO.setTelefono(f.getTelefono());
        fabVO.setDireccion(f.getDireccion());
        List<Producto> list = f.getProductos();
        fabVO.setProductos(new ArrayList<ProductoVO>());
        for(Producto p:list){
            fabVO.getProductos().add(transformarProducto(p));
            }
        return fabVO; 
        }
    private ItemVO transformarItem(Item item){
        if(item==null)return null;
        ItemVO itemVO=new ItemVO();
         item.getId();
        itemVO.setProducto(transformarProducto( item.getProducto()));
        itemVO.setValor(item.getValor());
        return itemVO;
        }
    private ProductoVO transformarProducto(Producto p){
        if(p==null)return null;
        ProductoVO productoVO=new ProductoVO();
        productoVO.setReferencia (String.valueOf( p.getId()));
        productoVO.setNombre(p.getNombre());
        productoVO.setCategoria( p.getCategoria());
        return productoVO;
        }
    private AvisoDespachoVO transformarAvisoDespacho(DispatchAdvice da){
        AvisoDespachoVO daVO=new AvisoDespachoVO();
        String camiones=da.getCamiones();
          List<String> camionesL=new ArrayList<String>();
        if(camiones!=null){
          camionesL=Arrays.asList( camiones.split(","));
        }
        daVO.setCamiones(camionesL);
        try{
        daVO.setFechaEmision(da.getFechaEmision().toGregorianCalendar().getTime());
        }catch(Exception e){
            daVO.setFechaEmision(null);
            }
        try{
        daVO.setFechaLlegada(da.getFechaLlegada().toGregorianCalendar().getTime());
        }catch(NullPointerException npe){
            daVO.setFechaLlegada(null);
            }
        da.getItems();
        daVO.setMontoOperacion(da.getMontoOperacion());
        daVO.setOrdenCompra( transformOrdenCompra(da.getOrdenCompra()));
        return daVO;
        }
    public void persistir(OrdenDevolucionVO rma){
        getReturnMaterialAdvice().process(rma.getCausa(), toXMLGregorianCalendar(rma.getFecha()), rma.getItem().getCantidad(), rma.getItem().getValor(), rma.getItem().getProducto().getNombre(), rma.getItem().getProducto().getCategoria(), rma.getItem().getProducto().getReferencia(), rma.getNumSeguimiento(), rma.getAvisoDespacho().getNumSeguimiento());
        }
    private OrdenDevolucionVO transformarRMA(ReturnMaterialAdvice rma){
        OrdenDevolucionVO rmaVO=new OrdenDevolucionVO();
        rmaVO.setAvisoDespacho(transformarAvisoDespacho(rma.getAvisoDespacho()));
        rmaVO.setCausa( rma.getCausa());
        rmaVO.setFecha(rma.getFecha().toGregorianCalendar().getTime());
    
        rmaVO.setItem(transformarItem(rma.getItems()));
        rmaVO.setNumSeguimiento(rma.getNumSeguimiento());
        rmaVO.setOrdenCompra(transformOrdenCompra( rma.getOrdenCompra()));
        return rmaVO;
        }
    private SubastaVO transformarSubasta(Subasta s){
        if(s==null)return null; 
        SubastaVO subVO=new SubastaVO();
        subVO.setNumSeguimiento(s.getNumSeguimiento());
        try{
        subVO.setFechaInicio(s.getFechaInicio().toGregorianCalendar().getTime());
        }catch(NullPointerException npe){
            subVO.setFechaInicio(null);
            }
          try{
          subVO.setFechaTerminacion(s.getFechaTerminacion().toGregorianCalendar().getTime());
          }catch(NullPointerException npe){
              subVO.setFechaTerminacion(null);
              }
        subVO.setMejor(transformarOferta(s.getMejor()));
        subVO.setOfertas(new ArrayList<OfertaVO>());
        for(Oferta of:s.getOfertas()){
             subVO.getOfertas().add(transformarOferta(of));
        }
        subVO.setOrdenCompra(transformOrdenCompra( s.getOrdenCompra()));
        
        return subVO;
        }
    
    private OfertaVO transformarOferta(Oferta of){
        OfertaVO ofVO=new OfertaVO();
        ofVO.setFabricante(transformarFabricante(of.getFabricante()));
        ofVO.setFechaEntrega(of.getHorarioEntrega().toGregorianCalendar().getTime());
        ofVO.setItem(transformarItem(of.getItem()));
        return ofVO;
        }
    private ClienteVO transformarCliente(Cliente cl){
        if(cl==null)return null;
        ClienteVO clVO = new ClienteVO();
        clVO.setContactos(new ArrayList<ContactoVO>());
        for (Contacto contacto : cl.getContactos()) {
            clVO.getContactos().add(transformarContacto(contacto));
        }
        clVO.setCuentaFact(transformarCuentaFacturacion(cl.getCtaFact()));
        clVO.setDireccion(cl.getDireccion());
        clVO.setEmail(cl.getEmail());
        cl.getId();
        clVO.setNit(cl.getNit());
        clVO.setNombre(cl.getNombre());
        clVO.setRazonSocial(cl.getRazonSocial());
        clVO.setTelefono(cl.getTelefono());
        return clVO;
        }
    private ContactoVO transformarContacto(Contacto contacto){
        if(contacto==null)return null;
        ContactoVO contactoVO=new ContactoVO();
        contactoVO.setIdContacto(contacto.getId());
        contactoVO.setCelular(contacto.getCelular());
        contactoVO.setDireccion(contacto.getDireccion());
        contactoVO.setEmail(contacto.getEmail());
        contactoVO.setNombre(contacto.getNombre());
        contactoVO.setNumIdentificacion( contacto.getNumIdentificacion());
        contactoVO.setTipoIdentificacion(contacto.getTipoIdentificacion());
        return contactoVO;
        }
    private CuentaFacturacionVO transformarCuentaFacturacion(CuentaFacturacion cuenta){
        if(cuenta==null)return null;
        CuentaFacturacionVO cuentaVO=new CuentaFacturacionVO();
        List<FacturaVO> facturas=new ArrayList<FacturaVO>();
        for(Factura factura:cuenta.getFacturas()){
            facturas.add(transformarFactura(factura));
            }
        cuenta.getId();
        cuentaVO.setNumeroReferencia( cuenta.getNumReferencia());
        cuenta.getTransacciones();
        return cuentaVO;
        }
    private SolicitudRegistroVO transformarSolicitudRegistro(SolicitudRegistro sr){
        SolicitudRegistroVO srvo=new SolicitudRegistroVO();
        srvo.setCausa(sr.getCausa());
        List<DocumentoVO> documentos=new ArrayList<DocumentoVO>();
        for(Documento d:sr.getDocumentos()){
            documentos.add(transformarDocumento(d));
            }
        List<ProductoVO> productos=new ArrayList<ProductoVO>();
          for(Producto d:sr.getProductos()){
              productos.add(transformarProducto(d));
              }
        srvo.setProductos(productos);
        srvo.setDocumentos(documentos);
        srvo.setEstado(sr.getEstado());
        srvo.setFecha(sr.getFecha()!=null?sr.getFecha().toGregorianCalendar().getTime():null);
        srvo.setNumRadicacion(sr.getNumRadicacion());
        return srvo;
        }
    private FacturaVO transformarFactura(Factura f){
        if(f==null)return null;
        FacturaVO factura=new FacturaVO();
        factura.setFechaInicio(f.getFechaInicio()!=null?f.getFechaInicio().toGregorianCalendar().getTime():null);
        factura.setFechaFin(f.getFechaFin()!=null?f.getFechaFin().toGregorianCalendar().getTime():null);
        factura.setNombre(f.getNombre());
        factura.setUrl(f.getUrl());
        factura.setValorPago(f.getValorPago());
        return factura;
        }
    private DocumentoVO transformarDocumento(Documento d){
        if(d==null)return null;
        DocumentoVO doc=new DocumentoVO();
        doc.setNombre(d.getNombre());
        doc.setTipo(d.getTipo());
        doc.setUrl(d.getUrl());
        return doc;
        }
    private XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        DatatypeFactory df;
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            return null;
        }
        if (date == null) {
          return null;
        } else {
          GregorianCalendar gc = new GregorianCalendar();
          gc.setTimeInMillis(date.getTime());
          return df.newXMLGregorianCalendar(gc);
        }

        }
    private ContactoCliente transformarContactoCliente(ContactoVO contactoVO){
        ContactoCliente cc=new ContactoCliente();
        cc.setCelular(contactoVO.getCelular());
        cc.setDireccion(contactoVO.getDireccion());
        cc.setEmail(contactoVO.getEmail());
        cc.setNombre(contactoVO.getNombre());
        cc.setNumIdentificacion(cc.getNumIdentificacion());
        cc.setTelefono(contactoVO.getTelefono());
        cc.setTipoIdentificacion(contactoVO.getTipoIdentificacion());
        return cc;
        }
    private ProductoSolicitud transformarProductoSolicitud(ProductoVO p){
        ProductoSolicitud ps=new ProductoSolicitud();
        ps.setCategoria(p.getCategoria());
        ps.setNombre(p.getNombre());
        return ps;
        }

    public void registrarPagoFactura(String numCuenta, long valor, String descripcion,
                                     String referencia) {
        getConfirmacionPago().process(numCuenta, valor, descripcion, referencia);
    }
}
