package test.ingenium.ash.control;

import com.ingenium.ash.control.HomeModuleMain;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Erik Arcos
 */
public class TestHouseModule {

    private Random random;

    public TestHouseModule() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        random = new Random();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHouseModule() {
        HomeModuleMain hmm = new HomeModuleMain((short) 1);

        int itemTotal = 20 + random.nextInt(30);
        byte[] itemType = {1, 2, 3};
        for (int i = 0; i < itemTotal; i++) {
            hmm.addItem(i, itemType[random.nextInt(3)]);
        }

        hmm.startHomeModule("localhost", 4444);

        long referenceTime = System.currentTimeMillis();
        while (20000 > System.currentTimeMillis() - referenceTime) {
            hmm.setStatus(random.nextInt(itemTotal), (byte) random.nextInt(100));
        }

        hmm.stopHomeModule();
    }
}
