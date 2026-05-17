
import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.MoreFunctionality;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MoreFunctionalityTest {

    public MoreFunctionalityTest() {
    }

    private Position<Integer> p5;
    private Position<Integer> p6, p7, p9;

    private BinaryTree<Integer> inicializa() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        p5 = t.addRoot(5);
        p6 = t.insertLeft(p5, 6);
        p7 = t.insertRight(p5, 7);
        t.insertLeft(p6, 8);
        p9 = t.insertRight(p6, 9);
        t.insertLeft(p7, 10);
        t.insertRight(p7, 11);
        return t;
    }

    /**
     * Test of isPerfect method, of class MoreFunctionality.
     */
    @Test
    public void testIsPerfect() {
        System.out.println("isPerfect");
        MoreFunctionality<Integer> instance = new MoreFunctionality<>();
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        assertTrue(instance.isPerfect(t));
        t.addRoot(20);
        assertTrue(instance.isPerfect(t));
        t = inicializa();
        assertTrue(instance.isPerfect(t));
        t.insertLeft(p9, 25);
        assertFalse(instance.isPerfect(t));
    }


}
