# Red P2P con busqueda de archivos

            - Tipo: caso de uso
            - Clase de esqueleto: `02_CASOS_DE_USO/proyecto_casos_de_uso/src/main/java/es/urjc/grafo/EDA/examen/casos/RedP2PBusquedaArchivos.java`
            - Estructuras permitidas/principales:

            - `HashMap<String, Nodo> nodos`
- `HashMap<String, HashSet<String>> conexiones`
- `HashMap<String, HashSet<String>> archivosPorNodo`
- `HashMap<String, HashSet<String>> nodosPorArchivo`

            ## Enunciado

            Implementa el gestor del dominio usando las estructuras indicadas. No uses una clase `Graph`; las relaciones deben representarse con `HashMap` y `HashSet` cuando el caso sea una red.

            ## Métodos que debe completar el alumno

            - `addNode`
- `addConnection`
- `addFile`
- `buscarArchivo`
- `nodosConArchivo`
- `nodoMasCompartidor`

            ## Criterios esperados

            - Mantener todos los índices sincronizados.
            - No admitir duplicados cuando el identificador ya exista.
            - Actualizar correctamente `TreeSet` y `PriorityQueue` cuando cambia el atributo que ordena.
            - Resolver consultas por rango con `TreeMap`.
            - Usar BFS manual sobre `HashMap<String, HashSet<String>>` cuando haya relaciones de red.
