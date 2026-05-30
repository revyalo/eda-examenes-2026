package RedP2P;

import java.net.InetAddress;

public class ConnectionManager {

    /**
     * Creates a connection manager with a maximum number of connections
     *
     * @param maximumConnections
     * @param ip
     * @param port
     */
    public ConnectionManager(int maximumConnections, InetAddress ip, int port) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Creates a new connection with the host, if possible
     *
     * @param ip
     * @param port
     * @return true if the new connection is created
     */
    public boolean newConnection(InetAddress ip, int port) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Closes the connection if it exists
     *
     * @param ip
     * @param port
     * @return true if the connection exists false otherwise
     */
    public boolean closeConnection(InetAddress ip, int port) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Closes all the active connections
     *
     * @return the number of the closed connections
     */
    public int closeAllConnections() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Indicates the number of active connections
     *
     * @return the number of actives connection
     */
    public int numberOfConnections() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
