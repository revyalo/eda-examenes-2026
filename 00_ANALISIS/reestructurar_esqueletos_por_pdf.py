from __future__ import annotations

import runpy
import shutil
import textwrap
from collections import defaultdict
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
OUT = ROOT / "EDA_Examenes_2026" / "06_ESQUELETOS_POR_PDF"
BASE = ROOT / "Esqueletos" / "Implementación - Esqueleto"
HYPER = ROOT / "Esqueletos" / "Hipergrafo"
GENERATOR = ROOT / "EDA_Examenes_2026" / "00_ANALISIS" / "generar_esqueletos_por_pdf.py"

EXAMS = runpy.run_path(str(GENERATOR))["EXAMS"]


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def clean_copytree(src: Path, dst: Path) -> None:
    if not src.exists():
        return
    shutil.copytree(
        src,
        dst,
        ignore=shutil.ignore_patterns(".git", ".idea", "target", "out", ".DS_Store", "__MACOSX"),
        dirs_exist_ok=True,
    )


def copy_professor_project_base(project: Path, exam: dict) -> None:
    shutil.copy2(BASE / "pom.xml", project / "pom.xml")
    base_java = BASE / "src/main/java/es/urjc/grafo/EDA"
    target_java = project / "src/main/java/es/urjc/grafo/EDA"
    for child in base_java.iterdir():
        if child.name == "examen":
            continue
        if child.is_dir():
            clean_copytree(child, target_java / child.name)
        else:
            shutil.copy2(child, target_java / child.name)

    if "hipergrafo" in exam["titulo"].lower() or any("hipergrafo" in e["nombre"].lower() for e in exam.get("exercises", [])):
        hyper_graphs = HYPER / "src/main/java/es/urjc/grafo/EDA/graphs"
        for name in ["AdjacencyMapUndirectedHyperGraph.java", "UndirectedHyperGraph.java"]:
            src = hyper_graphs / name
            if src.exists():
                shutil.copy2(src, target_java / "graphs" / name)


def todo(message: str) -> str:
    return f'throw new UnsupportedOperationException("TODO: {message}");'


def graph_method(method: str) -> str:
    if method == "existeCaminoDeLongitudMenorOIgualAN":
        return f"""
        public static <V, E> boolean existeCaminoDeLongitudMenorOIgualAN(AdjacencyMapGraph<V, E> graph, Vertex<V> start, Vertex<V> end, int n) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "kPower":
        return f"""
        public static <V, E> AdjacencyMapGraph<V, E> kPower(AdjacencyMapGraph<V, E> graph, int k) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "complementary":
        return f"""
        public static <V, E> AdjacencyMapGraph<V, E> complementary(AdjacencyMapGraph<V, E> graph) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "isEulerianGraph":
        return f"""
        public static <V, E> boolean isEulerianGraph(AdjacencyMapGraph<V, E> graph) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    return f"""
    public static <V, E> boolean {method}(AdjacencyMapGraph<V, E> graph) {{
        // TODO: completar siguiendo el enunciado del PDF.
        {todo(method)}
    }}
    """


def tree_method(method: str) -> str:
    if method == "cumplePropiedadesMonticulo":
        return f"""
        public static <E> boolean cumplePropiedadesMonticulo(BinaryTree<E> tree, Comparator<E> comparator) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "treeDegree":
        return f"""
        public static <E> int treeDegree(Tree<E> t) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "areIdentical":
        return f"""
        public static <E> boolean areIdentical(BinaryTree<E> t1, BinaryTree<E> t2) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "descendantsNumber":
        return f"""
        public static <E> int descendantsNumber(Tree<E> t, Position<E> p) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    if method == "isSymmetric":
        return f"""
        public static <E> boolean isSymmetric(BinaryTree<E> tree) {{
            // TODO: completar siguiendo el enunciado del PDF.
            {todo(method)}
        }}
        """
    return f"""
    public static <E> boolean {method}(Tree<E> tree) {{
        // TODO: completar siguiendo el enunciado del PDF.
        {todo(method)}
    }}
    """


