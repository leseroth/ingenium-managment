/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.test;

import com.ingenium.ash.notificator.SkypeNotification;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author Usuario
 */
public class TestSkypeCall extends TestCase {

    public TestSkypeCall(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSkypeCall() {
        try {
            SkypeNotification.startVideoCall("el_checho1");
        } catch (Exception ex) {
            Logger.getLogger(TestSkypeCall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
