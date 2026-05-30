package es.urjc.grafo.EDA.examen.casoslimpios;

    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class RegistroCNPLimpio {

        // TODO: declara aqui los atributos privados que necesites.
        // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
        // Estructuras recomendadas para este caso:
        // - HashMap<String, Opositor>
// - HashMap<String, HashSet<String>>
// - TreeMap<Double, HashSet<String>>
// - TreeSet<Opositor>

        public RegistroCNPLimpio() {
            // TODO: inicializa aqui tus estructuras cuando las declares.
        }


            public boolean addOpositor(Opositor opositor) {
                // TODO: insertar si no existe DNI y actualizar indices.
                throw new UnsupportedOperationException("TODO: addOpositor");
            }

            public Opositor getOpositor(String dni) {
                // TODO: buscar por DNI.
                throw new UnsupportedOperationException("TODO: getOpositor");
            }

            public boolean actualizarNotas(String dni, Notas notas) {
                // TODO: actualizar notas y reindexar ranking/rango.
                throw new UnsupportedOperationException("TODO: actualizarNotas");
            }

            public Iterable<Opositor> aptosPorProvincia(String provincia, double notaMinima) {
                // TODO: filtrar opositores de una provincia con media >= notaMinima.
                throw new UnsupportedOperationException("TODO: aptosPorProvincia");
            }

            public Iterable<Opositor> opositoresEntreNotas(double min, double max) {
                // TODO: devolver opositores con media en [min, max].
                throw new UnsupportedOperationException("TODO: opositoresEntreNotas");
            }

            public Iterable<Opositor> top(int n) {
                // TODO: devolver los n mejores por nota media, desempate por DNI.
                throw new UnsupportedOperationException("TODO: top");
            }

    }
