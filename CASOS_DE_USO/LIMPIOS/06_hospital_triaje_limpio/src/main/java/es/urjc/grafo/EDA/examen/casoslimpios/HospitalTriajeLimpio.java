package es.urjc.grafo.EDA.examen.casoslimpios;

    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class HospitalTriajeLimpio {

        // TODO: declara aqui los atributos privados que necesites.
        // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
        // Estructuras recomendadas para este caso:
        // - HashMap<String, Paciente>
// - HashMap<String, HashSet<String>>
// - TreeMap<LocalDateTime, HashSet<String>>
// - PriorityQueue<Paciente>

        public HospitalTriajeLimpio() {
            // TODO: inicializa aqui tus estructuras cuando las declares.
        }


            public boolean registrarPaciente(Paciente paciente) {
                // TODO: registrar paciente e indices.
                throw new UnsupportedOperationException("TODO: registrarPaciente");
            }

            public Paciente siguientePaciente() {
                // TODO: devolver y eliminar el paciente mas grave; desempate por llegada.
                throw new UnsupportedOperationException("TODO: siguientePaciente");
            }

            public boolean cambiarGravedad(String sip, int nuevaGravedad) {
                // TODO: actualizar prioridad y reinsertar en la cola si procede.
                throw new UnsupportedOperationException("TODO: cambiarGravedad");
            }

            public Iterable<Paciente> pacientesEspecialidad(String especialidad) {
                // TODO: devolver pacientes de una especialidad.
                throw new UnsupportedOperationException("TODO: pacientesEspecialidad");
            }

            public Iterable<Paciente> pacientesAntesDe(LocalDateTime fecha) {
                // TODO: devolver pacientes con llegada anterior o igual.
                throw new UnsupportedOperationException("TODO: pacientesAntesDe");
            }

            public boolean altaPaciente(String sip) {
                // TODO: eliminar paciente de todos los indices.
                throw new UnsupportedOperationException("TODO: altaPaciente");
            }

    }
