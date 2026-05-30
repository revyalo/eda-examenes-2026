
import es.urjc.grafo.EDA.CNP.Notas;
import es.urjc.grafo.EDA.CNP.Opositor;
import es.urjc.grafo.EDA.CNP.Registro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistroTest {

    Registro registro;

    @BeforeEach
    public void setUp() {
        List<Opositor> opositores = new ArrayList<>(10);
        opositores.add(new Opositor(12345678, "Max", "Verstappen", new Notas(9.0, 8.0, 437.0)));
        opositores.add(new Opositor(12345679, "Lando", "Norris", new Notas(4.0, 8.0, 374.0)));
        opositores.add(new Opositor(12345670, "Charles", "Leclerc", new Notas(3.0, 3.0, 356.0)));
        opositores.add(new Opositor(12345671, "Oscar", "Piastri", new Notas(2.0, 0.0, 292.0)));
        opositores.add(new Opositor(12345672, "Carlos", "Sainz Jr", new Notas(2.0, 1.0, 290.0)));
        opositores.add(new Opositor(12345673, "George", "Russell", new Notas(2.0, 4.0, 245.0)));
        opositores.add(new Opositor(12345674, "Lewis", "Hamilton", new Notas(1.0, 0.0, 223.0)));
        opositores.add(new Opositor(12345675, "Sergio", "Perez", new Notas(1.0, 0.0, 152.0)));
        opositores.add(new Opositor(12345676, "Fernando", "Alonso", new Notas(1.0, 0.0, 42.0)));
        opositores.add(new Opositor(12345677, "Pierre", "Gasly", new Notas(1.0, 0.0, 42.0)));

        registro = new Registro(opositores);
    }

    @Test
    public void testAddOpositor() {
        Assertions.assertEquals(10, registro.size());
        Assertions.assertTrue(registro.addOpositor(new Opositor(12345680, "Michael", "Schumacher", new Notas(10.0, 10.0, 500.0))), "No se ha podido añadir un nuevo opositor");
        Assertions.assertFalse(registro.addOpositor(new Opositor(12345680, "Michael", "Schumacher", new Notas(10.0, 10.0, 500.0))), "No se puede añadir un opositor con el mismo DNI");
        Assertions.assertEquals(11, registro.size());
        boolean found = false;
        for (Opositor opositor : registro.opositores()) {
            if (opositor.dni() == 12345679) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found, "No se ha encontrado el opositor añadido");
    }

    @Test
    public void testGetOpositor() {
        Assertions.assertEquals(10, registro.size());
        Opositor opositor = registro.getOpositor(12345678);
        Assertions.assertNotNull(opositor, "No se ha encontrado el opositor con DNI 12345678");
        Assertions.assertEquals("Max", opositor.nombre(), "El nombre del opositor con DNI 12345678 no es correcto");
        opositor = registro.getOpositor(12345679);
        Assertions.assertNotNull(opositor, "No se ha encontrado el opositor con DNI 12345679");
        Assertions.assertEquals("Lando", opositor.nombre(), "El nombre del opositor con DNI 12345679 no es correcto");
        opositor = registro.getOpositor(123);
        Assertions.assertNull(opositor, "Se ha encontrado un opositor con DNI 123");
    }

    @Test
    public void testGetMinNotaMedia() {
        Assertions.assertEquals(43.0 / 3.0, registro.getMinNotaMedia(), 0.01, "La nota media mínima no es correcta");
    }

    @Test
    public void testGetMaxNotaMedia() {
        Assertions.assertEquals(454.0 / 3.0, registro.getMaxNotaMedia(), 0.01, "La nota media máxima no es correcta");
    }

    @Test
    public void testOpositoresConPeorNota() {
        Iterable<Opositor> opositores = registro.OpositoresConPeorNota();
        Assertions.assertNotNull(opositores, "No se ha encontrado el opositor con peor nota");
        int count = 0;
        for (Opositor opositor : opositores) {
            Assertions.assertTrue(opositor.nombre().equals("Pierre") || opositor.nombre().equals("Fernando"), "El nombre del opositor con peor nota no es correcto");
            count++;
        }
        Assertions.assertEquals(2, count, "El número de opositores con peor nota no es correcto");
    }

    @Test
    public void testOpositoresConMejorNota() {
        Iterable<Opositor> opositores = registro.OpositoresConMejorNota();
        Assertions.assertNotNull(opositores, "No se ha encontrado el opositor con mejor nota");
        int count = 0;
        for (Opositor opositor : opositores) {
            Assertions.assertEquals("Max", opositor.nombre(), "El nombre del opositor con mejor nota no es correcto");
            count++;
        }
        Assertions.assertEquals(1, count, "El número de opositores con mejor nota no es correcto");
    }

    @Test
    public void testGetOpositoresConNotaMediaSuperiorA() {
        Iterable<Opositor> opositores = registro.getOpositoresConNotaMediaSuperiorA(293.0 / 3.0);
        int count = 0;
        for (Opositor opositor : opositores) {
            count++;
        }
        Assertions.assertEquals(5, count, "El número de opositores con nota media superior a (293.0 / 3.0) no es correcto");
    }

    @Test
    public void testGetOpositoresConNotaMediaInferiorA() {
        Iterable<Opositor> opositores = registro.getOpositoresConNotaMediaInferiorA(293.0 / 3.0);
        int count = 0;
        for (Opositor opositor : opositores) {
            count++;
        }
        Assertions.assertEquals(5, count, "El número de opositores con nota media inferior a (293.0 / 3.0) no es correcto");
    }

    @Test
    public void testGetOpositoresConNotaEnRango() {
        Iterable<Opositor> opositores = registro.getOpositoresConNotaMediaEnElRango(290.0 / 3.0, 295.0 / 3.0);
        int count = 0;
        for (Opositor opositor : opositores) {
            count++;
        }
        Assertions.assertEquals(2, count, "El número de opositores con nota media en el rango (290.0 / 3.0, 295.0 / 3.0) no es correcto");
    }
}
