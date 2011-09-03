/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.test;

import co.com.losalpes.marketplace.pomanager.beans.DaManagementLocal;
import co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.DispatchAdviceBO;
import co.com.losalpes.marketplace.pomanager.bos.PurchaseOrderBO;
import co.com.losalpes.marketplace.pomanager.exceptions.AvisoDespachoNoExisteException;
import co.com.losalpes.marketplace.pomanager.exceptions.OrdenCompraNoExisteException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author marketplace
 */
public class DaManagementTest {

    private static DaManagementLocal beanLocal;
    private static PoManagementLocal beanPo;
    private String numSeguimiento;

    public DaManagementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("openejb.jndiname.format", "{interfaceClass}");
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(prop);
        beanLocal = (DaManagementLocal)context.lookup("co.com.losalpes.marketplace.pomanager.beans.DaManagementLocal");
        beanPo = (PoManagementLocal)context.lookup("co.com.losalpes.marketplace.pomanager.beans.PoManagementLocal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws OrdenCompraNoExisteException {
        DispatchAdviceBO da = new DispatchAdviceBO();
        String camiones = "camion1;camion2";
        da.setCamiones(camiones);
        da.setFechaEmision(new Date(System.currentTimeMillis()));
        da.setFechaLlegada(new Date(System.currentTimeMillis()+100000));
        da.setMontoOperacion(1000000L);
        da.setNumSeguimiento("nom125478536589");
        PurchaseOrderBO po = beanPo.consultarPO("nom125478536589");
        da.setPo(po);

        beanLocal.registrarDA(da, "numSeguimiento");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void registrarDA() throws OrdenCompraNoExisteException {
        DispatchAdviceBO da = new DispatchAdviceBO();
        String camiones = "camion1;camion2";
        da.setCamiones(camiones);
        da.setFechaEmision(new Date(System.currentTimeMillis()));
        da.setFechaLlegada(new Date(System.currentTimeMillis()+400000));
        da.setMontoOperacion(2000000L);
        numSeguimiento = beanLocal.registrarDA(da, "numSeguimiento");
        Assert.assertTrue(numSeguimiento != null);
    }

    @Test
    public void consultarDA() {
        try {
            DispatchAdviceBO da = beanLocal.consultarDA(numSeguimiento);
            Assert.assertTrue(da.getMontoOperacion() == 2000000L);
        } catch (AvisoDespachoNoExisteException ex) {
            Logger.getLogger(DaManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail("El DA si existe");
        }

        try{
            DispatchAdviceBO da = beanLocal.consultarDA("numSeguimientoNoExiste");
            Assert.fail("El DA no existe.");
        } catch(AvisoDespachoNoExisteException ex){
            Logger.getLogger(DaManagementTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}