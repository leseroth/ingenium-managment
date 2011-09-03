/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.riskqualification.test;

import co.com.losalpes.marketplace.riskqualification.beans.CreditVerificationLocal;
import java.util.Properties;
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
public class RiskQualificationCreditVerificationTest {

    private static CreditVerificationLocal creditVerificationLocal;

    public RiskQualificationCreditVerificationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Properties props = new Properties();
        props.setProperty("openejb.jndiname.format","{interfaceClass}");
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(props);
        creditVerificationLocal = (CreditVerificationLocal)context.lookup("co.com.losalpes.marketplace.riskqualification.beans.CreditVerificationLocal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @Before
    public void setUp() {
       String nit = "860004922";
       try {
           creditVerificationLocal.registrarDataCredito(nit);
           creditVerificationLocal.registrarComfecamara(nit);
           creditVerificationLocal.registrarListaClinton(nit);
           creditVerificationLocal.registrarAntiLavados(nit);

       } catch (Exception ex) {


       }
    }

    @After
    public void tearDown() {
    }
    //Valida que la entidad tiene información registrada y vigente
    @Test
    public void dataCreditoValidarOK() {
         String scoring = "";
         try {
             scoring = creditVerificationLocal.verificarDataCredito("860004922",30);
             Assert.assertTrue(scoring.startsWith("A"));
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }
    //Valida que la entidad no tiene información registrada
    @Test
    public void dataCreditoValidarCrear() {
         String scoring = "";
         try {
             scoring = creditVerificationLocal.verificarDataCredito("861114922",30);
             Assert.assertEquals("A",scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }        
     }

    //Valida que la entidad tiene información registrada pero no vigente
    @Test
    public void dataCreditoValidar() {
         String scoring = "";
         try {
             scoring = creditVerificationLocal.verificarDataCredito("860004922",-1);
             Assert.assertEquals("A",scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada y vigente
    @Test
    public void confecamaraValidarOK() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarComfecamara("860004922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }
    
        
     //Valida que la entidad no tiene información registrada 
    @Test
    public void confecamaraValidarCrear() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarComfecamara("861114922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada pero no vigente
    @Test
    public void confecamaraValidar() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarComfecamara("860004922",-1);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada y vigente
    @Test
    public void listaClintonValidarOk() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaClinton("860004922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad no tiene información registrada
    @Test
    public void listaClintonValidarCrear() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaClinton("861114922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada pero no vigente
    @Test
    public void listaClintonValidar() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaClinton("860004922",-1);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada y vigente
    @Test
    public void antiLavadosValidarOK() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaAntiLavado("860004922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }
    
    //Valida que la entidad no tiene información registrada 
    @Test
    public void antiLavadosValidarCrear() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaAntiLavado("861114922",30);
            Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

    //Valida que la entidad tiene información registrada pero no vigente
    @Test
    public void antiLavadosValidar() {
         Boolean scoring = false;
         try {
            scoring = creditVerificationLocal.verificarListaAntiLavado("860004922",-1);
             Assert.assertTrue(scoring);
         } catch (Exception e) {
             Assert.fail(e.getMessage());
         }
     }

}