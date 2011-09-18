/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.test;

import co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.ComercioBO;
import co.com.losalpes.marketplace.pomanager.bos.FabricanteBO;
import co.com.losalpes.marketplace.pomanager.bos.ItemPOBO;
import co.com.losalpes.marketplace.pomanager.bos.ProductoBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author marketplace
 */
public class POManagementTest {

    private static PoManagementLocal beanLocal;

    public POManagementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("openejb.jndiname.format", "{interfaceClass}");
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(prop);
        beanLocal = (PoManagementLocal)context.lookup("co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        PurchaseOrderBO poBo = new PurchaseOrderBO();
        poBo.setEntrega(new Date());
        poBo.setEstado("PRUEBA");

        ComercioBO com = new ComercioBO();
        com.setNit("nitPrueba");
        com.setNombre("nombrePrueba");
        poBo.setComercioBO(com);

        ItemPOBO it = new ItemPOBO();
        it.setCantidad(1);
        ProductoBO prod = new ProductoBO();
        prod.setCategoria("categoriaPrueba");
        prod.setNombre("nombreProdPrueba");
        it.setProductoBO(prod);
        List<ItemPOBO> items = new ArrayList<ItemPOBO>();
        items.add(it);
        poBo.setItemPOBOList(items);
        beanLocal.registrarPO(poBo);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void registrarPO(){
    PurchaseOrderBO poBo = new PurchaseOrderBO();
        poBo.setEntrega(new Date());
        poBo.setEstado("PRUEBA");

        ComercioBO com = new ComercioBO();
        com.setNit("nitPrueba2");
        com.setNombre("nombrePrueba2");
        poBo.setComercioBO(com);

        ItemPOBO it = new ItemPOBO();
        it.setCantidad(1);
        ProductoBO prod = new ProductoBO();
        prod.setCategoria("categoriaPrueba2");
        prod.setNombre("nombreProdPrueba2");
        it.setProductoBO(prod);
        List<ItemPOBO> items = new ArrayList<ItemPOBO>();
        items.add(it);
        poBo.setItemPOBOList(items);
        String numSeguimiento = beanLocal.registrarPO(poBo);
        Assert.assertEquals(numSeguimiento.substring(0, 3), "nom");
    }

    @Test
    public void consultarPO(){
        try {
            PurchaseOrderBO po = beanLocal.consultarPO("numSeguimiento");
            Assert.fail();
        } catch (OrdenCompraNoExisteException ex) {
            
        }
        try{
            PurchaseOrderBO po = beanLocal.consultarPO("nom125478536589");
            Assert.assertEquals(po.getNumSeguimiento(), "nom125478536589");
        } catch(OrdenCompraNoExisteException ex) {
            Logger.getLogger(POManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }

    @Test
    public void actualizarEstadoPO(){
        try {
            beanLocal.actualizarEstadoPO("nom125478536589", "PRUEBA_ACTUALIZAR");
            PurchaseOrderBO po = beanLocal.consultarPO("nom125478536589");
            Assert.assertEquals(po.getEstado(), "PRUEBA_ACTUALIZAR");
        } catch (OrdenCompraNoExisteException ex) {
            Logger.getLogger(POManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }

    @Test
    public void establecerFabricanteAtiende(){
        try {
            FabricanteBO fabricante = new FabricanteBO();
            fabricante.setNit("nitFabricante");
            fabricante.setNombre("fabricantePrueba");
            
            ArrayList<ProductoBO> productos = new ArrayList<ProductoBO>();
            ProductoBO prod = new ProductoBO();
            prod.setCategoria("categoriaProducto");
            prod.setNombre("productoPrueba");
            productos.add(prod);
            
            beanLocal.establecerFabricanteAtiende("nom125478536589", fabricante, productos);
        } catch (OrdenCompraNoExisteException ex) {
            Logger.getLogger(POManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }
}