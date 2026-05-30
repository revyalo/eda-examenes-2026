from __future__ import annotations

import shutil
import textwrap
from dataclasses import dataclass
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
OUT = ROOT / "EDA_Examenes_2026" / "08_PRACTICA_ORDENADA_POR_PDF" / "04_ITERADORES_POR_PDF"
BASE_ENV = ROOT / "Esqueletos" / "Implementación - Esqueleto"
PKG = "es.urjc.grafo.EDA.examen.iteradores"
PKG_PATH = Path("es/urjc/grafo/EDA/examen/iteradores")


@dataclass
class Exercise:
    folder: str
    title: str
    source: str
    difficulty: str
    class_name: str
    statement: str
    main_source: str
    test_source: str


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def pom(artifact_id: str) -> str:
    return f"""
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <groupId>es.urjc.grafo.EDA</groupId>
            <artifactId>{artifact_id}</artifactId>
            <version>1.0-SNAPSHOT</version>

            <properties>
                <maven.compiler.source>21</maven.compiler.source>
                <maven.compiler.target>21</maven.compiler.target>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter</artifactId>
                    <version>5.8.1</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>

            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.0.0-M5</version>
                    </plugin>
                </plugins>
            </build>
        </project>
    """


def copy_environment(project: Path) -> None:
    src = BASE_ENV / "src/main/java/es/urjc/grafo/EDA"
    dst = project / "src/main/java/es/urjc/grafo/EDA"
    for item in src.iterdir():
        if item.name == "examen":
            continue
        target = dst / item.name
        if item.is_dir():
            shutil.copytree(item, target)
        else:
            shutil.copy2(item, target)


def test_header(class_name: str, body: str) -> str:
    return f"""
        package {PKG};

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Set;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            private static <E> List<E> values(Iterator<Position<E>> iterator) {{
                List<E> result = new ArrayList<>();
                while (iterator.hasNext()) {{
                    result.add(iterator.next().getElement());
                }}
                return result;
            }}

            private static <E> Set<E> valueSet(Iterator<Position<E>> iterator) {{
                return new HashSet<>(values(iterator));
            }}

        {body}
        }}
    """


