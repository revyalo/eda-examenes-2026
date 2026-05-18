package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class HospitalTriajeEspecialidades {

        private final HashMap<String, Paciente> pacientes = new HashMap<>();
private final HashMap<String, HashSet<String>> pacientesPorEspecialidad = new HashMap<>();
private final PriorityQueue<Paciente> colaTriaje = new PriorityQueue<>();
private final TreeMap<LocalDateTime, HashSet<String>> pacientesPorLlegada = new TreeMap<>();


    public record Paciente(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Paciente> {
        @Override
        public int compareTo(Paciente other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Double.compare(other.valor, this.valor);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }



    public void registrarPaciente(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar registrarPaciente - Hospital con triaje y especialidades");
    }


public String siguientePaciente(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar siguientePaciente - Hospital con triaje y especialidades");
}


public Iterable<String> pacientesEspecialidad(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar pacientesEspecialidad - Hospital con triaje y especialidades");
}


public Iterable<String> pacientesAntesDe(LocalDateTime fecha) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar pacientesAntesDe - Hospital con triaje y especialidades");
}


    public void cambiarPrioridad(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar cambiarPrioridad - Hospital con triaje y especialidades");
    }


    public void altaPaciente(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar altaPaciente - Hospital con triaje y especialidades");
    }

    }
