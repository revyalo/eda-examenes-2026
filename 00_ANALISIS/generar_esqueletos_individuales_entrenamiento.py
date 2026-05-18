from __future__ import annotations

import runpy
import shutil
import textwrap
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
BASE = ROOT / "Esqueletos" / "Implementación - Esqueleto"
TRAINING = ROOT / "EDA_Examenes_2026" / "07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS"
GEN = ROOT / "EDA_Examenes_2026" / "00_ANALISIS" / "generar_entrenamiento_nuevos_ejercicios.py"

data = runpy.run_path(str(GEN))
IMPLEMENTATION_GROUPS = data["IMPLEMENTATION_GROUPS"]
CASE_USE_EXERCISES = data["CASE_USE_EXERCISES"]
graph_method = data["graph_method"]
tree_method = data["tree_method"]
ordered_method = data["ordered_method"]
case_method = data["case_method"]
collection_init = data["collection_init"]
domain_types_for = data["domain_types_for"]
domain_record = data["domain_record"]
method_return = data["method_return"]
slug = data["slug"]


def sample_case_call(method: str) -> str:
    if method in {"addConnection", "connect", "seguir", "dejarDeSeguir", "addDependencia", "asignar", "registrarAlergia"}:
        return f'{method}("A", "B")'
    if method == "registrarContacto":
        return f'{method}("A", "B", java.time.LocalDateTime.now())'
    if method == "addTraduccion":
        return f'{method}("es", "hola", "hello")'
    if method == "registrarResultado":
        return f'{method}("A", "B", 1, 0)'
    if method in {"routersAlcanzables", "estacionesAlcanzables", "buscarArchivo", "propagar", "grupoExpandido", "hayConexionConEscalas"}:
        return f'{method}("A", 1)'
    if method in {"borrarMensajesAntiguos", "interaccionesAntesDe", "vuelosEntreFechas", "pacientesAntesDe"}:
        return f"{method}(java.time.LocalDateTime.now())"
    if method in {"habitantesEntreEdades", "equiposConPuntosEntre"}:
        return f"{method}(1, 5)"
    if method in {"opositoresEntreNotas"}:
        return f"{method}(1.0, 10.0)"
    if method in {"actualizarNota", "modelosEntrePrecision"}:
        return f'{method}("A", 1.0)'
    if method in {"palabrasEntre"}:
        return f'{method}("a", "z")'
    if method.startswith("top"):
        return f"{method}(1)"
    return f'{method}("A")'


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def copy_base(project: Path, include_env: bool) -> None:
    if project.exists():
        shutil.rmtree(project)
    project.mkdir(parents=True, exist_ok=True)
    shutil.copy2(BASE / "pom.xml", project / "pom.xml")
    if not include_env:
        return
    src = BASE / "src/main/java/es/urjc/grafo/EDA"
    dst = project / "src/main/java/es/urjc/grafo/EDA"
    for child in src.iterdir():
        if child.name == "examen":
            continue
        shutil.copytree(
            child,
            dst / child.name,
            ignore=shutil.ignore_patterns(".DS_Store", "target", "out", ".idea"),
            dirs_exist_ok=True,
        )


def class_for_group(group: str, exercise: str) -> str:
    if group == "grafos_prioritarios":
        return "GraphOperationsTraining"
    if group == "grafos_avanzados":
        return "GraphAdvancedOperationsTraining"
    if group == "arboles_binarios_y_generales":
        return "TreeOperationsTraining"
    if group == "abb_avl_diccionarios":
        return "OrderedStructuresTraining"
    return exercise


def build_individual_implementation(group: str, name: str, structure: str, difficulty: str, idea: str) -> None:
    folder = TRAINING / "01_IMPLEMENTACION_PURA" / "ejercicios" / group / slug(name)
    project = folder / "esqueleto"
    copy_base(project, include_env=True)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen"
    class_name = class_for_group(group, name)

    if group == "grafos_prioritarios":
        source = graph_class_source(class_name, graph_method(name), advanced=False)
    elif group == "grafos_avanzados":
        source = graph_class_source(class_name, graph_method(name), advanced=True)
    elif group == "arboles_binarios_y_generales":
        source = tree_class_source(class_name, tree_method(name))
    elif group == "abb_avl_diccionarios":
        source = ordered_class_source(class_name, ordered_method(name))
    else:
        source = iterator_class_source(class_name)

    write(main / f"{class_name}.java", source)
    write(test / f"{class_name}Test.java", implementation_test_source(group, name, class_name))
    write(project / "README.md", f"""
        # {name}

        - Tipo: implementacion pura
        - Estructura: {structure}
        - Dificultad: {difficulty}

        ## Enunciado

        {idea}

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/{class_name}.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/{class_name}Test.java`

        Completa el TODO sin cambiar firmas publicas.
    """)


