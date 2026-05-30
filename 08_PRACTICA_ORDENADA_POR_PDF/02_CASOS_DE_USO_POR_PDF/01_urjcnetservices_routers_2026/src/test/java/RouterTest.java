import es.urjc.grafo.EDA.examen.Message;
import es.urjc.grafo.EDA.examen.Router;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RouterTest {

    private Date f1, f2, f3, f4, f5, f6;
    private Message m1, m2, m3, m4, m5, m6, m7, m8, m9, m10;
    private InetAddress ip1;
    private InetAddress ip2;
    private InetAddress ip3;
    private InetAddress ip4;
    private Router r;

    @BeforeEach
    void setUp() throws UnknownHostException {
        ip1 = Inet4Address.getByName("192.168.0.15");
        ip2 = InetAddress.getByName("212.56.34.205");
        ip3 = InetAddress.getByName("34.76.143.67");
        ip4 = InetAddress.getByName("56.49.143.89");
        f1 = new Date(124, 11, 21, 9, 41);//public Date(int year,
        f2 = new Date(122, 10, 5, 12, 0);
        f3 = new Date(121, 3, 15, 4, 44);
        f4 = new Date(119, 7, 31, 0, 27);
        f5 = new Date(120, 2, 23, 7, 55);
        f6 = new Date(118, 11, 7, 20, 29);
        m1 = new Message(7, ip1, f1);
        m2 = new Message(9, ip2, f2);
        m3 = new Message(12, ip3, f3);
        m4 = new Message(18, ip4, f4);
        m5 = new Message(22, ip1, f5);
        m6 = new Message(67, ip2, f6);

        r = new Router(InetAddress.getByName("1.1.1.1"));
    }

    @Test
    void mensajeDeDifusion() {
        assertTrue(r.mensajeDeDifusion(m1));
        assertFalse(r.mensajeDeDifusion(m1));
        assertTrue(r.mensajeDeDifusion(m2));
        assertFalse(r.mensajeDeDifusion(m2));
        assertTrue(r.mensajeDeDifusion(m3));
        assertFalse(r.mensajeDeDifusion(m3));
        assertTrue(r.mensajeDeDifusion(m4));
        assertFalse(r.mensajeDeDifusion(m4));
        assertTrue(r.mensajeDeDifusion(m5));
        assertFalse(r.mensajeDeDifusion(m5));
        assertTrue(r.mensajeDeDifusion(m6));
        assertFalse(r.mensajeDeDifusion(m6));
    }

    @Test
    void borrarMensajesAntiguos() {
        r.mensajeDeDifusion(m1);
        r.mensajeDeDifusion(m2);
        r.mensajeDeDifusion(m3);
        r.mensajeDeDifusion(m4);
        r.mensajeDeDifusion(m5);
        r.mensajeDeDifusion(m6);

        assertEquals(0, r.borrarMensajesAntiguos(new Date(100, 6, 7, 7, 7)));
        assertEquals(2, r.borrarMensajesAntiguos(f4));

        r.mensajeDeDifusion(m4);
        r.mensajeDeDifusion(m6);

        assertEquals(6, r.borrarMensajesAntiguos(f1));
    }

    @Test
    void mensajeDeDifusionNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> r.mensajeDeDifusion(null));
    }

    @Test
    void mensajeDeDifusionMismoDiaDistintoMensajeSeAdmite() {
        Date mismaFecha = new Date(125, 0, 1, 10, 0);
        Message a = new Message(1, ip1, mismaFecha);
        Message b = new Message(2, ip2, mismaFecha);

        assertTrue(r.mensajeDeDifusion(a));
        assertTrue(r.mensajeDeDifusion(b));
    }

    @Test
    void borrarMensajesNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> r.borrarMensajesAntiguos(null));
    }

    @Test
    void borrarMensajesEnMapaVacioDevuelveCero() {
        assertEquals(0, r.borrarMensajesAntiguos(new Date(100, 0, 1)));
    }

    @Test
    void borrarMensajesActualizaEstado() {
        r.mensajeDeDifusion(m1);
        r.mensajeDeDifusion(m2);
        r.mensajeDeDifusion(m3);
        r.mensajeDeDifusion(m4);

        int borrados = r.borrarMensajesAntiguos(f3);
        assertEquals(2, borrados); // m3 (f3) y m4 (f4 anterior)
    }

}