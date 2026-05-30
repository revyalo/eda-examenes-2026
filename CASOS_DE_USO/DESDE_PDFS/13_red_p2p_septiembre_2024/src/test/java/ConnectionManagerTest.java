import RedP2P.ConnectionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mayte
 */
public class ConnectionManagerTest {
    
    public ConnectionManagerTest() {
    }
    private ConnectionManager server;

    @BeforeEach
    public void setUp() throws UnknownHostException{
        server = new ConnectionManager(100, InetAddress.getByName("2.4.5.1"),80);
        
        server.newConnection(InetAddress.getByName("192.176.215.2"), 7823);
        server.newConnection(InetAddress.getByName("193.177.216.3"), 7824);
        server.newConnection(InetAddress.getByName("194.178.217.4"), 7825);
        server.newConnection(InetAddress.getByName("195.179.218.5"), 7826);
        server.newConnection(InetAddress.getByName("196.180.219.6"), 7827);
        server.newConnection(InetAddress.getByName("197.181.10.2"), 7828);
        server.newConnection(InetAddress.getByName("198.182.11.3"), 7829);
        server.newConnection(InetAddress.getByName("199.183.12.4"), 7830);
        server.newConnection(InetAddress.getByName("88.184.13.5"), 6712);
        server.newConnection(InetAddress.getByName("89.185.14.6"), 6713);
        server.newConnection(InetAddress.getByName("90.186.15.7"), 6714);
    }

    /**
     * Test of newConnection method, of class ConnectionManager.
     */
    @Test
    public void testNewConnection() throws UnknownHostException {
        assertEquals(11, server.numberOfConnections());

        ConnectionManager instance = new ConnectionManager(1,InetAddress.getByName("2.3.1.4"),80);
        assertTrue(instance.newConnection(InetAddress.getByName("192.176.215.2"), 7823));
        assertFalse(instance.newConnection(InetAddress.getByName("201.6.125.48"), 9274));
        assertEquals(1, instance.numberOfConnections());
    }

    /**
     * Test of closeConnection method, of class ConnectionManager.
     */
    @Test
    public void testCloseConnection() throws UnknownHostException {
        assertTrue(server.closeConnection(InetAddress.getByName("197.181.10.2"), 7828));
        assertFalse(server.closeConnection(InetAddress.getByName("197.181.10.2"), 7828));
    }

    /**
     * Test of closeAllConnection method, of class ConnectionManager.
     */
    @Test
    public void testCloseAllConnections() throws UnknownHostException {
        assertEquals(11,server.closeAllConnections());
        assertEquals(0,server.closeAllConnections());
    }

    /**
     * Test of numberOfConnection method, of class ConnectionManager.
     */
    @Test
    public void testNumberOfConnections() throws UnknownHostException {
        assertEquals(11,server.numberOfConnections());
    }
    
}