def graph_class_source(class_name: str, method_code: str, advanced: bool) -> str:
    extra = "import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;" if advanced else ""
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Edge;
        import es.urjc.grafo.EDA.graphs.Vertex;
        {extra}

        import java.util.Map;

        public class {class_name} {{
        {method_code}
        }}
    """


def tree_class_source(class_name: str, method_code: str) -> str:
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Comparator;
        import java.util.Map;

        public class {class_name} {{
        {method_code}
        }}
    """


def ordered_class_source(class_name: str, method_code: str) -> str:
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        public class {class_name}<K extends Comparable<K>, V> {{
        {method_code}
        }}
    """


def iterator_class_source(class_name: str) -> str:
    constructor = "BinaryTree<E> tree"
    fields = "private final BinaryTree<E> tree;"
    assign = "this.tree = tree;"
    if class_name == "LevelLimitedIterator":
        constructor = "BinaryTree<E> tree, int maxLevel"
        fields += "\n    private final int maxLevel;"
        assign += "\n        this.maxLevel = maxLevel;"
    elif class_name == "BetweenLevelsIterator":
        constructor = "BinaryTree<E> tree, int minLevel, int maxLevel"
        fields += "\n    private final int minLevel;\n    private final int maxLevel;"
        assign += "\n        this.minLevel = minLevel;\n        this.maxLevel = maxLevel;"
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Iterator;

        public class {class_name}<E> implements Iterator<Position<E>> {{

            {fields}

            public {class_name}({constructor}) {{
                {assign}
            }}

            @Override
            public boolean hasNext() {{
                // TODO: preparar y consultar el siguiente nodo valido.
                throw new UnsupportedOperationException("TODO: hasNext en {class_name}");
            }}

            @Override
            public Position<E> next() {{
                // TODO: devolver el siguiente nodo segun el recorrido indicado.
                throw new UnsupportedOperationException("TODO: next en {class_name}");
            }}

            @Override
            public void remove() {{
                // TODO: eliminar el ultimo nodo devuelto cuando el ejercicio lo pida.
                throw new UnsupportedOperationException("TODO: remove en {class_name}");
            }}
        }}
    """


def implementation_test_source(group: str, name: str, class_name: str) -> str:
    if group.startswith("grafos"):
        return graph_test_source(name, class_name)
    if group == "arboles_binarios_y_generales":
        return tree_test_source(name, class_name)
    if group == "abb_avl_diccionarios":
        return ordered_test_source(name, class_name)
    return iterator_test_source(name, class_name)


