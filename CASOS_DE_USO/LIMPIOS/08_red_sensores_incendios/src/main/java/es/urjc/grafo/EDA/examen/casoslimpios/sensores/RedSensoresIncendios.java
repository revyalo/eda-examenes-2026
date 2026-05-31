package es.urjc.grafo.EDA.examen.casoslimpios.sensores;

import java.time.LocalDateTime;

public class RedSensoresIncendios {

    // TODO: declara aqui los atributos privados que necesites.

    public RedSensoresIncendios() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addSensor(Sensor sensor) {
        // TODO: registrar sensor sin duplicados.
        throw new UnsupportedOperationException("TODO: addSensor");
    }

    public boolean connect(String a, String b) {
        // TODO: conectar dos sensores existentes.
        throw new UnsupportedOperationException("TODO: connect");
    }

    public boolean registrarAlerta(Alerta alerta) {
        // TODO: registrar alerta si no existe y su sensor existe.
        throw new UnsupportedOperationException("TODO: registrarAlerta");
    }

    public Iterable<Sensor> sensoresAlcanzables(String origen, int saltos) {
        // TODO: devolver sensores alcanzables con distancia <= saltos.
        throw new UnsupportedOperationException("TODO: sensoresAlcanzables");
    }

    public int borrarAlertasAntiguas(LocalDateTime fecha) {
        // TODO: borrar alertas con fecha <= fecha.
        throw new UnsupportedOperationException("TODO: borrarAlertasAntiguas");
    }

    public Sensor sensorCentral() {
        // TODO: devolver sensor con menor distancia maxima al resto; null si no conexa.
        throw new UnsupportedOperationException("TODO: sensorCentral");
    }
}
