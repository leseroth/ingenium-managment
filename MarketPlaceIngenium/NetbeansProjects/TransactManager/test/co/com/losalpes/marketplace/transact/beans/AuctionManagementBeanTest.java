package co.com.losalpes.marketplace.transact.beans;

import com.ecocoma.service.shipping.fedex.FedExService;
import com.ecocoma.service.shipping.fedex.FedExServiceSoap;
import com.ecocoma.service.shipping.fedex.Postage;
import com.ecocoma.service.shipping.fedex.Shipping;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static co.com.losalpes.marketplace.transact.util.Constants.*;
import static co.com.losalpes.marketplace.transact.util.Util.*;

/**
 *
 * @author Erik
 */
public class AuctionManagementBeanTest {



    public AuctionManagementBeanTest() {
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
    public void testFedexWebServiceCall() {

        String senderPostalCode = "90210";
        String senderCountryCode = "US";
        String recipientPostalCode = "110121";
        String recipientCountryCode = "CO";
        String totalPackageWeight = "15";
        String declaredValue = "1500";

        Shipping shipping = null;

        try { // Call Web Service Operation
            FedExService serviceFedEx = new FedExService();
            FedExServiceSoap port = serviceFedEx.getFedExServiceSoap();
            shipping = port.getFedExRate(ECOCOMA_KEY, null, null, senderPostalCode, senderCountryCode, recipientPostalCode, recipientCountryCode, totalPackageWeight, declaredValue);
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue("Error al llamar al web service de ecocoma de fedex " + ex, false);
        }

        assertEquals("Se esperaban 2 registros", 2, shipping.getPackage().getPostage().size());

        Postage postage0 = shipping.getPackage().getPostage().get(0);
        assertEquals("03", postage0.getCode());
        assertEquals("FedEx International Economy (4-5 Days)", postage0.getMailService());
        assertEquals("388.89", postage0.getRate());
        assertEquals(5, getFedexTime(postage0.getMailService()));

        Postage postage1 = shipping.getPackage().getPostage().get(1);
        assertEquals("01", postage1.getCode());
        assertEquals("FedEx International Priority (1-3 Days)", postage1.getMailService());
        assertEquals("432.35", postage1.getRate());
        assertEquals(3, getFedexTime(postage1.getMailService()));
    }
}
