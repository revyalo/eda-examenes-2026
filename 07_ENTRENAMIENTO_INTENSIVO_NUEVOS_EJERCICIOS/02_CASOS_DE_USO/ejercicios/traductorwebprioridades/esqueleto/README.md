# Traductor web con prioridades

        ## Estructuras del esqueleto

        - `HashMap<String, HashMap<String, String>> traducciones`
- `HashMap<String, HashSet<String>> palabrasPorIdioma`
- `TreeSet<EntradaDiccionario> entradasOrdenadas`
- `PriorityQueue<SolicitudTraduccion> solicitudesPendientes`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/TraductorWebPrioridades.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/TraductorWebPrioridadesTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