def simple_method(method: str, message: str) -> str:
    if method in {"registrarRouter", "registrarArea", "registrarConexion", "registrarOpositor", "registrarNota",
                  "registrarInteraccion", "registrarJugador", "registrarPartida", "registrarNodo", "registrarElemento",
                  "registrarRelacion", "registrarPersona", "registrarAmistad", "cambiarLuz", "registrarEquipo",
                  "registrarAeropuerto", "registrarVuelo", "registrarEmpresa", "registrarTrabajador",
                  "registrarPueblo", "registrarCentro", "cargarDiccionario", "actualizarTabla", "relacionar"}:
        return f"""
        public void {method}(String a, String b) {{
            // TODO: completar usando las estructuras de datos del entorno.
            {todo(message)}
        }}
        """
    if method in {"existeRuta"}:
        return f"""
        public boolean {method}(String origen, String destino) {{
            // TODO: completar usando las estructuras de datos del entorno.
            {todo(message)}
        }}
        """
    if method.startswith(("consultar", "buscar", "mejor", "ranking", "clasificacion", "sugerencias", "calcular", "centro", "traducir")):
        return f"""
        public Iterable<String> {method}(String criterio) {{
            // TODO: completar usando las estructuras de datos del entorno.
            {todo(message)}
        }}
        """
    if method == "resolverCaso":
        return f"""
        public Iterable<String> resolverCaso() {{
            // TODO: completar el caso de uso solicitado.
            {todo(message)}
        }}
        """
    if method in {"hasNext"}:
        return f"""
        public boolean hasNext() {{
            // TODO: completar el iterador.
            {todo(message)}
        }}
        """
    if method in {"next"}:
        return f"""
        public Position<E> next() {{
            // TODO: completar el iterador.
            {todo(message)}
        }}
        """
    if method in {"remove", "clear"}:
        return f"""
        public void {method}() {{
            // TODO: completar siguiendo el enunciado.
            {todo(message)}
        }}
        """
    return f"""
    public Iterable<String> {method}() {{
        // TODO: completar siguiendo el enunciado del PDF.
        {todo(message)}
    }}
    """


def classify(exercise: dict) -> tuple[str, list[str], str]:
    name = exercise["nombre"]
    methods = exercise.get("methods", [])
    lowered = name.lower()
    if "graphoperations." in lowered:
        return "GraphOperations", [name.split(".")[-1]], "graph"
    if "treeoperations." in lowered:
        return "TreeOperations", [name.split(".")[-1]], "tree"
    if "morefunctionality." in lowered:
        return "MoreFunctionality", [name.split(".")[-1]], "more"
    if "funhandling." in lowered:
        return "FunHandling", [name.split(".")[-1]], "fun"
    if "internalnodeiterator" in lowered:
        return "InternalNodeIterator", ["hasNext", "next", "remove"], "iterator"
    if "extendedbreadthfirsttreeiterator" in lowered:
        return "ExtendedBreadthFirstTreeIterator", ["hasNext", "next", "remove"], "iterator"
    if "reverseinorden" in lowered:
        return "ReverseInordenBTIterator", ["hasNext", "next", "remove"], "iterator"
    if "withoutsiblingiterator" in lowered:
        return "WithoutSiblingIterator", ["hasNext", "next", "remove"], "iterator"
    if "leveliterator" in lowered:
        return "LevelIterator", ["hasNext", "next", "remove"], "iterator"
    if "linkedternarytree" in lowered:
        return "LinkedTernaryTree", ["addRoot", "insertFirst", "insertSecond", "insertThird"], "ternary"
    if "efficientdict" in lowered:
        return "EfficientDict", ["put", "get", "remove", "entries"], "dict"
    if "quicktree" in lowered:
        return "QuickTree", ["search", "insert", "remove"], "quicktree"
    if "minimumsuccesor" in lowered:
        return "MinimumSuccesorTree", methods, "quicktree"
    if "levelscomplete" in lowered:
        return "LevelsComplete", ["levelsComplete"], "levels"
    if "parcial1." in lowered:
        return "Parcial1", [name.split(".")[-1]], "parcial"
    if "bst." in lowered or "binarysearchtree" in lowered:
        return "BSTOperations", methods, "bst"
    if "arbol n-ario" in lowered:
        return "NAryTreeOperations", methods, "nary"
    if "hipergrafo" in lowered or "hypergraph" in lowered:
        return "HyperGraphOperations", methods, "hyper"
    return exercise["class"], methods or ["resolverCaso"], "case"


