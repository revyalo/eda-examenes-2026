# CNI: detector de contactos indirectos

        ## Estructuras del esqueleto

        - `HashMap<String, Agente> agentes`
- `HashMap<String, HashSet<String>> contactos`
- `HashMap<String, HashSet<String>> contactosPorZona`
- `TreeMap<LocalDateTime, HashSet<String>> interaccionesPorFecha`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/CNIContactosIndirectos.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/CNIContactosIndirectosTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