def exercises() -> list[Exercise]:
    return [
        Exercise(
            "01_enero_2026_extended_breadth_first_remove",
            "ExtendedBreadthFirstTreeIterator.remove",
            "PDF/esqueleto real: implementación enero 2026, iterador en anchura sobre LinkedTree.",
            "Alta",
            "ExtendedBreadthFirstTreeIterator",
            """
            Completa únicamente el método remove del iterador en anchura.

            El iterador ya sabe recorrer el árbol general en anchura. Debes hacer que remove elimine del
            LinkedTree el último nodo devuelto por next y todo su subárbol. Además, las posiciones pendientes
            del iterador que pertenecieran al subárbol eliminado no deben visitarse en llamadas posteriores.

            Casos importantes: no permitir remove antes de next, no permitir dos remove seguidos sobre el
            mismo nodo, eliminar hojas, eliminar nodos internos y eliminar la raíz.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;
                import java.util.LinkedList;

                public class ExtendedBreadthFirstTreeIterator<E> implements Iterator<Position<E>> {{

                    private LinkedList<Position<E>> nodesToVisit = new LinkedList<>();
                    private LinkedTree<E> tree;

                    public ExtendedBreadthFirstTreeIterator(LinkedTree<E> tree, Position<E> root) {{
                        this.nodesToVisit.add(root);
                        this.tree = tree;
                    }}

                    public ExtendedBreadthFirstTreeIterator(LinkedTree<E> tree) {{
                        this(tree, tree.root());
                    }}

                    @Override
                    public boolean hasNext() {{
                        return !this.nodesToVisit.isEmpty();
                    }}

                    @Override
                    public Position<E> next() {{
                        Position<E> currentPosition = this.nodesToVisit.poll();
                        if (!tree.isLeaf(currentPosition)) {{
                            for (Position<E> child : tree.children(currentPosition)) {{
                                this.nodesToVisit.add(child);
                            }}
                        }}
                        return currentPosition;
                    }}

                    @Override
                    public void remove() {{
                        // TODO: elimina el ultimo nodo devuelto por next y limpia la cola de nodos pendientes.
                        throw new UnsupportedOperationException("TODO: remove en ExtendedBreadthFirstTreeIterator");
                    }}
                }}
            """,
            test_header(
                "ExtendedBreadthFirstTreeIterator",
                """
                @Test
                void recorridoInicialEnAnchura() {
                    LinkedTree<Integer> tree = sampleGeneralTree();
                    assertEquals(List.of(1, 2, 3, 4, 5), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
                }

                @Test
                void removeEliminaHoja() {
                    LinkedTree<Integer> tree = sampleGeneralTree();
                    ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(tree);

                    assertEquals(1, it.next().getElement());
                    assertEquals(2, it.next().getElement());
                    assertEquals(3, it.next().getElement());
                    assertEquals(4, it.next().getElement());
                    it.remove();

                    assertEquals(4, tree.size());
                    assertEquals(List.of(1, 2, 3, 5), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
                }

                @Test
                void removeEliminaNodoInternoYNoVisitaSuSubarbolPendiente() {
                    LinkedTree<Integer> tree = sampleGeneralTree();
                    ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(tree);

                    assertEquals(1, it.next().getElement());
                    assertEquals(2, it.next().getElement());
                    it.remove();

                    assertEquals(List.of(3), values(it));
                    assertEquals(2, tree.size());
                    assertEquals(List.of(1, 3), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
                }

                private LinkedTree<Integer> sampleGeneralTree() {
                    LinkedTree<Integer> tree = new LinkedTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> two = tree.add(2, root);
                    tree.add(3, root);
                    tree.add(4, two);
                    tree.add(5, two);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "02_junio_2025_reverse_inorden",
            "ReverseInordenBTIterator",
            "PDF mixto junio 2025: parte de implementación de iteradores, separada del caso de uso de red eléctrica.",
            "Alta",
            "ReverseInordenBTIterator",
            """
            Implementa un iterador de árbol binario que devuelva las posiciones en inorden inverso:
            primero subárbol derecho, después nodo actual y por último subárbol izquierdo.

            No debes modificar el árbol. El método remove no forma parte del objetivo principal; puedes dejarlo
            sin soportar si el estilo de tu implementación lo justifica.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class ReverseInordenBTIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public ReverseInordenBTIterator(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: indica si queda alguna posicion pendiente en inorden inverso.
                        throw new UnsupportedOperationException("TODO: hasNext en ReverseInordenBTIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion en orden derecha-raiz-izquierda.
                        throw new UnsupportedOperationException("TODO: next en ReverseInordenBTIterator");
                    }}

                    @Override
                    public void remove() {{
                        // TODO opcional: si no se soporta, lanza UnsupportedOperationException.
                        throw new UnsupportedOperationException("TODO: remove en ReverseInordenBTIterator");
                    }}
                }}
            """,
            test_header(
                "ReverseInordenBTIterator",
                """
                @Test
                void arbolVacioNoTieneSiguiente() {
                    assertFalse(new ReverseInordenBTIterator<>(new LinkedBinaryTree<Integer>()).hasNext());
                }

                @Test
                void recorreEnInordenInverso() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> p3 = tree.addRoot(3);
                    Position<Integer> p10 = tree.insertLeft(p3, 10);
                    Position<Integer> p9 = tree.insertRight(p3, 9);
                    tree.insertLeft(p10, 7);
                    tree.insertRight(p10, 5);
                    Position<Integer> p11 = tree.insertRight(p9, 11);
                    tree.insertLeft(p11, 2);
                    tree.insertRight(p11, 6);

                    assertEquals(List.of(6, 11, 2, 9, 3, 5, 10, 7), values(new ReverseInordenBTIterator<>(tree)));
                }

                @Test
                void arbolConUnSoloNodo() {
                    LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
                    tree.addRoot("raiz");
                    assertEquals(List.of("raiz"), values(new ReverseInordenBTIterator<>(tree)));
                }
                """,
            ),
        ),
        Exercise(
            "03_internal_node_iterator_real",
            "InternalNodeIterator",
            "PDF/esqueleto real: funcionalidades de árboles e iterador de nodos internos.",
            "Media-alta",
            "InternalNodeIterator",
            """
            Implementa un iterador que recorra únicamente los nodos internos de un árbol binario. Un nodo
            interno es aquel que tiene al menos un hijo.

            El enunciado real no fija un único orden obligatorio en todos los materiales antiguos; estos tests
            comprueban el conjunto de posiciones internas y casos límite.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class InternalNodeIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public InternalNodeIterator(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true solo si queda algun nodo interno por visitar.
                        throw new UnsupportedOperationException("TODO: hasNext en InternalNodeIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion interna.
                        throw new UnsupportedOperationException("TODO: next en InternalNodeIterator");
                    }}
                }}
            """,
            test_header(
                "InternalNodeIterator",
                """
                @Test
                void nullYArbolVacioSeRechazan() {
                    assertThrows(IllegalArgumentException.class, () -> new InternalNodeIterator<Integer>(null));
                    assertThrows(IllegalArgumentException.class, () -> new InternalNodeIterator<>(new LinkedBinaryTree<Integer>()));
                }

                @Test
                void raizUnicaNoEsInterna() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    tree.addRoot(10);
                    assertFalse(new InternalNodeIterator<>(tree).hasNext());
                }

                @Test
                void devuelveTodosLosNodosInternos() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);

                    assertEquals(Set.of(1, 2, 3), valueSet(new InternalNodeIterator<>(tree)));
                }
                """,
            ),
        ),
        Exercise(
            "04_junio_2023_without_sibling_iterator",
            "WithoutSiblingIterator",
            "PDF mixto junio 2023: parte de implementación con iterador de nodos sin hermano, separada del caso de uso.",
            "Alta",
            "WithoutSiblingIterator",
            """
            Implementa un iterador sobre árbol binario que devuelva las posiciones que no tienen hermano.
            La raíz no cuenta como nodo sin hermano porque no tiene padre.

            Debes usar la API del árbol binario: parent, left, right, hasLeft, hasRight y sibling cuando sea útil.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class WithoutSiblingIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public WithoutSiblingIterator(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: indica si queda algun nodo no raiz sin hermano.
                        throw new UnsupportedOperationException("TODO: hasNext en WithoutSiblingIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion sin hermano.
                        throw new UnsupportedOperationException("TODO: next en WithoutSiblingIterator");
                    }}
                }}
            """,
            test_header(
                "WithoutSiblingIterator",
                """
                @Test
                void raizSolaNoCuenta() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    tree.addRoot(1);
                    assertFalse(new WithoutSiblingIterator<>(tree).hasNext());
                }

                @Test
                void devuelveNodosSinHermano() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    Position<Integer> four = tree.insertLeft(left, 4);
                    tree.insertRight(right, 5);
                    tree.insertRight(four, 7);

                    assertEquals(Set.of(4, 5, 7), valueSet(new WithoutSiblingIterator<>(tree)));
                }
                """,
            ),
        ),
        Exercise(
            "05_junio_2022_level_iterator",
            "LevelIterator",
            "PDF mixto junio 2022: parte de implementación LevelIterator, separada del caso de uso de luces.",
            "Media-alta",
            "LevelIterator",
            """
            Implementa un iterador por niveles para árbol binario. Debe recorrer primero la raíz, después sus
            hijos de izquierda a derecha, y continuar nivel a nivel.

            El método remove debe eliminar el último nodo devuelto cuando el árbol lo permita. Recuerda que
            LinkedBinaryTree.remove solo elimina posiciones con cero o un hijo.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class LevelIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public LevelIterator(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda alguna posicion pendiente por niveles.
                        throw new UnsupportedOperationException("TODO: hasNext en LevelIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion en anchura.
                        throw new UnsupportedOperationException("TODO: next en LevelIterator");
                    }}

                    @Override
                    public void remove() {{
                        // TODO: elimina el ultimo nodo devuelto si el árbol lo permite.
                        throw new UnsupportedOperationException("TODO: remove en LevelIterator");
                    }}
                }}
            """,
            test_header(
                "LevelIterator",
                """
                @Test
                void arbolVacioNoTieneSiguiente() {
                    assertFalse(new LevelIterator<>(new LinkedBinaryTree<Integer>()).hasNext());
                }

                @Test
                void recorrePorNiveles() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(1, 2, 3, 4, 5, 6), values(new LevelIterator<>(tree)));
                }

                @Test
                void removeEliminaUltimoNodoHojaDevuelto() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    LevelIterator<Integer> it = new LevelIterator<>(tree);
                    assertEquals(1, it.next().getElement());
                    assertEquals(2, it.next().getElement());
                    assertEquals(3, it.next().getElement());
                    assertEquals(4, it.next().getElement());
                    it.remove();
                    assertEquals(5, tree.size());
                    assertEquals(List.of(1, 2, 3, 5, 6), values(new LevelIterator<>(tree)));
                }

                private LinkedBinaryTree<Integer> sampleBinaryTree() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "06_extra_inorden_iterator_with_remove",
            "InordenIteratorWithRemove",
            "Ejercicio nuevo inspirado en iteradores de examen: remove sobre recorrido inorden.",
            "Alta",
            "InordenIteratorWithRemove",
            """
            Implementa un iterador inorden de árbol binario con remove. El recorrido debe ser izquierda,
            raíz, derecha.

            remove debe eliminar el último nodo devuelto por next cuando dicho nodo tenga cero o un hijo,
            respetando la limitación de LinkedBinaryTree.remove.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class InordenIteratorWithRemove<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public InordenIteratorWithRemove(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: indica si quedan posiciones del recorrido inorden.
                        throw new UnsupportedOperationException("TODO: hasNext en InordenIteratorWithRemove");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion en inorden.
                        throw new UnsupportedOperationException("TODO: next en InordenIteratorWithRemove");
                    }}

                    @Override
                    public void remove() {{
                        // TODO: elimina el ultimo nodo devuelto por next si es legal.
                        throw new UnsupportedOperationException("TODO: remove en InordenIteratorWithRemove");
                    }}
                }}
            """,
            test_header(
                "InordenIteratorWithRemove",
                """
                @Test
                void recorreEnInorden() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(4, 2, 5, 1, 3, 6), values(new InordenIteratorWithRemove<>(tree)));
                }

                @Test
                void removeEliminaHojaVisitada() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    InordenIteratorWithRemove<Integer> it = new InordenIteratorWithRemove<>(tree);
                    assertEquals(4, it.next().getElement());
                    it.remove();
                    assertEquals(5, tree.size());
                    assertEquals(List.of(2, 5, 1, 3, 6), values(new InordenIteratorWithRemove<>(tree)));
                }

                private LinkedBinaryTree<Integer> sampleBinaryTree() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "07_extra_reverse_inorden_with_remove",
            "ReverseInordenBTIteratorWithRemove",
            "Ejercicio nuevo: variante más difícil del ReverseInordenBTIterator real.",
            "Muy alta",
            "ReverseInordenBTIteratorWithRemove",
            """
            Implementa el recorrido inorden inverso y añade remove correcto. Es más delicado que el ejercicio
            real porque hay que mantener el estado del siguiente nodo tras borrar el último devuelto.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class ReverseInordenBTIteratorWithRemove<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public ReverseInordenBTIteratorWithRemove(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: indica si queda alguna posicion en inorden inverso.
                        throw new UnsupportedOperationException("TODO: hasNext en ReverseInordenBTIteratorWithRemove");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente posicion derecha-raiz-izquierda.
                        throw new UnsupportedOperationException("TODO: next en ReverseInordenBTIteratorWithRemove");
                    }}

                    @Override
                    public void remove() {{
                        // TODO: elimina el ultimo nodo devuelto manteniendo consistente el iterador.
                        throw new UnsupportedOperationException("TODO: remove en ReverseInordenBTIteratorWithRemove");
                    }}
                }}
            """,
            test_header(
                "ReverseInordenBTIteratorWithRemove",
                """
                @Test
                void recorreEnInordenInverso() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(6, 3, 1, 5, 2, 4), values(new ReverseInordenBTIteratorWithRemove<>(tree)));
                }

                @Test
                void removeEliminaHojaDerechaVisitada() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    ReverseInordenBTIteratorWithRemove<Integer> it = new ReverseInordenBTIteratorWithRemove<>(tree);
                    assertEquals(6, it.next().getElement());
                    it.remove();
                    assertEquals(5, tree.size());
                    assertEquals(List.of(3, 1, 5, 2, 4), values(new ReverseInordenBTIteratorWithRemove<>(tree)));
                }

                private LinkedBinaryTree<Integer> sampleBinaryTree() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "08_extra_leaf_iterator",
            "LeafIterator",
            "Ejercicio nuevo de práctica: iterador de hojas en árbol general.",
            "Media-alta",
            "LeafIterator",
            """
            Implementa un iterador de árbol general que devuelva solo las hojas. El orden esperado es por
            niveles, siguiendo la misma idea que los iteradores en anchura del entorno.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class LeafIterator<E> implements Iterator<Position<E>> {{

                    private final LinkedTree<E> tree;

                    public LeafIterator(LinkedTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda alguna hoja pendiente.
                        throw new UnsupportedOperationException("TODO: hasNext en LeafIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve la siguiente hoja en orden por niveles.
                        throw new UnsupportedOperationException("TODO: next en LeafIterator");
                    }}
                }}
            """,
            test_header(
                "LeafIterator",
                """
                @Test
                void raizSolaEsHoja() {
                    LinkedTree<Integer> tree = new LinkedTree<>();
                    tree.addRoot(1);
                    assertEquals(List.of(1), values(new LeafIterator<>(tree)));
                }

                @Test
                void devuelveHojasPorNiveles() {
                    LinkedTree<Integer> tree = sampleGeneralTree();
                    assertEquals(List.of(3, 4, 6), values(new LeafIterator<>(tree)));
                }

                private LinkedTree<Integer> sampleGeneralTree() {
                    LinkedTree<Integer> tree = new LinkedTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> two = tree.add(2, root);
                    tree.add(3, root);
                    tree.add(4, two);
                    Position<Integer> five = tree.add(5, two);
                    tree.add(6, five);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "09_extra_skip_leaves_iterator",
            "SkipLeavesIterator",
            "Ejercicio nuevo de práctica: recorrer solo nodos internos de árbol general.",
            "Media-alta",
            "SkipLeavesIterator",
            """
            Implementa un iterador sobre árbol general que salte las hojas y devuelva únicamente nodos internos.
            El orden esperado es por niveles.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class SkipLeavesIterator<E> implements Iterator<Position<E>> {{

                    private final LinkedTree<E> tree;

                    public SkipLeavesIterator(LinkedTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda algun nodo interno pendiente.
                        throw new UnsupportedOperationException("TODO: hasNext en SkipLeavesIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve el siguiente nodo interno por niveles.
                        throw new UnsupportedOperationException("TODO: next en SkipLeavesIterator");
                    }}
                }}
            """,
            test_header(
                "SkipLeavesIterator",
                """
                @Test
                void raizSolaNoAparece() {
                    LinkedTree<Integer> tree = new LinkedTree<>();
                    tree.addRoot(1);
                    assertFalse(new SkipLeavesIterator<>(tree).hasNext());
                }

                @Test
                void devuelveInternosPorNiveles() {
                    LinkedTree<Integer> tree = sampleGeneralTree();
                    assertEquals(List.of(1, 2, 5), values(new SkipLeavesIterator<>(tree)));
                }

                private LinkedTree<Integer> sampleGeneralTree() {
                    LinkedTree<Integer> tree = new LinkedTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> two = tree.add(2, root);
                    tree.add(3, root);
                    tree.add(4, two);
                    Position<Integer> five = tree.add(5, two);
                    tree.add(6, five);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "10_extra_between_levels_iterator",
            "BetweenLevelsIterator",
            "Ejercicio nuevo de práctica: iterador por niveles acotados.",
            "Alta",
            "BetweenLevelsIterator",
            """
            Implementa un iterador de árbol binario que devuelva solo los nodos cuya profundidad esté entre
            minLevel y maxLevel, ambos incluidos. La raíz está en profundidad 0.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class BetweenLevelsIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;
                    private final int minLevel;
                    private final int maxLevel;

                    public BetweenLevelsIterator(BinaryTree<E> tree, int minLevel, int maxLevel) {{
                        this.tree = tree;
                        this.minLevel = minLevel;
                        this.maxLevel = maxLevel;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda algun nodo entre los niveles pedidos.
                        throw new UnsupportedOperationException("TODO: hasNext en BetweenLevelsIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve el siguiente nodo por niveles dentro del rango.
                        throw new UnsupportedOperationException("TODO: next en BetweenLevelsIterator");
                    }}
                }}
            """,
            test_header(
                "BetweenLevelsIterator",
                """
                @Test
                void devuelveNodosEntreDosNiveles() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(2, 3, 4, 5, 6), values(new BetweenLevelsIterator<>(tree, 1, 2)));
                }

                @Test
                void nivelCeroDevuelveRaiz() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(1), values(new BetweenLevelsIterator<>(tree, 0, 0)));
                }

                private LinkedBinaryTree<Integer> sampleBinaryTree() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "11_extra_breadth_first_even_level_iterator",
            "BreadthFirstEvenLevelIterator",
            "Ejercicio nuevo de práctica: BFS filtrando niveles pares.",
            "Alta",
            "BreadthFirstEvenLevelIterator",
            """
            Implementa un iterador por anchura que devuelva únicamente posiciones situadas en niveles pares:
            0, 2, 4, etc.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class BreadthFirstEvenLevelIterator<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;

                    public BreadthFirstEvenLevelIterator(BinaryTree<E> tree) {{
                        this.tree = tree;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda algun nodo en nivel par.
                        throw new UnsupportedOperationException("TODO: hasNext en BreadthFirstEvenLevelIterator");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve el siguiente nodo de nivel par en anchura.
                        throw new UnsupportedOperationException("TODO: next en BreadthFirstEvenLevelIterator");
                    }}
                }}
            """,
            test_header(
                "BreadthFirstEvenLevelIterator",
                """
                @Test
                void incluyeRaizYNodosDeNivelDos() {
                    LinkedBinaryTree<Integer> tree = sampleBinaryTree();
                    assertEquals(List.of(1, 4, 5, 6), values(new BreadthFirstEvenLevelIterator<>(tree)));
                }

                private LinkedBinaryTree<Integer> sampleBinaryTree() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    tree.insertLeft(left, 4);
                    tree.insertRight(left, 5);
                    tree.insertRight(right, 6);
                    return tree;
                }
                """,
            ),
        ),
        Exercise(
            "12_extra_path_iterator_to_root",
            "PathIteratorToRoot",
            "Ejercicio nuevo de práctica: iterador de camino desde un nodo hasta la raíz.",
            "Muy alta",
            "PathIteratorToRoot",
            """
            Implementa un iterador que empiece en una posición objetivo y vaya subiendo por parent hasta la raíz.
            Debe devolver primero el nodo inicial y terminar en la raíz.
            """,
            f"""
                package {PKG};

                import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
                import es.urjc.grafo.EDA.utils.Position;

                import java.util.Iterator;

                public class PathIteratorToRoot<E> implements Iterator<Position<E>> {{

                    private final BinaryTree<E> tree;
                    private final Position<E> start;

                    public PathIteratorToRoot(BinaryTree<E> tree, Position<E> start) {{
                        this.tree = tree;
                        this.start = start;
                    }}

                    @Override
                    public boolean hasNext() {{
                        // TODO: devuelve true si queda algun ancestro por visitar.
                        throw new UnsupportedOperationException("TODO: hasNext en PathIteratorToRoot");
                    }}

                    @Override
                    public Position<E> next() {{
                        // TODO: devuelve el nodo actual y prepara su padre.
                        throw new UnsupportedOperationException("TODO: next en PathIteratorToRoot");
                    }}
                }}
            """,
            test_header(
                "PathIteratorToRoot",
                """
                @Test
                void recorreDesdeHojaHastaRaiz() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    Position<Integer> left = tree.insertLeft(root, 2);
                    Position<Integer> right = tree.insertRight(root, 3);
                    Position<Integer> leaf = tree.insertRight(left, 5);
                    tree.insertRight(right, 6);

                    assertEquals(List.of(5, 2, 1), values(new PathIteratorToRoot<>(tree, leaf)));
                }

                @Test
                void empezarEnRaizDevuelveSoloRaiz() {
                    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                    Position<Integer> root = tree.addRoot(1);
                    assertEquals(List.of(1), values(new PathIteratorToRoot<>(tree, root)));
                }
                """,
            ),
        ),
    ]


def project_readme(ex: Exercise) -> str:
    return f"""
        # {ex.title}

        **Origen:** {ex.source}

        **Dificultad:** {ex.difficulty}

        ## Enunciado

        {textwrap.dedent(ex.statement).strip()}

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/{str(PKG_PATH)}/{ex.class_name}.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/{str(PKG_PATH)}/{ex.class_name}Test.java`.
        Deben fallar inicialmente por los TODO esperados.
    """


def index(exs: list[Exercise]) -> str:
    rows = "\n".join(
        f"| {i:02d} | `{ex.folder}` | {ex.title} | {ex.difficulty} | {ex.source} |"
        for i, ex in enumerate(exs, start=1)
    )
    return f"""
        # Índice de iteradores por PDF y práctica extra

        Esta carpeta separa los ejercicios de iteradores de árboles para que puedas practicarlos sin mezclar
        casos de uso, grafos u otros bloques de implementación.

        ## Ejercicios

        | # | Carpeta | Ejercicio | Dificultad | Origen |
        |---:|---|---|---|---|
        {rows}

        ## Orden recomendado

        1. `03_internal_node_iterator_real`
        2. `08_extra_leaf_iterator`
        3. `09_extra_skip_leaves_iterator`
        4. `05_junio_2022_level_iterator`
        5. `02_junio_2025_reverse_inorden`
        6. `04_junio_2023_without_sibling_iterator`
        7. `01_enero_2026_extended_breadth_first_remove`
        8. `06_extra_inorden_iterator_with_remove`
        9. `07_extra_reverse_inorden_with_remove`
        10. `10_extra_between_levels_iterator`
        11. `11_extra_breadth_first_even_level_iterator`
        12. `12_extra_path_iterator_to_root`

        Primero domina `hasNext`/`next` sin borrar; después pasa a `remove`, que es donde suelen romperse
        los invariantes del iterador.
    """


def root_readme() -> str:
    return """
        # Iteradores de árboles por PDF

        Carpeta específica para practicar iteradores de EDA:

        - ejercicios reales extraídos/separados de PDFs antiguos,
        - variantes nuevas inspiradas en esos patrones,
        - esqueletos sin solución,
        - tests completos.

        Cada subcarpeta es un proyecto Maven independiente. Entra en una y ejecuta:

        ```bash
        mvn test
        ```

        Que fallen por `UnsupportedOperationException` es normal hasta que completes los TODO.
    """


def update_doc(path: Path, marker: str, content: str) -> None:
    if not path.exists():
        return
    text = path.read_text(encoding="utf-8")
    start = f"<!-- {marker}:start -->"
    end = f"<!-- {marker}:end -->"
    block = f"{start}\n{content.strip()}\n{end}"
    if start in text and end in text:
        before = text.split(start, 1)[0].rstrip()
        after = text.split(end, 1)[1].lstrip()
        path.write_text(f"{before}\n\n{block}\n\n{after}", encoding="utf-8")
    else:
        path.write_text(f"{text.rstrip()}\n\n{block}\n", encoding="utf-8")


def main() -> None:
    if OUT.exists():
        shutil.rmtree(OUT)
    OUT.mkdir(parents=True)

    exs = exercises()
    for ex in exs:
        project = OUT / ex.folder
        project.mkdir(parents=True)
        write(project / "pom.xml", pom(ex.folder.replace("_", "-")))
        copy_environment(project)
        write(project / "src/main/java" / PKG_PATH / f"{ex.class_name}.java", ex.main_source)
        write(project / "src/test/java" / PKG_PATH / f"{ex.class_name}Test.java", ex.test_source)
        write(project / "README.md", project_readme(ex))

    write(OUT / "README.md", root_readme())
    write(OUT / "INDICE_ITERADORES.md", index(exs))

    overview = textwrap.dedent("""
        ## Iteradores añadidos

        Se ha añadido `04_ITERADORES_POR_PDF`, una carpeta separada con ejercicios de iteradores de árboles.
        Incluye patrones reales de enero 2026, junio 2025, junio 2023 y junio 2022, además de variantes nuevas
        para entrenar `remove`, inorden inverso, hojas, nodos internos y recorridos por niveles.
    """).strip()
    update_doc(OUT.parent / "README.md", "iteradores-por-pdf", overview)
    update_doc(OUT.parent / "INDICE_LIMPIO.md", "iteradores-por-pdf", overview)

    root_overview = textwrap.dedent("""
        ## Carpeta de iteradores

        Dentro de `08_PRACTICA_ORDENADA_POR_PDF/04_ITERADORES_POR_PDF` tienes una colección separada de
        iteradores de árboles con esqueletos Maven y tests: `ExtendedBreadthFirstTreeIterator.remove`,
        `ReverseInordenBTIterator`, `InternalNodeIterator`, `WithoutSiblingIterator`, `LevelIterator` y
        variantes nuevas de práctica.
    """).strip()
    update_doc(ROOT / "EDA_Examenes_2026" / "README.md", "iteradores-por-pdf", root_overview)


if __name__ == "__main__":
    main()