def graph_test_source(name: str, class_name: str) -> str:
    assertion = {
        "shortestDistanceLessOrEqual": f"assertEquals(2, {class_name}.shortestDistanceLessOrEqual(graph, a, c, 2));",
        "verticesAtDistanceK": f"assertNotNull({class_name}.verticesAtDistanceK(graph, a, 2));",
        "verticesWithinDistanceK": f"assertNotNull({class_name}.verticesWithinDistanceK(graph, a, 2));",
        "graphSquareWithoutDuplicates": f"assertNotNull({class_name}.graphSquareWithoutDuplicates(graph));",
        "limitedBFSPath": f"assertNotNull({class_name}.limitedBFSPath(graph, a, c, 2));",
        "isConnectedWithLimit": f"assertTrue({class_name}.isConnectedWithLimit(graph, 2));",
        "eccentricity": f"assertEquals(2, {class_name}.eccentricity(graph, a));",
        "graphDiameter": f"assertEquals(2, {class_name}.graphDiameter(graph));",
        "centralVertex": f"assertNotNull({class_name}.centralVertex(graph));",
        "isTreeGraph": f"assertTrue({class_name}.isTreeGraph(graph));",
        "hasCycleUndirected": f"assertFalse({class_name}.hasCycleUndirected(graph));",
        "connectedComponents": f"assertEquals(1, {class_name}.connectedComponents(graph));",
        "largestConnectedComponentSize": f"assertEquals(3, {class_name}.largestConnectedComponentSize(graph));",
        "removeIsolatedVertices": f"assertEquals(0, {class_name}.removeIsolatedVertices(graph));",
        "complementaryIfConnected": f"assertNotNull({class_name}.complementaryIfConnected(graph));",
        "kClosure": f"assertNotNull({class_name}.kClosure(graph, 2));",
        "minimumBroadcastRoot": f"assertNotNull({class_name}.minimumBroadcastRoot(graph));",
        "broadcastTreeFrom": f"assertNotNull({class_name}.broadcastTreeFrom(graph, a));",
        "sameConnectedComponent": f"assertTrue({class_name}.sameConnectedComponent(graph, a, c));",
        "bridgesSimpleVersion": f"assertNotNull({class_name}.bridgesSimpleVersion(graph));",
        "isBipartite": f"assertTrue({class_name}.isBipartite(graph));",
        "distanceMapFromVertex": f"assertNotNull({class_name}.distanceMapFromVertex(graph, a));",
        "reachableIgnoringVertex": f"assertFalse({class_name}.reachableIgnoringVertex(graph, a, c, b));",
        "countShortestPaths": f"assertEquals(1, {class_name}.countShortestPaths(graph, a, c));",
        "graphPowerEdgesCount": f"assertEquals(3, {class_name}.graphPowerEdgesCount(graph, 2));",
    }[name]
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            @Test
            void {name}DebeImplementarse() {{
                AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
                Vertex<String> a = graph.insertVertex("A");
                Vertex<String> b = graph.insertVertex("B");
                Vertex<String> c = graph.insertVertex("C");
                graph.insertEdge(a, b, 1);
                graph.insertEdge(b, c, 1);

                {assertion}
            }}
        }}
    """


def tree_test_source(name: str, class_name: str) -> str:
    assertion = {
        "isAlmostComplete": f"assertTrue({class_name}.isAlmostComplete(binary));",
        "isMinHeap": f"assertTrue({class_name}.isMinHeap(binary, Integer::compareTo));",
        "isHeap": f"assertTrue({class_name}.isHeap(binary, Integer::compareTo));",
        "heapDegreeViolation": f"assertNull({class_name}.heapDegreeViolation(binary, Integer::compareTo));",
        "lastNodeInLevelOrder": f"assertNotNull({class_name}.lastNodeInLevelOrder(binary));",
        "isCompleteUntilLevel": f"assertTrue({class_name}.isCompleteUntilLevel(binary));",
        "width": f"assertEquals(2, {class_name}.width(binary));",
        "levelWithMoreNodes": f"assertEquals(1, {class_name}.levelWithMoreNodes(binary));",
        "areCousins": f"assertFalse({class_name}.areCousins(binary, left, right));",
        "lowestCommonAncestor": f"assertEquals(root, {class_name}.lowestCommonAncestor(binary, left, right));",
        "isBalanced": f"assertTrue({class_name}.isBalanced(binary));",
        "diameter": f"assertEquals(2, {class_name}.diameter(binary));",
        "removeLeaves": f"assertEquals(2, {class_name}.removeLeaves(general));",
        "pruneBelowDepth": f"assertEquals(2, {class_name}.pruneBelowDepth(general, 0));",
        "mirrorCopy": f"assertNotNull({class_name}.mirrorCopy(binary));",
        "isMirrorOf": f"assertTrue({class_name}.isMirrorOf(binary, binary));",
        "hasSameShape": f"assertTrue({class_name}.hasSameShape(binary, binary));",
        "areIdenticalIgnoringLeaves": f"assertTrue({class_name}.areIdenticalIgnoringLeaves(binary, binary));",
        "descendantsAtDistanceK": f"assertNotNull({class_name}.descendantsAtDistanceK(general, general.root(), 1));",
        "degreeDistribution": f"assertNotNull({class_name}.degreeDistribution(general));",
    }[name]
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            @Test
            void {name}DebeImplementarse() {{
                LinkedBinaryTree<Integer> binary = new LinkedBinaryTree<>();
                Position<Integer> root = binary.addRoot(1);
                Position<Integer> left = binary.insertLeft(root, 2);
                Position<Integer> right = binary.insertRight(root, 2);

                LinkedTree<Integer> general = new LinkedTree<>();
                Position<Integer> gRoot = general.addRoot(1);
                general.add(2, gRoot);
                general.add(3, gRoot);

                {assertion}
            }}
        }}
    """


