# Synthetic Intel: red de modelos de IA

            - Tipo: caso de uso
            - Clase de esqueleto: `02_CASOS_DE_USO/proyecto_casos_de_uso/src/main/java/es/urjc/grafo/EDA/examen/casos/SyntheticIntelModelos.java`
            - Estructuras permitidas/principales:

            - `HashMap<String, ModeloIA> modelos`
- `HashMap<String, HashSet<String>> dependencias`
- `HashMap<String, HashSet<String>> modelosPorEmpresa`
- `TreeSet<ModeloIA> rankingPrecision`
- `TreeMap<Double, HashSet<String>> modelosPorPrecision`

            ## Enunciado

            Implementa el gestor del dominio usando las estructuras indicadas. No uses una clase `Graph`; las relaciones deben representarse con `HashMap` y `HashSet` cuando el caso sea una red.

            ## Métodos que debe completar el alumno

            - `addModelo`
- `addDependencia`
- `dependeDirectamente`
- `dependeIndirectamente`
- `topModelos`
- `modelosEntrePrecision`

            ## Criterios esperados

            - Mantener todos los índices sincronizados.
            - No admitir duplicados cuando el identificador ya exista.
            - Actualizar correctamente `TreeSet` y `PriorityQueue` cuando cambia el atributo que ordena.
            - Resolver consultas por rango con `TreeMap`.
            - Usar BFS manual sobre `HashMap<String, HashSet<String>>` cuando haya relaciones de red.
