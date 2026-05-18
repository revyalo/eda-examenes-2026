# URJCFlights sin Graph

        ## Estructuras del esqueleto

        - `HashMap<String, Aeropuerto> aeropuertos`
- `HashMap<String, HashSet<String>> vuelosSalientes`
- `HashMap<String, HashSet<String>> vuelosEntrantes`
- `TreeMap<LocalDateTime, HashSet<String>> vuelosPorHora`
- `HashMap<String, Vuelo> vuelosPorCodigo`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/URJCFlightsSinGraph.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/URJCFlightsSinGraphTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
