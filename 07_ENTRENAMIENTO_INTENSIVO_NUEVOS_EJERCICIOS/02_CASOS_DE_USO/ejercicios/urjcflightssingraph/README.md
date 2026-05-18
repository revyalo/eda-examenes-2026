# URJCFlights sin Graph

            - Tipo: caso de uso
            - Clase de esqueleto: `02_CASOS_DE_USO/proyecto_casos_de_uso/src/main/java/es/urjc/grafo/EDA/examen/casos/URJCFlightsSinGraph.java`
            - Estructuras permitidas/principales:

            - `HashMap<String, Aeropuerto> aeropuertos`
- `HashMap<String, HashSet<String>> vuelosSalientes`
- `HashMap<String, HashSet<String>> vuelosEntrantes`
- `TreeMap<LocalDateTime, HashSet<String>> vuelosPorHora`
- `HashMap<String, Vuelo> vuelosPorCodigo`

            ## Enunciado

            Implementa el gestor del dominio usando las estructuras indicadas. No uses una clase `Graph`; las relaciones deben representarse con `HashMap` y `HashSet` cuando el caso sea una red.

            ## Métodos que debe completar el alumno

            - `addAirport`
- `addFlight`
- `hayVueloDirecto`
- `hayConexionConEscalas`
- `vuelosEntreFechas`
- `aeropuertoConMasSalidas`

            ## Criterios esperados

            - Mantener todos los índices sincronizados.
            - No admitir duplicados cuando el identificador ya exista.
            - Actualizar correctamente `TreeSet` y `PriorityQueue` cuando cambia el atributo que ordena.
            - Resolver consultas por rango con `TreeMap`.
            - Usar BFS manual sobre `HashMap<String, HashSet<String>>` cuando haya relaciones de red.
