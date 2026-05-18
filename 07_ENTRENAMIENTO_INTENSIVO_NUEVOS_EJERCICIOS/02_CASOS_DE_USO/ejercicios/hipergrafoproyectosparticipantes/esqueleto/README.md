# Hipergrafo de proyectos y participantes usando solo mapas

        ## Estructuras del esqueleto

        - `HashMap<String, Proyecto> proyectos`
- `HashMap<String, Participante> participantes`
- `HashMap<String, HashSet<String>> participantesPorProyecto`
- `HashMap<String, HashSet<String>> proyectosPorParticipante`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/HipergrafoProyectosParticipantes.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/HipergrafoProyectosParticipantesTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
