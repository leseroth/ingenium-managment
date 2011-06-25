package test.ingenium.ash.communication;

import com.ingenium.ash.communication.ConnectorClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Erik Arcos
 */
public class TestConnection {
    
    public TestConnection() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConnection() {
        ConnectorClient cc = new ConnectorClient("localhost", 4444);
        
        cc.sendMessage(new byte[]{5,1,2,3,4,5});
        cc.sendMessage(new byte[]{6,1,2,3,4,5,6});
        cc.sendMessage(new byte[]{7,1,2,3,4,5,6,7});
    }
}
