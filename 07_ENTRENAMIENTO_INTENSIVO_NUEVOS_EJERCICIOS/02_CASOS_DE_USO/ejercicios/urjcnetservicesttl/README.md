# URJCNetServices 2: red de routers con TTL

            - Tipo: caso de uso
            - Clase de esqueleto: `02_CASOS_DE_USO/proyecto_casos_de_uso/src/main/java/es/urjc/grafo/EDA/examen/casos/URJCNetServicesTTL.java`
            - Estructuras permitidas/principales:

            - `HashMap<String, Router> routers`
- `HashMap<String, HashSet<String>> conexiones`
- `HashMap<String, Mensaje> mensajes`
- `TreeMap<LocalDateTime, HashSet<String>> mensajesPorFecha`

            ## Enunciado

            Implementa el gestor del dominio usando las estructuras indicadas. No uses una clase `Graph`; las relaciones deben representarse con `HashMap` y `HashSet` cuando el caso sea una red.

            ## Métodos que debe completar el alumno

            - `addRouter`
- `addConnection`
- `recibirMensaje`
- `routersAlcanzables`
- `borrarMensajesAntiguos`
- `routerMasConectado`

            ## Criterios esperados

            - Mantener todos los índices sincronizados.
            - No admitir duplicados cuando el identificador ya exista.
            - Actualizar correctamente `TreeSet` y `PriorityQueue` cuando cambia el atributo que ordena.
            - Resolver consultas por rango con `TreeMap`.
            - Usar BFS manual sobre `HashMap<String, HashSet<String>>` cuando haya relaciones de red.
