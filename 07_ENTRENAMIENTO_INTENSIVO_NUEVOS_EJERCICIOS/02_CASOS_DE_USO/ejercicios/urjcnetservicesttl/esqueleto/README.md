# URJCNetServices 2: red de routers con TTL

        ## Estructuras del esqueleto

        - `HashMap<String, Router> routers`
- `HashMap<String, HashSet<String>> conexiones`
- `HashMap<String, Mensaje> mensajes`
- `TreeMap<LocalDateTime, HashSet<String>> mensajesPorFecha`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/URJCNetServicesTTL.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/URJCNetServicesTTLTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
