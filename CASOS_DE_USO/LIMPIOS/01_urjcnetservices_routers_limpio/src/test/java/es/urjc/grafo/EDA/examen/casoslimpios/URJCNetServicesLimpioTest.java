package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class URJCNetServicesLimpioTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    private static <E> Set<E> toSet(Iterable<E> values) {
        return new HashSet<>(toList(values));
    }


        @Test
        void altaDuplicadosYConexiones() {
            URJCNetServicesLimpio net = new URJCNetServicesLimpio();
            Router a = new Router("A", "10.0.0.1", "Norte", 2);
            Router b = new Router("B", "10.0.0.2", "Norte", 1);
            assertTrue(net.addRouter(a));
            assertTrue(net.addRouter(b));
            assertFalse(net.addRouter(a));
            assertTrue(net.addConnection("A", "B"));
            assertFalse(net.addConnection("A", "B"));
            assertFalse(net.addConnection("A", "Z"));
        }

        @Test
        void ttlYMensajesPorFecha() {
            URJCNetServicesLimpio net = new URJCNetServicesLimpio();
            net.addRouter(new Router("A", "10.0.0.1", "N", 1));
            net.addRouter(new Router("B", "10.0.0.2", "N", 1));
            net.addRouter(new Router("C", "10.0.0.3", "S", 1));
            net.addConnection("A", "B");
            net.addConnection("B", "C");
            assertEquals(2, toList(net.routersAlcanzables("A", 1)).size());

            LocalDateTime d1 = LocalDateTime.of(2026, 1, 1, 10, 0);
            LocalDateTime d2 = LocalDateTime.of(2026, 1, 2, 10, 0);
            net.recibirMensaje(new Mensaje("M1", "A", "B", d1, 1));
            net.recibirMensaje(new Mensaje("M2", "A", "C", d2, 2));
            assertEquals(1, toList(net.mensajesHasta(d1)).size());
        }

        @Test
        void routerCentralEnRedConexa() {
            URJCNetServicesLimpio net = new URJCNetServicesLimpio();
            Router a = new Router("A", "1", "N", 1);
            Router b = new Router("B", "2", "N", 1);
            Router c = new Router("C", "3", "N", 1);
            net.addRouter(a);
            net.addRouter(b);
            net.addRouter(c);
            net.addConnection("A", "B");
            net.addConnection("B", "C");
            assertEquals(b, net.routerCentral());
        }

}
