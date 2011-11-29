/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.pomanager.test;

import co.com.losalpes.marketplace.pomanager.beans.RmaManagementLocal;
import co.com.losalpes.marketplace.pomanager.bos.ReturnMaterialAdviceBO;
import co.com.losalpes.marketplace.pomanager.exceptions.BussinessException;
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
public class RmaManagementTest {

    private static RmaManagementLocal beanLocal;

    public RmaManagementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("openejb.jndiname.format", "{interfaceClass}");
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(prop);
        beanLocal = (RmaManagementLocal)context.lookup("co.com.losalpes.marketplace.pomanager.beans.RmaManagementLocal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void registrarRma(){
        try {
            ReturnMaterialAdviceBO rma = new ReturnMaterialAdviceBO();
            beanLocal.registrarRMA(rma);
        } catch (BussinessException ex) {
            Logger.getLogger(RmaManagementTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail("No se debe lanzar la excepción de PO no existente");
        } 
    }
}