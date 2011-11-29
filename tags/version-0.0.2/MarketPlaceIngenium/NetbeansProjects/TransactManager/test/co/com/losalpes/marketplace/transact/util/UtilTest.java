package co.com.losalpes.marketplace.transact.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static co.com.losalpes.marketplace.transact.util.Util.*;

/**
 *
 * @author Erik
 */
public class UtilTest {

    public UtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
    public void testGetFedexTime() {
        String mailService = null;
        
        mailService = "FedEx Express Saver (by 4:30pm in 3 days)";
        assertEquals("Se esperaba un valor distinto", 3, getFedexTime(mailService));
        
        mailService = "FedEx 2Day (by 4:30pm in 2 days)";
        assertEquals("Se esperaba un valor distinto", 2, getFedexTime(mailService));
        
        mailService = "FedEx Standard Overnight (by 3:00pm)";
        assertEquals("Se esperaba un valor distinto", 1, getFedexTime(mailService));
        
        mailService = "FedEx Priority Overnight (by 10:30am)";
        assertEquals("Se esperaba un valor distinto", 1, getFedexTime(mailService));
        
        mailService = "FedEx First Overnight (by 8:30am)";
        assertEquals("Se esperaba un valor distinto", 1, getFedexTime(mailService));
        
        mailService = "FedEx International Economy (4-5 Days)";
        assertEquals("Se esperaba un valor distinto", 5, getFedexTime(mailService));
        
        mailService = "FedEx International Priority (1-3 Days)";
        assertEquals("Se esperaba un valor distinto", 3, getFedexTime(mailService));
        
        mailService = "Algun texto que no tiene ningun sentido";
        assertEquals("Se esperaba un valor distinto", 0, getFedexTime(mailService));
    }

}