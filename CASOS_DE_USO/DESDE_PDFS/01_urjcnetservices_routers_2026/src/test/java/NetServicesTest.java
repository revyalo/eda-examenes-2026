import es.urjc.grafo.EDA.examen.NetServices;
import es.urjc.grafo.EDA.examen.Router;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class NetServicesTest {

    private Router r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    private NetServices net;

    @BeforeEach
    void setUp() throws UnknownHostException {
        net = new NetServices();
        r1 = new Router(InetAddress.getByName("1.1.1"));
        r2 = new Router(InetAddress.getByName("2.2.2.2"));
        r3 = new Router(InetAddress.getByName("3.3.3.3"));
        r4 = new Router(InetAddress.getByName("4.4.4.4"));
        r5 = new Router(InetAddress.getByName("5.5.5.5"));
        r6 = new Router(InetAddress.getByName("6.6.6.6"));
        r7 = new Router(InetAddress.getByName("7.7.7.7"));
        r8 = new Router(InetAddress.getByName("8.8.8.8"));
        r9 = new Router(InetAddress.getByName("9.9.9.9"));
        r10 = new Router(InetAddress.getByName("10.10.10.10"));
    }

    @Test
    void addRouter() {
        try {
            net.addRouter(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertTrue(net.addRouter(r1));
        assertTrue(net.addRouter(r2));
        assertTrue(net.addRouter(r3));
        assertTrue(net.addRouter(r4));
        assertTrue(net.addRouter(r5));
        assertTrue(net.addRouter(r6));
        assertTrue(net.addRouter(r7));
        assertTrue(net.addRouter(r8));
        assertTrue(net.addRouter(r9));
        assertTrue(net.addRouter(r10));
        assertFalse(net.addRouter(r1));
        assertFalse(net.addRouter(r2));
        assertFalse(net.addRouter(r3));
        assertFalse(net.addRouter(r4));
        assertFalse(net.addRouter(r5));
        assertFalse(net.addRouter(r6));
        assertFalse(net.addRouter(r7));
        assertFalse(net.addRouter(r8));
        assertFalse(net.addRouter(r9));
        assertFalse(net.addRouter(r10));
    }

    @Test
    void addConnection() {
        try {
            net.addConnection(null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertFalse(net.addConnection(r1, r2));
        assertTrue(net.addRouter(r1));
        assertTrue(net.addRouter(r2));
        assertTrue(net.addRouter(r3));
        assertTrue(net.addRouter(r4));
        assertTrue(net.addRouter(r5));
        assertTrue(net.addRouter(r6));
        assertTrue(net.addRouter(r7));
        assertTrue(net.addRouter(r8));
        assertTrue(net.addConnection(r1, r8));
        assertTrue(net.addConnection(r1, r4));
        assertTrue(net.addConnection(r1, r5));
        assertTrue(net.addConnection(r2, r8));
        assertTrue(net.addConnection(r2, r5));
        assertTrue(net.addConnection(r2, r6));
        assertTrue(net.addConnection(r2, r7));
        assertTrue(net.addConnection(r3, r7));
        assertTrue(net.addConnection(r3, r8));
        assertFalse(net.addConnection(r3, r9));
        assertFalse(net.addConnection(r3, r10));
        assertTrue(net.addRouter(r9));
        assertTrue(net.addRouter(r10));
        assertTrue(net.addConnection(r3, r9));
        assertTrue(net.addConnection(r3, r10));
        assertTrue(net.addConnection(r8, r10));
    }

    @Test
    void centralNode() {
        try {
            net.centralNode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(net.addRouter(r1));
        assertTrue(net.addRouter(r2));
        assertTrue(net.addRouter(r3));
        assertTrue(net.addRouter(r4));
        assertTrue(net.addRouter(r5));
        assertTrue(net.addRouter(r6));
        assertTrue(net.addRouter(r7));
        assertTrue(net.addRouter(r8));
        assertTrue(net.addRouter(r9));
        assertTrue(net.addRouter(r10));
        assertNull(net.centralNode());

        assertTrue(net.addConnection(r1, r8));
        assertTrue(net.addConnection(r1, r4));
        assertTrue(net.addConnection(r1, r5));
        assertTrue(net.addConnection(r2, r8));
        assertTrue(net.addConnection(r2, r5));
        assertTrue(net.addConnection(r2, r6));
        assertTrue(net.addConnection(r2, r7));
        assertTrue(net.addConnection(r3, r7));
        assertTrue(net.addConnection(r3, r8));

        assertNull(net.centralNode());

        assertTrue(net.addConnection(r3, r9));
        assertTrue(net.addConnection(r3, r10));
        assertTrue(net.addConnection(r8, r10));
        assertEquals(r8, net.centralNode());

    }

    @Test
    void addRouterNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> net.addRouter(null));
    }

    @Test
    void addConnectionConNulosLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> net.addConnection(null, r1));
        assertThrows(IllegalArgumentException.class, () -> net.addConnection(r1, null));
        assertThrows(IllegalArgumentException.class, () -> net.addConnection(null, null));
    }

    @Test
    void addConnectionEntreRoutersNoRegistradosDevuelveFalse() {
        assertFalse(net.addConnection(r1, r2));
    }

    @Test
    void addConnectionDuplicadaNoSeInserta() {
        net.addRouter(r1);
        net.addRouter(r2);
        assertTrue(net.addConnection(r1, r2));
        assertFalse(net.addConnection(r1, r2));
    }

    @Test
    void centralNodeEnGrafoVacioLanzaExcepcion() {
        assertThrows(RuntimeException.class, net::centralNode);
    }

    @Test
    void centralNodeEnGrafoNoConexoDevuelveNull() {
        net.addRouter(r1);
        net.addRouter(r2);
        net.addRouter(r3);
        net.addRouter(r4);
        net.addConnection(r1, r2);
        net.addConnection(r3, r4);
        assertNull(net.centralNode());
    }

    @Test
    void centralNodeEnGrafoTrivialDevuelveUnicoRouter() {
        net.addRouter(r1);
        assertEquals(r1, net.centralNode());
    }

    @Test
    void centralNodeEnGrafoConexoPequenioDevuelveCentro() {
        net.addRouter(r1);
        net.addRouter(r2);
        net.addRouter(r3);
        net.addRouter(r4);
        net.addConnection(r1, r2);
        net.addConnection(r2, r3);
        net.addConnection(r2, r4);
        assertEquals(r2, net.centralNode());
    }
}