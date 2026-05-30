# URJCNetServices limpio: routers, mensajes y TTL

        ## Objetivo

        Grafo manual con routers, mensajes por fecha y consultas por distancia.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<String, Router> para buscar routers por id`
- `HashMap<String, HashSet<String>> para conexiones no dirigidas`
- `HashMap<String, Mensaje> para mensajes por id`
- `TreeMap<LocalDateTime, HashSet<String>> para mensajes por fecha`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
