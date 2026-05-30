# Plantilla mental para casos de uso

| Necesidad | Estructura |
|---|---|
| Buscar por ID, DNI, matrícula, código | `HashMap<K,V>` |
| Evitar duplicados | `HashSet<E>` |
| Mantener orden por fecha, nota, precio, distancia | `TreeMap<K,V>` |
| Mantener ranking de objetos | `TreeSet<E>` |
| Sacar siempre el más urgente/prioritario | `PriorityQueue<E>` |

## Grafo no dirigido con mapas

```java
HashMap<String, Objeto> objetos = new HashMap<>();
HashMap<String, HashSet<String>> adyacencias = new HashMap<>();
```

## Grafo dirigido con mapas

```java
HashMap<String, HashSet<String>> salientes = new HashMap<>();
HashMap<String, HashSet<String>> entrantes = new HashMap<>();
```

## Índice secundario

```java
HashMap<String, HashSet<String>> idsPorCategoria = new HashMap<>();
TreeMap<LocalDateTime, HashSet<String>> idsPorFecha = new TreeMap<>();
```

Recuerda: si cambias un campo que participa en `TreeSet` o `PriorityQueue`, normalmente tienes que quitar y volver a insertar el objeto.
