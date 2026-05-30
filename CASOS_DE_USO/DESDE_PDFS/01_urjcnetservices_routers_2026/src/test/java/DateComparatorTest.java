import es.urjc.grafo.EDA.examen.DateComparator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateComparatorTest {
    private final Comparator<Date> comparator = new DateComparator();

    @Test
    void devuelveNegativoSiPrimeraFechaEsPosterior() {
        Date posterior = new Date(126, 0, 1, 12, 0);
        Date anterior = new Date(125, 0, 1, 12, 0);
        assertTrue(comparator.compare(posterior, anterior) < 0);
    }

    @Test
    void devuelvePositivoSiPrimeraFechaEsAnterior() {
        Date posterior = new Date(126, 0, 1, 12, 0);
        Date anterior = new Date(125, 0, 1, 12, 0);
        assertTrue(comparator.compare(anterior, posterior) > 0);
    }

    @Test
    void devuelveCeroSiFechasSonIguales() {
        Date fecha1 = new Date(125, 0, 1, 12, 0);
        Date fecha2 = new Date(125, 0, 1, 12, 0);
        assertEquals(0, comparator.compare(fecha1, fecha2));
    }

    @Test
    void ordenaEnOrdenDescendente() {
        Date masReciente = new Date(126, 0, 2, 10, 0);
        Date intermedia = new Date(125, 6, 1, 8, 0);
        Date masAntigua = new Date(124, 11, 31, 6, 0);
        List<Date> fechas = new ArrayList<>(List.of(intermedia, masAntigua, masReciente));

        Collections.sort(fechas, comparator);

        assertEquals(List.of(masReciente, intermedia, masAntigua), fechas);
    }
}
