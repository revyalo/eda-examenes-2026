import es.urjc.grafo.EDA.examen.GraphOperations;
import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.Vertex;
import es.urjc.grafo.EDA.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsTest {

    private AdjacencyMapGraph<String, Boolean> g, complementario;

    @BeforeEach
    void setUp() {
        g = new AdjacencyMapGraph<>(false);
        Map<String, Vertex<String>> mG = new HashMap<>();
        mG.put("Madrid", g.insertVertex("Madrid"));
        mG.put("Cadiz", g.insertVertex("Cadiz"));
        mG.put("Murcia", g.insertVertex("Murcia"));
        mG.put("Salamanca", g.insertVertex("Salamanca"));
        mG.put("Valencia", g.insertVertex("Valencia"));
        mG.put("Oviedo", g.insertVertex("Oviedo"));
        g.insertEdge(mG.get("Cadiz"), mG.get("Madrid"), true);
        g.insertEdge(mG.get("Cadiz"), mG.get("Murcia"), true);
        g.insertEdge(mG.get("Cadiz"), mG.get("Salamanca"), true);
        g.insertEdge(mG.get("Cadiz"), mG.get("Valencia"), true);
        g.insertEdge(mG.get("Cadiz"), mG.get("Oviedo"), true);

        complementario = new AdjacencyMapGraph<>(false);
        Map<String, Vertex<String>> mComple = new HashMap<>();
        mComple.put("Madrid", complementario.insertVertex("Madrid"));
        mComple.put("Cadiz", complementario.insertVertex("Cadiz"));
        mComple.put("Murcia", complementario.insertVertex("Murcia"));
        mComple.put("Salamanca", complementario.insertVertex("Salamanca"));
        mComple.put("Valencia", complementario.insertVertex("Valencia"));
        mComple.put("Oviedo", complementario.insertVertex("Oviedo"));
        complementario.insertEdge(mComple.get("Madrid"), mComple.get("Murcia"), true);
        complementario.insertEdge(mComple.get("Madrid"), mComple.get("Salamanca"), true);
        complementario.insertEdge(mComple.get("Madrid"), mComple.get("Valencia"), true);
        complementario.insertEdge(mComple.get("Madrid"), mComple.get("Oviedo"), true);
        complementario.insertEdge(mComple.get("Murcia"), mComple.get("Salamanca"), true);
        complementario.insertEdge(mComple.get("Murcia"), mComple.get("Valencia"), true);
        complementario.insertEdge(mComple.get("Murcia"), mComple.get("Oviedo"), true);
        complementario.insertEdge(mComple.get("Salamanca"), mComple.get("Valencia"), true);
        complementario.insertEdge(mComple.get("Salamanca"), mComple.get("Oviedo"), true);
        complementario.insertEdge(mComple.get("Valencia"), mComple.get("Oviedo"), true);
    }

    @Test
    void complementary() {
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.complementary(null));

        AdjacencyMapGraph<String, Boolean> otro = GraphOperations.complementary(new AdjacencyMapGraph<>(false));
        assertTrue(otro.vertices().isEmpty());
        assertTrue(otro.edges().isEmpty());

        otro = GraphOperations.complementary(g);
        assertEquals(complementario.vertices().size(), otro.vertices().size());
        assertEquals(complementario.edges().size(), otro.edges().size());

        int cont = 0;
        for (Edge<Boolean> e : otro.edges()) {
            Pair<Vertex<String>, Vertex<String>> vertexPar = otro.endVertices(e);
            Vertex<String> v1 = g.getVertex(vertexPar.getFirst().getElement());
            Vertex<String> v2 = g.getVertex(vertexPar.getSecond().getElement());
            assertFalse(g.areAdjacent(v1, v2));
            cont++;
        }
        assertEquals(10, cont);

        for (Edge<Boolean> edge : g.edges()) {
            Pair<Vertex<String>, Vertex<String>> vertexPar = g.endVertices(edge);
            Vertex<String> v1 = otro.getVertex(vertexPar.getFirst().getElement());
            Vertex<String> v2 = otro.getVertex(vertexPar.getSecond().getElement());
            assertFalse(otro.areAdjacent(v1, v2));
        }
    }
}