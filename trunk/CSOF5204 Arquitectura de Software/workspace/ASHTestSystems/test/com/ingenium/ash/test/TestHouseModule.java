/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.control.HomeModuleMain;
import junit.framework.TestCase;

public class TestHouseModule extends TestCase {

    public TestHouseModule(String testName) {
        super(testName);
    }

    public void testHouseModule() {
        HomeModuleMain hmm = new HomeModuleMain((short) 1);

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
        boolean test = true;
        while (10000 > System.currentTimeMillis() - referenceTime) {
            if(test && 5000 > System.currentTimeMillis() - referenceTime) {
                hmm.setStatus(1, (byte) 1);
                test = false;
            }   
        }

        hmm.stopHomeModule();
    }
}
