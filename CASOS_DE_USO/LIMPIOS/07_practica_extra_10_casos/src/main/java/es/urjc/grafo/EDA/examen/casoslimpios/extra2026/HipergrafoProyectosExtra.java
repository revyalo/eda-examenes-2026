package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

public class HipergrafoProyectosExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public HipergrafoProyectosExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addProyecto(Proyecto proyecto) {
        // TODO: registrar proyecto.
        throw new UnsupportedOperationException("TODO: addProyecto");
    }

    public boolean addParticipante(Participante participante) {
        // TODO: registrar participante.
        throw new UnsupportedOperationException("TODO: addParticipante");
    }

    public boolean asignar(String participante, String proyecto) {
        // TODO: relacionar participante y proyecto.
        throw new UnsupportedOperationException("TODO: asignar");
    }

    public Iterable<Participante> participantesRelacionados(String participante) {
        // TODO: participantes que comparten al menos un proyecto.
        throw new UnsupportedOperationException("TODO: participantesRelacionados");
    }

    public Iterable<Proyecto> proyectosComunes(String p1, String p2) {
        // TODO: proyectos en los que participan ambos.
        throw new UnsupportedOperationException("TODO: proyectosComunes");
    }

    public Iterable<Participante> grupoExpandido(String participante, int saltos) {
        // TODO: expansion alternando participante-proyecto hasta saltos.
        throw new UnsupportedOperationException("TODO: grupoExpandido");
    }
}
