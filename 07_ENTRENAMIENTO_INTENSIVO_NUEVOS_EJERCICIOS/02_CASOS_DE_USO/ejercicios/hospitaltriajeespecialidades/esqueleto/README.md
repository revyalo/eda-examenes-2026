# Hospital con triaje y especialidades

        ## Estructuras del esqueleto

        - `HashMap<String, Paciente> pacientes`
- `HashMap<String, HashSet<String>> pacientesPorEspecialidad`
- `PriorityQueue<Paciente> colaTriaje`
- `TreeMap<LocalDateTime, HashSet<String>> pacientesPorLlegada`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/HospitalTriajeEspecialidades.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/HospitalTriajeEspecialidadesTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
