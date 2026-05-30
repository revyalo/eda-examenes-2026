# Hospital limpio: triaje y especialidades

        ## Objetivo

        PriorityQueue, indices por SIP, especialidad y llegada.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<String, Paciente> para pacientes`
- `HashMap<String, HashSet<String>> para especialidades`
- `TreeMap<LocalDateTime, HashSet<String>> para llegadas`
- `PriorityQueue<Paciente> para triaje`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
