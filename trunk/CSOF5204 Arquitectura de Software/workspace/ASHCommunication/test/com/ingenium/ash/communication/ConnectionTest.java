package com.ingenium.ash.communication;

import static junit.framework.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Erik
 */
public class ConnectionTest {
    
    private static int PORT = 4444;
    private ConnectorServer connServer;
    
    public ConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
       connServer = new ConnectorServer(); 
       connServer.startServer(PORT);
    }
    
    @After
    public void tearDown() {
        connServer.stopServer();
    }
    
    @Test
    public void testConnection() {
        int b = 0xf;
        
        assertNull(connServer.startServer(PORT));

    }
}
