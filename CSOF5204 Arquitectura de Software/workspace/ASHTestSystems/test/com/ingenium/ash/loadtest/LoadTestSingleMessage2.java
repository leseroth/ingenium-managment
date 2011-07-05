/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.loadtest;

import com.clarkware.junitperf.TimedTest;
import com.ingenium.ash.load.StartLoadBalancer;

import com.ingenium.ash.test.TestSingleMessage2;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;

public class LoadTestSingleMessage2 {

    private final static int centralSystems = 2;

    public static Test suite() {
        try {
            StartLoadBalancer.main();
            Thread.sleep(20000);
//            for (int i = 0; i < centralSystems; i++) {
//                StartCentralSystem.main();
//                Thread.sleep(1000);
//            }
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadTestSingleMessage2.class.getName()).log(Level.SEVERE, null, ex);
        }

        long maxTimeInMillis = 1000; //modificar tiempo en milisegundos aceptado
        int concurrentUsers = 190; //modificar usuarios componentes
        Test test = new TestSingleMessage2("testMessage");
        Test timedTest = new TimedTest(test, maxTimeInMillis);
        Test loadTest1 = new com.clarkware.junitperf.LoadTest(timedTest, concurrentUsers);
        return loadTest1;
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
