# URJCFlights limpio: vuelos dirigidos y escalas

        ## Objetivo

        Grafo dirigido con vuelos por codigo y por fecha.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<String, Aeropuerto> para aeropuertos`
- `HashMap<String, Vuelo> para vuelos`
- `HashMap<String, HashSet<String>> para salidas`
- `HashMap<String, HashSet<String>> para entradas`
- `TreeMap<LocalDateTime, HashSet<String>> para fechas`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
