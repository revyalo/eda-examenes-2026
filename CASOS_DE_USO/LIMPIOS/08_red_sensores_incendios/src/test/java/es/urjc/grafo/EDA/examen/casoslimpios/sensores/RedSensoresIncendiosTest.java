package es.urjc.grafo.EDA.examen.casoslimpios.sensores;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedSensoresIncendiosTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void redAlertasYCentralidad() {
        RedSensoresIncendios red = new RedSensoresIncendios();
        red.addSensor(new Sensor("S1", "Norte", 1));
        red.addSensor(new Sensor("S2", "Norte", 2));
        red.addSensor(new Sensor("S3", "Sur", 3));
        red.connect("S1", "S2");
        red.connect("S2", "S3");
        assertEquals(2, toList(red.sensoresAlcanzables("S1", 1)).size());
        assertEquals("S2", red.sensorCentral().id());

        LocalDateTime fecha = LocalDateTime.of(2026, 1, 1, 10, 0);
        red.registrarAlerta(new Alerta("A1", "S1", fecha, 5, "Norte"));
        assertEquals(1, red.borrarAlertasAntiguas(fecha));
    }
}