def class_source(class_name: str, methods: list[str], kind: str, title: str) -> str:
    unique_methods = []
    for method in methods:
        method = method.replace("minimumFromPosition", "minimum")
        if method not in unique_methods:
            unique_methods.append(method)

    if kind == "graph":
        body = "\n".join(graph_method(m) for m in unique_methods)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;

        public class GraphOperations {{
        {body}
        }}
        """
    if kind == "tree":
        body = "\n".join(tree_method(m) for m in unique_methods)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Comparator;

        public class TreeOperations {{
        {body}
        }}
        """
    if kind == "more":
        body_parts = []
        for m in unique_methods:
            if m == "leftView":
                body_parts.append(f"""
                public static <E> Iterable<E> leftView(BinaryTree<E> tree) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
            else:
                body_parts.append(f"""
                public static <E> boolean {m}(BinaryTree<E> tree) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;

        public class MoreFunctionality {{
        {''.join(body_parts)}
        }}
        """
    if kind == "fun":
        body_parts = []
        for m in unique_methods:
            if m == "removeHalfNodes":
                body_parts.append(f"""
                public static <E> void removeHalfNodes(BinaryTree<E> tree) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
            else:
                body_parts.append(f"""
                public static <E> boolean {m}(BinaryTree<E> tree, Iterable<E> values) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;

        public class FunHandling {{
        {''.join(body_parts)}
        }}
        """
    if kind == "iterator":
        body = "\n".join(simple_method(m, class_name) for m in unique_methods)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Iterator;

        public class {class_name}<E> implements Iterator<Position<E>> {{

            private final BinaryTree<E> tree;

            public {class_name}(BinaryTree<E> tree) {{
                this.tree = tree;
            }}

        {body}
        }}
        """
    if kind == "ternary":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.utils.Position;

        public class LinkedTernaryTree<E> {{

            public Position<E> addRoot(E element) {{
                // TODO: completar la estructura ternaria.
                {todo("addRoot")}
            }}

            public Position<E> insertFirst(Position<E> parent, E element) {{
                // TODO: completar la estructura ternaria.
                {todo("insertFirst")}
            }}

            public Position<E> insertSecond(Position<E> parent, E element) {{
                // TODO: completar la estructura ternaria.
                {todo("insertSecond")}
            }}

            public Position<E> insertThird(Position<E> parent, E element) {{
                // TODO: completar la estructura ternaria.
                {todo("insertThird")}
            }}
        }}
        """
    if kind == "dict":
        return f"""
        package es.urjc.grafo.EDA.examen;

        public class EfficientDict<K, V> {{

            public V put(K key, V value) {{
                // TODO: completar el diccionario eficiente.
                {todo("put")}
            }}

            public V get(K key) {{
                // TODO: completar el diccionario eficiente.
                {todo("get")}
            }}

            public V remove(K key) {{
                // TODO: completar el diccionario eficiente.
                {todo("remove")}
            }}

            public Iterable<K> entries() {{
                // TODO: completar el diccionario eficiente.
                {todo("entries")}
            }}
        }}
        """
    if kind in {"quicktree", "bst"}:
        body = "\n".join(simple_method(m, class_name) for m in unique_methods)
        return f"""
        package es.urjc.grafo.EDA.examen;

        public class {class_name}<E extends Comparable<E>> {{
        {body}
        }}
        """
    if kind == "levels":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;

        public class LevelsComplete {{

            public static <E> boolean levelsComplete(BinaryTree<E> tree) {{
                // TODO: completar siguiendo el enunciado del PDF.
                {todo("levelsComplete")}
            }}
        }}
        """
    if kind == "parcial":
        body_parts = []
        for m in unique_methods:
            if m == "isIsogram":
                body_parts.append(f"""
                public static boolean isIsogram(String text) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
            elif m == "degree":
                body_parts.append(f"""
                public static <E> int degree(Tree<E> tree) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
            else:
                body_parts.append(f"""
                public static <E> Iterable<Position<E>> {m}(Tree<E> tree, Position<E> position) {{
                    // TODO: completar siguiendo el enunciado del PDF.
                    {todo(m)}
                }}
                """)
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.utils.Position;

        public class Parcial1 {{
        {''.join(body_parts)}
        }}
        """
    if kind == "nary":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;

        public class NAryTreeOperations {{

            public static <E> void clear(LinkedTree<E> tree) {{
                // TODO: completar siguiendo el enunciado del PDF.
                {todo("clear")}
            }}

            public static <E> LinkedTree<E> copy(LinkedTree<E> tree) {{
                // TODO: completar siguiendo el enunciado del PDF.
                {todo("copy")}
            }}
        }}
        """
    if kind == "hyper":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapUndirectedHyperGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;

        public class HyperGraphOperations<V, E> {{

            private final AdjacencyMapUndirectedHyperGraph<V, E> hyperGraph = new AdjacencyMapUndirectedHyperGraph<>();

            public Vertex<V> insertVertex(V value) {{
                return hyperGraph.insertVertex(value);
            }}

            public void insertHyperedge(Iterable<Vertex<V>> vertices, E value) {{
                // TODO: completar o delegar segun el enunciado del PDF.
                {todo("insertHyperedge")}
            }}
        }}
        """

    body = "\n".join(simple_method(m, title) for m in unique_methods)
    return f"""
    package es.urjc.grafo.EDA.examen;

    public class {class_name} {{

    {body}
    }}
    """


def smoke_test_source(class_name: str, kind: str, methods: list[str]) -> str:
    if kind == "graph":
        method_set = set(methods)
        if "isEulerianGraph" in method_set:
            invocation = "assertTrue(GraphOperations.isEulerianGraph(graph));"
            assertion_import = "assertTrue"
        elif "complementary" in method_set:
            invocation = "assertNotNull(GraphOperations.complementary(graph));"
            assertion_import = "assertNotNull"
        elif "kPower" in method_set:
            invocation = "assertNotNull(GraphOperations.kPower(graph, 1));"
            assertion_import = "assertNotNull"
        else:
            invocation = "assertTrue(GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, b, 1));"
            assertion_import = "assertTrue"
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
                Vertex<String> a = graph.insertVertex("A");
                Vertex<String> b = graph.insertVertex("B");
                graph.insertEdge(a, b, "AB");

                {invocation}
            }}
        }}
        """
    if kind == "tree":
        method_set = set(methods)
        if "treeDegree" in method_set:
            imports = "import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;"
            assertion_import = "assertEquals"
            invocation = "assertEquals(0, TreeOperations.treeDegree(new LinkedTree<>()));"
        elif "areIdentical" in method_set:
            imports = "import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;"
            assertion_import = "assertTrue"
            invocation = "assertTrue(TreeOperations.areIdentical(new LinkedBinaryTree<>(), new LinkedBinaryTree<>()));"
        elif "cumplePropiedadesMonticulo" in method_set:
            imports = "import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;"
            assertion_import = "assertTrue"
            invocation = "assertTrue(TreeOperations.cumplePropiedadesMonticulo(new LinkedBinaryTree<Integer>(), Integer::compareTo));"
        elif "descendantsNumber" in method_set:
            imports = "import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;\n        import es.urjc.grafo.EDA.utils.Position;"
            assertion_import = "assertEquals"
            invocation = "LinkedTree<Integer> tree = new LinkedTree<>();\n                Position<Integer> root = tree.addRoot(1);\n                assertEquals(0, TreeOperations.descendantsNumber(tree, root));"
        else:
            imports = "import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;"
            assertion_import = "assertTrue"
            invocation = "assertTrue(TreeOperations.isSymmetric(new LinkedBinaryTree<>()));"
        return f"""
        package es.urjc.grafo.EDA.examen;

        {imports}
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {invocation}
            }}
        }}
        """
    if kind == "iterator":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertFalse;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {class_name}<Integer> iterator = new {class_name}<>(new LinkedBinaryTree<>());
                assertFalse(iterator.hasNext());
            }}
        }}
        """
    if kind == "case":
        first_method = methods[0] if methods else "resolverCaso"
        if "resolverCaso" in methods:
            call = "assertDoesNotThrow(servicio::resolverCaso);"
            assertion_import = "assertDoesNotThrow"
        elif first_method.startswith(("registrar", "cargar", "actualizar", "relacionar", "cambiar")):
            call = f'assertDoesNotThrow(() -> servicio.{first_method}("A", "B"));'
            assertion_import = "assertDoesNotThrow"
        elif first_method in {"remove", "clear"}:
            call = f"assertDoesNotThrow(servicio::{first_method});"
            assertion_import = "assertDoesNotThrow"
        else:
            call = f"assertNotNull(servicio.{first_method}());"
            assertion_import = "assertNotNull"
        return f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {class_name} servicio = new {class_name}();
                {call}
            }}
        }}
        """
    if kind == "more":
        method = methods[0] if methods else "isPerfect"
        if method == "leftView":
            assertion = "assertNotNull(MoreFunctionality.leftView(new LinkedBinaryTree<>()));"
            assertion_import = "assertNotNull"
        else:
            assertion = f"assertTrue(MoreFunctionality.{method}(new LinkedBinaryTree<>()));"
            assertion_import = "assertTrue"
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {assertion}
            }}
        }}
        """
    if kind == "fun":
        method = methods[0] if methods else "esPrefijo"
        if method == "removeHalfNodes":
            assertion = "assertDoesNotThrow(() -> FunHandling.removeHalfNodes(new LinkedBinaryTree<>()));"
            assertion_import = "assertDoesNotThrow"
        else:
            assertion = f"assertTrue(FunHandling.{method}(new LinkedBinaryTree<>(), java.util.List.of()));"
            assertion_import = "assertTrue"
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {assertion}
            }}
        }}
        """
    if kind == "hyper":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                HyperGraphOperations<String, String> hyperGraph = new HyperGraphOperations<>();
                assertDoesNotThrow(() -> hyperGraph.insertHyperedge(java.util.List.of(), "H"));
            }}
        }}
        """
    if kind == "ternary":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertNotNull;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                LinkedTernaryTree<Integer> tree = new LinkedTernaryTree<>();
                assertNotNull(tree.addRoot(1));
            }}
        }}
        """
    if kind == "dict":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertNull;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                EfficientDict<String, Integer> dict = new EfficientDict<>();
                assertNull(dict.put("A", 1));
            }}
        }}
        """
    if kind in { "quicktree", "bst" }:
        method = methods[0] if methods else "search"
        return f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertNotNull;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {class_name}<Integer> tree = new {class_name}<>();
                assertNotNull(tree.{method}());
            }}
        }}
        """
    if kind == "levels":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                assertTrue(LevelsComplete.levelsComplete(new LinkedBinaryTree<>()));
            }}
        }}
        """
    if kind == "parcial":
        method = methods[0] if methods else "isIsogram"
        if method == "isIsogram":
            body = 'assertTrue(Parcial1.isIsogram("abc"));'
            assertion_import = "assertTrue"
            imports = ""
        elif method == "degree":
            body = "assertEquals(0, Parcial1.degree(new LinkedTree<>()));"
            assertion_import = "assertEquals"
            imports = "import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;"
        else:
            body = "LinkedTree<Integer> tree = new LinkedTree<>();\n                Position<Integer> root = tree.addRoot(1);\n                assertNotNull(Parcial1.antecesors(tree, root));"
            assertion_import = "assertNotNull"
            imports = "import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;\n        import es.urjc.grafo.EDA.utils.Position;"
        return f"""
        package es.urjc.grafo.EDA.examen;

        {imports}
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.{assertion_import};

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                {body}
            }}
        }}
        """
    if kind == "nary":
        return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertNotNull;

        class {class_name}Test {{

            @Test
            void ejercicioDebeImplementarse() {{
                assertNotNull(NAryTreeOperations.copy(new LinkedTree<>()));
            }}
        }}
        """
    return f"""
    package es.urjc.grafo.EDA.examen;

    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

    class {class_name}Test {{

        @Test
        void ejercicioDebeImplementarse() {{
            assertDoesNotThrow(() -> {{
                new {class_name}();
            }});
        }}
    }}
    """


def build_project(exam: dict) -> None:
    if not exam.get("exercises"):
        return

    exam_dir = OUT / exam["slug"]
    project = exam_dir / "esqueletos_generados"
    if project.exists():
        shutil.rmtree(project)
    project.mkdir(parents=True)
    copy_professor_project_base(project, exam)

    classes: dict[str, dict] = {}
    for exercise in exam.get("exercises", []):
        if exercise["tipo"] not in {"implementacion", "casos_de_uso", "pendiente_revision"}:
            continue
        class_name, methods, kind = classify(exercise)
        item = classes.setdefault(class_name, {"methods": [], "kind": kind, "titles": []})
        item["methods"].extend(methods)
        item["titles"].append(exercise["nombre"])

    main_dir = project / "src/main/java/es/urjc/grafo/EDA/examen"
    test_dir = project / "src/test/java/es/urjc/grafo/EDA/examen"
    for class_name, item in classes.items():
        source = class_source(class_name, item["methods"], item["kind"], "; ".join(item["titles"]))
        write(main_dir / f"{class_name}.java", source)
        write(test_dir / f"{class_name}Test.java", smoke_test_source(class_name, item["kind"], item["methods"]))

    write(
        project / "README.md",
        f"""
        # Esqueleto con estructura del profesor - {exam['titulo']}

        Este proyecto se ha generado aplicando la estructura que aparece en los esqueletos reales:

        - `pom.xml` con `groupId` `es.urjc.grafo.EDA`, Java 21 y JUnit Jupiter 5.8.1.
        - Codigo en `src/main/java/es/urjc/grafo/EDA`.
        - Clases del examen en `src/main/java/es/urjc/grafo/EDA/examen`.
        - Tests en `src/test/java/es/urjc/grafo/EDA/examen`.
        - Entorno base copiado desde `Esqueletos/Implementación - Esqueleto`.

        No contiene soluciones. Los metodos del alumno tienen TODO y lanzan `UnsupportedOperationException`.

        Si esta carpeta del PDF tambien tiene `esqueletos_existentes`, el esqueleto original copiado ahi tiene prioridad.
        """,
    )


def main() -> None:
    for exam in EXAMS:
        build_project(exam)


if __name__ == "__main__":
    main()
