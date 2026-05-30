# CNI limpio: contactos indirectos

        ## Objetivo

        Grafo manual de personas, contactos por fecha/minutos y BFS limitado.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<Integer, Agente> para agentes`
- `HashMap<Integer, HashSet<Integer>> para contactos`
- `TreeMap<LocalDate, HashSet<Contacto>> para fechas`
- `HashSet<Integer> para visitados en BFS`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
