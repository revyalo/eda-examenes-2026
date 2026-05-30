# Registro CNP limpio: opositores, ranking y rangos

        ## Objetivo

        Mapas por DNI, ranking por nota, indices por provincia y consultas por rango.

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/es/urjc/grafo/EDA/examen/casoslimpios`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        - `HashMap<String, Opositor> para DNI`
- `HashMap<String, HashSet<String>> para provincia`
- `TreeMap<Double, HashSet<String>> para nota media`
- `TreeSet<Opositor> para ranking`

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
