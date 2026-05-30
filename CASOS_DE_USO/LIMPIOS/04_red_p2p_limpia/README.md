# Red P2P limpia: nodos, conexiones y archivos

        ## Objetivo

        Grafo manual con indices directos e inversos de archivos.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<String, Nodo> para nodos`
- `HashMap<String, HashSet<String>> para conexiones`
- `HashMap<String, HashSet<String>> para archivos por nodo`
- `HashMap<String, HashSet<String>> para nodos por archivo`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
