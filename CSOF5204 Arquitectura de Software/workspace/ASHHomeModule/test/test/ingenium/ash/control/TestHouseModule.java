/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ingenium.ash.control;

import com.ingenium.ash.control.HomeModuleMain;
import java.util.Random;
import junit.framework.TestCase;


public class TestHouseModule extends TestCase {

    private Random random;

    public TestHouseModule(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        random = new Random();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

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
