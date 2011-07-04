/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ingenium.ash.test;

import junit.framework.TestCase;

/**
 *
 * @author davper
 */
public class TestHouseSignedData extends TestCase {

    public TestHouseSignedData(String testName) {
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

    public void testFirmaTrama() {
        byte[] b1 = new byte[300];
        for (int i = 0; i < 300; i++) {
            b1[i] = 5;
        }
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
