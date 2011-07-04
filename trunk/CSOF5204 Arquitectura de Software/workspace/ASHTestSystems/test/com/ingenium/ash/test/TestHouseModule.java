/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.control.HomeModuleMain;
import junit.framework.TestCase;

public class TestHouseModule extends TestCase {
    
    private static short houseId = 100;
    private int totalSeconds = 10;

    public TestHouseModule(String testName) {
        super(testName);
    }

    public void testHouseModule() {
        HomeModuleMain hmm = new HomeModuleMain((short) houseId++);

        int itemTotal = 40;
        for (int i = 0; i < itemTotal; i++) {
            if (i < 10) {
                hmm.addItem(i, (byte) 2);
            } else if (i < 20) {
                hmm.addItem(i, (byte) 2);
            } else {
                hmm.addItem(i, (byte) 2);
            }
        }

        hmm.startHomeModule();

        long referenceTime = System.currentTimeMillis();
        long cycleTime = referenceTime;
        boolean test = true;
        while (totalSeconds * 1000 > cycleTime - referenceTime) {
            if(test && 5000 < cycleTime - referenceTime) {
                hmm.setStatus(1, (byte) 1);
                test = false;
            }
            cycleTime = System.currentTimeMillis();
        }

        hmm.stopHomeModule();
    }
}
