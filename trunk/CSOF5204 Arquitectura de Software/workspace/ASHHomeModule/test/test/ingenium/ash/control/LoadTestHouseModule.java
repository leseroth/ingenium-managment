/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test.ingenium.ash.control;

import com.clarkware.junitperf.TimedTest;
import junit.framework.Test;

public class LoadTestHouseModule {
    public static Test suite() {
        long maxTimeInMillis = 80000; //modificar tiempo en milisegundos aceptado
        int concurrentUsers = 10; //modificar usuarios componentes
        Test test = new TestHouseModule("testHouseModule");
        Test timedTest = new TimedTest(test, maxTimeInMillis);
        Test loadTest1 = new com.clarkware.junitperf.LoadTest(timedTest, concurrentUsers);
        return loadTest1;
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
