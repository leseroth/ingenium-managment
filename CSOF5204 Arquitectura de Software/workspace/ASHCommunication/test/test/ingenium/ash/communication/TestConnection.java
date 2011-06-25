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
        
        cc.sendMessage();
        cc.sendMessage();
        cc.sendMessage();
    }
}
