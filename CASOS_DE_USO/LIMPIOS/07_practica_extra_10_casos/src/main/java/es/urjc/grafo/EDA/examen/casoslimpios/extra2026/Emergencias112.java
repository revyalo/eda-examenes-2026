package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public class Emergencias112 {

    // TODO: declara aqui los atributos privados que necesites.

    public Emergencias112() {
        // TODO: inicializa tus estructuras.
    }

    public boolean registrarIncidencia(Incidencia incidencia) {
        // TODO: registrar incidencia sin duplicados.
        throw new UnsupportedOperationException("TODO: registrarIncidencia");
    }

    public Incidencia atenderSiguiente() {
        // TODO: devolver y eliminar la incidencia mas urgente.
        throw new UnsupportedOperationException("TODO: atenderSiguiente");
    }

    public boolean cancelarIncidencia(String codigo) {
        // TODO: cancelar una incidencia pendiente.
        throw new UnsupportedOperationException("TODO: cancelarIncidencia");
    }

    public Iterable<Incidencia> incidenciasAntesDe(LocalDateTime fecha) {
        // TODO: devolver incidencias con hora anterior o igual.
        throw new UnsupportedOperationException("TODO: incidenciasAntesDe");
    }

    public String municipioConMasIncidencias() {
        // TODO: devolver el municipio con mas incidencias activas.
        throw new UnsupportedOperationException("TODO: municipioConMasIncidencias");
    }
}