def ordered_test_source(name: str, class_name: str) -> str:
    assertion = {
        "rangeCount": f"assertEquals(0, training.rangeCount(1, 5));",
        "removeRange": f"assertEquals(0, training.removeRange(1, 5));",
        "floor": f"assertNull(training.floor(5));",
        "ceiling": f"assertNull(training.ceiling(5));",
        "predecessor": f"assertNull(training.predecessor(5));",
        "successor": f"assertNull(training.successor(5));",
        "kSmallest": f"assertNotNull(training.kSmallest(2));",
        "isBST": f"assertTrue({class_name}.isBST(tree));",
        "mergeWithoutDuplicates": f"assertDoesNotThrow(() -> training.mergeWithoutDuplicates(new {class_name}<>()));",
        "splitByKey": f"assertNotNull(training.splitByKey(5));",
        "heightIfInserted": f"assertEquals(0, training.heightIfInserted(5));",
        "countRepeatedKeys": f"assertEquals(0, training.countRepeatedKeys(5));",
        "findAllInRange": f"assertNotNull(training.findAllInRange(1, 5));",
        "isAVL": f"assertTrue({class_name}.isAVL(tree));",
        "firstUnbalancedNode": f"assertNull({class_name}.firstUnbalancedNode(tree));",
    }[name]
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            @Test
            void {name}DebeImplementarse() {{
                {class_name}<Integer, String> training = new {class_name}<>();
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                tree.addRoot(1);

                {assertion}
            }}
        }}
    """


def iterator_test_source(name: str, class_name: str) -> str:
    if class_name == "LevelLimitedIterator":
        construction = f"new {class_name}<>(tree, 2)"
    elif class_name == "BetweenLevelsIterator":
        construction = f"new {class_name}<>(tree, 0, 2)"
    else:
        construction = f"new {class_name}<>(tree)"
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            @Test
            void {name}DebeImplementarse() {{
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                {class_name}<Integer> iterator = {construction};
                assertFalse(iterator.hasNext());
            }}
        }}
    """


def build_individual_case(class_name: str, title: str, structures: list[str], methods: list[str]) -> None:
    folder = TRAINING / "02_CASOS_DE_USO" / "ejercicios" / slug(class_name)
    project = folder / "esqueleto"
    copy_base(project, include_env=False)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen/casos"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen/casos"
    fields = "\n".join("    private final " + s + " = new " + collection_init(s) + ";" for s in structures)
    records = "\n\n".join(domain_record(t) for t in domain_types_for(structures))
    methods_code = "\n".join(case_method(m, title) for m in methods)
    write(main / f"{class_name}.java", f"""
        package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class {class_name} {{

        {fields}

        {records}

        {methods_code}
        }}
    """)
    test_methods = "\n\n".join(case_test_method(class_name, method) for method in methods)
    write(test / f"{class_name}Test.java", f"""
        package es.urjc.grafo.EDA.examen.casos;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

        {test_methods}
        }}
    """)
    write(project / "README.md", f"""
        # {title}

        ## Estructuras del esqueleto

        {chr(10).join("- `" + s + "`" for s in structures)}

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/{class_name}.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/{class_name}Test.java`

        Completa los TODO manteniendo todos los indices sincronizados.
    """)


def case_test_method(class_name: str, method: str) -> str:
    call = f"servicio.{sample_case_call(method)}"
    ret = method_return(method)
    if ret == "void":
        assertion = f"assertDoesNotThrow(() -> {call});"
    elif ret == "boolean":
        assertion = f"assertTrue({call});"
    else:
        assertion = f"assertNotNull({call});"
    return f"""
        @Test
        void {method}DebeImplementarse() {{
            {class_name} servicio = new {class_name}();
            {assertion}
        }}
    """


def main() -> None:
    total_impl = 0
    for group, exercises in IMPLEMENTATION_GROUPS.items():
        for name, structure, difficulty, idea in exercises:
            build_individual_implementation(group, name, structure, difficulty, idea)
            total_impl += 1
    total_cases = 0
    for class_name, title, structures, methods in CASE_USE_EXERCISES:
        build_individual_case(class_name, title, structures, methods)
        total_cases += 1
    write(TRAINING / "04_INDICES" / "ESQUELETOS_INDIVIDUALES.md", f"""
        # Esqueletos individuales

        Se ha generado un proyecto `esqueleto` dentro de cada carpeta de ejercicio grande.

        - Ejercicios de implementación con esqueleto propio: {total_impl}
        - Casos de uso con esqueleto propio: {total_cases}

        Cada `esqueleto` contiene:

        - `pom.xml`
        - `src/main/java`
        - `src/test/java`
        - `README.md`

        Los métodos están incompletos a propósito.
    """)


if __name__ == "__main__":
    main()
