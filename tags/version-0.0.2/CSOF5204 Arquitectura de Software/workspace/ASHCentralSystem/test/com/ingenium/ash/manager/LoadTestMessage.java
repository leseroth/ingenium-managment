/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ingenium.ash.manager;

import com.clarkware.junitperf.TimedTest;
import junit.framework.Test;
/**
 *
 * @author PC12345
 */
public class LoadTestMessage {

    public static Test suite() {
        long maxTimeInMillis = 1000; //modificar tiempo en milisegundos aceptado
        int concurrentUsers = 3000; //modificar usuarios componentes
        Test test = new MessageTest("testMessage");
        Test timedTest = new TimedTest(test, maxTimeInMillis);
        Test loadTest1 = new com.clarkware.junitperf.LoadTest(timedTest, concurrentUsers);
        return loadTest1;
    }

    public static void main(String args[]) {

        junit.textui.TestRunner.run(suite());
    }

}
