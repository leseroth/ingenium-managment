/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.manager;

import com.ingenium.ash.cache.CacheRules;
import com.ingenium.ash.cache.RuleHouse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ManagerTest {

    public byte[] event;

    public ManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        RuleHouse rh = new RuleHouse(1,11,Byte.parseByte("01001001", 2));
        CacheRules.putRule(rh);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of processEvent method, of class Manager.
     */
    @Test
    public void testProcessEvent() {
        //System.out.println("processEvent");
        event = null;
        Manager instance = new Manager();
        instance.processEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class Manager.
     */
    @Test
    public void testEvaluate() {
        //System.out.println("evaluate");
        /*Evento no casa quemandose*/
        event = new byte[]{2,1,1,1,1,0};
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.evaluate(event);
        assertEquals(expResult, result);

        /*Evento casa quemandose*/
        event = new byte[]{2,1,1,1,1,1};
        expResult = true;
        result = instance.evaluate(event);
        assertEquals(expResult, result);

        /*RFID*/
        event = new byte[]{1,0,0,0,1,Byte.parseByte("00000010", 2)};
        expResult = true;
        result = instance.evaluate(event);
        assertEquals(expResult, result);

        /*RFID*/
        event = new byte[]{1,0,0,0,1,Byte.parseByte("01000000", 2)};
        expResult = false;
        result = instance.evaluate(event);
        assertEquals(expResult, result);

    }

    /**
     * Test of smokeProcess method, of class Manager.
     */
    @Test
    public void testSmokeProcess() {
        //System.out.println("smokeProcess");
        byte status = 0;
        boolean expResult = false;
        boolean result = Manager.smokeProcess(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sensorProcess method, of class Manager.
     */
    @Test
    public void testSensorProcess() {
        //System.out.println("sensorProcess");
        byte status = 0;
        int code = 0;
        boolean expResult = false;
        boolean result = Manager.sensorProcess(status, code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RFIDProcess method, of class Manager.
     */
    @Test
    public void testRFIDProcess() {
        //System.out.println("RFIDProcess");
        byte status = 0;
        int code = 0;
        boolean expResult = false;
        boolean result = Manager.RFIDProcess(status, code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}