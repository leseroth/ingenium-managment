package test.ingenium.ash.communication;

import com.ingenium.ash.communication.ConnectorClient;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
//        cc.sendMessage(new byte[]{5,1,2,3,4,5});
//        cc.sendMessage(new byte[]{6,1,2,3,4,5,6});
//        cc.sendMessage(new byte[]{7,1,2,3,4,5,6,7});
        
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(135);
        byte[] test=bb.array();
        System.out.println(test[0]+"-"+test[1]+"-"+test[2]+"-"+test[3]);
        cc.sendMessage(bb.array());
        try {
            Thread.sleep(1000*60*10);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
